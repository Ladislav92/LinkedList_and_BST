package com.ladislav;

/**
 * Created by Ladislav on 1/15/2017.
 */
public abstract class ListItem {

    public ListItem(Object value) {
        this.value = value;
    }
    
    protected ListItem rightLink;
    protected ListItem leftLink;
    
    protected Object value;

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    
    abstract int compareTo(ListItem item);
    
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
    
