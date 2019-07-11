package com.TheaterApp;

import Library.Library;
import Library.MemberIdServer;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Theater implements Serializable {
    private static final long serialVersionUID = 1L;
    private Wallet wallet;
    private ShowCatalog showCatalog;
    private ClientList clientList;
    private CustomerList customerList;
    private static Theater theater;

    private Theater(){
        wallet = Wallet.instance();
        showCatalog = ShowCatalog.instance();
        clientList = ClientList.instance();
        customerList = CustomerList.instance();
    }

    public static Theater instance(){
        if (theater == null){
            // instantiating all singletons
            CustomerIdServer.instance();
            ClientIdServer.instance();
            return theater = new Theater();
        }else{
           return theater;
        }
    }

    /**
     * Organizes the operations for adding client
     * @param name
     * @param address
     * @param phoneNumber
     * @return
     */
    public Client addClient( String name, String address, String phoneNumber){
        Client client = new Client(name,address,phoneNumber);
        if (clientList.addClient(client)){
            return client;
        }else{
            return null;
        }
    }

    public boolean removeClient(String clientId){
        Client client = clientList.search(clientId);
        if (clientList.search(clientId) != null){
            if (client.getShow() == null || client.getShow().getShowEndDate().before(Calendar.getInstance()) ) {
                clientList.removeClient(clientId);
                return true;
            }
        }
        return false;

    }

    public String clientList(){
        return clientList.toString();

    }

    public Customer addCustomer(String name, String address,
                            String phoneNumber, String cardNumber, String expDate){
        Customer customer = new Customer(name,address,phoneNumber);
        CreditCard card = new CreditCard(cardNumber,expDate, customer.getId());

        if (!wallet.cardExist(card)){
            card.setCustomersID(customer.getId());// setting the owner of the card
            customer.addCard(card); // setting the card to the owner
            customerList.insertCustomer(customer);
            wallet.addCard(card);
            return customer;
        }
       return null;
    }

    public boolean removeCustomer(String customerID) {
        Customer customer = customerList.search(customerID);
        if (customerList.search(customerID ) != null){
            wallet.remove(customerID);
            customerList.removeCustomer(customerID);
            return true;
        }
        return false;

    }

    public boolean addCreditCard(String customerID,String cardNumber, String expDate){
        if (!wallet.cardUsed(cardNumber)){
           Customer customer = customerList.search(customerID);
           CreditCard card = new CreditCard(cardNumber,expDate,customerID);

           customer.addCard(card);
           card.setCustomersID(customerID);
           wallet.addCard(card);
           return true;
        }
        return false;

    }

    public boolean removeCreditCard(String cardNumber){
        Customer customer = customerList.searchByCard(cardNumber);
        CreditCard card = wallet.search(cardNumber);
        if (customer.numOfCard()>1){
            customer.removeCard(card);
            wallet.removeCard(card);
            return true;
        }
        return false;
    }

    public String listOfCustomers(){
        return customerList.toString();
    }

// Note done. check the availability of the date first.
    public Show addShow(String showName, String clientID, String strDate, String endDate ){ // dd/mm/yyyy format
            Show show = new Show(showName, strDate,endDate);
           Client client = clientList.search(clientID);
           client.setShow(show);
           show.setClient(client);
           showCatalog.addShow(show);
           return show;

    }

    public String listOfShow(){
       return showCatalog.toString();
    }


    public static Theater retrieve() {
        try {
            FileInputStream file = new FileInputStream("TheaterData");
            ObjectInputStream input = new ObjectInputStream(file);
            input.readObject();
            CustomerIdServer.retrieve(input);
            ClientIdServer.retrieve(input);
            return theater;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return null;
        }
    }


    /**
     * Serializes the Theater object
     * @return true iff the data could be saved
     */
    public static  boolean save() {
        try {
            FileOutputStream file = new FileOutputStream("TheaterData");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(theater);
            output.writeObject(MemberIdServer.instance());
            return true;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }
    /**
     * Writes the object to the output stream
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(theater);
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }
    /**
     * Reads the object from a given stream
     * @param input the stream to be read
     */
    private void readObject(ObjectInputStream input) {
        try {
            input.defaultReadObject();
            if (theater == null) {
                theater = (Theater) input.readObject();
            } else {
                input.readObject();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /** String form of the library
     *
     */
    @Override
    public String toString() {
        return customerList + "\n" +
                clientList + "\n"+ showCatalog +"\n"+ wallet;
    }
}



