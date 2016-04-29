package com.example.mplus009.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button blogin;
    EditText etUsername, etPassword;
    TextView RegisterHere;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        blogin = (Button) findViewById(R.id.bLogin);
        RegisterHere = (TextView) findViewById(R.id.RegisterHere);
        blogin.setOnClickListener(this);

        blogin.setOnClickListener(this);
        RegisterHere.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogin:

                User user = new User(null, null);
                userLocalStore.StoreUserData(user);
                userLocalStore.setUserLoggedIn(true);

                break;

            case R.id.RegisterHere:

                startActivity(new Intent(this, Register.class));

                break;
        }
    }
}
