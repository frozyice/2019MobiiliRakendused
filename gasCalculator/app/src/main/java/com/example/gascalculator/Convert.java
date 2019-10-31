package com.example.gascalculator;

import android.content.Context;
import android.os.Debug;
import android.text.Editable;
import android.util.Log;
import android.widget.Toast;

import java.text.DecimalFormat;


public class Convert {

    private double Distance;
    private double Economy;
    private double Price;
    private double NoOfPeople;

    public Convert(String distance, String economy, String price, String noOfPeople) {
        Distance = Double.parseDouble(distance);
        Economy = Double.parseDouble(economy);
        Price = Double.parseDouble(price);
        NoOfPeople = Double.parseDouble(noOfPeople);

        if(NoOfPeople<=0)
            NoOfPeople=1;
    }


    public double fuelUsed()
    {
        return Distance/100*Economy;
    }

    public double fuelCost()
    {
        return fuelUsed()*Price;
    }

    public double costPerPerson()
    {
        return fuelCost()/NoOfPeople;
    }

}


