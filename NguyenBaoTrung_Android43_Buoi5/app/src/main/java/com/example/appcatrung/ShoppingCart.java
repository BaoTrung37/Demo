package com.example.appcatrung;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart extends AppCompatActivity {

    private ImageButton imbtBack;
    private ListView lvFoodOrdered;
    private TextView tvTotal;

    private ArrayList<Food> listFoodrdered;
    private HashMap<String,Integer> map;
    private FoodOrderAdapter foodOrderAdapter;

    private int total;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        connectView();

        imbtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    private void connectView() {
        imbtBack = findViewById(R.id.image_forward);
        lvFoodOrdered = findViewById(R.id.listview_cart);
        tvTotal = findViewById(R.id.text_cart_total);

        listFoodrdered = new ArrayList<>();
        map = new HashMap<>();

        total = 0;

        intent = getIntent();
        bundle = intent.getExtras();
        if(bundle != null){
            map = (HashMap<String, Integer>) bundle.getSerializable("Map");

            listFoodrdered = (ArrayList<Food>) bundle.getSerializable("ListFood");
            total = bundle.getInt("Total",0);
        }
        tvTotal.setText(total +"$");

        foodOrderAdapter = new FoodOrderAdapter(listFoodrdered,map);
        lvFoodOrdered.setAdapter(foodOrderAdapter);

    }
}