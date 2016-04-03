package com.example.dagrawa.walmarthack315;

/**
 * Created by hp on 02-04-2016.
 */


import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CreateGroupFragment extends Fragment {

    public CreateGroupFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_create_group, container, false);
//        Button button = (Button) rootView.findViewById(R.id.createGroup);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Group is created",Toast.LENGTH_SHORT).show();
//            }
//        });
        return rootView;
    }
}
