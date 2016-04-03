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
        import android.widget.AdapterView;
        import android.widget.ListAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.Collection;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class WalmartCreditsFragment extends Fragment {

    public WalmartCreditsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.walmartcredits, container, false);

        ArrayList<CreditClass> arrayList = new ArrayList<>();
        arrayList.add(new CreditClass("Deepak",20));
        arrayList.add(new CreditClass("Dinesg",10));
        //  ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        ListAdapter myAdapter = new CustomAdapterWithoutImage(this.getActivity(),arrayList);
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
