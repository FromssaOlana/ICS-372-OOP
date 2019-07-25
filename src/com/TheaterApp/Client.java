package com.TheaterApp;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public Client(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
        this.id = CLIENT_STRING + ClientIdServer.instance().getId();
    }

    public String getName() {
        return name;
    }
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public boolean addTicket(Ticket ticket){
        return soldTickets.add(ticket);
    }

    public boolean equals(String id) {

        return this.id.equals(id);
    }

    @Override
    public String toString() {
        return
                "Client name: " + name +
                "\nAddress: " + address +
                "\nShow: " + show +
                "Id: " + id  +
                "\nBalance: " + balance +
                "\nPhoneNumber: " + phoneNumber+"\n";
    }

    @Override
    public boolean matches(String key) {
        return this.id.equals(key);
    }
}
