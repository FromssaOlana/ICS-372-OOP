package TheaterApplication;

/**
 * Author Fromssa Olana
 * A student ticket class will represent a student type ticket.
 */

public class StudentTicket extends Ticket {
    private static final long serialVersionUID = 1L;

    public StudentTicket(double Price, String dateOfShow) {
        super(Price, dateOfShow);
        super.setTypOfTicket("Student Ticket");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
