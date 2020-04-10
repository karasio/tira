package com.tira.tehtava11;

public class BinarySearch {
    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 16, 17, 19, 24, 26, 31, 36, 37, 39, 44, 45, 47, 48, 50, 53, 55, 56, 57, 58, 60, 67, 69, 72, 75, 77, 78};


    private int search(int iFirst, int searched, int iLast) {
        if (iLast >= iFirst) {
            int middle = iFirst + (iLast - iFirst) / 2;
            if (array[middle] == searched) {
                return middle;
            }
            if (array[middle] > searched) {
                return search(iFirst, searched, middle-1);
            }
            return search(middle + 1, searched, iLast);
        }
        return -1;
    }

    public void searchHelp(int searched) {
        int index = search(0, searched, array.length-1);

        if (index == -1) {
            System.out.println("Alkiota ei löydy");
        } else {
            System.out.println("Alkio " + searched + " löytyi indexillä " + index);
        }

    }

    private int[] insert(int[] newArray, int added, int iAdded, int iLast) {
        for (int i = iLast; i > iAdded; i--) {
            newArray[i] = newArray[i-1];
        }
        newArray[iAdded] = added;

        return newArray;
    }

    private int searchIndexForNew(int[] newArray, int added, int iFirst, int iLast) {

        int middle = iFirst + (iLast - iFirst) / 2;
        if (newArray[middle] == added) {
            System.out.println("Arvo " + added + " löytyy jo taulukosta, duplikaatteja ei hyväksytä");
            return -1;
        }
        // oikea paikka löytyy
        if (newArray[middle] < added && newArray[middle+1] > added) {
            return middle+1;
        }
        // jos taulukon keskimmäinen on suurempi kuin lisättävä
        if (newArray[middle] > added) {
            return searchIndexForNew(newArray, added, iFirst, middle-1);
        }
        // jos taulukon keskimmäinen on pienempi kuin lisättävä
        return searchIndexForNew(newArray, added, middle+1, iLast);
    }

    public void insertHelp(int added) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        int index;
        if (array[array.length-1] < added) {
            newArray[array.length] = added;
            array = newArray;
            return;
        } else if (array[0] > added) {
            index = 0;
        } else {
            index = searchIndexForNew(newArray, added, 0, array.length-1);
        }
        if (index != -1) {
            System.out.println("lisätään indexiin " + index );
            array = insert(newArray, added, index, array.length);
        }
    }

    public void print() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
