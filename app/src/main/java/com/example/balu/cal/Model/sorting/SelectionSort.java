package com.example.balu.cal.Model.sorting;

import android.util.Log;

import com.example.balu.cal.Model.utils.Utils;

/**
 * Created by balu on 1/17/18.
 */

public class SelectionSort {

    private String TAG = "SelectionSort";
    int sortedIndex = 0;
    int minElementIndex = 0;

    public SelectionSort() {
        Log.d(TAG, "SelectionSort()");
        int[] arr = new int[]{19, 23, 67, 44, 5, 1, 98, 43, 50, 10};
        selectionSort(arr);
        Utils.printArray(TAG, arr);

    }

    private void selectionSort(int[] arr) {
        int minElement = arr[sortedIndex];
        minElementIndex = sortedIndex;

        for (int i = sortedIndex; i < arr.length; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                minElementIndex = i;
            }
        }
        swapNumbers(arr, minElementIndex, sortedIndex);

        while (sortedIndex <= arr.length - 1) {
            selectionSort(arr);
        }

    }

    private void swapNumbers(int[] arr, int minElementIndex, int sortedIndex) {
        Log.d(TAG, "swapNumbers minElementIndex:" + minElementIndex + " val:" + arr[minElementIndex] + "  sortedIndex:" +
                sortedIndex + "  val:" + arr[sortedIndex]);
        int temp = arr[minElementIndex];
        arr[minElementIndex] = arr[sortedIndex];
        arr[sortedIndex] = temp;
        this.sortedIndex = sortedIndex + 1;
    }
}
