package com.frozyice.serviceexercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, RingService.class);

    }

    @Override
    protected void onPause() {
        super.onPause();
        this.timerHandler();
    }

    private void timerHandler() {
        final Handler handler = new Handler();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        };
        timer.schedule(timerTask, 10000);

    }

    public void onBtnStart(View view) {

        startService(intent);
    }

    public void onBtnStop(View view) {
        //Intent intent = new Intent(this, RingService.class);
        stopService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (timer.equals(true)) timer.cancel();

    }
}
