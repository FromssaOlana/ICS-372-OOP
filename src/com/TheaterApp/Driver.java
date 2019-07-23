package com.TheaterApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;



public class Driver
{
    public static void main(String[] args) {
     ShowTime showTime = new ShowTime("12/12/2000","01/15/2020");
        ShowTime showTime2 = new ShowTime("12/12/2001","07/15/2020");
        ShowTime showTime3 = new ShowTime("12/12/2002","09/15/2020");
    Client client = new Client("Fromssa ","372 ajfaj","823797322");
        Client client2 = new Client("yidi ","372 ajfaj","823797322");
     Show show = new Show("Tommy and Jerry",showTime, client);
        Show show2 = new Show("Tommy and Jerry",showTime, client);

    // System.out.println(show.toString());

    }

}
