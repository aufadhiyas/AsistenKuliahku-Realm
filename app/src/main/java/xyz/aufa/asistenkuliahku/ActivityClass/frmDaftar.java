package xyz.aufa.asistenkuliahku.ActivityClass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import xyz.aufa.asistenkuliahku.SessionManager.SessionManager;
import xyz.aufa.asistenkuliahku.Webservice.Webservice_Controller;

public class frmDaftar extends AppCompatActivity {
    Button btnDaftar, btnKembali;
    EditText email, pass, nama;
    AlertDialog alertDialog;
    private static final String TAG = frmDaftar.class.getSimpleName();
    SessionManager session;

    private String EmailView;
    private ProgressDialog pDialog;

    private static final String Key_nama = "nama";
    private static final String Key_email = "email";
    private static final String Key_password = "password";
    private static final String url = "Webservice_Controller.URL_DAFTAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmdaftar);
        btnDaftar = (Button) findViewById(R.id.btnDaftar1);
        btnKembali = (Button) findViewById(R.id.btnKembali);
        email = (EditText) findViewById(R.id.txtEmailDaftar);
        pass = (EditText) findViewById(R.id.txtPasswordDaftar);
        nama = (EditText) findViewById(R.id.txtNamaDaftar);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        session = new SessionManager(getApplicationContext());
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaftar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String emails = email.getText().toString().trim();
                        String passwords = pass.getText().toString().trim();
                        String namas = nama.getText().toString().trim();
                        if (!namas.isEmpty() && !emails.isEmpty() && !passwords.isEmpty()) {

                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Please enter your details!", Toast.LENGTH_LONG)
                                    .show();
                        }
                        //registerUser(emails, passwords,namas);


                    }
                });
            }
        });
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(frmDaftar.this,
                        Dashboard.class);
                startActivity(intent);
            }
        });


    }

    private void initCustomAlertDialog(String EmailView) {
        View v = getLayoutInflater().inflate(R.layout.dialogverivikasi, null);
        TextView txtEmail = (TextView) findViewById(R.id.lblemailDaftar);
        //txtEmail.setText(EmailView);
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setView(v);
        alertDialog.setTitle("Verifikasi Email");
    }
    private void registerUser(final String namas, final String emails,
                              final String passwords) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                Webservice_Controller.URL_DAFTAR, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String email = user.getString("email");
                        String created_at = user
                                .getString("created_at");

                        // Inserting row in users table
                        //db.addUser(name, email, uid, created_at);

                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(
                                frmDaftar.this,
                                frmLogin.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("nama", namas);
                params.put("email", emails);
                params.put("password", passwords);

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