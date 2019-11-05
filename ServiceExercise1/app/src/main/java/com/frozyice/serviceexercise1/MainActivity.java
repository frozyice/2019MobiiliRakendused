package com.frozyice.serviceexercise1;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TimeService service;
    private char c = 'e';



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        service = new TimeService();
        String string = "We test coders. Give us a try";

       String sentence = "dajadsdjd aksljsfdalk ";
       int length = sentence.length();

       Arrays.sort(a);





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
