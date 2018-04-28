package com.example.balu.cal.core_java;

import android.util.Log;

import java.util.Iterator;

/**
 * Created by balu on 3/26/18.
 */

public class InterthreadCommunication {

    public InterthreadCommunication() {
        Item item = new Item();
        Item.ProducerThread producerThread = new Item.ProducerThread(item);
        Item.ConsumerThread ConsumerThread = new Item.ConsumerThread(item);
        producerThread.start();
        ConsumerThread.start();
    }
    }

    class Item {

        boolean isSetItem = false;
        int item = 0;

        public synchronized void getItem() {
            if (!isSetItem) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.d("GET ITEM: ", item + "");
            isSetItem = false;
            notify();
        }

        public synchronized void setItem(int value) {
            if (isSetItem) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isSetItem = true;
            item = value;
            Log.d("SET ITEM: ", item + "");
            notify();
        }

        class ProducerThread extends Thread {
            private Item item;

            ProducerThread(Item item) {
                this.item = item;
            }

            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    item.getItem();
                }
            }
        }

        class ConsumerThread extends Thread {
            int i;
            private Item item;

            public ConsumerThread(Item item) {
                this.item = item;
            }

            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    item.setItem(++i);
                }
            }
        }

    }
}
