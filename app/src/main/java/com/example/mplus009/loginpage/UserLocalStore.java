package com.example.mplus009.loginpage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mplus009 on 01/03/2016.
 */
public class UserLocalStore {

    public static final String SP_NAME = "userDetail";
    SharedPreferences UserLocalDatabase;                    //allow us to store the data locally (on the phone)

    public UserLocalStore(Context context) {

        UserLocalDatabase = context.getSharedPreferences(SP_NAME, 0); //An activity has to instatiate the SharedPreferences. LocalDataStore can not do it, because it's a Java class

    }

    //Update everiything that is stored currently in the sharedPreferences.
    public void StoreUserData(User user) {
        SharedPreferences.Editor spEditor = UserLocalDatabase.edit();
        spEditor.putString("name", user.name);
        spEditor.putString("userName", user.userName);
        spEditor.putString("password", user.password);
        spEditor.putInt("age", user.age);
        spEditor.commit();
    }

    public User getLoggedInUser() {
        String name = UserLocalDatabase.getString("name", "");
        String username = UserLocalDatabase.getString("username", "");
        String password = UserLocalDatabase.getString("password", "");
        int age = UserLocalDatabase.getInt("age", -1);

        User storedUser = new User(name, username, age, password);
        return storedUser;
    }

    public void setUserLoggedIn(Boolean loggedIn) {

        SharedPreferences.Editor spEditor = UserLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean ifUserLoggedIn() {

        if (UserLocalDatabase.getBoolean("LoggedIn", false) == true) {
            return true;
        } else {
            return false;
        }
    }

    public void clearUserData() {

        SharedPreferences.Editor spEditor = UserLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
