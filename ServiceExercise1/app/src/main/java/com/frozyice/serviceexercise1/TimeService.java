package com.frozyice.serviceexercise1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TimeService extends Service {

    public String date;
    public String time;
    public boolean isRunning;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void start()
    {
        isRunning=true;
        Thread th = new Thread(new Clock());
        th.start();

    }

    private class Clock implements Runnable {
        @Override
        public void run() {
            do {
                date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                time = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
            } while (isRunning);


        }
    }
}

