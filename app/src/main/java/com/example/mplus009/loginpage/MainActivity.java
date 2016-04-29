package com.example.mplus009.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView etName;
    TextView etAge;
    TextView etUsername;
    Button bLogout;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (TextView) findViewById(R.id.etName);
        etAge = (TextView) findViewById(R.id.etAge);
        etUsername = (TextView) findViewById(R.id.etUsername);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {


        }
    }

    private boolean authenticate() {
        return userLocalStore.ifUserLoggedIn();
    }

    private void displayUserDetail() {

        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.userName);
        etName.setText(user.name);
        etAge.setText(user.age);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogout:

                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(this, Login.class));

                break;
        }
    }
}
