package com.TheaterApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowCatalog extends ItemList<Show, String> implements Serializable {


    private static final long serialVersionUID = 1L;
    private static ShowCatalog showCatalog;

    /*
     * Private constructor for singleton pattern
     *
     */
    private ShowCatalog() {
    }

    /**
     * Supports the singleton pattern
     *
     * @return the singleton object
     */
    public static ShowCatalog instance() {
        if ( showCatalog == null) {
            return (showCatalog = new ShowCatalog());
        } else {
            return showCatalog;
        }
    }

    /**
     * Checks whether a show with a given show name exists.
     *
     * @param showName the id of the book
     * @return true iff the book exists
     */
    public Show search(String showName) {
      return super.search(showName);
    }

    /**
     * Removes a client from the catalog
     *
     * @param show client id
     * @return true iff client could be removed
     */
    public boolean removeShow(Show show) {
        return super.remove(show);
    }

    /**
     * Inserts a show into the collection
     *
     * @param show the client to be inserted
     * @return true iff the client could be inserted. Currently always true
     */
    public boolean addShow(Show show) {
       return super.add(show);

    }
    /// NOT done yet!
    private boolean isOpen(Show show){
      return false;
    }


    /*
     * Supports serialization
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(showCatalog);
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
            if (showCatalog!= null) {
                return;
            } else {
                input.defaultReadObject();
                if (showCatalog == null) {
                    showCatalog = (ShowCatalog) input.readObject();
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
