package com.tira.tehtava12;

public class Main {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(20);
        heap.insert(9);
        heap.insert(4);
        heap.insert(13);
        heap.insert(12);
        heap.insert(14);
        heap.print();
        System.out.println("---------------------------------Delete min");
        heap.deleteMin();
        heap.print();
        System.out.println("--------------------------------------add 4");
        heap.insert(4);
        heap.print();
        System.out.println("-------------------------------------add 15");
        heap.insert(-15);
        heap.print();
        System.out.println("-------------------------------------add 53");
        heap.insert(53);
        heap.print();
        while (heap.getSize() > 0) {
            System.out.println("---------------------------------Delete min");
            heap.deleteMin();
            heap.print();
        }
    }
}
