package com.ladislav;

/**
 * Created by Ladislav on 1/16/2017.
 */
public class BinarySearchTree implements  NodeList {
    
    ListItem root;
    
    @Override
    public ListItem getRoot() {
        return root;
    }
    
    @Override
    public boolean addItem(ListItem newItem) {
        
        if (root == null) {
            root = newItem;
            return true;
        }
        ListItem test = this.root;
        while (test != null) {
            int comparation = test.compareTo(newItem);
            
            if (comparation > 0) { // new item is smaler than test item
                ListItem newTest = test.previous();
                if (newTest == null) {
                    test.setPrevious(newItem);
                    return true;
                } else {
                    test = newTest;
                }
            } else if (comparation < 0) { // new item is larger than test item
                ListItem newTest = test.next();
                if (newTest == null) {
                    test.setNext(newItem);
                    return true;
                } else {
                    test = newTest;
                }
            } else {
                System.out.println("It is already in list!");
                return false;
            }
        }
        return false;
    }


    // Still not implemented !
    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting: " + item.getValue());
        }
        
        ListItem current = this.root;
        ListItem parent= current;
        boolean isLeftSide = false;
    
        while (current != null) {
            int comparation = current.compareTo(item);
            if (comparation > 0) {  // item is smaller than current
                parent = current;
                isLeftSide = true;
                current = current.previous();
    
            } else if (comparation < 0) {
                parent = current;
                isLeftSide = false;
                current = current.next();
            } else {
                performRemoval(current, parent, isLeftSide);
                return true;
            }
        }
        
        return false;
    }
    
    private void performRemoval(ListItem forRemoval, ListItem parent, boolean isLeftSide){
        
        if(forRemoval.next() != null && forRemoval.previous() != null){
            forRemoval = null;
        }
    }
    @Override
    public void traverse(ListItem root) {
    
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
            
        }
        
    }
    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.addItem(new Node("8"));
        tree.addItem(new Node("3"));
        tree.addItem(new Node("10"));
        tree.addItem(new Node("14"));
        tree.addItem(new Node("13"));
        tree.addItem(new Node("1"));
        tree.addItem(new Node("6"));
        tree.addItem(new Node("4"));
        tree.addItem(new Node("7"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("6"));
        tree.traverse(tree.getRoot());
    }
}
