package com.tira.tehtava12;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class BinaryHeap {
    private Integer[] array;
    private int size;
    private int maxSize;
    private static final int FIRST = 1;

    public BinaryHeap(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Integer[maxSize+1];
        this.size = 0;
        array[0] = Integer.MIN_VALUE;
    }

    public void insert(int value) {
        if (size >= maxSize || value == 0) {
            System.out.println("Array full or invalid value (0 is not ok)");
            return;
        }
        array[++size] = value;
        int current = size;

        while(array[current] < array[findParent(current)]) {
            swap(current, findParent(current));
            current = findParent(current);
        }
    }

    public boolean isLeaf(int i) {
        if (array[findLeftChild(i)] == null && array[findRightChild(i)] == null) {
//            System.out.println("no children");
            return true;
        }
        return false;
    }

    public void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

    }

    private void minHeapify(int pos) {
//        if (pos != 1) {
//            System.out.println("parent now " + array[pos-1]);
//        }
//        System.out.println("index " + pos + " value: " +  array[pos]);
        if (pos <= size) {
            if (!isLeaf(pos)) {
//                System.out.println("Is not leaf");
                if (array[findRightChild(pos)] != null && array[findLeftChild(pos)] != null) {
                    if (array[pos] > array[findRightChild(pos)] ||
                            array[pos] > array[findLeftChild(pos)]) {
//                        System.out.println("Parent greater than one of its children");
                        if (array[findLeftChild(pos)] < array[findRightChild(pos)]) {
//                            System.out.println("swap " + array[pos] + " and " + array[findLeftChild(pos)]);
                            swap(pos, findLeftChild(pos));
                            minHeapify(findLeftChild(pos));
                        } else {
//                            System.out.println("swap " + array[pos] + " and " + array[findRightChild(pos)]);
                            swap(pos, findRightChild(pos));
                            minHeapify(findRightChild(pos));
                        }
                    }
                } else if (array[findLeftChild(pos)] != null && array[findRightChild(pos)] == null) {
//                    System.out.println("swap " + array[pos] + " and " + array[findLeftChild(pos)]);
                    swap(pos, findLeftChild(pos));
                    minHeapify(findLeftChild(pos));
                } else {
//                    System.out.println("swap " + array[pos] + " and " + array[findRightChild(pos)]);
                    swap(pos, findRightChild(pos));
                    minHeapify(findRightChild(pos));
                }

            }
        }
    }

    public void deleteMin() {
        if (size == 0) {
            return;
        }
        int popped = array[FIRST];
        array[FIRST] = array[size];
        array[size--] = null;
        minHeapify(FIRST);
        System.out.println("Deleted " + popped);
    }

    public int findRightChild(int index) {
        return 2*index+1;
    }

    public int findLeftChild(int index) {
        return 2*index;
    }

    public int findParent(int index) {
        return index/2;
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            String left = array[2*i] != null ? "Left: " + String.valueOf(array[2*i]) : "Left: -";
            String right = array[2*i+1] != null ? "Right: " +  String.valueOf(array[2*i+1]) : "Right: -";
            System.out.print("Node: " + array[i] + " " +  left + " " + right);
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
