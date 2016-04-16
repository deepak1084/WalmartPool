package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/4/16.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShippingCart extends Activity {
    Activity con =null;
    ArrayList<String> valuesGroups;
    Double totalPrice = 0.0;
    ListAdapter listAdapter = null;
    ListView listView = null;
    ArrayList<GroupDetailsPOJO> sports=null;

     /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean flag = getIntent().getExtras().getBoolean("ShippingMethod");
         totalPrice = getIntent().getExtras().getDouble("TotalPrice");
        valuesGroups = new ArrayList<>();
        con = this;

        setContentView(R.layout.contentshippinglayout);
        listView = (ListView) findViewById(R.id.subscribed_group_list);

        Spinner spinner = (Spinner) findViewById(R.id.wait_time_spinner);
        ArrayAdapter<CharSequence> waitTimeAdapter = ArrayAdapter.createFromResource(this,
                R.array.wait_time_options, android.R.layout.simple_spinner_item);
        waitTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(waitTimeAdapter);

        Button b = (Button) findViewById(R.id.submitToCommunity);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i<sports.size(); i++) {
                    if (sports.get(i).isBox()){
                        valuesGroups.add(sports.get(i).getId());
                    }
                }

                String groupsSubs = "";
                for(int i=0;i<valuesGroups.size();i++) {
                    groupsSubs+= valuesGroups.get(i);
                    Log.i("Degroup",valuesGroups.get(i));
                    if(i!=valuesGroups.size()-1) {
                        groupsSubs +=",";
                    }
                }
                JSONObject j = new JSONObject();

                try {
                    j.put("user_id","1");
                    j.put("groups",groupsSubs);
                    j.put("shipping_price",150);
                    j.put("amount",totalPrice);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                new ShippingCartGroupPost().execute(j);
                Intent intent = new Intent(con,ThankYou.class);
                startActivity(intent);
            }
        });
        setJsonValueInterface s = new setJsonValueInterface() {
            @Override
            public void SetJSONObject(JSONArray j) {
                if (j != null) {
                    sports = null;
                    sports = new ArrayList<>();
                    for (int i = 0; i < j.length(); i++) {
                        try {
                            sports.add(new GroupDetailsPOJO(j.getJSONObject(i).getString("group_id"),"Deepak",j.getJSONObject(i).getString("name"),j.getJSONObject(i).getString("address"),Float.parseFloat(j.getJSONObject(i).getString("group_total")),false));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    listAdapter = new CustomListAdapterForSubscribedList(con, sports);
                    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                    listView.setAdapter(listAdapter);
                }
            }
        };

        new ShippingCartGroupFetch(s,"150").execute();
    }

    @Override
    public void onStop() {
        super.onStop();
        this.finish();
    }

}