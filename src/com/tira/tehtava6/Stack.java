package com.tira.tehtava6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Stack {

    private LinkedList<String> list;

    public Stack() {
        list = new LinkedList<>();
    }

    // create new element and add it to the top of the stack
    public void push(String aData) {
        list.add(aData);
    }

    // delete & return element from the top of the stack
    // return null if nothing in the stack
    public ListItem pop() {
        if (list.size() == 0) {
            return null;
        }
        ListItem li = new ListItem();
        li.setData(list.getLast());
        list.removeLast();
        return li;
    }

    // print stacks elements without changing the stack
    public void printItems() {
        ListItem li = new ListItem();
        Iterator iterator = list.descendingIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public int getSize() {
        return list.size();
    }
}
