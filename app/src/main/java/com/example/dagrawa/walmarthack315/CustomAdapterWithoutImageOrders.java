package com.example.dagrawa.walmarthack315;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dagrawa on 4/2/16.
 */
public class CustomAdapterWithoutImageOrders extends BaseAdapter {
    private static LayoutInflater inflater=null;

ArrayList<OrderDetail> creditArrayList=null;

    public CustomAdapterWithoutImageOrders(Activity activity, ArrayList<OrderDetail> arrayList) {
        creditArrayList = arrayList;
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return creditArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return creditArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = inflater.inflate(R.layout.orders_custom_row, parent, false);


        TextView orderIdText = (TextView) customView.findViewById(R.id.orderNoValue);
        TextView dateText = (TextView) customView.findViewById(R.id.OrderDateValue);
        TextView orderAmtText = (TextView) customView.findViewById(R.id.OrderAmountValue);
        TextView status = (TextView) customView.findViewById(R.id.StatusValue);
        TextView grps = (TextView) customView.findViewById(R.id.GroupValue);



        orderIdText.setText(creditArrayList.get(position).getOrderId());
        dateText.setText(creditArrayList.get(position).getOrderDate());
        orderAmtText.setText(creditArrayList.get(position).getOrderAmount());

        status.setText(creditArrayList.get(position).getStatus());
        grps.setText(creditArrayList.get(position).getGroups());

        return customView;
    }
}
