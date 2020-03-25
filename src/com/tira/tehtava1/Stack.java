package com.tira.tehtava1;

public class Stack {

    private ListItem top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // create new element and add it to the top of the stack
    public void push(String aData) {
        ListItem help = new ListItem();
        help.setData(aData);
        help.setNext(top);
        top = help;
        size++;
    }

    // delete & return element from the top of the stack
    // return null if nothing in the stack
    public ListItem pop() {

        if (top == null) {
            return null;
        }

        ListItem removed = top;
        top = top.getNext();
        size--;
        return removed;

    }

    // print stacks elements without changing the stack
    public void printItems() {
        ListItem current = top;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}
