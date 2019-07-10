package com.TheaterApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShowCatalog implements Serializable {


    private static final long serialVersionUID = 1L;
    private List showList = new LinkedList<Show>();
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
     * Checks whether a book with a given book id exists.
     *
     * @param showId the id of the book
     * @return true iff the book exists
     */
    public Show search(String showId) {
        for (Iterator iterator = showList.iterator(); iterator.hasNext(); ) {
            Show show = (Show) iterator.next();
            if (show.getId().equals(showId)) {
                return show;
            }
        }
        return null;
    }

    /**
     * Removes a client from the catalog
     *
     * @param showId client id
     * @return true iff client could be removed
     */
    public boolean removeShow(String showId) {
        Show show = search(showId);
        if (show == null) {
            return false;
        } else {
            return showList.remove(show);
        }
    }

    /**
     * Inserts a book into the collection
     *
     * @param show the client to be inserted
     * @return true iff the client could be inserted. Currently always true
     */
    public boolean addShow(Show show) {
        showList.add(show);
        return true;
    }

    /**
     * Returns an iterator to all books
     *
     * @return iterator to the collection
     */
    public Iterator getShow() {
        return showList.iterator();
    }

    /*
     * Supports serialization
     * @param output the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(showList);
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
        return showList.toString();
    }

}
