package com.frozyice.queuemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    boolean isOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toggleButton = findViewById(R.id.toggleButton);

        if (getIntent().getExtras() != null)
        {
            if ((getIntent().getStringExtra("isOpen")).equals("true")) isOpen=true;
            else isOpen=false;

            toggleButton.setChecked(isOpen);

        }




    }



    public void onReturn(View view) {

        finish();

    }
}
