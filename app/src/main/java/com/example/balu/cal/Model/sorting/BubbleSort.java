package com.example.balu.cal.Model.sorting;

import android.util.Log;

import com.example.balu.cal.Model.utils.Utils;

/**
 * Created by balu on 1/17/18.
 */

public class BubbleSort {
    private static final String TAG = "BubbleSort";

    public BubbleSort() {
        Log.d(TAG, "QuickSort()");
        int[] arr = new int[]{19, 23, 67, 44, 5, 1, 98, 43, 50, 10,1000,344,0,-3,-99,8};
        bubbleSort(arr);
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swapNumbers(arr, j - 1, j);
                }
            }
        }
        Utils.printArray(TAG,arr);
    }

    private void swapNumbers(int[] arr, int i, int j) {
        Log.d(TAG, "swapNumbers i:" + i + " val:" + arr[i] + "  j:" + j + "  val:" + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
