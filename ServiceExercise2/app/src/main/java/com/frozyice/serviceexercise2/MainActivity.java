package com.frozyice.serviceexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static Random rand = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartService(View view) {
        Intent intent = new Intent (this, FiveSecService.class);
        startService(intent);



    }

    public void onChangeColor(View view) {
        getWindow().getDecorView().setBackgroundColor(Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

    }
}
