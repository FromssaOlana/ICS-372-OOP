package com.TheaterApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class TicketBarCodeServer {
    private  int barCode;
    private static TicketBarCodeServer server;
    /*
     * Private constructor for singleton pattern
     *
     */
    private TicketBarCodeServer() {
        Random random = new Random();
        barCode  = random.nextInt(1000000000);

    }
    /**
     * Supports the singleton pattern
     *
     * @return the singleton object
     */
    public static TicketBarCodeServer instance() {
        if (server == null) {
            return (server = new TicketBarCodeServer());
        } else {
            return server;
        }
    }
    /**
     * Getter for Barcode
     * @return barcode of the client
     */
    public int getBarCode() {
        return barCode;
    }
    /**
     * String form of the collection
     *
     */
    @Override
    public String toString() {
        return ("Barcode:" + barCode);
    }
    /**
     * Retrieves the server object
     *
     * @param input inputstream for deserialization
     */
    public static void retrieve(ObjectInputStream input) {
        try {
            server = (TicketBarCodeServer) input.readObject();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception cnfe) {
            cnfe.printStackTrace();
        }
    }
    /*
     * Supports serialization
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) throws IOException {
        try {
            output.defaultWriteObject();
            output.writeObject(server);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    /*
     * Supports serialization
     * @param input the stream to be read from
     */
    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        try {
            input.defaultReadObject();
            if (server == null) {
                server = (TicketBarCodeServer) input.readObject();
            } else {
                input.readObject();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
