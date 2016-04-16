package com.example.dagrawa.walmarthack315;

/**
 * Created by hp on 02-04-2016.
 */


        import android.annotation.TargetApi;
        import android.app.Activity;
        import android.app.Fragment;
        import android.os.Build;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ListAdapter;
        import android.widget.ListView;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MyOrdersFragment extends Fragment {
    View root;
    Activity context;
    public MyOrdersFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.orders_fragment, container, false);
        root = rootView;
        context = this.getActivity();
        final ArrayList<OrderDetail> arrayList = new ArrayList<>();
        setJsonValueInterface s = new setJsonValueInterface() {
            @Override
            public void SetJSONObject(JSONArray j) {
                Log.i("Coming under setJSOn","Deepak");

                if(j!=null) {
                Log.i("In orders fragment", j.toString());
                for(int i=0;i<j.length();i++) {
                    try {
                        JSONObject ob = j.getJSONObject(i);
                        JSONArray gArry = ob.getJSONArray("groups");
                        String groupsValue="";
                        if(gArry != null) {
                            for (int k = 0; k < gArry.length(); k++) {
                                groupsValue += gArry.getJSONObject(k).getString("name");
                                if(k!=gArry.length()-1) {
                                    groupsValue+=",";
                                }
                            }
                        }
                        arrayList.add(new OrderDetail(ob.getString("order_id"),ob.getString("time"), ob.getString("amount"),ob.getString("status"),groupsValue, ob.getString("shipping_price"), ob.getString("saving")));
//
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                        Log.i("Coming under setJSOn", "Deepak");
                        ListAdapter myAdapter = new CustomAdapterWithoutImageOrders(context, arrayList);
                        ListView listView = (ListView) root.findViewById(R.id.listView);

                        listView.setAdapter(myAdapter);

                    listView.setOnItemClickListener(
                            new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String item = String.valueOf(parent.getItemAtPosition(position));
//                        Toast.makeText(getActivity(),item, Toast.LENGTH_LONG).show();
                                }
                            }
                        );



                }
            }
        };
        new CreditsFetchingTask(s).execute();

        return rootView;
    }
}

