package com.example.sorting;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    // O(n log(n)) time and O(log(n)) space
    private static void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }

        int pivotIdx = startIdx;
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;

        while (leftIdx <= rightIdx) {
            if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            }

            if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            }

            if (array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }

        swap(array, pivotIdx, rightIdx);

        // Call for two halves
        quickSortHelper(array, startIdx, rightIdx - 1);
        quickSortHelper(array, rightIdx + 1, endIdx);
    }

    private static void swap(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        quickSort(array);
        System.out.println("After sorting the array : " + Arrays.toString(array));
    }
}
