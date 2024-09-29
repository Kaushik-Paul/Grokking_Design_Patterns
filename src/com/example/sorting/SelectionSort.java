package com.example.sorting;

import java.util.Arrays;

public class SelectionSort {

    // O(n ^ 2) time and O(1) space
    private static void selectionSort(int[] array) {
        int currentIndex = 0;

        while (currentIndex < array.length) {
            int smallestIndex = currentIndex;

            for (int i = currentIndex + 1; i < array.length; i++) {
                if (array[smallestIndex] > array[i]) {
                    smallestIndex = i;
                }
            }

            swapNumbers(array, currentIndex, smallestIndex);
            currentIndex++;
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
        selectionSort(array);     // Sorting the array
        System.out.print("The sorted array is : " + Arrays.toString(array));
    }
}
