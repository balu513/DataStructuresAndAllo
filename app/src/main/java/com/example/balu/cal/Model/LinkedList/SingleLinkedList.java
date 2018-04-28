package com.example.balu.cal.Model.LinkedList;

import android.util.Log;

/**
 * Created by balu on 1/19/18.
 */

public class SingleLinkedList {

    private static final String TAG = "SingleLinkedList";
    Node rootNode = null;
    Node temp = null;

    public SingleLinkedList() {

        insertAtLast(10);
        insertAtLast(2);


        insertElementAtStart(77);
        insertElementAtStart(70);
        insertElementAtStart(12);

        insertAtLast(14);
        insertAtLast(58);

        insertElementAtMiddle(55);

        insertElementAtStart(706);
        insertAtLast(100);
        insertElementAtStart(126);

        printLinkedList();
    }


    public void insertAtLast(int val) {
        Node temp = null;
        if (rootNode == null) {
            rootNode = new Node(val, null);
            return;
        }
        while (true) {
            if (temp == null)
                temp = rootNode;

            if (temp.next == null) {
                temp.next = new Node(val, null);
                break;
            }
            temp = temp.next;

        }
    }

    public void insertElementAtStart(int value) {

        if (rootNode == null) {
            rootNode = new Node(value, null);
        }
        Node rootNode = getRootNode();
        Node node = new Node(value, rootNode);
        this.rootNode = node;
    }

    public void insertElementAtMiddle(int value) {

        int middlePosition = getLengthOfLinkedList() / 2;
        Node currentNode = getNodeAtPosition(middlePosition);
        Node nextNode = currentNode.next;
        currentNode.next = new Node(value, nextNode);
    }

    private Node getNodeAtPosition(int position) {
        int index = 0;
        Node node = getRootNode();
        while (index != position) {
            node = node.next;
            index++;
        }
        return node;
    }

    private void printLinkedList() {
        Node node = getRootNode();
        String result = "";
        while (node.next != null) {
            result = result + node.value + " ";
            node = node.next;
        }
        Node lastNode = node;
        Log.d(TAG, result + " " + lastNode.value);
    }


    private Node getRootNode() {
        return this.rootNode;
    }

    private Node getNextNode(Node node) {
        return node.next;
    }

    public int getLengthOfLinkedList() {
        Node node = getRootNode();
        int index = 0;
        while (node.next != null) {
            node = node.next;
            index++;
        }
        return index;
    }

    class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


}
