package com.TheaterApp;
import java.io.*;
import java.util.Calendar;


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
        if (client!= null){
            if (client.getShow() == null || client.getShow().getShowEndDate().before(Calendar.getInstance()) ) {
              return clientList.removeClient(client);
            }
            System.out.println("Client has a booked show.");
        }else {
            System.out.println("There is no such client.");
        }
        return false;

    }

    public Customer addCustomer(String name, String address,
                            String phoneNumber, String cardNumber, String expDate){
        Customer customer = new Customer(name,address,phoneNumber);
        CreditCard card = new CreditCard(cardNumber,expDate, customer.getId());
        if (wallet.search(cardNumber) == null){
            customer.addCard(card);
            card.setCustomersID(customer.getId());
            wallet.addCard(card);
            customerList.addCustomer(customer);
            return customer;
        }
        return null;

    }

    public boolean removeCustomer(Customer customer) {
        if (customerList.search(customer.getId()) != null){
            wallet.removeAssociatedCards(customer.getId());
            return  customerList.removeCustomer(customer);

        }
        return false;

    }

    public boolean addCreditCard(String customerID,String cardNumber, String expDate) {
        if (wallet.search(cardNumber) == null) {
            Customer customer = customerList.search(customerID);
            CreditCard card = new CreditCard(cardNumber, expDate, customerID);
            customer.addCard(card);
            card.setCustomersID(customerID);
            wallet.addCard(card);
            return true;
        }else {
            System.out.println("Credit card is already used!");
            return false;
        }
    }



// Note done. check the availability of the date first.
    public Show addShow(String showName, String clientID, String strDate, String endDate ){ // dd/mm/yyyy format
            ShowTime showTime = new ShowTime(strDate,endDate);
           Client client = clientList.search(clientID);
           if ((client != null) && showTime.getStartDate().before(showTime.getEndDate())){
               Show show = new Show(showName,showTime,client);
               client.setShow(show);
               show.setClient(client);
               showCatalog.addShow(show);
               return show;

           }else {
               return null;
           }
    }

    public String listOfCustomers(){
        return customerList.toString();
    }
    public String clientList(){
        return clientList.toString();

    }

    public String listOfShow(){
       return showCatalog.toString();
    }


    public static Theater retrieve() {
        try {
            FileInputStream file = new FileInputStream("TheaterData");
            ObjectInputStream input = new ObjectInputStream(file);
            input.readObject();
            //CustomerIdServer.retrieve(input);
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
           output.writeObject(CustomerIdServer.instance());
            output.writeObject(ClientIdServer.instance());
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



    public boolean removeCreditCard(String credit_card_number) {
        if (wallet.search(credit_card_number) == null) {
            System.out.println("Wallet is empty!");
            return false;
        }
        CreditCard card = wallet.search(credit_card_number);
        if (card != null) {
            Customer customer = customerList.search(card.getCustomersID());
            if (customer.numOfCard() > 1) {
                customer.removeCard(card);
                wallet.removeCard(card);
                return true;
            }

        }
        return false;
    }


    public Customer searchCustomer(String customer_id) {
        return customerList.search(customer_id);
    }
}



