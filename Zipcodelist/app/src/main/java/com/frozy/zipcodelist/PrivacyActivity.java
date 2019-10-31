package com.frozy.zipcodelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class PrivacyActivity extends AppCompatActivity {

    private CheckBox agreed;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        agreed = findViewById(R.id.checkbox);

        timer = new CountDownTimer(8000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Toast.makeText(PrivacyActivity.this, getResources().getString(R.string.toastMessage),Toast.LENGTH_LONG).show();
            this.start();
            }
        }.start();

       agreed.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               boolean checked = ((CheckBox)view).isChecked();
               if (checked)
               {
                   Intent start = new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(start);
                   timer.cancel();
               }
           }
       });

    }
}
