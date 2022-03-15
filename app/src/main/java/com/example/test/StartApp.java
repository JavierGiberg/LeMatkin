package com.example.test;

import android.content.Intent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

public class StartApp extends AppCompatActivity {
    private static  int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(StartApp.this, MainActivity2.class);
                StartApp.this.startActivity(mainIntent);
                StartApp.this.finish();
            }
        }, SPLASH_TIME_OUT);




    }
    }
