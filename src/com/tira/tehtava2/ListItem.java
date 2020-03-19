package com.tira.tehtava2;

public class ListItem {

    private String data;
    private ListItem next;

    public ListItem() {
        next = null;
    }

    public String getData() {

        return data;
    }

    public void setData(String data) {

        this.data = data;
    }

    public ListItem getNext() {

        return next;
    }

    public void setNext(ListItem next) {

        this.next = next;
    }

    @Override
    public String toString() {
        boolean isThereNext = false;
        if (next != null) {
            isThereNext = true;
        }
        return "ListItem{" +
                "data='" + data + '\'' +
                '}' + " next= " + isThereNext;
    }
}
