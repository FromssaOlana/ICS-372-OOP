package TheaterApplication;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Author Fromssa Olana
 * A client class
 */
public class Client implements Serializable, Matchable<String> {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private Show show;
    private String id;
    private double balance;
    private String phoneNumber;
    private static final String CLIENT_STRING = "CLIENT";
    private List<Ticket> soldTickets = new LinkedList<>();

    /**
     * A client constructor
     * @param name
     * @param address
     * @param phoneNumber
     */
    Client(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
        this.id = CLIENT_STRING + ClientIdServer.instance().getId();
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    void addBalance(double balance) {
        this.balance += balance;
    }

    String getName() {
        return name;
    }

    Show getShow() {
        return show;
    }

    void setShow(Show show) {
        this.show = show;
    }

    boolean addTicket(Ticket ticket) {
        return soldTickets.add(ticket);
    }

    @Override
    public String toString() {
        return
                "Client name: " + name +
                        "\nAddress: " + address +
                        "\nShow: " + show +
                        "Id: " + id +
                        "\nBalance: " + balance +
                        "\nPhoneNumber: " + phoneNumber + "\n";
    }

    @Override
    public boolean matches(String key) {
        return this.id.equals(key);
    }
}
