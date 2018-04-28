package com.example.balu.cal.Model.utils;

import android.util.Log;

/**
 * Created by balu on 1/17/18.
 */

public class Utils {

    public static void printArray(String TAG, int[] arr) {
        Log.d(TAG, "printArray called");
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res = res + " " + arr[i];
        }
        Log.d(TAG, "sorted Array: " + res);
    }
}
