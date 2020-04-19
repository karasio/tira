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
        String data;
        do {
            System.out.print("\n\t1. Fill calculation (infix)");
            System.out.print("\t\t\t2. Fill calculation (postfix)");
            System.out.println("\t\t\t3. End");
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("What shall we calculate?");
                    data = new String(Lue.rivi());
                    Double d = c.calculate(data, true);
                    if (d != null) {
                        System.out.println("=" + d);
                    }
                    break;
                case '2':
                    System.out.println("What shall we calculate?");
                    data = new String(Lue.rivi());
                    Double d2 = c.calculate(data, false);
                    if (d2 != null) {
                        System.out.println("=" + d2);
                    }
                    break;
                default:
                    break;
            }
        }
        while (select != '3');
    }
//printMenu loppuu ----------------------------------------------------------------
}
