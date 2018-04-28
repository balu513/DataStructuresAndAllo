package com.example.balu.cal.Model.problems;

import android.util.Log;

import java.awt.font.TextAttribute;

/**
 * Created by balu on 2/14/18.
 */

public class MatrixTraverals {

    private static final String TAG = "MatrixTraverals";
    private int path[][];

    public MatrixTraverals() {

        int arr[][] = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        };
        path = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };

        boolean output = findOne(arr, 0, 0);
        Log.d(TAG, "one position: x->" + x + " y->" + y + "     Res: " + output);
        printpath(path);

    }

    private void printpath(int[][] path) {
        System.out.println("---- Traversal Path ----");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" " + path[i][j]);
            }
            System.out.println();
        }
    }

    private int x, y;
    boolean res;

    private boolean findOne(int[][] arr, int i, int j) {
        if (i > 3 || j > 3)
            return false;

        if (path[i][j] == 0) {
            return false;
        }
        path[i][j] = 0;

        if (arr[i][j] == 1) {
            x = i;
            y = j;
            return true;
        }
        res = findOne(arr, i + 1, j);

        if (res == false)
            res = findOne(arr, i, j + 1);

        return res;


    }

}
