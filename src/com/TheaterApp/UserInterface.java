package com.TheaterApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class UserInterface {

    private static UserInterface userInterface;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Theater theater;
    private static final int EXIT = 0;
    private static final int ADD_CLIENT = 1;
    private static final int ADD_CUSTOMER = 2;
    private static final int ADD_SHOW = 3;
    private static final int REMOVE_CLIENT = 4;
    private static final int REMOVE_CUSTOMER = 5;
    private static final int REMOVE_CREDIT_CARD = 8;
    private static final int LIST_ALL_CLIENTS = 6;
    private static final int ADD_CREDIT_CARD = 7;
    private static final int LIST_ALL_CUSTOMERS = 9;
    private static final int LIST_ALL_SHOWS = 10;
    private static final int SAVE = 11;
    private static final int RETRIEVE = 12;
    private static final int REGULAR_TICKETS = 13;
    private static final int ADVANCED_TICKET = 14;
    private static final int STUDENT_TICKET = 15;
    private static final int PAY_CLIENT = 16;
    private static final int PRINT_TICKETS = 17;
    private static final int HELP = 18;
    /**
     * Made private for singleton pattern.
     * Conditionally looks for any saved data. Otherwise, it gets
     * a singleton Library object.
     */
    private UserInterface() {
        if (yesOrNo("Look for saved data and  use it?")) {
            retrieve();
        } else {
            theater = Theater.instance();
        }
    }

    /**
     * Supports the singleton pattern
     *
     * @return the singleton object
     */
    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }

    /**
     * Gets a token after prompting
     *
     * @param prompt - whatever the user wants as prompt
     * @return - the token from the keyboard
     */
    public String getToken(String prompt) {
        do {
            try {
                System.out.println(prompt);
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            } catch (IOException ioe) {
                System.exit(0);
            }
        } while (true);
    }

    /**
     * Queries for a yes or no and returns true for yes and false for no
     *
     * @param prompt The string to be prepended to the yes/no prompt
     * @return true for yes and false for no
     */
    private boolean yesOrNo(String prompt) {
        String more = getToken(prompt + " (Y|y)[es] or anything else for no");
        if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
            return false;
        }
        return true;
    }

    /**
     * Converts the string to a number
     *
     * @param prompt the string for prompting
     * @return the integer corresponding to the string
     */
    public int getNumber(String prompt) {
        do {
            try {
                String item = getToken(prompt);
                Integer number = Integer.valueOf(item);
                return number.intValue();
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a number ");
            }
        } while (true);
    }

    /**
     * Prompts for a date and gets a date object
     *
     * @param prompt the prompt
     * @return the data as a Calendar object
     */
    public Calendar getDate(String prompt) {
        do {
            try {
                Calendar date = new GregorianCalendar();
                String item = getToken(prompt);
                DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
                date.setTime(dateFormat.parse(item));
                return date;
            } catch (Exception fe) {
                System.out.println("Please input a date as mm/dd/yy");
            }
        } while (true);
    }

    /**
     * Prompts for a command from the keyboard
     *
     * @return a valid command
     */
    public int getCommand() {
        do {
            try {
                int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
                if (value >= EXIT && value <= HELP) {
                    return value;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number");
            }
        } while (true);
    }

    /**
     * Displays the help screen
     */
    public void help() {
        System.out.println("Enter a number between 0 and 12 as explained below:");
        System.out.println(EXIT + " to Exit");
        System.out.println(ADD_CLIENT + " to add a client");
        System.out.println(ADD_CUSTOMER + " to  add customer");
        System.out.println(ADD_SHOW + " to add show");
        System.out.println(REMOVE_CLIENT + " to remove client ");
        System.out.println(REMOVE_CUSTOMER + " to  remove customer");
        System.out.println(LIST_ALL_CLIENTS + " to list all clients");
        System.out.println(ADD_CREDIT_CARD + " to add credit card");
        System.out.println(REMOVE_CREDIT_CARD + " to remove credit card");
        System.out.println(LIST_ALL_CUSTOMERS + " to list all customers");
        System.out.println(LIST_ALL_SHOWS + " to list all shows");
        System.out.println(SAVE + " to  save data");
        System.out.println(RETRIEVE + " to  retrieve");
        System.out.println(PRINT_TICKETS + " to print all tickets");
        System.out.println(REGULAR_TICKETS + " to buy regular ticket");
        System.out.println(ADVANCED_TICKET + " to buy advanced ticket");
        System.out.println(STUDENT_TICKET + "  to buy student ticket");
        System.out.println(PAY_CLIENT + " to pay client");
        System.out.println(HELP + " for help");


    }

    /**
     * Method to be called for adding a member.
     * Prompts the user for the appropriate values and
     * uses the appropriate Library method for adding the member.
     */
    public void addClient() {
        String name = getToken("Enter client name");
        String address = getToken("Enter address");
        String phone = getToken("Enter phone");
        Client result;
        result = theater.addClient(name, address, phone);
        if (result == null) {
            System.out.println("Could not add CLIENT");
        }
        System.out.println( result + "New client added ");
    }

    /**
     * Method to be called for adding a book.
     * Prompts the user for the appropriate values and
     * uses the appropriate Library method for adding the book.
     */
    public void addCustomer() {
        Customer result;
        do {
            String name = getToken("Enter customer name");
            String address = getToken("Enter address");
            String phone_number = getToken("Enter phone number");
            String card_number = getToken("Enter card number");
            String exp_date = getToken("Enter exp date");
            result = theater.addCustomer(name, address, phone_number, card_number, exp_date);
            if (result != null) {
                System.out.println(result);
                System.out.println("New Customer added");
            } else {
                System.out.println("Customer could not be added. Card might be used already.");
            }
            if (!yesOrNo("Add more customer?")) {
                break;
            }
        } while (true);
    }

    public void addShow() {

        String name = getToken("Enter show name");
        String client_id = getToken("Enter client Id");
        String start_date = getToken("Enter start date: dd/mm/yyyy");
        String end_date = getToken("Enter end date: dd/mm/yyyy");
        String ticketPrice = getToken("Enter show regular ticket price");


        if (theater.addShow(name, client_id, start_date, end_date,Double.valueOf(ticketPrice)) != null) {
            System.out.println("Show added");
        }else {
            System.out.println("Could not add show. Client might not registered or invalid date");
        }
    }

    public void addCreditCard() {
        String customer_id = getToken("Enter customerID");
        String credit_card_number = getToken("Enter card number");
        String exp_date = getToken("Enter exp date");
        boolean result;
        result = theater.addCreditCard(customer_id,credit_card_number,exp_date);
        if (result){
            System.out.println("New card added.");
        }else {
            System.out.println("could not add credit card");
        }
    }

    public void removeClient() {
        String client_id = getToken("Enter client Id");
        if (!theater.removeClient(client_id)) {
            System.out.println("Could not remove client");
        }
        System.out.println("Client removed ");
    }

    public void removeCustomer() {
        String customer_id = getToken("Enter customer Id");
        Customer customer = theater.searchCustomer(customer_id);
        boolean result;
        result = theater.removeCustomer(customer);
        if (!result) {
            System.out.println("Could not remove customer");
        }
        System.out.println("Customer removed");
    }

    public void removeCreditCard() {
        String credit_card_number = getToken("Enter credit card number");
        boolean result;
        result = theater.removeCreditCard(credit_card_number);
        if (!result) {
            System.out.println("Could not remove credit card");
        }else {
            System.out.println("Credit card removed");
        }
    }

    public void listAllClients(){

        System.out.println(theater.clientList());
    }

    public void listAllCustomers()
    {
        System.out.println(theater.listOfCustomers());
    }
    public void listAllShows(){

        System.out.println(theater.listOfShow());
    }

    /**
     * Regular ticket sale
     */
    public void regulTickets(){
        String quantity = getToken("Enter quantity of ticks");
        String customer_id = getToken("Enter customer Id");
        String show_date = getToken("Enter show date: dd/mm/yyyy");
        String show_name = getToken("Enter show name");
        String card_number = getToken("Enter card number");
        theater.regularTicket(Integer.valueOf(quantity),customer_id,card_number,show_name,show_date);
    }

    /**
     * Advanced ticket sale
     */
    public void advancedTickets(){
        String quantity = getToken("Enter quantity of ticks");
        String customer_id = getToken("Enter customer Id");
        String show_date = getToken("Enter show date: dd/mm/yyyy");
        String show_name = getToken("Enter show name");
        String card_number = getToken("Enter card number");
        theater.advancedTicket(Integer.valueOf(quantity),customer_id,card_number,show_name,show_date);
    }

    /**
     * Student ticket sale
     */
    public void studentTickets(){
        String quantity = getToken("Enter quantity of ticks");
        String customer_id = getToken("Enter customer Id");
        String show_date = getToken("Enter show date: dd/mm/yyyy");
        String show_name = getToken("Enter show name");
        String card_number = getToken("Enter card number");
        theater.studentAdvancedTicket(Integer.valueOf(quantity),customer_id,card_number,show_name,show_date);
    }

    public void payClient(){
        String clientID = getToken("Enter client Id");
        System.out.println("Client balance is: "+theater.getClientBalnce(clientID));
        String amount = getToken("Enter amount to be paid");
        theater.payClient(Double.valueOf(amount), clientID);
    }
    public void printTickets(){
        theater.listOfTickets();
    }


    /**
     * Method to be called for saving the Library object.
     * Uses the appropriate Library method for saving.
     */
    private void save() {
        if (theater.save()) {
            System.out.println(" The theater has been successfully saved in the file TheaterData \n");
        } else {
            System.out.println(" There has been an error in saving \n");
        }
    }

    /**
     * Method to be called for retrieving saved data.
     * Uses the appropriate Library method for retrieval.
     */
    private void retrieve() {
        try {
            Theater temptheater = Theater.retrieve();
            if (temptheater != null) {
                System.out.println(" The theater has been successfully retrieved from the file TheaterData \n");
                theater = temptheater;
            } else {
                System.out.println("File doesnt exist; creating new library");
                theater = Theater.instance();
            }
        } catch (Exception cnfe) {
            cnfe.printStackTrace();
        }
    }

    /**
     * Orchestrates the whole process.
     * Calls the appropriate method for the different functionalties.
     */
    public void process() {
        int command;
        help();
        while ((command = getCommand()) != EXIT) {
            switch (command) {
                case ADD_CLIENT:
                    addClient();
                    break;
                case ADD_CUSTOMER:
                    addCustomer();
                    break;
                case ADD_SHOW:
                    addShow();
                    break;
                case ADD_CREDIT_CARD:
                    addCreditCard();
                    break;
                case REMOVE_CLIENT:
                    removeClient();
                    break;
                case REMOVE_CREDIT_CARD:
                    removeCreditCard();
                    break;
                case REMOVE_CUSTOMER:
                    removeCustomer();
                    break;
                case LIST_ALL_CLIENTS:
                    listAllClients();
                    break;
                case LIST_ALL_CUSTOMERS:
                    listAllCustomers();
                    break;
                case LIST_ALL_SHOWS:
                    listAllShows();
                    break;
                case SAVE:
                    save();
                    break;
                case RETRIEVE:
                    retrieve();
                    break;
                case REGULAR_TICKETS:
                    regulTickets();
                    break;
                case ADVANCED_TICKET:
                    advancedTickets();
                    break;
                case STUDENT_TICKET:
                    studentTickets();
                    break;
                case PAY_CLIENT:
                    payClient();
                    break;
                case PRINT_TICKETS:
                    printTickets();
                    break;
                case HELP:
                    help();
                    break;
            }
        }
    }

    /**
     * The method to start the application. Simply calls process().
     *
     * @param args not used
     */
    public static void main(String[] args) {

        UserInterface.instance().process();
    }
}
