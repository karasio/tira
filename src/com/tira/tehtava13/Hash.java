package com.tira.tehtava13;

/*
Tehtävä 13. Toteuta suljetun hajautuksen avaimen lisäys- ja avaimella haku -operaatiot.
 Kirjoita luokka, joka kapseloi hajautustaulun ja tarjoaa em. julkiset operaatiot.
 Testaa hajautuksen toiminta testausvalikon avulla tai yksikkötestein.
 */

public class Hash {
    private final int MAX_SIZE = 6143;
    private Integer[] hashTable = new Integer[MAX_SIZE];


    public void insert(int value) {
        int index = value % MAX_SIZE;
        int help = 1;
        boolean freeIndexFound = false;
        while (!freeIndexFound) {
            if (hashTable[index] != null) {
                index = (value + help) % MAX_SIZE;
                help++;
            } else {
                freeIndexFound = true;
                hashTable[index] = value;
            }
        }
    }

    public int search(int value) {
        int index = value % MAX_SIZE;
        int help = 1;
        boolean rightIndexFound = false;
        while(!rightIndexFound) {
            if (hashTable[index] == null || index == MAX_SIZE) {
                return -1;
            } else if (hashTable[index] != value) {
                index = (value + help) % MAX_SIZE;
                help++;
            } else {
                rightIndexFound = true;
            }
        }
        return index;
    }

    public void printTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print(hashTable[i] + " ");
            if (i % 23 == 0 && i != 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void printValues() {
        int printedPerLine = 0;
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                // Formatting index for neater printing
                char[] sIndex = Integer.toString(i).toCharArray();
                char[] temp = {' ', ' ', ' ', ' '};
                for (int j = 0; j < sIndex.length; j++) {
                    temp[j] = sIndex[j];
                }
                String s = new String(temp);
                System.out.print(hashTable[i] + " at index " + s + "\t\t");
                printedPerLine++;
                if (printedPerLine == 5) {
                    System.out.println();
                    printedPerLine = 0;
                }
            }
        }
    }
}
