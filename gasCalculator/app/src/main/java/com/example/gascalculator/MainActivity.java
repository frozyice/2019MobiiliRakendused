package com.example.gascalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class 1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc (View view) {
        EditText distance = findViewById(R.id.editTripDis);
        EditText economy = findViewById(R.id.editFuelEco);
        EditText price = findViewById(R.id.editFuelPrice);
        EditText noOfPeople = findViewById(R.id.editPeople);

        String distanceStr = distance.getText().toString();
        String economyStr = economy.getText().toString();
        String priceStr = price.getText().toString();
        String noOfPeopleStr = noOfPeople.getText().toString();

        TextView fuelUsed = findViewById(R.id.editFuelUsed);
        TextView cost = findViewById(R.id.editCost);
        TextView costPerPerson = findViewById(R.id.editCostperPerson);

        if (noOfPeopleStr.length()==0)
            noOfPeopleStr="1";

        if (distanceStr.length()==0 || economyStr.length()==0 || priceStr.length()==0)
            Toast.makeText(getApplicationContext(),"Please fill all the required fields!",Toast.LENGTH_LONG).show();
        else
        {
            Convert convert = new Convert(distanceStr, economyStr, priceStr, noOfPeopleStr);

            fuelUsed.setText(String.format("%.2f",convert.fuelUsed()));
            cost.setText(String.format("%.2f",convert.fuelCost()));
            costPerPerson.setText(String.format("%.2f",convert.costPerPerson()));
        }
    }
}
