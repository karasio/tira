package com.tira.tehtava2;

public class Queue {

    private ListItem head;
    private ListItem tail;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void push(String aData) {
        ListItem help = new ListItem();
        help.setData(aData);

        if (head == null) {
            head = help;
        } else {
            tail.setNext(help);
        }

        tail = help;
        size++;
    }

    public ListItem pop() {
        if (size == 0) {
            return null;
        }

        ListItem removed = head;
        head = head.getNext();
        size--;

        return removed;
    }

    public void printItems() {
        ListItem current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }

/*  //  ALTERNATIVE APPROACH WITH ONLY ONE INSTANCE OF LISTITEM
    private ListItem li;
    private int size;

    public Queue() {
        li = null;
        size = 0;
    }

    public void push(String aData) {
        // aData = a = argument
        ListItem help = new ListItem();
        help.setData(aData);
        help.setNext(null);

        if (li == null) {
            li = help;
        } else {
            ListItem last = li;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(help);
        }
        size++;
    }


    public ListItem pop() {

        if (li == null) {
            System.out.println("top=null");
            return null;
        }

        ListItem removed = li;
        li = li.getNext();
        size--;
        return removed;
    }

    public void printItems() {
        ListItem current = li;
        System.out.println("li=" + li);
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }*/

}
