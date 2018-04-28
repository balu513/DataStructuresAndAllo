package com.example.balu.cal.Model.trees;

import android.util.Log;

/**
 * Created by balu on 1/22/18.
 */

public class BSTWithTraversals {

    Node node;
    private static final String TAG = "BSTWithTraversals";

    public BSTWithTraversals() {
        insert(10);
        insert(12);
        insert(20);
        insert(14);
        insert(8);

        Log.e(TAG,"IN ORDER");
        inorder(node);
        Log.e(TAG,"PRE ORDER");
        preorder(node);
        Log.e(TAG,"POST ORDER");
        postorder(node);
    }

    private void insert(int key) {
        if (node == null) {
            node = insert(null, key);
        } else {
            insert(node, key);
        }
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        // left child
        if (key < node.key) {
            Node leftChild = insert(node.left, key);
            node.left = leftChild;

            leftChild.parent = node;
        }
        // right child
        if (key > node.key) {
            Node rightChild = insert(node.right, key);
            node.right = rightChild;

            rightChild.parent = node;
        }
        return node;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            Log.d(TAG, "node: " + root.key);
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            Log.d(TAG, "node: " + root.key);
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            Log.d(TAG, "node: " + root.key);
        }

    }


    class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
        }
    }
}
