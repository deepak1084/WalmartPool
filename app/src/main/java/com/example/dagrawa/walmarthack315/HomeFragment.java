package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 02-04-2016.
 */

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HomeFragment extends Fragment {
    int count = 0;
    TextView tt ;
    double TotalPrice = 0;
    Set<Integer> posn = new HashSet<Integer>();
    public HomeFragment(){}
    Context con = null;
    Button b;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        tt= (TextView)this.getActivity().findViewById(R.id.textView);
        b = (Button)this.getActivity().findViewById(R.id.checkoutbuttoncart);
        con = this.getActivity();
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(con,CheckOut.class);
                intent.putExtra("total_price",TotalPrice);
                intent.putExtra("set", (Serializable) posn);
                intent.putExtra("Count",count);
                startActivity(intent);

            }
        });
        final String[] items = {"Anarkali Dress Material" +
                "\nRs.349.00","Hoodie\n Rs.200.00","Printed T-Shirt\n Rs.90.00","Karya Blue Jean\n" +
                "\n\nRs.490.00","Campus Black Shoes" +
                "\n\nRs.330.00","Bonkerz Blue Clogs\nRs.269.00"};
        int[] itemImages = {R.drawable.iphone,R.drawable.prod2,R.drawable.prod3,R.drawable.prod4,R.drawable.prod5,R.drawable.prod6};

        ListAdapter myAdapter = new CustomAdapter(this.getActivity(), items, itemImages);
        ListView dinesListView = (ListView) rootView.findViewById(R.id.listView);

        dinesListView.setAdapter(myAdapter);

        dinesListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(position));
                        String price = item.substring(item.lastIndexOf("Rs.") + 3);
                        TotalPrice = TotalPrice + Double.parseDouble(price);
                        posn.add(position);



                        count++;


                        System.out.println("textView" + tt);

                        if (tt != null) {
                            tt.setText(String.valueOf(TotalPrice));
                        }
//                        Toast.makeText(getContext(), item, Toast.LENGTH_LONG).show();
//                        Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
                    }
                }
        );





        return rootView;
    }


}