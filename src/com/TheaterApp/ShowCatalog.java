package com.TheaterApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Author Fromssa Olana
 * ShowCatalog class is a collection class that will hold objects of shows.
 */

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
        if (showCatalog == null) {
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
     * Inserts a show into the collection
     *
     * @param show the client to be inserted
     * @return true iff the client could be inserted. Currently always true
     */
    boolean addShow(Show show) {
        if (isDateAvailable(show)) {
            return super.add(show);
        }
        System.out.println("Show date is already booked by other play. ");
        return false;
    }

    /**
     * Checks if the requested date ia available to add the show
     *
     * @param show
     * @return
     */
    private boolean isDateAvailable(Show show) {
        List<Show> list = super.getList();
        Show[] array = list.toArray(new Show[list.size()]);
        if (list.size() == 0) {
            return true;
        }
        if ((show.getShowEndDate().before(array[0].getShowStartDate()) ||
                (show.getShowStartDate().after(array[array.length - 1].getShowEndDate())))) {
            return true;
        }
        for (int i = 1; i < array.length; i++) {
            if (show.getShowStartDate().after(array[i - 1].getShowEndDate()) &&
                    show.getShowEndDate().before(array[i])) {
                return true;
            }
        }
        return false;
    }

    Show search(Calendar showDate) {
        List<Show> list = super.getList();
        for (Iterator<Show> iterator = list.iterator(); iterator.hasNext(); ) {
            Show show = iterator.next();
            if (showDate.after(show.getShowStartDate()) &&
                    showDate.before(show.getShowEndDate())) {
                return show;
            }
        }
        return null;
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
            if (showCatalog != null) {
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
