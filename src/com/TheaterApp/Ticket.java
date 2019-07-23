package com.TheaterApp;

public abstract class Ticket {
    private String barCode;
    private double ticketPrice;
    private String dateOfShow;
    protected String TypeOfTicket = null;

    public Ticket(double regularPrice, String dateOfShow) {
        this.barCode = Integer.toString(TicketBarCodeServer.instance().getBarCode());
        this.ticketPrice = regularPrice;
        this.dateOfShow = dateOfShow;
    }

    public void setTypOfTicket(String typeOfTicket){
        this.TypeOfTicket = typeOfTicket;
    }

    @Override
    public String toString() {
        return "Ticket" +
                "\n barCode='" + barCode +
                "\n ticketPrice=" + ticketPrice +
                "\n dateOfShow='" + dateOfShow +
                "\n TypOfTicket='" + TypeOfTicket ;
    }
}
