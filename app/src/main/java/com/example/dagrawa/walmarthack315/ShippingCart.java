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
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ShippingCart extends Activity implements
        View.OnClickListener {
    Button button;
    ListView listView;
    ArrayAdapter<String> adapter;
    Context con =null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean flag = getIntent().getExtras().getBoolean("ShippingMethod");

        setContentView(R.layout.contentshippinglayout);
        con = this;
        findViewsById();

        setJsonValueInterface s = new setJsonValueInterface() {
            @Override
            public void SetJSONObject(JSONArray j) {
                ArrayList<String> sports = new ArrayList<>();
                for (int i = 0; i < j.length(); i++) {
                    try {
                        sports.add(j.getJSONObject(i).getString("group_id"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                adapter = new ArrayAdapter<String>(con,
                        android.R.layout.simple_list_item_multiple_choice, sports);
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                listView.setAdapter(adapter);

            }
        };
        String str = null;
        if(flag == true) {
            str = "standard";
        }else {
            str = "expedite";
        }
        new ShippingCartGroupFetch(s,str).execute();
        button.setOnClickListener(this);
        Button but = (Button) findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(con,"Thank you for placing the order",Toast.LENGTH_SHORT);
            }
        });
    }

    private void findViewsById() {
        listView = (ListView) findViewById(R.id.list);
        button = (Button) findViewById(R.id.button2);
    }

    public void onClick(View v) {
        Toast.makeText(con,"Thank you for placing the order",Toast.LENGTH_SHORT);
        SparseBooleanArray checked = listView.getCheckedItemPositions();
        ArrayList<String> selectedItems = new ArrayList<String>();
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapter
            int position = checked.keyAt(i);
            // Add sport if it is checked i.e.) == TRUE!
            if (checked.valueAt(i))
                selectedItems.add(adapter.getItem(position));
        }

        String[] outputStrArr = new String[selectedItems.size()];

        for (int i = 0; i < selectedItems.size(); i++) {
            outputStrArr[i] = selectedItems.get(i);
        }

        Log.i("Deepak", outputStrArr.toString());
//        new ShippingCartGroupPost(JSONOBEJCT).execute();

    }
}