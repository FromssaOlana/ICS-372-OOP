package com.TheaterApp;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Author Fromssa Olana
 * A showTime class is a class that sets a show time for a show.
 */

public class ShowTime implements Comparable, Serializable {
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;


    public ShowTime(String showStartDate, String showEndDate) {

        String startDate = showStartDate; // dd/mm/yyyy
        String[] stringArray = startDate.split("/");
        String endDate = showEndDate;
        String[] stringArray2 = endDate.split("/");
        if (isValidDate(stringArray) && isValidDate(stringArray2)) {
            this.startDate = new GregorianCalendar(Integer.valueOf(stringArray[2]),
                    Integer.valueOf(stringArray[1]), Integer.valueOf(stringArray[0]));


            this.endDate = new GregorianCalendar(Integer.valueOf(stringArray2[2]),
                    Integer.valueOf(stringArray2[1]), Integer.valueOf(stringArray2[0]));
        } else {
            System.out.println("Invalid date! ");
        }
    }

    GregorianCalendar getStartDate() {
        return startDate;
    }

    GregorianCalendar getEndDate() {
        return endDate;
    }

    private boolean isValidDate(String[] array) {

        if (Integer.valueOf(array[2]) < 2019) {
            return false;
        } else if (Integer.valueOf(array[1]) < 1 || Integer.valueOf(array[1]) > 12) {
            return false;
        } else if (Integer.valueOf(array[0]) < 1 || Integer.valueOf(array[0]) > 31) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object other) {
        ShowTime showTime = (ShowTime) other;

        return this.startDate.compareTo(showTime.getStartDate());
    }

    @Override
    public String toString() {
        return "ShowTime: " +
                "startDate = " + startDate.get(Calendar.DATE) + "/" + startDate.get(Calendar.MONTH) + "/" + startDate.get(Calendar.YEAR) +
                " - endDate = " + endDate.get(Calendar.DATE) + "/" + endDate.get(Calendar.MONTH) + "/" + endDate.get(Calendar.YEAR) + "\n";
    }
}
