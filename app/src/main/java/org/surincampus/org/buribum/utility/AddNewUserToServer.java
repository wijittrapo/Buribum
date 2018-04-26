package org.surincampus.org.buribum.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AddNewUserToServer extends AsyncTask<String,Void,String> {  //thread AsyncTask

    //Explicite

    private Context context;  //channel for communication


    public AddNewUserToServer(Context context) {
        this.context = context;


    } //constructor


    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder().add("isAdd", "true")
                    .add("Name",strings[0]).add("User",strings[1]).add("Password",strings[2]).build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[3]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}// Main Class
