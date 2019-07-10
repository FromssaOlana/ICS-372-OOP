package com.TheaterApp;

import Library.Book;
import Library.Catalog;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ClientList implements Serializable {


    private static final long serialVersionUID = 1L;
    private List clientLinkedList = new LinkedList<Client>();
    private static ClientList clientList;

    /*
     * Private constructor for singleton pattern
     *
     */
    private ClientList() {
    }

    /**
     * Supports the singleton pattern
     *
     * @return the singleton object
     */
    public static ClientList instance() {
        if (clientList == null) {
            return (clientList = new ClientList());
        } else {
            return clientList;
        }
    }

    /**
     * Checks whether a book with a given book id exists.
     *
     * @param clientId the id of the book
     * @return true iff the book exists
     */
    public Client search(String clientId) {
        for (Iterator iterator = clientLinkedList.iterator(); iterator.hasNext(); ) {
            Client client = (Client) iterator.next();
            if (client.getId().equals(clientId)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Removes a client from the catalog
     *
     * @param ClientId client id
     * @return true iff client could be removed
     */
    public boolean removeClient(String ClientId) {
        Client client = search(ClientId);
        if (client == null) {
            return false;
        } else {
            return clientLinkedList.remove(client);
        }
    }

    /**
     * Inserts a book into the collection
     *
     * @param client the client to be inserted
     * @return true iff the client could be inserted. Currently always true
     */
    public boolean addClient(Client client) {
        clientLinkedList.add(client);
        return true;
    }

    /**
     * Returns an iterator to all clients
     *
     * @return iterator to the collection
     */
    public Iterator getClients() {
        return clientLinkedList.iterator();
    }

    /*
     * Supports serialization
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(clientList);
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
            if (clientList != null) {
                return;
            } else {
                input.defaultReadObject();
                if (clientList == null) {
                    clientList = (ClientList) input.readObject();
                } else {
                    input.readObject();
                }
            }
        } catch (IOException ioe) {
            System.out.println("in Client readObject \n" + ioe);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    /**
     * String form of the collection
     */
    public String toString() {
        return clientLinkedList.toString();
    }
}

