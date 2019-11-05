package com.frozyice.serviceexercise2;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FiveSecService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void start() {
        Thread thread = new Thread(new Toaster());
        thread.start();
    }

    private class Toaster implements Runnable {
        @Override
        public void run() {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Toast.makeText(getApplicationContext(),"Your message",Toast.LENGTH_LONG).show();

        }
    }
}

/*
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();*/
