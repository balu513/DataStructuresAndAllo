package com.example.balu.cal.Model.LinkedList;

import android.util.Log;

/**
 * Created by balu on 1/19/18.
 */

public class DoubleLinkedList {
    private static final String TAG = "DoubleLinkedList";
    Node rootNode, temp;

    public DoubleLinkedList() {

        insertElementAtLast(12);
        insertElementAtLast(142);
        insertElementAtLast(1);
        insertElementAtLast(100);

        insertElementAtStart(33);
        insertElementAtStart(78);
        insertElementAtStart(101);
        insertElementAtStart(22);

        insertElementAtMiddle(109);

        printDoulbeLinkedList();


    }


    public void insertElementAtLast(Object value) {

        if (getRootNode() == null) {
            rootNode = new Node(value, null, null);
            temp = rootNode;
        } else {
            Node node = new Node(value, temp, null);
            temp.next = node;
            temp = node;
        }
    }

    public void insertElementAtStart(Object value) {
        if (getRootNode() == null) {
            rootNode = new Node(value, null, null);
        } else {
            Node node = new Node(value, null, rootNode);
            rootNode.prev = node;
            setRootNode(node);
        }
    }

    public void insertElementAtMiddle(Object value) {
        int middle = getLengthOfLinkedList() / 2;
        Node mNode = getNodeAtPosition(middle);
        Node mNext = mNode.next;

        Node node = new Node(value, mNode, mNext);
        mNode.next = node;
        mNext.prev = node;


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

    private Node getNodeAtPosition(int position) {
        int index = 0;
        Node node = getRootNode();
        while (index != position) {
            node = node.next;
            index++;
        }
        return node;
    }

    public Node getRootNode() {
        return this.rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    private void printDoulbeLinkedList() {
        Node node = getRootNode();
        String result = "";
        while (node.next != null) {
            result = result + node.value + " ";
            node = node.next;
        }
        Node lastNode = node;
        Log.d(TAG, result + " " + lastNode.value);
    }

    public class Node {
        public Object value;
        public Node next;
        public Node prev;

        Node(Object value, Node prevNode, Node nextNode) {

            this.value = value;
            this.prev = prevNode;
            this.next = nextNode;
        }
    }
}
