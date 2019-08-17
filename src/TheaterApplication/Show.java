package TheaterApplication;

import java.io.Serializable;
import java.util.*;

/**
 * Author Fromssa Olana
 * A show class will represent a show and will hold all attributes.
 */

public class Show implements Matchable<String>, Comparable, Serializable {
    private static final long serialVersionUID = 1L;
    private String showName;
    private ShowTime showTime;
    private Client client;
    private double ticketPrice;


    Show(String showName, ShowTime showTime, Client client, double ticketPrice) {
        this.showName = showName;
        this.showTime = showTime;
        this.client = client;
        this.ticketPrice = ticketPrice;
    }

    double getTicketPrice() {
        return ticketPrice;
    }

    public Client getClient() {

        return this.client;
    }

    Calendar getShowStartDate() {

        return showTime.getStartDate();
    }

    Calendar getShowEndDate() {

        return showTime.getEndDate();
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public String toString() {
        return "Show Name: " + showName + "\nShow host: " + client.getName() + "\n" +
                this.showTime.toString();
    }

    @Override
    public boolean matches(String key) {
        return this.showName.equals(key);
    }


    @Override
    public int compareTo(Object other) {
        Show show = (Show) other;
        return this.showTime.compareTo(show.showTime);
    }
}
