package com.TheaterApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Wallet extends ItemList<CreditCard,String> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Wallet wallet;


    /*
     * Private constructor for singleton pattern
     *
     */
    private Wallet() {
    }

    /**
     * Supports the singleton pattern
     *
     * @return the singleton object
     */
    public static Wallet instance() {
        if (wallet == null) {
            return (wallet = new Wallet());
        } else {
            return wallet;
        }
    }

    public int size(){
        return super.size();
    }

    /**
     * Checks whether a card with a given card id exists.
     *
     * @param cardNumber the id of the card
     * @return true iff the book exists
     */
    public CreditCard search(String cardNumber) {
     return super.search(cardNumber);
    }

    /**
     * Removes a client from the catalog
     *
     * @param creditCard client id
     * @return true iff client could be removed
     */
    public boolean remove(CreditCard creditCard) {
        return super.remove(creditCard);
    }
    public void removeAssociatedCards(String customerId){
        for (CreditCard card: super.getList() ){
            if (card.getCustomersID().equals(customerId)){
                remove(card);
            }
        }
    }

    /**
     * Inserts a book into the collection
     *
     * @param card the client to be inserted
     * @return true iff the client could be inserted. Currently always true
     */
    public boolean addCard(CreditCard card) {
        return super.add(card);
    }
    public boolean removeCard(CreditCard card) {
        return super.remove(card);

    }

    /*
     * Supports serialization
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(wallet);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /*
     * Supports serialization
     *  @param input the stream to be read from
     */
    private void readObject(ObjectInputStream input) {
        try {
            if (wallet != null) {
                return;
            } else {
                input.defaultReadObject();
                if (wallet == null) {
                    wallet = (Wallet) input.readObject();
                } else {
                    input.readObject();
                }
            }
        } catch (IOException ioe) {
            System.out.println("in wallet readObject \n" + ioe);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }



    /**
     * String form of the collection
     */
    public String toString() {

        return super.toString();
    }
}



