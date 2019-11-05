package com.frozyice.queuemanager;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private String currentPhonenumber;
    private List<String> phonenumbersList;
    private boolean isAcceptingNewPeople;

    public Queue(){
        phonenumbersList = new ArrayList<>();
    }

    public String getCurrentPhonenumber() {
        return currentPhonenumber;
    }

    public void setCurrentPhonenumber(String currentPhonenumber) {
        this.currentPhonenumber = currentPhonenumber;
    }

    public List<String> getPhonenumbersList() {
        return phonenumbersList;
    }

    public void setPhonenumbersList(List<String> phonenumbersList) {
        this.phonenumbersList = phonenumbersList;
    }
}
