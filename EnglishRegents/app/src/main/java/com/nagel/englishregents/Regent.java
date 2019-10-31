package com.nagel.englishregents;

import java.util.Locale;
/*
* Model class which represents a regent. */
public class Regent {
    private String name;
    private int from, to;

    public Regent(String name, int from, int to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String getRegent(){
        if (from != Integer.MIN_VALUE && to != Integer.MAX_VALUE) return String.format(Locale.getDefault(),"%s: %d - %d", name, from, to);
        else if (from != Integer.MIN_VALUE) return String.format(Locale.getDefault(),"%s: %d -", name, from);
        else if (to != Integer.MAX_VALUE) return String.format(Locale.getDefault(),"%s: - %d", name, to);
        else return  name;
    }

    public String toString(){ return  name; }
}
