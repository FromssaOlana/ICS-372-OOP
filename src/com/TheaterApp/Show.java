package com.TheaterApp;

import java.util.*;
import java.util.List;

public class Show {
    private String showName;
    private Calendar showStartDate;
    private Calendar showEndDate;
    private Client client;
    private List bookedCustumersList = new LinkedList<Customer>();

    public Show(String showName, String showStartDate, String showEndDate) {

        String startDate = showStartDate; // dd/mm/yyyy
        String[] stringArray = startDate.split("/");
        int[] intArray = new int[stringArray.length];
        this.showStartDate = new GregorianCalendar(intArray[2],intArray[1],intArray[0]);

        String endDate = showStartDate;
        String[] stringArray2 = endDate.split("/");
        int[] intArray2 = new int[stringArray2.length];

        this.showEndDate = new GregorianCalendar(intArray2[2],intArray2[1],intArray2[0]);
        this.showName = showName;

    }

    public String getShowName() {
        return showName;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Client getClient(){
        return this.client;
    }

    public void setShowName(String showName) {

        this.showName = showName;
    }

    public Calendar getShowStartDate() {
        return showStartDate;
    }

    public void setShowStartDate(Calendar showStartDate) {

        this.showStartDate = showStartDate;
    }

    public Calendar getShowEndDate(){
        return showEndDate;
    }

    public void setShowEndDate(Calendar showEndDate) {

        this.showEndDate = showEndDate;
    }

    public boolean removeCustomer(Customer customer) {
        if (bookedCustumersList.remove(customer)) {
            return true;
        }
        return false;
    }
}
