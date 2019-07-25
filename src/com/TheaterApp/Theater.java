package com.TheaterApp;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Author Fromssa Olana
 * A Theater class is the main orchestrator of all the class.
 * It wll instantiate objects and assigns a duets according the objects purpose.
 */

public class Theater implements Serializable {
    private static final long serialVersionUID = 1L;
    private Wallet wallet;
    private ShowCatalog showCatalog;
    private ClientList clientList;
    private CustomerList customerList;
    private List<Ticket> tickets = new LinkedList<>();
    private static Theater theater;
    private double theaterBalance = 0.0;

    /*
    A private constructor
     */
    private Theater() {
        wallet = Wallet.instance();
        showCatalog = ShowCatalog.instance();
        clientList = ClientList.instance();
        customerList = CustomerList.instance();
    }

    /**
     * A singleton constructor
     * @return
     */
    public static Theater instance() {
        if (theater == null) {
            // instantiating all singletons
            CustomerIdServer.instance();
            ClientIdServer.instance();
            TicketBarCodeServer.instance();
            return theater = new Theater();
        } else {
            return theater;
        }
    }

    /**
     * Returns clients balance
     * @param clientId
     * @return
     */
    double getClientBalance(String clientId) {
        Client client = clientList.search(clientId);
        if (client != null) {
            return client.getBalance();
        }
        System.out.println("Could not find client. ");
        return -1;
    }

    /**
     * It pays a client with needed amount
     * @param amount
     * @param clientId
     */
    void payClient(double amount, String clientId) {
        Client client = clientList.search(clientId);
        if (amount > client.getBalance()) {
            System.out.println("Amount is over balance");
        } else {
            client.setBalance(client.getBalance() - amount);
            System.out.println("$" + amount + " paid to client. ");
        }
    }

    /**
     * Organizes the operations for adding client
     *
     * @param name
     * @param address
     * @param phoneNumber
     * @return
     */
    Client addClient(String name, String address, String phoneNumber) {
        Client client = new Client(name, address, phoneNumber);
        if (clientList.addClient(client)) {
            return client;
        } else {
            return null;
        }
    }

    /**
     * Removes a client from a list
     * @param clientId
     * @return boolean
     */
    boolean removeClient(String clientId) {
        Client client = clientList.search(clientId);
        if (client != null) {
            if (client.getShow() == null || client.getShow().getShowEndDate().before(Calendar.getInstance())) {
                return clientList.removeClient(client);
            }
            System.out.println("CAN NOT REMOVE. Client has a booked show.");
        } else {
            System.out.println("There is no such client.");
        }
        return false;

    }

    /**
     * Adds a customer to a list.
     * @param name
     * @param address
     * @param phoneNumber
     * @param cardNumber
     * @param expDate
     * @return customer object
     */
    Customer addCustomer(String name, String address,
                         String phoneNumber, String cardNumber, String expDate) {
        Customer customer = new Customer(name, address, phoneNumber);
        CreditCard card = new CreditCard(cardNumber, expDate, customer.getId());
        if (wallet.search(cardNumber) == null) {
            customer.addCard(card);
            card.setCustomersID(customer.getId());
            wallet.addCard(card);
            customerList.addCustomer(customer);
            System.out.println("New customer added.");
            return customer;
        }
        System.out.println("Customer could not be added. Card might be used already.");
        return null;

    }

    /**
     * Removes a customer from a list.
     * @param customer
     * @return
     */
    boolean removeCustomer(Customer customer) {
        if (customerList.search(customer.getId()) != null) {
            wallet.removeAssociatedCards(customer.getId());
            boolean b = customerList.removeCustomer(customer);
            System.out.println("Customer removed");
            return b;
        }
        System.out.println("Could not remove customer");
        return false;

    }

    /**
     * Adds Credit card to a list
     * @param customerID
     * @param cardNumber
     * @param expDate
     * @return credit card object
     */
    boolean addCreditCard(String customerID, String cardNumber, String expDate) {
        if (wallet.search(cardNumber) == null) {
            Customer customer = customerList.search(customerID);
            CreditCard card = new CreditCard(cardNumber, expDate, customerID);
            customer.addCard(card);
            card.setCustomersID(customerID);
            wallet.addCard(card);
            return true;
        } else {
            System.out.println("Credit card is already used!");
            return false;
        }
    }

    /**
     * Adds a show to a client and to a show list
     * @param showName
     * @param clientID
     * @param strDate
     * @param endDate
     * @param ticketPrice
     * @return show object
     */
    Show addShow(String showName, String clientID, String strDate, String endDate, double ticketPrice) { // dd/mm/yyyy format
        ShowTime showTime = new ShowTime(strDate, endDate);
        Client client = clientList.search(clientID);
        if ((client != null) && showTime != null) {

            if (showTime.getStartDate().before(showTime.getEndDate()) && showTime.getStartDate().after(Calendar.getInstance())) {
                Show show = new Show(showName, showTime, client, ticketPrice);
                client.setShow(show);
                show.setClient(client);
                if (showCatalog.addShow(show)) {
                    return show;
                }

            }

        }

        return null;
    }

