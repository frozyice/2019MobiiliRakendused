package com.frozy.zipcodelist;

public class Zipcode {
    private String code;
    private String city;

    public Zipcode(String code, String city) {
        this.code = code;
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }


    public String toString()
    {
        return getCode() + " " + getCity();
    }

}
