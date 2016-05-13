package com.example.mplus009.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button blogin;
    EditText etUsername, etPassword;
    TextView RegisterHere;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView RegisterHere = (TextView) findViewById(R.id.RegisterHere);
//        blogin.setOnClickListener(this);
//
//        blogin.setOnClickListener(this);
        RegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerintent = new Intent(Login.this, Register.class);
                Login.this.startActivity(registerintent);             //tells the current activity to open the Register activity
            }
        });
//        userLocalStore = new UserLocalStore(this);
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bLogin:
//
//                String username = etUsername.getText().toString();
//                String password = etPassword.getText().toString();
//                User user = new User(username, password);
//
//                authenticate(user);
//                break;
//
//            case R.id.RegisterHere:
//
//                startActivity(new Intent(this, Register.class));
//
//                break;
//        }
//    }
//    private void authenticate(User user){
//
//        RegisterRequests registerRequests = new RegisterRequests(this);
//        registerRequests.fetchUserDataInBackground(user, new GetUserCallback() {
//            @Override
//            public void done(User returnedUser) {
//                if (returnedUser == null){
//                    showErrorMessage();
//                }else {
//                    logUserIn(returnedUser);
//                }
//            }
//        });
//    }
//
//    private void showErrorMessage(){
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Login.this);
//        alertDialog.setMessage("Incorrect User Detail");
//        alertDialog.setPositiveButton("OK", null);
//        alertDialog.show();
//    }
//
//    private void logUserIn(User user){
//        userLocalStore.StoreUserData(user);
//        userLocalStore.setUserLoggedIn(true);
//
//        startActivity(new Intent(this, MainActivity.class));
//    }
}
