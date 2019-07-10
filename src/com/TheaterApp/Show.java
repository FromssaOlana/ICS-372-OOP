package com.TheaterApp;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Show {
    private  String playName;
    private Calendar playStartDate;
    private Calendar playEndDate;
    private String showID;
    private static final String SHOW_STRING = "SHOW ";
    private List bookedCustumersList = new LinkedList<Customer>();

    public Show(String playName){
        this.playName = playName;
        showID = SHOW_STRING + ShowIdServer.instance().getId();
    }

    public String getId() {
        return showID;
    }


    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public Calendar getPlayStartDate() {
        return playStartDate;
    }

    public void setPlayStartDate(Calendar playStartDate) {
        this.playStartDate = playStartDate;
    }

    public Calendar getPlayEndDate() {
        return playEndDate;
    }

    public void setPlayEndDate(Calendar playEndDate) {
        this.playEndDate = playEndDate;
    }

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    public boolean removeCustomer(Customer customer) {
        if (bookedCustumersList.remove(customer)){
            return true;
        }
        return false;
    }
}
