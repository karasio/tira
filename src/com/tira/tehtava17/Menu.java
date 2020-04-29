/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tira.tehtava17;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author kamaj
 */
public class Menu {
    //main alkaa-----------------------------------------------------------------------------
    public static void main(String[] args) {
        printMenu();

    }
    //main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
    private static void printMenu() {
        Integer select;
        TreeSet tree = new TreeSet<>();
//        String[] sList = {"david", "bo", "coco", "angela", "emil", "fabio", "gabby"}
        Integer[] list = {4, 32, 56, 21, 56778, 224, 1, -88, 0, 282, 282};

//        String[] sList = {"k", "n", "e", "f", "g", "r", "s", "a", "m", "t",  "o", "l", "u", "v"};
        for (Integer i : list) {
            tree.add(i);
        }

        System.out.println("TreeSetiin lisätty {4, 32, 56, 21, 56778, 224, 1, -88, 0, 282, 282}");
        Integer data;
        do {
            System.out.print("\t1. Lisää avain.");
            System.out.print("\t\t2. Etsi avaimella.");
            System.out.print("\t\t3. InOrder.");
            System.out.print("\t\t4. PreOrder");
            System.out.print("\t\t5. Poista avaimella.\n");
            System.out.print("Valintasi: ");
            select = Lue.kluku();
            switch (select) {
                case 1:
                    System.out.print("Anna uusi avain (kokonaisluku): ");
                    data = Lue.kluku();
                    tree.add(data);
                    System.out.println(data + " lisätty");
                    break;
                case 2:
                    System.out.println("Anna etsittävä avain (kokonaisluku)");
                    data = Lue.kluku();
                    if (tree.contains(data)){
                        System.out.println("Avain löytyi.");
                    }
                    else {
                        System.out.println("Avainta ei löytynyt.");
                    }
                    break;
                case 3:
                    System.out.print("InOrder: ");
                    Iterator<Integer> i = tree.iterator();
                    while(i.hasNext()) {
                        System.out.print(i.next() + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Puun läpikäynti esijärjestyksessä ei ole mahdollista, mutta tässä puu laskevassa järjestyksessä.");
                    Iterator<Integer> i2 = tree.descendingIterator();
                    System.out.print("Descending order: ");
                    while(i2.hasNext()) {
                        System.out.print(i2.next() + " ");
                    }
                    System.out.println();
                    break;
                case 5:
                    data = Lue.kluku();
                    if (tree.remove(data)) {
                        System.out.println("Poistettu " + data);
                    } else {
                        System.out.println("Antamaasi lukua ei löydy");
                    }
                    break;
                case 6:
                    break;
            }
        }
        while (select != 6);
    }
//printMenu loppuu ----------------------------------------------------------------
}

