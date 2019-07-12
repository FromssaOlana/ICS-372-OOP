package com.TheaterApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Wallet wallet;
    private List creditWallet = new LinkedList<CreditCard>();


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
        return creditWallet.size();
    }

    /**
     * Checks whether a card with a given card id exists.
     *
     * @param cardNumber the id of the card
     * @return true iff the book exists
     */
    public CreditCard search(String cardNumber) {
        for (Iterator iterator = creditWallet.iterator(); iterator.hasNext(); ) {
            CreditCard card = (CreditCard) iterator.next();
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    public boolean cardExist(CreditCard card) {
        for (Iterator iterator = creditWallet.iterator(); iterator.hasNext(); ) {
            CreditCard card1= (CreditCard) iterator.next();
            if (card1.equals(card)) {
                return true;
            }

        }
        return false;

    }
    public boolean cardUsed(String cardNumber) {
        for (Iterator iterator = creditWallet.iterator(); iterator.hasNext(); ) {
            CreditCard card = (CreditCard) iterator.next();
            if (card.getCardNumber().equals(cardNumber)) {
                return true;
            }

        }
        return false;

    }

    /**
     * Removes a client from the catalog
     *
     * @param customerId client id
     * @return true iff client could be removed
     */
    public boolean remove(String customerId) {
        for (Iterator iterator = creditWallet.iterator(); iterator.hasNext(); ) {
            CreditCard card = (CreditCard) iterator.next();
            if (card.getCustomersID().equals(customerId)) {
                creditWallet.remove(card);
            }
        }
        return true;
    }

    /**
     * Inserts a book into the collection
     *
     * @param card the client to be inserted
     * @return true iff the client could be inserted. Currently always true
     */
    public boolean addCard(CreditCard card) {
        creditWallet.add(card);
        return true;
    }
    public boolean removeCard(CreditCard card) {
        creditWallet.remove(card);
        return true;

    }

    /**
     * Returns an iterator to all cards
     *
     * @return iterator to the collection
     */
    public Iterator getCreditCards() {
        return creditWallet.iterator();
    }

    /*
     * Supports serialization
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(creditWallet);
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

        return creditWallet.toString();
    }
}



