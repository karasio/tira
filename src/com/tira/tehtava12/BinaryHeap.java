package com.tira.tehtava12;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class BinaryHeap {
    private int[] array;
    private int size;
    private int maxSize;
    private static final int FIRST = 1;

    public BinaryHeap(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize+1];
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
        if (array[findLeftChild(i)] == 0 && array[findRightChild(i)] == 0) {
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
                if (array[pos] > array[findRightChild(pos)] ||
                        array[pos] > array[findLeftChild(pos)]) {
//                    System.out.println("Parent greater than one of its children");
                    if (array[findLeftChild(pos)] < array[findRightChild(pos)]) {
//                        System.out.println("swap " + array[pos] + " and " + array[findLeftChild(pos)]);
                        swap(pos, findLeftChild(pos));
                        minHeapify(findLeftChild(pos));
                    } else {
//                        System.out.println("swap " + array[pos] + " and " + array[findRightChild(pos)]);
                        swap(pos, findRightChild(pos));
                        minHeapify(findRightChild(pos));
                    }
                }

        } else {
            array[size--] = 0;
            }
        }
    }

    public int deleteMin() {
        int popped = array[FIRST];
        array[FIRST] = array[size];
//        array[size--] = 0;
        if (size <= 2) {
            array[size] = 0;
            size--;
            return popped;
        }
        minHeapify(FIRST);
        return popped;
    }

    public int findRightChild(int index) {
//        System.out.println("Right child at index: " + 2*index+1);
        return 2*index+1;
    }

    public int findLeftChild(int index) {
//        System.out.println("Left child at index: " + 2*index);
        return 2*index;
    }

    public int findParent(int index) {
//        System.out.println("Parent at index: " + index/2);
        return index/2;
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print("Parent: " + array[i]
            + " Left Child: " + array[2 * i]
            + " Right Child: " + array[2 * i + 1]);
            System.out.println();
        }
    }
}
