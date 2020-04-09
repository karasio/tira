/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tira.tehtava8ja9ja10;

/**
 *
 * @author kamaj
 */
public class Node {
    private String data;
    private BinaryTree left;
    private BinaryTree right;
    private int nodeHeight;

    public Node(String value, int nodeHeight) {
        data = value;
        left = right = null;
        this.nodeHeight = nodeHeight;
    }

    public Node(String value) {
        data = value;
        left = right = null;
    }

    public Node (String value, BinaryTree left, BinaryTree right) {
        data = new String(value);
        this.left = left;
        this.right = right;
    }
    public String getData() {
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
