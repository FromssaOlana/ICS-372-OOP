package com.TheaterApp;

public class AdvancedTicket extends Ticket{
    public AdvancedTicket(double Price, String dateOfShow) {
        super(Price, dateOfShow);
        super.TypeOfTicket = "Advanced Ticket";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
