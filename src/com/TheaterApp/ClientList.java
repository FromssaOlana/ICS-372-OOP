package com.TheaterApp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Author Fromssa Olana
 * A client Collection class that hold an object of client.
 */
public class ClientList extends ItemList<Client,String> implements Serializable {


    private static final long serialVersionUID = 1L;
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
     * Checks whether a client with a given client id exists.
     *
     * @param clientId the id of the book
     * @return true iff the book exists
     */
    public Client search(String clientId) {
      return super.search(clientId);
    }

    /**
     * Removes a client from the catalog
     *
     * @param client client id
     * @return true iff client could be removed
     */
    public boolean removeClient(Client client) {
      return super.remove(client);
    }

    /**
     * Inserts a book into the collection
     *
     * @param client the client to be inserted
     * @return true iff the client could be inserted. Currently always true
     */
    public boolean addClient(Client client) {

        return super.add(client);
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

        return super.toString();
    }
}

