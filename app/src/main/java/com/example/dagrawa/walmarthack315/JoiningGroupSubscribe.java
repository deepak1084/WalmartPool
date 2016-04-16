package com.example.dagrawa.walmarthack315;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dagrawa on 4/3/16.
 */
public class JoiningGroupSubscribe extends AsyncTask<JSONObject,Void,JSONArray> {
    public JoiningGroupSubscribe() {
    }

    @Override
    protected JSONArray doInBackground(JSONObject... params) {
        URL url = null;
        JSONArray j = null;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://10.0.12.186:3000/allocate_user_group");
            Log.i("Deepak","http://10.0.12.186:3000/allocate_user_group");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(params[0].toString());
            out.close();
            Log.i("Data",params[0].toString());

            int HttpResult =urlConnection.getResponseCode();

            Log.i("Deepak", String.valueOf(HttpResult));

    } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return j;
        }
    }

}
