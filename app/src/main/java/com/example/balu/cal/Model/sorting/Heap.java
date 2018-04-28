package com.example.balu.cal.Model.sorting;

import android.util.Log;

import com.example.balu.cal.Model.utils.Utils;

/**
 * Created by balu on 1/17/18.
 */

public class Heap {

    private String TAG = "Heap";


    public Heap() {
        Log.d(TAG, "Heap()");

        int[] arr = new int[]{19, 1, 23, 67, 44, 5, 2, 98, 43, 10, 43};
        Utils.printArray(TAG + ":::  INPUT Array ::: ", arr);

        int[] minHeapfyArray = minHeapfy(arr);
        Utils.printArray(TAG + ":::  minHeapfyArray ::: ", minHeapfyArray);


        int[] maxHeapfyArray = maxHeapfy(arr);
        Utils.printArray(TAG + ":::  maxHeapfyArray ::: ", maxHeapfyArray);

        int[] res = heapSort(minHeapfyArray);
        Utils.printArray(TAG + ":::  heapSort ::: ", res);

    }

    /*
    Always root value should be minimum than childs of the corrsponding root.
     */
    private int[] minHeapfy(int[] arr) {
        int index = 0;
        int[] result = new int[arr.length];

        while (index < arr.length) {

            result[index] = arr[index];

            if (index == 0) {
                index++;
                continue;
            }

            int childIndex = index;
            int childValue = result[childIndex];

            int rootIndex = getRootIndex(childIndex);
            int rootValue = result[rootIndex];

            if (childValue < rootValue) {
                swapNumbers(result, childIndex, rootIndex);
                doBackWordTraversalForMinHeapfy(result, rootIndex);
            }

            index++;
        }
        return result;
    }

    /*
 Always root value should be minimum than childs of the corrsponding root.
  */
    private int[] maxHeapfy(int[] arr) {
        int index = 0;
        int[] result = new int[arr.length];

        while (index < arr.length) {

            result[index] = arr[index];

            if (index == 0) {
                index++;
                continue;
            }

            int childIndex = index;
            int childValue = result[childIndex];

            int rootIndex = getRootIndex(childIndex);
            int rootValue = result[rootIndex];

            if (childValue > rootValue) {
                swapNumbers(result, childIndex, rootIndex);
                doBackWordTraversalForMaxHeapfy(result, rootIndex);
            }

            index++;
        }
        return result;
    }

    private int[] heapSort(int[] arr) {

        int length = arr.length;
        int[] result = new int[length];
        int index = 0;

        while (index < length) {
            result[index] = arr[0];
            arr[0] = arr[arr.length - 1];
            /*
            First index element replaced with last element and remove the first element means main root element,
            and get the minheapfy for the remaing subarray and do the same process ...
             */
            int[] subArray = getSubArray(arr, 0, arr.length - 1);
            arr = minHeapfy(subArray);
            index = index + 1;
        }
        return result;

    }

    private int[] getSubArray(int[] arr, int start, int end) {
        int res[] = new int[end];
        for (int i = start; i < end; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /*
    check minHeapfy until root < child   or   main root ie index=0
     */
    private void doBackWordTraversalForMinHeapfy(int[] result, int index) {
        int rootNodeIndex = getRootIndex(index);
        if (index != 0 && rootNodeIndex != 0) {
            while (result[index] < result[rootNodeIndex]) {
                swapNumbers(result, rootNodeIndex, index);
                doBackWordTraversalForMinHeapfy(result, rootNodeIndex);
            }
        }
    }

    /*
check maxHeapfy until root > child   or   main root ie index=0
 */
    private void doBackWordTraversalForMaxHeapfy(int[] result, int index) {
        int rootNodeIndex = getRootIndex(index);
        if (index != 0 && rootNodeIndex != 0) {
            while (result[index] > result[rootNodeIndex]) {
                swapNumbers(result, rootNodeIndex, index);
                doBackWordTraversalForMaxHeapfy(result, rootNodeIndex);
            }
        }
    }

    private void swapNumbers(int[] result, int index1, int index2) {
        Log.d(TAG + " swap:  ", index1 + " :" + result[index1] + "   " + index2 + " :" + result[index2]);
        int temp = result[index1];
        result[index1] = result[index2];
        result[index2] = temp;
    }

    private int getRootIndex(int chaildNodeIndex) {
        return (int) Math.floor((chaildNodeIndex-1) / 2);
    }


    // main root starts with '0' index
    private int getLeftChildNodeIndex(int rootNodeIndex) {
        return rootNodeIndex * 2 + 1;
    }

    // main root starts with '0' index
    private int getRightChildNodeIndex(int rootNodeIndex) {
        return rootNodeIndex * 2 + 2;
    }

    private int getMinmumChildIndex(int[] arr, int leftIndex, int rightIndex) {
        return arr[leftIndex] < arr[rightIndex] ? leftIndex : rightIndex;
    }


}
