package com.example.mplus009.loginpage;

/**
 * Created by mplus009 on 05/05/2016.
 */
interface GetUserCallback {     //this is interface because doesn't implement any method, it just tell activity which method will be called
    //   when the server request is completed

    public abstract void done(User returnedUser);            //the method should be abstract because an interface can hold just the abstract methods

}
