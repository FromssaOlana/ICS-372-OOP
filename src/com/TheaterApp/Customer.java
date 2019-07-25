package com.TheaterApp;
import java.util.Iterator;
import java.io.Serializable;
import java.util.*;

public class Customer implements Serializable, Matchable<String> {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phone;
    private String id;
    private static final String CUSTOMER_STRING = "CUSTOMER";
    private List<CreditCard> creditCards = new LinkedList<>();
    private List<Ticket> tickets = new LinkedList<>();
   // private List transactions = new LinkedList();
    /**
     * Represents a single member d
     * @param name name of the member
     * @param address address of the member
     * @param phone phone number of the member
     */
    public  Customer (String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        id = CUSTOMER_STRING + (CustomerIdServer.instance()).getId();
    }
    public boolean addCard(CreditCard card){
        if (card != null){
            creditCards.add(card);
            return true;
        }
        return  false;
    }

    public boolean removeCard(CreditCard card){
        if (!(creditCards.size() == 0 )){
            creditCards.remove(card);
            return true;
        }
        return false;
    }

    public int numOfCard(){
        return creditCards.size();
    }

    public boolean hasCard(String cardNumber) {
        for (Iterator iterator = creditCards.iterator(); iterator.hasNext(); ) {
            CreditCard card = (CreditCard) iterator.next();
            if (card.getCardNumber().equals(cardNumber)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Getter for name
     * @return member name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for phone number
     * @return phone number
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Getter for address
     * @return member address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Getter for id
     * @return member id
     */
    public String getId() {
        return id;
    }
    /**
     * Setter for name
     * @param newName member's new name
     */
    public void setName(String newName) {
        name = newName;
    }


    /**
     * Checks whether the member is equal to the one with the given id
     * @param id of the member who should be compared
     * @return true iff the member ids match
     */
    public boolean equals(String id) {

        return this.id.equals(id);
    }

    public String print(){
        return "Customer" +
                " name: " + name +
                "\naddress: " + address +
                "\nphone: " + phone +
                "\nId: " + id;
    }
    @Override
    public String toString() {
        return "Customer" +
               " name: " + name +
                "\nAddress: " + address +
                "\nPhone: " + phone +
                "\nId: " + id +
                "\nCreditCards: " + creditCards +
                "\nTickets: " + tickets +"\n";
    }

    @Override
    public boolean matches(String key) {
        return this.id.equals(key);
    }

    public void addTicket(Ticket regularTicket) {
        tickets.add(regularTicket);
    }
}