    /**
     * Generates a regular type ticket.
     * @param quantity
     * @param customerId
     * @param cardNumber
     * @param showDate
     */
    void regularTicket(int quantity, String customerId, String cardNumber, String showDate) {

        String[] stringArray = showDate.split("/");
        Calendar date = new GregorianCalendar(Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[1]), Integer.valueOf(stringArray[0]));
        Customer customer = customerList.search(customerId);
        Show show = showCatalog.search(date);
        if (show != null && customer != null) {
            for (int i = 0; i < quantity; i++) {
                Client client = show.getClient();
                Ticket regularTicket = new RegularTicket(show.getTicketPrice(), showDate);
                tickets.add(regularTicket);
                customer.addTicket(regularTicket);
                client.addTicket(regularTicket);
                client.addBalance(show.getTicketPrice() / 2);
                this.theaterBalance += show.getTicketPrice() / 2;
            }
            System.out.println(quantity + " Tickets have purchased");


        } else {
            System.out.println("Error: Either no show on that day or couldn't find customer");
        }
    }

    /**
     * Generates an advanced type ticket.
     * @param quantity
     * @param customerId
     * @param cardNumber
     * @param showDate
     */
    void advancedTicket(int quantity, String customerId, String cardNumber, String showDate) {
        String[] stringArray = showDate.split("/");
        Calendar date = new GregorianCalendar(Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[1]), Integer.valueOf(stringArray[0]));
        Customer customer = customerList.search(customerId);
        Show show = showCatalog.search(date);
        if (show != null && customer != null) {
            for (int i = 0; i < quantity; i++) {
                Client client = show.getClient();
                double price = show.getTicketPrice() * 7 / 10;
                Ticket advancedTicket = new AdvancedTicket(price, showDate);
                tickets.add(advancedTicket);
                customer.addTicket(advancedTicket);
                client.addTicket(advancedTicket);
                client.addBalance(price / 2);
                this.theaterBalance += price / 2;
            }
            System.out.println(quantity + " Tickets have purchased");


        } else {
            System.out.println("Error: Either no show on that day or couldn't find customer");
        }

    }

    /**
     * Generates a student type ticket.
     * @param quantity
     * @param customerId
     * @param cardNumber
     * @param dateOfShow
     */
    void studentAdvancedTicket(int quantity, String customerId, String cardNumber, String dateOfShow) {
        String[] stringArray = dateOfShow.split("/");
        Calendar date = new GregorianCalendar(Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[1]), Integer.valueOf(stringArray[0]));
        Customer customer = customerList.search(customerId);
        Show show = showCatalog.search(date);
        if (show != null && customer != null) {
            for (int i = 0; i < quantity; i++) {
                Client client = show.getClient();
                double price = show.getTicketPrice() * 7 / 20;
                Ticket studentTicket = new StudentTicket(price, dateOfShow);
                tickets.add(studentTicket);
                customer.addTicket(studentTicket);
                client.addTicket(studentTicket);
                client.addBalance(price / 2);
                this.theaterBalance += price / 2;
            }
            System.out.println(quantity + " Tickets have purchased");
            System.out.println("All " + quantity + " students must show valid student id.”");

        }

    }

    /**
     *
     * @return list of tickets
     */
    String listOfTickets() {
        return tickets.toString();
    }

    /**
     *
     * @return List of customers
     */
    String listOfCustomers() {
        return customerList.toString();
    }

    /**
     *
     * @return list of clients
     */
    String clientList() {
        return clientList.toString();

    }

    /**
     *
     * @return list of shows
     */
    String listOfShow() {
        return showCatalog.toString();
    }

    boolean removeCreditCard(String credit_card_number) {
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
                System.out.println("Credit card removed");
                return true;
            } else {
                System.out.println("Could not remove credit card. customer has 1 card. ");
            }


        }
        return false;
    }

    /**
     *
     * @param customer_id
     * @return customer object
     */
    Customer searchCustomer(String customer_id) {
        return customerList.search(customer_id);
    }

    /**
     * Retrieves all the data that is stored
     * @return
     */
    static Theater retrieve() {
        try {
            FileInputStream file = new FileInputStream("TheaterData");
            ObjectInputStream input = new ObjectInputStream(file);
            input.readObject();
            CustomerIdServer.retrieve(input);
            ClientIdServer.retrieve(input);
            TicketBarCodeServer.retrieve(input);
            return theater;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return null;
        }
    }


    /**
     * Serializes the Theater object
     *
     * @return true iff the data could be saved
     */
    static boolean save() {
        ObjectOutputStream output;
        try {
            FileOutputStream file = new FileOutputStream("TheaterData");
            output = new ObjectOutputStream(file);
            output.writeObject(theater);
            output.writeObject(CustomerIdServer.instance());
            output.writeObject(ClientIdServer.instance());
            output.writeObject(TicketBarCodeServer.instance());
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    /**
     * Writes the object to the output stream
     *
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(theater);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /**
     * Reads the object from a given stream
     *
     * @param input the stream to be read
     */
    private void readObject(ObjectInputStream input)
            throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        if (theater == null) {
            theater = (Theater) input.readObject();
        } else {
            input.readObject();
        }
    }

}



