package com.example.balu.cal.Model.sorting;

import android.util.Log;

/**
 * Created by balu on 1/16/18.
 */

public class CountingSort {

    private String TAG = "CountingSort";
    int[] arr, dump;

    public CountingSort() {
        Log.d(TAG, "CountingSort()");
        this.arr = new int[]{19, 43, 0, 23, 67, 44, 5, 1, 98, 43, 50, 10, 43};
        countingSort();

    }

    private void countingSort() {
        int max = getMaxValue();
        int min = getMinValue();
        int range = max - min;
        dump = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            dump[arr[i]] = dump[arr[i]] + 1;
        }
        printArray();
    }
    private void printArray() {
        Log.d(TAG, "printArray called");
        String res = "";
        for (int i = 0; i < this.dump.length; i++) {
            if (dump[i] > 0) {
                for (int c = 0; c < dump[i]; c++) {
                    res = res + " " + i;
                }
            }
        }
        Log.d("CountingSort:", res);
    }

    public int getMaxValue() {
        int max = this.arr[0];
        for (int val : arr) {
            if (val > max)
                max = val;
        }
        return max;
    }

    public int getMinValue() {
        int min = this.arr[0];
        for (int val : arr) {
            if (val < min)
                min = val;
        }
        return min;
    }
}
