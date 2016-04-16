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

public class ShippingCart extends Activity
         {
    Button button;
    ListView listView;
    ListAdapter adapter;
    Activity con =null;
    String str = null;
    Double totalPrice = 0.0;
Integer shipCost = 0;
             Integer waitTime = 0;
             /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean flag = getIntent().getExtras().getBoolean("ShippingMethod");
         totalPrice = getIntent().getExtras().getDouble("TotalPrice");

        con = this;

        setContentView(R.layout.contentshippinglayout);

        Spinner spinner = (Spinner) findViewById(R.id.wait_time_spinner);
        ArrayAdapter<CharSequence> waitTimeAdapter = ArrayAdapter.createFromResource(this,
                R.array.wait_time_options, android.R.layout.simple_spinner_item);
        waitTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(waitTimeAdapter);


        setJsonValueInterface s = new setJsonValueInterface() {
            @Override
            public void SetJSONObject(JSONArray j) {
                if (j != null) {
                    ArrayList<GroupDetailsPOJO> sports = new ArrayList<>();
                    for (int i = 0; i < j.length(); i++) {
                        try {

                            sports.add(new GroupDetailsPOJO(j.getJSONObject(i).getString("group_id"),"Deepak",j.getJSONObject(i).getString("name"),j.getJSONObject(i).getString("address"),Float.parseFloat(j.getJSONObject(i).getString("group_total"))));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    ListView listView = (ListView) findViewById(R.id.subscribed_group_list);
                    ListAdapter listAdapter = new CustomListAdapterForSubscribedList(con, sports);
                    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                    listView.setAdapter(listAdapter);

                }
            }
        };

        new ShippingCartGroupFetch(s,"150").execute();
//        new ShippingCartGroupFetch(s,str).execute();
////        button.setOnClickListener(this);
//        Button but = (Button) findViewById(R.id.submitToPersonal);
//        but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(con,ThankYouPage.class);
//
//                startActivity(intent);
//            }
//        });
//        Button subComm = (Button) findViewById(R.id.submitToCommunity);
//        subComm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(con,"Thank you for placing the order",Toast.LENGTH_LONG).show();
//                SparseBooleanArray checked = listView.getCheckedItemPositions();
//                ArrayList<String> selectedItems = new ArrayList<String>();
//                for (int i = 0; i < checked.size(); i++) {
//                    // Item position in adapter
//                    int position = checked.keyAt(i);
//                    // Add sport if it is checked i.e.) == TRUE!
//                    if (checked.valueAt(i))
//                        selectedItems.add(((GroupFetchAtShippingPage)adapter.getItem(position)).getGrpId());
//                }
//
//                String[] outputStrArr = new String[selectedItems.size()];
//
//                for (int i = 0; i < selectedItems.size(); i++) {
//                    outputStrArr[i] = selectedItems.get(i);
//                }
//                String outputArrayAsString = "";
//                for(int i=0;i<outputStrArr.length;i++) {
//                    Log.i("Deepak", outputStrArr[i]);
//                    outputArrayAsString +=outputStrArr[i]+",";
//                }
//                JSONObject j = new JSONObject();
//                try {
//                    j.put("user_id","dagrawa");
//                    j.put("status","InProcess");
//                    j.put("zip_code","560034");
//                    j.put("group_id","grp1");
//                    j.put("subc_groups",outputArrayAsString.substring(0,outputArrayAsString.length()-1));
//                    j.put("shipping_method",str);
//                    j.put("ship_cost",shipCost);
//                    j.put("ship_discount",0);
//                    j.put("total_amount",totalPrice);
//                    j.put("wait_time",waitTime);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//        new ShippingCartGroupPost().execute(j);
//                Intent intent = new Intent(con,ThankYouPage.class);
//
//                startActivity(intent);
//            }
//        });
    }



}