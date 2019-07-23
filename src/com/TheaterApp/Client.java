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
    private List creditCards = new LinkedList();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
        this.id = CLIENT_STRING + ClientIdServer.instance().getId();
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getId() {

        return id;
    }

    public boolean equals(String id) {

        return this.id.equals(id);
    }
    public String toString(){
        return "\nName: "+ this.name + "\nAddress: " + this.address+ "\nClient ID: "+ this.id+"\n";
    }


    @Override
    public boolean matches(String key) {
        return this.id.equals(key);
    }
}
