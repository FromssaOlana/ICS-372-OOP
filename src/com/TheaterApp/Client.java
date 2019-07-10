package com.TheaterApp;

import Library.Book;
import Library.Hold;
import Library.Transaction;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private Show show;
    private String id;
    private String phoneNumber;
    private static final String CLIENT_STRING = "CLIENT";
    private List creditCards = new LinkedList();
    private List bookedShows = new LinkedList();

    public Client(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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


}
