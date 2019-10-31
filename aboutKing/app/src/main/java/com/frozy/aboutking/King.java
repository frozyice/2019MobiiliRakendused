package com.frozy.aboutking;

public class King {
    private String name, text;
    private int from;
    private int to;

    public King(String name, int from, int to, String text) {
        this.name = name;
        this.text = text;
        this.from = from;
        this.to = to;
    }


    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String toString() {
        return name;
    }

    public String getKing() {return name + " reigned " + from + " to " + to; }
}
