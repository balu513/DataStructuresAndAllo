package com.example.balu.cal.Model.LinkedList;

import android.util.Log;


/**
 * Created by balu on 1/20/18.
 */

public class LinkedHashMap {

    private final Node[] bucketArray;
    private Node front, rear;
    private static final int MAX_SIZE = 50;
    private static final int BUCKET_CAPACITY = 100;
    private static final String TAG = "LinkedHashMap";


    public LinkedHashMap() {
        bucketArray = new Node[BUCKET_CAPACITY];
        put("one", "balu1");
        put("two", "balu2");
        put("three", "balu3");
        put("four", "balu4");
        put("five", "balu5");


        Object value = get("two");
        Log.d(TAG, "get:  value: " + value.toString());

        Object value1 = get("five");
        Log.d(TAG, "get:  value: " + value1.toString());

        printInsertionOrder();

    }

    private int getHash(Object key) {
        return key.hashCode() % MAX_SIZE;
    }

    private void put(Object key, Object value) {
        int hashKey = getHash(key);

        //root node
        if (front == null && rear == null) {
            Node node = new Node(hashKey, key, value, null, null, null, null);
            bucketArray[hashKey] = node;
            front = node;
            rear = node;
        } else {
            if (isHashBucketCollision(hashKey)) {
                Node lastCollisionNode = getLastLinkedNodeFromHashBucketifHashCollisonHappens(hashKey);
                Node node = new Node(hashKey, key, value, null, rear, lastCollisionNode, null);
                bucketArray[hashKey] = node;
                rear.next = node;
                rear = node;
            } else {
                Node node = new Node(hashKey, key, value, rear, null, null, null);
                bucketArray[hashKey] = node;
                rear.next = node;
                rear = node;
            }
        }
        Log.d(TAG, "put:  value: " + value.toString() + "  hashcode:" + hashKey);
    }

    private Node getLastLinkedNodeFromHashBucketifHashCollisonHappens(int hash) {
        Node node = bucketArray[hash];
        if (node.linkedNext == null) return node;
        else {
            // loop will exist before last node.
            while ((node = node.linkedNext) != null) {
            }
            // last Node
            //node = node.getLinkedNext();
            return node;
        }
    }

    private void printInsertionOrder() {
        Node node = getFront();
        String str = "";
        str = " " + node.val;
        while ((node = node.next) != null) {
            str = str + " " + node.val;
        }
        Log.d(TAG, "Insertion Order Of LinkedHashMap:  " + str);
    }

    private Node getFront() {
        return this.front;
    }

    private Node getRear() {
        return this.rear;
    }

    private Object get(Object key) {
        int hashKey = getHash(key);
        Node node = bucketArray[hashKey];
        if (!isHashBucketCollision(hashKey)) {
            return node.val;
        }
        while (node.linkedNext != null) {
            if (node.key.equals(key))
                return node.val;

            node = node.linkedNext;
        }
        return node.val;
    }

    private Node getNode(Object key) {
        int hashKey = getHash(key);
        Node node = bucketArray[hashKey];
        if (!isHashBucketCollision(hashKey)) {
            return node;
        }
        while (node.linkedNext != null) {
            if (node.key.equals(key))
                return node;

            node = node.linkedNext;
        }
        return node;
    }

    private void remove(Object key) {
        Node node = getNode(key);
        if (node == null)
            return;

        Node prev = node.prev;
        Node next = node.next;
        Node linkedPrev = node.linkedPrev;
        Node linkedNext = node.linkedNext;

        if (isFrontNode() && isRearNode()) {
            Log.d(TAG, "hashMap became EMPTY");
            return;
        }
        if (isFrontNode()) {
            Log.d(TAG, "removed Front Node");
            if (next != null)
                front = next;
            return;
        }
        if (isRearNode()) {
            Log.d(TAG, "removed Last Node");
            if (prev != null)
                rear = prev;
            return;
        }
        if (prev != null && next != null && linkedPrev != null && linkedNext != null) {
            prev.next = next;
            next.prev = prev;
            linkedPrev.linkedNext = linkedNext;
            linkedNext.linkedPrev = linkedPrev;
        }
        //todo


    }

    private boolean isFrontNode() {
        return true;
    }

    private boolean isRearNode() {
        return true;
    }

    public boolean isHashBucketCollision(int hashCode) {
        return bucketArray[hashCode] != null ? true : false;
    }

    public class Node {


        private int hashCode;
        private Object key;
        private Object val;
        private Node prev;
        private Node next;
        private Node linkedPrev;
        private Node linkedNext;

        Node(int hashCode, Object key, Object val, Node prev, Node next, Node linkedPrev, Node linkedNext) {

            this.hashCode = hashCode;
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.linkedPrev = linkedPrev;
            this.linkedNext = linkedNext;
        }
    }
}
