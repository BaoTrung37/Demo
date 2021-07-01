package com.example.appcatrung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    private ArrayList <Food> listFoods;

    public FoodAdapter(ArrayList<Food> listFoods) {
        this.listFoods = listFoods;
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
    private class ViewHolder{
        TextView tvName,tvPrice;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.listview_food_order,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.text_item_foodorder);
            viewHolder.tvPrice = convertView.findViewById(R.id.text_item_price);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Food food = listFoods.get(position);
        viewHolder.tvName.setText(food.getName());
        viewHolder.tvPrice.setText(String.valueOf(food.getPrice()) + "$");

        return convertView;
    }
}
