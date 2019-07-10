package com.TheaterApp;

import Library.Book;
import Library.Hold;
import Library.MemberIdServer;
import Library.Transaction;

import java.io.Serializable;
import java.util.*;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phone;
    private String id;
    private static final String CUSTOMER_STRING = "CUSTOMER";
    private List showsBooked = new LinkedList();
    private List creditCards = new LinkedList();
    private List transactions = new LinkedList();
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
    /**
     * Stores the book as issued to the member
     * @param show the book to be issued
     * @return true iff the book could be marked as issued. always true currently
     */
    public boolean bookShow(Show show) {
        if (showsBooked.add(show)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param show
     * @return
     */
    public boolean cancelShow(Show show) {
       int index = showsBooked.indexOf(show);
       Show show1 = (Show) showsBooked.get(index);
        if ( showsBooked.remove(show) && show1.removeCustomer(this)){
            return true;
        }
        return false;
    }

    /**
     * Gets an iterator to the shows that is booked
     * @return Iterator to the collection of issued books
     */
    public Iterator getBookedShows() {
        return (showsBooked.listIterator());
    }

    /**
     * Removes a hold
     * @param bookId the book id for removing a hold
     * @return true iff the hold could be removed
     */
    public boolean removeHold(String bookId) {
        for (ListIterator iterator = creditCards.listIterator(); iterator.hasNext(); ) {
            Hold hold = (Hold) iterator.next();
            String id = hold.getBook().getId();
            if (id.equals(bookId)) {
                transactions.add(new Transaction ("Hold Removed ", hold.getBook().getTitle()));
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    /**
     * Gets an iterator to a collection of selected ransactions
     * @param date the date for which the transactions have to be retrieved
     * @return the iterator to the collection
     */
    public Iterator getTransactions(Calendar date) {
        List result = new LinkedList();
        for (Iterator iterator = transactions.iterator(); iterator.hasNext(); ) {
            Transaction transaction = (Transaction) iterator.next();
            if (transaction.onDate(date)) {
                result.add(transaction);
            }
        }
        return (result.iterator());
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
     * Setter for address
     * @param newAddress member's new address
     */
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    /**
     * Setter for phone
     * @param newPhone member's new phone
     */
    public void setPhone(String newPhone) {
        phone = newPhone;
    }
    /**
     * Checks whether the member is equal to the one with the given id
     * @param id of the member who should be compared
     * @return true iff the member ids match
     */
    public boolean equals(String id) {
        return this.id.equals(id);
    }

}