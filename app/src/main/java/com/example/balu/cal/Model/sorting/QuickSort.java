package com.example.balu.cal.Model.sorting;

import android.util.Log;

import com.example.balu.cal.Model.utils.Utils;

/**
 * Created by balu on 1/16/18.
 */

public class QuickSort {
    private static final String TAG = "QuickSort";
    int[] arr;

    public QuickSort() {
        Log.d(TAG, "QuickSort()");
        this.arr = new int[]{19, 23, 67, 44, 5,5,5,1, 98, 43, 50, 10,0};
        quickSort(0, this.arr.length - 1);
        Utils.printArray(TAG, this.arr);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        int pivot = arr[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            while (this.arr[i] < pivot) {
                i++;
            }
            while (this.arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swapNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void swapNumbers(int i, int j) {
        Log.d(TAG, "swapNumbers i:" + i + " val:" + arr[i] + "  j:" + j + "  val:" + arr[j]);
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

}
