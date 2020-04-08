package com.tira.tehtava8ja9;

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

    public void findForDelete(String data) {
        data = data.toLowerCase();
        BinaryTree temp = delete(this, data);
        if(temp != null) {
            System.out.println("Poistettu " + data);
        } else {
            System.out.println("Ei löydy");
        }
    }

    public BinaryTree delete(BinaryTree tree, String data) {

        if (tree == null) {
            return null;
        }
        if (find(data) == null) {
            return null;
        }

        if (data.equals(tree.root.getData())) {
            if (tree.root.left() == null && tree.root.right() == null) {            // no sub trees -- remove leaf
                tree.root = null;
            } else if (tree.root.right() == null){                                  // 1 child: left -- attach child to parent's left
                Node child = tree.root.left().root;
                tree.root = child;
            } else if (tree.root.left() == null) {                                  // 1 child: right -- attach child to parent' right
                Node child = tree.root.right().root;
                tree.root = child;
            } else {                                                                // 2 children -- find out last child on right side
                Node lastChild = lastChild(tree.root.right().root);                 // replace node to be deleted with last child and attach
                BinaryTree tree1 = new BinaryTree();                                // it's children to last child
                delete(tree, lastChild.getData());
                tree1.root = new Node(lastChild.getData());
                tree1.root.setLeft(tree.root.left());
                tree1.root.setRight(tree.root.right());
                tree.root = tree1.root;
            }
        } else if (data.compareTo(tree.root.getData()) < 0) {           // etsi vasemmalta
            delete(tree.root.left(), data);
        } else if (data.compareTo((tree.root.getData())) > 0) {  // etsi oikeelta
            delete(tree.root.right(), data);
        }

        if (tree.root != null) {
            if (tree.root.left() != null) {
                if (tree.root.left().root == null) {
                    tree.setLeft(null);
                }
            }
            if (tree.root.right() != null) {
                if (tree.root.right().root == null ) {
                    tree.setRight(null);
                }
            }
        }

        return tree;

    }

    public Node lastChild(Node node) {
        if (node.left() != null) {
            return lastChild(node.left().root);
        }
        return node;
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
