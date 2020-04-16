package com.tira.tehtava14;

public class OperandiStack {
    private Node top;

    public OperandiStack() {
        top = null;
    }

    public void push(double data) {
        Node help = new Node();
        help.setDbl(data);
        help.setNext(top);
        top = help;
    }

    public Node pop() {
        if (top != null) {
            Node removed = top;
            top = top.getNext();
            return removed;
        }
        return null;
    }

    public void clear() {
        Node current = top;
        while (current!= null) {
            top = top.getNext();
        }
    }
}
