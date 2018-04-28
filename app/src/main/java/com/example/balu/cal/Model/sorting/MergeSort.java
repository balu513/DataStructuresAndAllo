package com.example.balu.cal.Model.sorting;

import android.util.Log;

/**
 * Created by balu on 1/16/18.
 */

public class MergeSort {
    private String TAG = "MergeSort";
    int[] arr;

    public MergeSort() {
        Log.d(TAG, "MergeSort()");
        arr = new int[]{19, 23, 67, 44, 5, 1, 98, 43, 50, 10};

        sort(arr, 0, arr.length - 1);
        printArray(arr);

    }

    public void sort(int[] arr, int l, int r) {

        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {

            if (arr[i] < arr[j]) {
                arr[k] = arr[i];
                i++;
                k++;
            } else {
                arr[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i < n1) {
            arr[k] = arr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = arr[j];
            i++;
            k++;
        }

    }

    public void printArray(int[] ar) {
        Log.d(TAG, "printArray called");
        String res = "";
        for (int i = 0; i < ar.length; i++) {
            res = res + ar[i];
        }
        Log.d("MergeSort:", res);
    }
}
