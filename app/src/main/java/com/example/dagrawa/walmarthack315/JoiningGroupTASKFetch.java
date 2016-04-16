package com.example.dagrawa.walmarthack315;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dagrawa on 4/3/16.
 */
public class JoiningGroupTASKFetch extends AsyncTask<Void,Void,JSONArray> {
    setJsonValueInterface setInterface=null;
    String par = null;
    String val = null;

    public JoiningGroupTASKFetch(setJsonValueInterface s, String param,String val) {
    this.setInterface = s;
        this.par = param;
        this.val = val;
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        URL url = null;
        JSONArray j = null;
        HttpURLConnection urlConnection = null;
        try {
            Log.i("Deepak","http://10.0.12.186:3000/fetch_group?"+par+"="+val);
            url = new URL("http://10.0.12.186:3000/fetch_group?"+par+"="+val);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");


            int HttpResult =urlConnection.getResponseCode();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            urlConnection.getInputStream(),
                            "utf-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();
            String retString=new String(sb.toString());
            JSONObject ob = new JSONObject(retString);
            if(ob!=null) {
                j = ob.getJSONArray("groups");
            }
            Log.i("deepak",retString);

    } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return j;
        }
    }

    @Override
    protected void onPostExecute(JSONArray jsonObject) {
        setInterface.SetJSONObject(jsonObject);
    }

}
