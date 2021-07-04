package com.example.appcatrung;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.appcatrung.databinding.ActivityFoodOrderBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FoodOrder extends AppCompatActivity {

    public final static String[] _food = {"Pizza Panda", "KFC Super",
            "Bread Eggs", "Coca cola", "Chicken Super", "Cup Cake"};
    public final static int[] _price = {10, 20, 5, 7, 50, 25};

    private HashMap<String,Integer> map;
    private ArrayList<Food> listFoods;
    private ArrayList<Food> listFoodOrders;
    private FoodAdapter foodAdapter;

    private int total;
    private int count;
    private ActivityFoodOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order);

        connectView();

        binding.imageCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FoodOrder.this, ShoppingCart.class);
                Bundle bundle1 = new Bundle();

                bundle1.putSerializable("Map",map);
                bundle1.putSerializable("ListFood",listFoodOrders);
                bundle1.putInt("Total",total);

                intent1.putExtras(bundle1);
                startActivity(intent1);
            }

        });
        binding.listviewFoodorder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food= listFoods.get(position);

                if(map.get(food.getName()) != null){
                    map.put(food.getName(),map.get(food.getName()) + 1);
                }
                else{
                    map.put(food.getName(),1);
                    listFoodOrders.add(food);
                }
//                Log.d("haha",String.valueOf(map.get(food)));
                binding.textCount.setText(++count + "");
                total += food.getPrice();
                binding.textTotal.setText(total + "$");
                binding.textNotify.setVisibility(View.INVISIBLE);
            }
        });
        binding.buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total != 0){
                    total = 0;
                    count = 0;
                    binding.textCount.setText(count + "");
                    binding.textTotal.setText(total + "$");
                    binding.textNotify.setVisibility(View.VISIBLE);
                    listFoodOrders.clear();
                }
                else{
                    binding.textNotify.setVisibility(View.INVISIBLE);
                    Toast.makeText(FoodOrder.this,
                            "you need to choose at least 1 product",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void connectView() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_food_order);

        total = 0;
        count = 0;
        listFoods = new ArrayList<>();
        listFoodOrders = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < _food.length; i++) {
            listFoods.add(new Food(_food[i], _price[i]));
        }

        foodAdapter = new FoodAdapter(listFoods);
        binding.listviewFoodorder.setAdapter(foodAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}