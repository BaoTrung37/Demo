package com.example.appcatrung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingBuildInfo;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appcatrung.databinding.ActivityMainBinding;
import com.example.appcatrung.databinding.ActivityShoppingCartBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart extends AppCompatActivity {

    private ArrayList<Food> listFoodrdered;
    private HashMap<String,Integer> map;
    private FoodOrderAdapter foodOrderAdapter;

    private int total;
    private Intent intent;
    private Bundle bundle;

    private ActivityShoppingCartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        connectView();

        binding.imageForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,intent);
                finish();
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });

    }

    private void connectView() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_shopping_cart);
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
        binding.textCartTotal.setText(total +"$");

        foodOrderAdapter = new FoodOrderAdapter(listFoodrdered,map);
        binding.listviewCart.setAdapter(foodOrderAdapter);

    }
}