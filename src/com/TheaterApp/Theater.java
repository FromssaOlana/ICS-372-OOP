package com.TheaterApp;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Theater implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int CLIENT_NOT_FOUND = 1;
    public static final int SHOW_NOT_FOUND  = 2;
    public static final int CUSTOMER_NOT_FOUND  = 3;
    public static final int CARD_NOT_FOUND  = 4;
   // public static final int _NOT_FOUND   = 5;
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
            ShowIdServer.instance();
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
    // not done
    public int removeClient(String clientId){
        Client client = clientList.search(clientId);
        if (client == null) {
            return(CLIENT_NOT_FOUND);
        }
        return -1;

    }
    public void clientList(){
        System.out.println(clientList.toString());

    }

    public boolean addCustomer(String name, String address,
                            String phoneNumber, String cardNumber, String expDate){
        Customer customer = new Customer(name,address,phoneNumber);
        CreditCard card = new CreditCard(cardNumber,expDate, customer.getId());

        if (customerList.insertCustomer(customer) && wallet.addCard(card)){
            return true;
        }
        return false;

    }


}
