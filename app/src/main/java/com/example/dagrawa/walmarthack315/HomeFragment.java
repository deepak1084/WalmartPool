package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 02-04-2016.
 */

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HomeFragment extends Fragment {

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        String[] items = {"Apple iPhone 6s (Space Grey, 64GB)\n\n$649.00","Harry Potter and the Goblet of Fire\n\n$10.00","RCA Home Theatre System with Bluetooth\n\n$90.00","RCA gaming controller\n\n$49.99","SanDisk Ultra MicroSD 64GB\n\n$30.00","Photron Tripod Stand\n\n$17.00"};
        int[] itemImages = {R.drawable.iphone,R.drawable.book,R.drawable.home_theatre,R.drawable.controller,R.drawable.sdcard,R.drawable.tripod};
        //  ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        ListAdapter myAdapter = new CustomAdapter(this.getActivity(), items, itemImages);
        ListView dinesListView = (ListView) rootView.findViewById(R.id.listView);

        dinesListView.setAdapter(myAdapter);

        dinesListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(position));
//                        Toast.makeText(getActivity(),item, Toast.LENGTH_LONG).show();
                    }
                }
        );

        return rootView;
    }
}
