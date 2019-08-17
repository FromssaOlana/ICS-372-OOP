package TheaterApplication;

/**
 * Author Fromssa Olana
 * An Advanced Ticket class.
 */
public class AdvancedTicket extends Ticket{
    private static final long serialVersionUID = 1L;

   AdvancedTicket(double Price, String dateOfShow) {
        super(Price, dateOfShow);
        super.setTypOfTicket("Advanced Ticket");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
