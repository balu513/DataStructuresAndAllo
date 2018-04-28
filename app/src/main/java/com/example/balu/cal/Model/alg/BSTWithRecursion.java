package com.example.balu.cal.Model.alg;

import android.util.Log;

/**
 * Created by balu on 1/24/18.
 */

public class BSTWithRecursion {

    private static final String TAG = "BSTWithRecursion";
    private final int[] arr;
    private final int searchElement;


    public BSTWithRecursion() {
        arr = new int[]{2, 3, 5, 7, 9, 12, 23, 56, 78, 90};
        searchElement = 56;
        boolean elementFound = isElementFound(0);
        if (!elementFound) {
            Log.d(TAG, "element not found");
        }

    }


    private boolean isElementFound(int index) {
        if ((index < arr.length)) {
            if (arr[index] == searchElement) {
                Log.d(TAG, "element found at index: " + index);
                return true;
            }
            isElementFound(index * 2 + 1);
            isElementFound(index * 2 + 2);
        }
        return false;
    }

    private boolean isElementFound(int[] arr, int si, int ei) {
        int mid = (si + ei) / 2;
        if (searchElement < arr[mid])
            //isElementFoun todo

            return false;
        return false;
    }

    private int[] getRangeArray(int[] arr, int si, int ei) {
        int[] dummy = new int[ei - si];
        for (int i = si; i < ei; i++) {

        }
        return null;
    }
}
