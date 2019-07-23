package com.TheaterApp;

public class RegularTicket extends Ticket {

    public RegularTicket(double Price, String dateOfShow) {
        super(Price,dateOfShow);
        super.TypeOfTicket = "Regular Ticket";

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
