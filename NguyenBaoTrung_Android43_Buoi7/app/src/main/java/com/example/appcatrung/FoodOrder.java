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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FoodOrder extends AppCompatActivity {

    public final static String[] _food = {"Pizza Panda", "KFC Super",
            "Bread Eggs", "Coca cola", "Chicken Super", "Cup Cake"};
    public final static int[] _price = {10, 20, 5, 7, 50, 25};
    public final static int REQUEST_CODE_EX = 1;

    private ImageButton imbtShoppingCart;
    private Button btOrder;
    private ListView lvMenuFoodOrder;
    private TextView tvTotal;
    private TextView tvCount;
    private TextView tvNotify;

    private HashMap<String,Integer> map;
    private ArrayList<Food> listFoods;
    private ArrayList<Food> listFoodOrders;
    private FoodAdapter foodAdapter;

    private int total;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order);

        connectView();

        imbtShoppingCart.setOnClickListener(new View.OnClickListener() {
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
        lvMenuFoodOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                tvCount.setText(++count + "");
                total += food.getPrice();
                tvTotal.setText(total + "$");
                tvNotify.setVisibility(View.INVISIBLE);
            }
        });
        btOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total != 0){
                    total = 0;
                    count = 0;
                    tvCount.setText(count + "");
                    tvTotal.setText(total + "$");
                    tvNotify.setVisibility(View.VISIBLE);
                    listFoodOrders.clear();
                }
                else{
                    tvNotify.setVisibility(View.INVISIBLE);
                    Toast.makeText(FoodOrder.this,
                            "you need to choose at least 1 product",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void connectView() {
        imbtShoppingCart = findViewById(R.id.image_cart);
        btOrder = findViewById(R.id.button_order);
        lvMenuFoodOrder = findViewById(R.id.listview_foodorder);
        tvTotal = findViewById(R.id.text_total);
        tvCount = findViewById(R.id.text_count);
        tvNotify = findViewById(R.id.text_notify);

        total = 0;
        count = 0;
        listFoods = new ArrayList<>();
        listFoodOrders = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < _food.length; i++) {
            listFoods.add(new Food(_food[i], _price[i]));
        }

        foodAdapter = new FoodAdapter(listFoods);
        lvMenuFoodOrder.setAdapter(foodAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}