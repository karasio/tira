package com.tira.tehtava14;

public class OperatorStack {
    private Node top;
    private int size;

    public OperatorStack() {
        top = null;
        size = 0;
    }

    public void push(char data) {
        Node help = new Node();
        help.setChr(data);
        help.setNext(top);
        top = help;
        size++;
    }

    public Node pop() {
        if (top != null) {
            Node removed = top;
            top = top.getNext();
            size--;
            return removed;
        }
        return null;
    }

    public void printItems() {
        Node current = top;
        while (current != null) {
            System.out.println(current.getChr());
            current = current.getNext();
        }
    }

    public char peek() {
        if (top != null) {
            return top.getChr();
        }
        return 'q';
    }

    public void clear() {
        Node current = top;
        while (current!= null) {
            top = top.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}
