package com.frozyice.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.namesList);
    }

    List<String> names = new ArrayList<>();


    public void addName(View view)
    {
        EditText firstName = findViewById(R.id.editTextFirstName);
        EditText lastName = findViewById(R.id.editTextLastName);

        if (!firstName.getText().toString().equals("") && !lastName.getText().toString().equals(""))
        {
            names.add(firstName.getText().toString() + " " + lastName.getText().toString());
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
            list.setAdapter(arrayAdapter);

            firstName.setText("");
            lastName.setText("");
        }

        else
        {
            Toast.makeText(getApplicationContext(),"Please enter first and last name!", Toast.LENGTH_LONG).show();
        }
    }

    public void clear (View view)
    {
        EditText firstName = findViewById(R.id.editTextFirstName);
        EditText lastName = findViewById(R.id.editTextLastName);

        firstName.setText("");
        lastName.setText("");
    }





}
