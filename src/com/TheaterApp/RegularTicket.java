package com.TheaterApp;

import java.io.Serializable;

public class RegularTicket extends Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    public RegularTicket(double Price, String dateOfShow) {

        super(Price,dateOfShow);
        super.setTypOfTicket("Regular Ticket");

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
