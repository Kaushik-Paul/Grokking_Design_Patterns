package com.example.sorting;

import java.util.Arrays;

public class BubbleSort {

    // O(n^2) time and O(1) space
    private static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int counter = 0;

        while (!isSorted) {
            for (int i = 0; i < array.length - 1 - counter; i++) {
                isSorted = true;

                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    swapNumbers(array, i, i + 1);
                }
            }
            counter++;
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
        bubbleSort(array);
        System.out.print("The sorted array is : " + Arrays.toString(array));
    }
}
