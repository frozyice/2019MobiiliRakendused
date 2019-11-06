package com.frozyice.serviceexercise2;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FiveSecService extends IntentService {
    private Handler handler;


    public FiveSecService() {
        super("service");
        handler = new Handler();
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String message = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss", Locale.getDefault()).format(new Date());

        Toaster toaster = new Toaster(this);
        toaster.ShowToast(message);

    }
}