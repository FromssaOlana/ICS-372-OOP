package com.TheaterApp;

public class Themain {

    public static void main(String[] args) {
        Theater theater = Theater.instance();

       // Client client1 = new Client("Fromssa", "1970 Burns","98272788");

        theater.addClient("Fromssa", "1970 Burns","98272788");
        theater.addClient("Olana", "1970 Burns","98272788");

        theater.addCustomer("Yididya", "1970 Burns","98272788","1234567890","09/2022");
        theater.addCustomer("babay", "1970 Burns","98272788","1234567890","09/2022");

       theater.clientList();

    }
}
