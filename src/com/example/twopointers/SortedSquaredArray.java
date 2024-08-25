package com.example.twopointers;

import java.util.Arrays;

public class SortedSquaredArray {

    // O(n) time and O(n) space
    private static int[] sortedSquaredArray(int[] array) {
        int[] sortedArray = new int[array.length];
        int startIdx = 0;
        int endIdx = array.length - 1;

        for (int i = sortedArray.length - 1; i >= 0; i--) {
            if (Math.abs(array[startIdx]) >= Math.abs(array[endIdx])) {
                sortedArray[i] = (int) Math.pow(array[startIdx], 2);
                startIdx++;
            } else {
                sortedArray[i] = (int) Math.pow(array[endIdx], 2);
                endIdx--;
            }
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-7, -5, -4, 3, 6, 8, 9};
        int[] array2 = new int[]{-8, -7, -6, -5, -4, -3, -2};
        int[] array3 = new int[]{2, 5, 8, 9, 10, 23};
        System.out.println("The Squared Sorted Array is: " + Arrays.toString(sortedSquaredArray(array)));
        System.out.println("The Squared Sorted Array is: " + Arrays.toString(sortedSquaredArray(array2)));
        System.out.println("The Squared Sorted Array is: " + Arrays.toString(sortedSquaredArray(array3)));
    }

}
