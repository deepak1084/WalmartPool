package com.example.dagrawa.walmarthack315;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sushant on 4/16/16.
 */
public class CustomListAdadpterForGroupListSushant extends BaseAdapter {

    private static LayoutInflater inflater = null;
    List<GroupDetailsPOJO> groupList = null;

    public CustomListAdadpterForGroupListSushant(Activity activity, List<GroupDetailsPOJO> groupList) {
        this.groupList = groupList;
        inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return groupList.size();
    }

    @Override
    public Object getItem(int position) {
        return groupList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = inflater.inflate(R.layout.group_details_row, parent, false);

        ImageView grpImage = (ImageView) customView.findViewById(R.id.group_image);
        TextView grpName = (TextView) customView.findViewById(R.id.group_name);
        TextView ownerName = (TextView) customView.findViewById(R.id.owner_name);
        TextView grpAddress = (TextView) customView.findViewById(R.id.group_address);

//        grpImage.setImageURI(R.drawable.img_fridge);
        grpName.setText(groupList.get(position).getName());
        ownerName.setText(groupList.get(position).getOwnerName());
        grpAddress.setText(groupList.get(position).getAddress());

        return customView;
    }
}
