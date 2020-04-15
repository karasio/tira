package com.tira.tehtava13;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Hash hash = new Hash();

        // inserting 4000 randomized numbers from range 1000 - 10000
        for (int i = 0; i < 100; i++) {
            hash.insert((int) (1000 + (Math.random() * 9000)));
        }

        hash.printTable();

        System.out.println("Numbers found");
        // testing search with 2000 randomized numbers ranging from 1000 - 10000
        int printedPerLine = 0;
        for (int i = 0; i < 2000; i++) {
            int random = (int) (1000 + (Math.random() * 9000));
            int index = hash.search(random);

            // Formatting index for neater printing
            char[] sIndex = Integer.toString(index).toCharArray();
            char[] temp = {' ', ' ', ' ', ' '};
            for (int j = 0; j < sIndex.length; j++) {
                temp[j] = sIndex[j];
            }
            String s = new String(temp);
            if (index != -1) {
                System.out.print(random + " at index " + s +  "\t\t");
                printedPerLine++;
                if (printedPerLine == 5) {
                    System.out.println();
                    printedPerLine = 0;
                }
            }
        }
        System.out.println("\n----------------------------------------------------");
        System.out.println("All saved numbers");
        hash.printValues();
    }
}
