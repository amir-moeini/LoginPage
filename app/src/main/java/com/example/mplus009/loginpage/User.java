package com.example.mplus009.loginpage;

/**
 * Created by mplus009 on 01/03/2016.
 */
public class User {

    String name, userName, password;
    int age;

    public User(String name, String userName, int age, String password) {

        this.name = name;
        this.userName = userName;
        this.age = age;
        this.password = password;
    }

    public User(String userName, String password) {

        this.userName = userName;
        this.password = password;
        this.age = -1;
        this.name = "";
    }

}
