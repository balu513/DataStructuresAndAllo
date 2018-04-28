package com.example.balu.cal.Model.LinkedList;

import android.util.Log;

/**
 * Created by balu on 2/15/18.
 */

public class ReverseLinkedList {

    private Node root;
    private static final String TAG = "ReverseLinkedList";

    public ReverseLinkedList() {

        insert(1);
        insert(2);
        insert(3);

        printLinkedList();


    }

    public void insert(int val) {
        Node temp = null;
        if (root == null) {
            root = new Node(val, null);
            return;
        }
        while (true) {
            if (temp == null)
                temp = root;

            if (temp.next == null) {
                temp.next = new Node(val, null);
                break;
            }
            temp = temp.next;

        }
    }

    class Node {
        int val;
        Node next;

        Node(int key, Node next) {
            this.val = key;
            this.next = next;
        }
    }

    private void printLinkedList() {
        Node node = root;
        String result = "";
        while (node.next != null) {
            result = result + node.val + " -> ";
            node = node.next;
        }
        Node lastNode = node;
        Log.d(TAG, result + "" + lastNode.val);
    }
}
