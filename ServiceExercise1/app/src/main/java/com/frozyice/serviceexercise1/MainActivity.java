package com.frozyice.serviceexercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TimeService service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        service = new TimeService();
    }

    public void StartService(View view) {
        service.start();
        textView.setText("connected");
    }

    public void ShowDate(View view) {
        if (!service.isRunning)
            textView.setText("not connected");
        else
            textView.setText(service.date);
    }

    public void ShowTime(View view) {
        if (!service.isRunning)
            textView.setText("not connected");
        else
            textView.setText(service.time);
    }
}
