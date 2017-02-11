package com.ladislav;

/**
 * Created by Ladislav on 1/16/2017.
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
