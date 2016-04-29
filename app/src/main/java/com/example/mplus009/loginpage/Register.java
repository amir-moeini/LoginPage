package com.example.mplus009.loginpage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register extends AppCompatActivity implements View.OnClickListener {

    TextView etName;
    TextView etAge;
    TextView etUsername;
    TextView etPassword;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (TextView) findViewById(R.id.etName);
        etAge = (TextView) findViewById(R.id.etAge);
        etUsername = (TextView) findViewById(R.id.etUsername);
        etPassword = (TextView) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:

                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                User registredeData = new User(name, username, age, password);

                break;
        }
    }
}
