package xyz.aufa.asistenkuliahku.ActivityClass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import xyz.aufa.asistenkuliahku.SessionManager.AppController;
import xyz.aufa.asistenkuliahku.SessionManager.ReadInstallation;
import xyz.aufa.asistenkuliahku.SessionManager.SessionManager;
import xyz.aufa.asistenkuliahku.Webservice.Webservice_Controller;
import xyz.aufa.asistenkuliahku.frmVerifikasi;

public class frmLogin extends AppCompatActivity {
    private  static final String TAG = frmDaftar.class.getSimpleName();
    Button btnLogin, btnRegister;
    private SessionManager session;
    private EditText txtEmail, txtPassword;
    private ProgressDialog pDialog;
    private TextView lupa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmlogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnDaftar);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        lupa = (TextView)findViewById(R.id.lblLupaPassword);
        lupa.setMovementMethod(LinkMovementMethod.getInstance());
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);


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
                Boolean status= true;
                if(!email.isEmpty() && !pass.isEmpty()){

                    checkLogin(email,pass,status);
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
    private void checkLogin(final String email, final String password, final Boolean statusLogin) {
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
                    int status_verifikasi = jObjs.getInt("status_verifikasi");
                    String email = jObjs.getString("email");
                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session
                        if (status_verifikasi == 0){
                            session.setVerifyStat(false);
                            Intent intent = new Intent(frmLogin.this, frmVerifikasi.class);
                            String Email = null;
                            intent.putExtra(email, Email);
                        }else{
                            session.setLogin(true);
                            Intent intent = new Intent(frmLogin.this,
                                    Dashboard.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    response, Toast.LENGTH_LONG).show();
                        }

                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObjs.getString("message");
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
