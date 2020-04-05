package com.tira.tehtava7;

public class BinaryTree {

    private Node root;
    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }
    public BinaryTree() {
        root = null;
    }

//    public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
//        root = new Node(rootValue, left, right);
//    }
    
    public void insert(String aData){
        aData = aData.toLowerCase();
        if (root == null) {
            root = new Node(aData);
        } else if(aData.compareTo(root.getData()) <= 0) {
            if (root.left() == null) {
                root.setLeft(new BinaryTree(aData));
            } else {
                root.left().insert(aData);
            }
        } else {
            if (root.right() == null) {
                root.setRight(new BinaryTree(aData));
            } else {
                root.right().insert(aData);
            }
        }
    }
    
    public BinaryTree find(String aData){
        aData = aData.toLowerCase();
        if (aData.equals(root.getData())) {
            return new BinaryTree(aData);
        } else if (aData.compareTo(root.getData()) < 0) {
            if (root.left() != null) {
                return root.left().find(aData);
            }
            return null;
        } else {
            if (root.right() != null) {
                return root.right().find(aData);
            }
            return null;
        }
    }

    public void inOrder() {
        if (root != null) {
            if (root.left() != null)
                root.left().inOrder();
            System.out.println(root.getData());
            if (root.right() != null)
                root.right().inOrder();
        }
    }
  
    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
