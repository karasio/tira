package com.tira.tehtava5;

/**
 *
 * @author kamaj
 * modified by karasio
 */
interface Iterator {
    boolean hasNext();
    Object next();
}

public class StackIterator implements Iterator {
    private ListItem  current;
    private Stack container; // container on tietorakenne, jota iteroidaan
    private int index = -1;

    StackIterator (Stack c) { // konstruktori on "package visible"
        container = c;
        current = container.top;
        index = container.getSize();
    }
    // palautetaan tieto siitä, löytyyko rakenteesta seuraava alkio
    // hmm... palautetaan tieto siitä, osoittaako nykypositio (current) alkiota vai ei.
    public boolean hasNext() {
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

    // palautetaan nykyinen (lista-alkio) ja siirretään nykypositiota pykälä eteenpäin
    public ListItem next() {
        current=container.getListItem(index - 1);
        index--;
        return current;
    }

}


