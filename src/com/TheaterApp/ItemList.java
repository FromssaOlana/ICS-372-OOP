package com.TheaterApp;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author Fromssa Olana
 * ItemList class is a generic collection class that will be extended with different class.
 *
 * @param <T>
 * @param <K>
 */

public class ItemList<T extends Matchable<K>, K> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<T> list = new LinkedList<>();

    /**
     * Checks whether an item with a given id exists.
     *
     * @param key the id of the item
     * @return the item iff the item exists
     */
    public T search(K key) {
        for (T item : list) {
            if (item.matches(key)) {
                return item;
            }
        }
        return null;
    }

    public int size() {
        return list.size();
    }

    List<T> getList() {
        return this.list;
    }

    /**
     * Adds an item to the list.
     *
     * @param item the item to be added
     * @return true iff the item could be added
     */
    boolean add(T item) {
        return list.add(item);
    }

    /**
     * Adds a ticket a collection
     * @param ticket
     * @return
     */

    /**
     * Removes the item from the list
     *
     * @param item the item to be removed
     * @return true iff the item could be removed
     */
    public boolean remove(T item) {
        return list.remove(item);
    }

    /**
     * Returns an iterator for the collection
     *
     * @return iterator for the collection
     */
    public Iterator<T> iterator() {

        return list.iterator();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(" ");
        for (T item : list) {
            string.append("\n").append(item.toString());

        }
        return string.toString();

    }
}
