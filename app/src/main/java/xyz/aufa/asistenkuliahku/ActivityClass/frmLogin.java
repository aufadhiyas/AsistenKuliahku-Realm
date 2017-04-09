package xyz.aufa.asistenkuliahku.ActivityClass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import xyz.aufa.asistenkuliahku.R;
import xyz.aufa.asistenkuliahku.SQLite_Controller.SQLiteHandler;
import xyz.aufa.asistenkuliahku.SessionManager.SessionManager;
import xyz.aufa.asistenkuliahku.Webservice.Webservice_Controller;

public class frmLogin extends AppCompatActivity {
    private  static final String TAG = frmDaftar.class.getSimpleName();
    Button btnLogin, btnRegister;
    private SessionManager session;
    private SQLiteHandler db;
    private EditText txtEmail, txtPassword;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_login);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnDaftar);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        db=new SQLiteHandler(getApplicationContext());
        session = new SessionManager(getApplicationContext());

        if(session.isLoggedIn()){
            Intent intent = new Intent(frmLogin.this, Dashboard.class);
            startActivity(intent);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String pass = txtPassword.getText().toString().trim();
                if(!email.isEmpty() && !pass.isEmpty()){
                    checkLogin(email,pass);
                }else{
                    Toast.makeText(getApplicationContext(), "Masukkan Email Dan Password Anda", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(frmLogin.this, frmDaftar.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void checkLogin(final String email, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                Webservice_Controller.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObjs = new JSONObject(response);
                    boolean error = jObjs.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session
                        session.setLogin(true);

                        // Now store the user in SQLite
                       // String uid = jObjs.getString("uid");

                      //  JSONObject user = jObjs.getJSONObject("user");
                     //   String name = user.getString("name");
                      //  String email = user.getString("email");
                      //  String created_at = user
                        //        .getString("created_at");

                        // Inserting row in users table
                       // db.addUser(name, email, uid, created_at);

                        // Launch main activity
                        Intent intent = new Intent(frmLogin.this,
                                Dashboard.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(getApplicationContext(),
                                response, Toast.LENGTH_LONG).show();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObjs.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
