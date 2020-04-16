package com.tira.tehtava14;

public class Node {
    private char chr;
    private Double dbl;
    private Node next;

    public Node() {
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public char getChr() {
        return chr;
    }

    public Double getDbl() {
        return dbl;
    }

    public void setChr(char chr) {
        this.chr = chr;
    }

    public void setDbl(Double dbl) {
        this.dbl = dbl;
    }
}
