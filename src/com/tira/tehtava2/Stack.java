package com.tira.tehtava2;

public class Stack {

    private ListItem top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // muodosta uusi lista-alkio ja vie se jonon perälle
    public void push(String aData) {
        // aData = a = argument
        ListItem help = new ListItem();
        help.setData(aData);
        help.setNext(null);

        if (top == null) {
            top = help;
        } else {
            ListItem last = top;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(help);
        }
        size++;
    }

    // poista ja palauta alkio, joka jonossa ensimmäisenä
    // jos pino tyhjä, palauta null
    public ListItem pop() {

        if (top == null) {
            System.out.println("top=null");
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
        System.out.println("top=" + top);
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}
