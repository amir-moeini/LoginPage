package com.example.mplus009.loginpage;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mplus009 on 05/05/2016.
 */
public class RegisterRequests extends StringRequest {   //StringRequest belongs to Volley. allow us to make request to the Register.php file on the
    // server and get the String

    private static final String REGISTER_REQUEST_URL = "http://loginpage.comli.com/Register.php";
    private Map<String, String> params;


    public RegisterRequests(String name, String username, int age, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);  //passing the value that Volley need

        params = new HashMap<>();
        params.put("name", name);
        params.put("age", username);
        params.put("username", age + "");
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

//    ProgressDialog progressDialog;                                   //allows us to show load in by windows
//    public static final int CONNECTION_TIMEOUT = 1000 * 15;            //connection should persist before time out
//    public static final String SERVER_ADDRESS = "http://localhost:8080/xampp/htdocs/sample/";

//    public RegisterRequests(Context context){
//        progressDialog = new ProgressDialog(context);
//        progressDialog.setCancelable(false);
//        progressDialog.setTitle("Processing");
//        progressDialog.setMessage("Please wair...");
//    }

//    public void storeUserDataInBackground(User user, GetUserCallback userCallback){
//            progressDialog.show();
//            new StoreUserDataAsyncTask(user, userCallback).execute();
//    }
//
//    public void fetchUserDataInBackground(User user, GetUserCallback callBack){
//            progressDialog.show();
//            new FetchUserDataAsyncTask(user, callBack).execute();
//    }

    //Background task in Android ai called AsyncTask

//First void = we are not sending anything to this task that is being executed because we're sending it to the constructor
//second void = how we want to receive a progress from the AsyncTask. in this case we don't want to receive the progress,
// we just want to open the progress when AsyncTask start and close it when the AsyncTask end.
//Third void = this is what we want AsynhTask to return.
//    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void>{
//    User user;
//    GetUserCallback userCallback;
//
//        public StoreUserDataAsyncTask(User user, GetUserCallback userCallback){
//            this.user = user;
//            this.userCallback = userCallback;
//
//        }
//    @Override
//    protected Void doInBackground(Void... params) {
//            //create form to send to server
//        HashMap dataToSend = new HashMap<>();
//        dataToSend.put("name", user.name);
//        dataToSend.put("age", user.age);
//        dataToSend.put("username", user.userName);
//        dataToSend.put("password", user.password);
//
//        //setting attribute for Http Param
//
//            URL url;
//        try {
//            url = new URL(SERVER_ADDRESS + "Register.php");
//            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setConnectTimeout(CONNECTION_TIMEOUT);
//            conn.setReadTimeout(CONNECTION_TIMEOUT);
//            Uri.Builder builder = new Uri.Builder().appendQueryParameter("name",user.name).appendQueryParameter("age",user.age+"").appendQueryParameter("username",user.userName).appendQueryParameter("password",user.password);
//            String query = builder.build().getEncodedQuery();
//            OutputStream os = conn.getOutputStream();
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//            writer.write(query);
//            writer.flush();
//            writer.close();
//            os.close();
//        } catch (IOException e) {
//        }
//        return null;
//    }
//
//    //What happens when AsyncTask in finished.
//    @Override
//    protected void onPostExecute(Void aVoid) {
//        progressDialog.dismiss();
//        userCallback.done(null);            //inform the yusercall back, so the activity which spoted this task, will know that it's done
//        super.onPostExecute(aVoid);
//    }
//
//    //second void =
//
//    }

//    public class FetchUserDataAsyncTask extends AsyncTask<Void, Void, User>{
//        User user;
//        GetUserCallback userCallback;
//
//        public FetchUserDataAsyncTask(User user, GetUserCallback userCallback){
//            this.user = user;
//            this.userCallback = userCallback;
//
//        }
//        @Override
//        protected User doInBackground(Void... params) {
//
//            //setting attribute for Http Param
//            User returnedUser;
//            URL url;
//            try {
//                url = new URL(SERVER_ADDRESS + "FetchUserData.php");
//                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//                conn.setRequestMethod("POST");
//                conn.setConnectTimeout(CONNECTION_TIMEOUT);
//                conn.setReadTimeout(CONNECTION_TIMEOUT);
//                Uri.Builder builder = new Uri.Builder().appendQueryParameter("username",user.userName).appendQueryParameter("password",user.password);
//                String query = builder.build().getEncodedQuery();
//                OutputStream os = conn.getOutputStream();
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//                writer.write(query);
//                writer.flush();
//                writer.close();
//                os.close();
//                conn.connect();
//                InputStream in = new BufferedInputStream(conn.getInputStream());
//                String response = IOUtils.toString(in, "UTF-8");
//                JSONObject jResponse = new JSONObject(response);
//                if(jResponse.length()==0){
//                    returnedUser = null;
//                }else{
//                    String name = jResponse.getString("name");
//                    int age = jResponse.getInt("age");
//                    returnedUser = new User(name, user.userName, age, user.password);
//                }
//                return returnedUser;
//            } catch (IOException | JSONException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        //What happens when AsyncTask in finished.
//        @Override
//        protected void onPostExecute(User returnedUser) {
//            progressDialog.dismiss();
//            userCallback.done(returnedUser);            //inform the usercall back, so the activity which spoted this task, will know that it's done
//            super.onPostExecute(returnedUser);
//        }
//
//        //second void =
//
//    }
}
