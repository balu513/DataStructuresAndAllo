package com.example.balu.cal.Model.problems;

import android.util.Log;

/**
 * Created by balu on 2/13/18.
 */

public class DP_Lis_Factorial {
    private static final String TAG = "DP_Lis_Factorial";
    private final Integer[] copy1, copy2;
    private final int N = 5;


    public DP_Lis_Factorial() {
        copy1 = new Integer[N + 1];
        Integer factorial1 = factorial1(N);
        Log.d(TAG, "factorial1: memoization " + factorial1);

        copy2 = new Integer[N + 1];
        Integer factorial2 = factorial2(N);
        Log.d(TAG, "factorial1: tabulization " + factorial2);


        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println("Length of lis is "
                + _lis(arr, n) + "n");

        LCM("bnthalu", "nantha");


    }

    private int[][] path;
    int pi, pj;

    //"nantha", "bnthalu"
    private void LCM(String s1, String s2) {
        System.out.println("  ------------LCM-------    s1: " + s1 + "  s2: " + s2);
        if (s1.length() == 0 || s2.length() == 0)
            return;
        path = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                pi = i + 1;
                pj = j + 1;
                if (s1.charAt(i) == s2.charAt(j)) {
                    path[pi][pj] = path[pi - 1][pj - 1] + 1;
                } else {
                    path[pi][pj] = max(path[pi - 1][pj], path[pi][pj - 1]);
                }

            }
        }

        printLCMMatrix(path, s1, s2);
        System.out.println("LCM :" + getLCString(path, pi, pj, s1, s2));


    }

    private void printLCMMatrix(int[][] path, String s1, String s2) {
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }


    }

    String result = "";

    private String getLCString(int[][] path, int pi, int pj, String s1, String s2) {

        if (path[pi][pj] == 0)
            return result;

        if (s1.charAt(pi - 1) == s2.charAt(pj - 1)) {
            result = s1.charAt(pi - 1) + result;
            getLCString(path, pi - 1, pj - 1, s1, s2);
        } else {
            if (path[pi - 1][pj] > path[pi][pj - 1])
                getLCString(path, pi - 1, pj, s1, s2);
            else
                getLCString(path, pi, pj - 1, s1, s2);

        }
        return result;
    }

    private int max(int n1, int n2) {
        return (n1 > n2) ? n1 : n2;
    }


    // top down memoization
    public Integer factorial1(int n) {
        if (copy1[n] == null) {
            if (n <= 1)
                return 1;
            else
                return n * factorial1(n - 1);
        }
        return copy1[n];
    }

    // bottom up tabulization
    public Integer factorial2(int n) {
        copy2[0] = 1;
        copy2[1] = 1;
        for (int i = 2; i <= n; i++) {
            copy2[i] = i * copy2[i - 1];
        }
        return copy2[n];
    }

    // LIS
    private int lis(int[] arr, int n) {
        int[] lis = new int[n];
        int max = 0;
        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = 0; i < lis.length; i++) {
            if (max < lis[i])
                max = lis[i];
        }
        return max;
    }

    // LIS with PATH
    private int _lis(int[] arr, int n) {
        int[] lis = new int[n];
        int[] bt = new int[n]; // backtracking for path
        int max = 0, indexAtMax = 0;
        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
            bt[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    bt[i] = j;
                }
            }
        }

        for (int i = 0; i < lis.length; i++) {
            if (max < lis[i]) {
                max = lis[i];
                indexAtMax = i;
            }
        }
        getLISPath(bt, arr, indexAtMax);
        return max;
    }

    private void getLISPath(int[] bt, int[] arr, int index) {
        Log.d(TAG, arr[index] + "");
        if (bt[index] == -1) {
            return;
        }
        getLISPath(bt, arr, bt[index]);
    }

}