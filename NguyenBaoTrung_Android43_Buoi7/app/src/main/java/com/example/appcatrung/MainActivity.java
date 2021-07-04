package com.example.appcatrung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appcatrung.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ILogin{

    public final static String KEY_USERNAME = "Admin";
    public final static String KEY_PASSWORD = "123456";

    ActivityMainBinding binding;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        loginPresenter = new LoginPresenter(this);
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = binding.tvMainUser.getText().toString().trim();
                String pass = binding.tvMainPassword.getText().toString().trim();
                loginPresenter.onLogin(user,pass);
            }
        });
    }

    @Override
    public void onLoginSuccesfull(String mess) {
            Toast.makeText(this,mess,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, FoodOrder.class);
            startActivity(intent);
            overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
    }

    @Override
    public void onLoginError(String mess) {
            Toast.makeText(this,mess,Toast.LENGTH_SHORT).show();
    }
}