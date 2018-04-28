package com.example.balu.cal.Model.alg;

import android.util.Log;

/**
 * Created by balu on 1/23/18.
 */

public class Trie {

    TrieNode rootNode, tempNode;
    private static final String TAG = "TRIE";

    public Trie() {
        rootNode = new TrieNode();
        tempNode = rootNode;
        insert("balu");
        insert("baluballi");
        insert("ram");
        insert("laxman");
        insert("baluballi");

        isWordPresent("balu");
        isWordPresent("laxman");
        isWordPresent("sourav");

        isWordPresent("bal");
    }

    public void insert(String str) {
        tempNode = rootNode;
        for (int i = 0; i < str.length(); i++) {
            int charIndex = getCharIndex(str.charAt(i));
            if (tempNode.blocks[charIndex] == null) {
                tempNode.blocks[charIndex] = new TrieNode();
            }
            tempNode = tempNode.blocks[charIndex];
            if (i == str.length() - 1) {
                tempNode.isWord = true;
            }
        }
        Log.d(TAG, "word: " + str + " added successfully");

    }

    private int getCharIndex(char ch) {
        return 25 - (122 - (int) ch);
    }

    private boolean isWordPresent(String word) {
        tempNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            int charIndex = getCharIndex(word.charAt(i));
            tempNode = tempNode.blocks[charIndex];
            if (tempNode == null) {
                Log.d(TAG, "word: " + word + "  is not present");
                return false;
            }
        }
        if (tempNode.isWord)
            Log.d(TAG, "word present :" + word);
        else
            Log.d(TAG, "word is Not present :" + word);

        return tempNode.isWord == true ? true : false;
    }

    private void getListWordsStartWith() {

    }


    class TrieNode {
        boolean isWord;
        TrieNode[] blocks = new TrieNode[26];
    }
}

