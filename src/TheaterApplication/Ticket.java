package TheaterApplication;

import java.io.Serializable;

/**
 * An abstract class to be extended by all three ticket types.
 */

public abstract class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private String barCode;
    private double ticketPrice;
    private String dateOfShow;
    private String TypeOfTicket = null;

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
                " barCode: " + barCode +
                ",  ticketPrice: " + ticketPrice +
                ",  dateOfShow: " + dateOfShow +
                ",  TypOfTicket: " + TypeOfTicket +"\n";
    }
}
