package com.vilkre.conversion;

public class converter {
    public static final double factor =1.609344;

    public static double toKM(double miles)
    {
        return miles * factor;
    }

    public static double toMiles(double kilometers)
    {
        return kilometers / factor;
    }
}
