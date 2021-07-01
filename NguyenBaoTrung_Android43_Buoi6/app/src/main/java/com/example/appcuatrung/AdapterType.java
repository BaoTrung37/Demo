package com.example.appcuatrung;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterType extends BaseAdapter {

    ArrayList<String> list;

    public AdapterType(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        convertView = layoutInflater.inflate(
                R.layout.spinner_item_layout,parent, false);
        TextView tvItem = convertView.findViewById(R.id.tv_item_spinner);
        tvItem.setText(list.get(position));
        return convertView;
    }
}
