package com.TheaterApp;

import java.util.*;
import java.util.List;

public class Show implements Matchable<String>, Comparable {
    private String showName;
    private ShowTime showTime;
    private Client client;
    private double ticketPrice;
    private List bookedCostumersList = new LinkedList<Customer>();

    public Show(String showName, ShowTime showTime, Client client, double ticketPrice) {
        this.showName = showName;
        this.showTime = showTime;
        this.client = client;
        this.ticketPrice = ticketPrice;
    }

    public String getShowName() {

        return showName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public Client getClient(){

        return this.client;
    }
    public Calendar getShowStartDate() {

        return showTime.getStartDate();
    }

    public Calendar getShowEndDate(){

        return showTime.getEndDate();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean removeCustomer(Customer customer) {
        if (bookedCostumersList.remove(customer)) {
            return true;
        }
        return false;
    }

    @Override // to string needs to be fixed
    public String toString() {
       return "Show Name: "+showName + "\nShow host: " + client.getName() + "\n"+
                this.showTime.toString();
    }

    @Override
    public boolean matches(String key) {
        return this.showName.equals(key);
    }


    @Override
    public int compareTo(Object other) {
        Show show = (Show)other;
        return this.showTime.compareTo(show.showTime);
    }
}
