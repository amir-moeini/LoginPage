package com.example.mplus009.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

//    EditText etName;
//    EditText etAge;
//    EditText etUsername;
//    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final int age = Integer.parseInt(etAge.getText().toString());
                final String password = etPassword.getText().toString();

                Response.Listener<String> responselistener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            Boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent(Register.this, Login.class);
                                Register.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Register Faild")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                                ;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequests registerRequests = new RegisterRequests(name, username, age, password, responselistener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequests);


            }
        });

    }
}


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bRegister:
//
//                String name = etName.getText().toString();
//                String username = etUsername.getText().toString();
//                String password = etPassword.getText().toString();
//                int age = Integer.parseInt(etAge.getText().toString());
//
//                User user = new User(name, username, age, password);
//                registerUser(user);
//
//                break;
//        }
//    }
//    private void registerUser(User user){
//
//        registerRequests.storeUserDataInBackground(user, new GetUserCallback() {
//            @Override
//            public void done(User returnedUser) {
//                startActivity(new Intent(Register.this, Login.class));
//            }
//        });
//    }
//}
