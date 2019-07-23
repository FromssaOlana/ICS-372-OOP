package com.TheaterApp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CustomerList extends ItemList<Customer,String> implements Serializable {


    private static final long serialVersionUID = 1L;
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
      if (customerList == null){
          return new CustomerList();
      }else {
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

        return super.search(customerId);
    }
    /**
     * Inserts a member into the collection
     * @param customer the member to be inserted
     * @return true iff the member could be inserted. Currently always true
     */
    public boolean addCustomer(Customer customer) {
        return super.add(customer);
    }

    public boolean removeCustomer(Customer customer){
       return super.remove(customer);
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
    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {

        input.defaultReadObject();
        if (customerList == null) {
            customerList = (CustomerList) input.readObject();
        } else {
            input.readObject();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
