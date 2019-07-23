package com.TheaterApp;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ShowTime implements Comparable  {
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }


    public ShowTime(String showStartDate, String showEndDate) {

        String startDate = showStartDate; // dd/mm/yyyy
        String[] stringArray = startDate.split("/");
        this.startDate = new GregorianCalendar(Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[1])-1,Integer.valueOf(stringArray[0])-0);

        String endDate = showEndDate;
        String[] stringArray2 = endDate.split("/");
        this.endDate = new GregorianCalendar(Integer.valueOf(stringArray2[2]),
                Integer.valueOf(stringArray2[1])-1,Integer.valueOf(stringArray2[0]));

    }
    @Override
    public int compareTo(Object other) {
        ShowTime showTime = (ShowTime) other;

            return this.startDate.compareTo(showTime.getStartDate());
    }

    @Override
    public String toString() {
        return "ShowTime: " +
                "startDate = " + startDate.get(Calendar.DATE) +"/"+ startDate.get(Calendar.MONTH) +"/"+ startDate.get(Calendar.YEAR) +
                " - endDate = " + endDate.get(Calendar.DATE) +"/"+endDate.get(Calendar.MONTH) +"/"+ endDate.get(Calendar.YEAR);
    }
}
