package com.example.sorting;

import java.util.Arrays;

public class InsertionSort {

    // O(n ^ 2) time and O(1) space
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    swapNumbers(array, j, j - 1);
                }
            }
        }
    }

    private static void swapNumbers(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        int[] arr = new int[]{3, 6, 9, 10, 11, 45, 88};
        insertionSort(array);     // Sorting the array
        System.out.print("The sorted array is : " + Arrays.toString(array));
    }
}
