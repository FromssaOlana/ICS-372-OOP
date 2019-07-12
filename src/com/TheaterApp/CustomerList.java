package com.TheaterApp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomerList {


    private static final long serialVersionUID = 1L;
    private List customers = new LinkedList();
    private static CustomerList customerList;
    /*
     * Private constructor for singleton pattern
     *
     */
    private CustomerList() {
    }
    /**
     * Supports the singleton pattern
     *
     * @return the singleton object
     */
    public static CustomerList instance() {
        if (customerList == null) {
            return (customerList = new CustomerList());
        } else {
            return customerList;
        }
    }
    /**
     * Checks whether a member with a given member id exists.
     * @param customerId the id of the member
     * @return true iff member exists
     *
     */
    public Customer search(String customerId) {
        for (Iterator iterator = customers.iterator(); iterator.hasNext(); ) {
            Customer customer = (Customer) iterator.next();
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public Customer searchByCard(String cardNumber) {
        for (Iterator iterator = customers.iterator(); iterator.hasNext(); ) {
            Customer customer = (Customer) iterator.next();
            if (customer.hasCard(cardNumber)) {
                return customer;
            }
        }
        return null;
    }
    /**
     * Inserts a member into the collection
     * @param customer the member to be inserted
     * @return true iff the member could be inserted. Currently always true
     */
    public boolean insertCustomer(Customer customer) {
        customers.add(customer);
        return true;
    }

    public boolean removeCustomer(String customerId){
        Customer customer = search(customerId);
        if (customer == null){
            return false;
        }else {
            customers.remove(customer);
            return true;
        }
    }
    /*
     * Supports serialization
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(customerList);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    /*
     * Supports serialization
     *  @param input the stream to be read from
     */
    private void readObject(ObjectInputStream input) {
        try {
            if (customerList != null) {
                return;
            } else {
                input.defaultReadObject();
                if (customerList == null) {
                    customerList = (CustomerList) input.readObject();
                } else {
                    input.readObject();
                }
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    /** String form of the collection
     *
     */
    @Override
    public String toString() {
        return customers.toString();
    }
}
