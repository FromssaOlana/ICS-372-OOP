package TheaterApplication;

import java.io.Serializable;

/**
 * Author Fromssa Olana
 * A regularTicket class will hold an attribute of a regular ticket.
 */

public class RegularTicket extends Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    RegularTicket(double Price, String dateOfShow) {

        super(Price,dateOfShow);
        super.setTypOfTicket("Regular Ticket");

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
