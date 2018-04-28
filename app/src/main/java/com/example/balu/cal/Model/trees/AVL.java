package com.example.balu.cal.Model.trees;

import android.util.Log;

/**
 * Created by balu on 3/19/18.
 */

public class AVL {

    Node root;
    private String TAG = "AVL";

    public AVL() {
       /* insert(10);
        insert(16);*/
        insert(4);
        insert(24);
        insert(44);
        insert(64);
        insert(90);
/*        insert(6);*/
        inorder(root);
    }

    private void insert(int val) {
        root = insertNodeWithAVl(root, val);
    }

    // without AVL
    private void insertNode(Node node, int val) {
        if (root == null) {
            root = new Node(val, null, null);
            return;
        }
        if (val < node.value) {
            if (node.left != null) {
                insertNode(node.left, val);
            } else {
                node.left = new Node(val, null, null);
            }
        } else {
            if (node.right != null) {
                insertNode(node.right, val);
            } else {
                node.right = new Node(val, null, null);
            }
        }
    }


    private Node insertNodeWithAVl(Node node, int val) {

        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (val < node.value) {
            node.left = insertNodeWithAVl(node.left, val);
        } else {
            node.right = insertNodeWithAVl(node.right, val);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        //LL
        if (balance > 1 && val < node.left.value) {
            return rightRotate(node);
        }
        //RR
        if (balance < -1 && val > node.right.value) {
            return leftRotate(node);
        }
        //LR
        if (balance > 1 && val > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if (balance < -1 && val < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);

        }
        return node;
    }

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }


    private Node leftRotate(Node node) {
        Node x = node.right;
        Node t2 = x.left;

        x.left = node;
        node.right = t2;

        node.height = Math.max(node.left.height, node.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;

        return node;

    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        Node t2 = x.right;

        x.right = node;
        node.left = t2;

        node.height = Math.max(node.left.height, node.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;

        return node;
    }


    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    class Node {

        int value;
        Node left;
        Node right;

        Node parent;
        int height = 1;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value, Node left, Node right, Node parent, int height, int balanceFactor) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.height = height;
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            Log.d(TAG, "node: " + root.value);
            inorder(root.right);
        }
    }
}
