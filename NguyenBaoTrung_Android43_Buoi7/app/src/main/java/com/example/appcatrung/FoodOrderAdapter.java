package com.example.appcatrung;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodOrderAdapter extends BaseAdapter {
    ArrayList<Food> listFoods;
    HashMap<String,Integer> map;

    public FoodOrderAdapter(ArrayList<Food> listFoods, HashMap<String, Integer> map) {
        super();
        this.listFoods = listFoods;
        this.map = map;
    }

    @Override
    public int getCount() {
        return listFoods.size();
    }

    @Override
    public Object getItem(int position) {
        return listFoods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.listview_food_ordered,parent,false);

        TextView tvName,tvAmount;
        tvName = convertView.findViewById(R.id.text_item_foodordered);
        tvAmount = convertView.findViewById(R.id.text_item_amount);
        Food food = listFoods.get(position);

        tvName.setText(food.getName());
        tvAmount.setText(String.valueOf(map.get(food.getName())) +"");
        return convertView;
    }
}
