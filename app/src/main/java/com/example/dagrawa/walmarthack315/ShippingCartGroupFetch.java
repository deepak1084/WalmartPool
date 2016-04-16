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
public class ShippingCartGroupFetch extends AsyncTask<Void,Void,JSONArray> {
    setJsonValueInterface setInterface=null;
    String shippingMethod;
    public ShippingCartGroupFetch(setJsonValueInterface s,String shipping) {
    this.setInterface = s;
        this.shippingMethod = shipping;
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        URL url = null;
        JSONArray j = null;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://10.0.12.186:3000/fetch_group?user_id=1");
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
