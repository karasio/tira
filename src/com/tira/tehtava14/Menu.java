package com.tira.tehtava14;

import com.tira.tehtava6.Lue;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: Stadia</p>
 *
 * @author JPK
 * @version 1.0
 */
public class Menu {
    //main alkaa-----------------------------------------------------------------------------
    public static void main(String[] args) {

        printMenu();

    }
    //main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
    private static void printMenu() {
        char select;
        Calc c = new Calc();
        String data; // Pinon data-kenttä
        do {
            System.out.println("\n\t\t\t1. Fill calculation (as infix): Remember to use ( ) when needed");
            System.out.print("\t\t\t2. End\n");
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("What shall we calculate?");
                    data = new String(Lue.rivi());
                    Double d = c.calculate(data);
                    if (d != null) {
                        System.out.println("=" + d);
                    }
                    break;
                default:
                    break;
            }
        }
        while (select != '2');
    }
//printMenu loppuu ----------------------------------------------------------------
}
