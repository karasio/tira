/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tira.tehtava18;

public class Node {
    private Integer data;
    private BinaryTree left;
    private BinaryTree right;
    private int nodeHeight;

    public Node(Integer value, int nodeHeight) {
        data = value;
        left = right = null;
        this.nodeHeight = nodeHeight;
    }

    public Node(Integer value) {
        data = value;
        left = right = null;
    }

    public Node (Integer value, BinaryTree left, BinaryTree right) {
        data = value;
        this.left = left;
        this.right = right;
    }
    public Integer getData() {
        return data;
    }
    public BinaryTree left() {
        return left;
    }
    public BinaryTree right() {
        return right;
    }
    public void setLeft(BinaryTree tree) {
        left = tree;
    }
    public void setRight(BinaryTree tree) {
        right = tree;
    }
    public int getNodeHeight() { return nodeHeight; }
    public void setNodeHeight(int nodeHeight) { this.nodeHeight = nodeHeight; }
}
