package com.frozy.stopper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    private TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.txtTimer);
        if (savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }

        runTimer();
    }

    @Override
    protected void onStart() {
        if (wasRunning)
        {
            running = true;
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        wasRunning=running;
        running=false;
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onStartClick(View view) {
        running = true;
    }

    public void onStopClick(View view) {
        running = false;
    }

    public void onResetClick(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer()
    {
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600)/60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours,minutes,secs);
        timer.setText(time);
        if (running) {
            seconds++;
        }
        handler.postDelayed(this,1000);
            }
        });
    }



}
