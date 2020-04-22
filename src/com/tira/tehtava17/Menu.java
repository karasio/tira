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

        Integer data;
        do {
            System.out.print("\n\t1. Lisää avain.");
            System.out.print("\t\t2. Etsi avaimella.");
            System.out.print("\t\t3. Käy puu läpi esijärjestyksessä.");
            System.out.print("\t\t4. Poista avaimella.\n");
            select = Lue.kluku();
            switch (select) {
                case 1:
                    System.out.println("Anna uusi avain (merkkijono)");
                    data = Lue.kluku();
                    tree.add(data);
                    break;
                case 2:
                    System.out.println("Anna etsittävä avain (merkkijono)");
                    data = Lue.kluku();
                    if (tree.contains(data)){
                        System.out.println("Avain löytyi.");
                    }
                    else {
                        System.out.println("Avainta ei löytynyt.");
                    }
                    break;
                case 3:
                    Iterator<Integer> i = tree.iterator();
                    while(i.hasNext()) {
                        System.out.print(i.next() + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    data = Lue.kluku();
                    tree.remove(data);
                    break;
                case 5:
                    break;
            }
        }
        while (select != 5);
    }
//printMenu loppuu ----------------------------------------------------------------
}

