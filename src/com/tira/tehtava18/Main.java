package com.tira.tehtava18;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 100000;

        // JCAPI TreeSet
        Set treeset = new TreeSet();
        System.out.println("Starting to fill TreeSet");
        long tsStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            Integer x = (int)(Math.random()*Integer.MAX_VALUE);
            if (i == 0) {
                treeset.add(x);
            } else if (i != 0 && !treeset.contains(x)) {
                treeset.add(x);
            } else {
                i--;
            }
        }

        Iterator it = treeset.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        long tsEnd = System.currentTimeMillis();
        System.out.println();
        System.out.println("With TreeSet - operations took " + (tsEnd - tsStart) + "ms");

        // BinaryTree
        BinaryTree binaryTree = new BinaryTree();

        System.out.println("Starting to fill BinaryTree");
        long btStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            Integer x = (int)(Math.random()*Integer.MAX_VALUE);
            if (i == 0) {
                binaryTree.insert(x);
            } else if ( i != 0 && binaryTree.find(x) == null) {
                binaryTree.insert(x);
            } else {
                i--;
            }
        }

        binaryTree.inOrder();
        long btEnd = System.currentTimeMillis();
        System.out.println();
        System.out.println("With BinaryTree - operations took " + (btEnd - btStart) + "ms");
    }
}
