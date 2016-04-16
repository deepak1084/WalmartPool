package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/4/16.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by hp on 03-04-2016.
 */
public class CheckOut extends Activity {
    TextView tt2 ;
    TextView tt3;
    Double total_price;
    Double total = new Double(0);
    Context con= null;
    boolean normal = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        con = this;
        setContentView(R.layout.checkout);
        Intent intent = getIntent();
        tt2 = (TextView) findViewById(R.id.Shipping_Amount);
        tt3 = (TextView)findViewById(R.id.Total_Amount);
        total_price = intent.getDoubleExtra("total_price", 0.0);
        Math.round(total_price);
        int Count1 = intent.getIntExtra("Count", 0);

        TextView tt = (TextView) findViewById(R.id.itemssize);
        tt.setText(String.valueOf(Count1));
        TextView tt1 = (TextView) findViewById(R.id.Subtotal_Amount);
        tt1.setText("Rs." + String.valueOf(total_price));

        RadioButton rr = (RadioButton)findViewById(R.id.radioButton);
        RadioButton rr2 = (RadioButton)findViewById(R.id.radioButton2);
        tt2.setText("Rs.250");
        total = total_price +250.0;
        Math.round(total);

        tt3.setText("Rs" + String.valueOf(Math.round(total)));
        rr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tt2.setText("Rs.250");
                 total= total_price + 250.0;
                Math.round(total);
                tt3.setText("Rs." + String.valueOf(Math.round(total)));
                normal = false;

            }
        });
        rr2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tt2.setText("Rs.150");
                total = total_price +150.0;
                Math.round(total);
                tt3.setText("Rs." + String.valueOf(Math.round(total)));
                normal= true;
            }
        });

        System.out.println(total_price);
        HashSet<Integer> position = (HashSet)intent.getSerializableExtra("set");
        final String[] items = {"Anarkali Dress Material" +
                "\nRs.349.00","Hoodie\n Rs.200.00","Printed T-Shirt\n Rs.90.00","Karya Blue Jean\n" +
                "\n\nRs.490.00","Campus Black Shoes" +
                "\n\nRs.330.00","Bonkerz Blue Clogs\nRs.269.00"};
        int[] itemImages = {R.drawable.iphone,R.drawable.prod2,R.drawable.prod3,R.drawable.prod4,R.drawable.prod5,R.drawable.prod6};
        final String[] items1 = new String[position.size()];
        int[] itemImages1 = new int[position.size()];
        int j =0 ;
        Iterator<Integer> it = position.iterator();

        while(j < position.size()) {
            System.out.println("j**" + j);
            int a = (int)it.next();
            items1[j] = items[a];
            itemImages1[j++] = itemImages[a];
        }


        ListAdapter myAdapter = new CustomAdapter1(this, items1, itemImages1);
        ListView dinesListView = (ListView)findViewById(R.id.ItemListView);

        dinesListView.setAdapter(myAdapter);
        Button b = (Button)findViewById(R.id.checkoutToShipping);
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(con,ShippingCart.class);
                intent.putExtra("ShippingMethod",normal);
                intent.putExtra("TotalPrice", total_price);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        this.finish();
    }
}