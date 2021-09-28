package com.mine.noting;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.mine.noting.ui.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private final String TAG = "SplashActivity";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        // open main activity after delay ms
        loadMain();
    }

    private void loadMain(){

        Handler handler = new Handler();
        handler.postDelayed(() -> {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(intent);
            finish();

        },3000); // this could cause not exact 3000ms
    }
}
