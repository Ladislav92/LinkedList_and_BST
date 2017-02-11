package com.ladislav;

/**
 * Created by Ladislav on 1/15/2017.
 */
public class MyLinkedList implements NodeList {
   ListItem root;
   
   public MyLinkedList() {
      //default constructor for creating an empty list
   }
   
   public MyLinkedList(ListItem root) {
      this.root = root;
   }
   
   @Override
   public ListItem getRoot() {
      return this.root;
   }
   @Override
   public boolean addItem(ListItem newItem) {
   
      if (root == null) {
         root = newItem;
         return true;
      }
      ListItem currentItem = this.root;
      while (currentItem != null){
         int comparison = (currentItem.compareTo(newItem));

         if (comparison < 0) {
            //new item is greater than current
            if(currentItem.next() != null) { //hasNext()
               currentItem = currentItem.next();
               return true;
            }else{
               currentItem.setNext(newItem).setPrevious(currentItem);
               return true;
            }
         } else if (comparison > 0) {
            //is less than current
            if (currentItem.previous() != null) { // hasPrevious()
               currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
               newItem.setNext(currentItem).setPrevious(newItem);
            } else {
               //We are at the root
               newItem.setNext(this.root).setPrevious(newItem);
               this.root = newItem;
            }
         } else {
            System.out.println(newItem.getValue() + " is already present in list, not aded");
            return false;
         }
      }
      return false;
   }
   
   @Override
   public boolean removeItem(ListItem forRemove) {
      ListItem currentItem = this.root;
      while (currentItem != null){
         int comparison = currentItem.compareTo(forRemove);
         if (comparison == 0) {
            if (currentItem == this.root) {
                  this.root = currentItem.next();
                  if(this.root != null) {
                     this.root.setPrevious(null);
                  }
            } else {
                  currentItem.previous().setNext(currentItem.next());
               if (currentItem.next() != null) {
                  currentItem.next().setPrevious(currentItem.previous());
               }
            }
            return true;
         } else if (comparison<0) {
            currentItem = currentItem.next();
         } else {
            System.out.println("Item:" + forRemove.getValue() + " is not existing in a list.");
            return false;
         }
      }
      return false;
   }
   
   @Override
   public void traverse(ListItem root) {
      System.out.println("traverse started");
      if(root == null) {
         System.out.println("The list is empty");
      } else {
         while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
         }
      }
   }
   
   public static void main(String[] args) {
      MyLinkedList list = new MyLinkedList();
   
      list.addItem(new Node("1"));
      list.addItem(new Node("2"));
      list.traverse(list.getRoot());
      list.removeItem(new Node("1"));
      list.traverse(list.getRoot());
      
      if(list.getRoot().previous() != null){
         System.out.println(list.getRoot().previous().getValue());
      }else{
         System.out.println("Root has no prevous element");
      }
   
   }
}
