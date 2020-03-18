package com.tira.tehtava1;

public class Stack {

    private ListItem top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // muodosta uusi lista-alkio ja vie se pinon huipulle
    public void push(String aData) {
        // aData = a = argument
        ListItem help = new ListItem();
        help.setData(aData);

        if (top == null) {
            top = help;
        } else {
            help.setNext(top);
            top = help;
        }
        size++;
    }

    // poista ja palauta alkio pinon huipulta
    // jos pino tyhjä, palauta null
    public ListItem pop() {

        if (top == null) {
            return null;
        }

        ListItem removed = top;
        top = top.getNext();
        size--;
        return removed;

    }

    // tulosta pinon sisältö muuttamatta pinoa
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
