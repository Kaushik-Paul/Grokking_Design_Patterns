package com.example.twopointers;

import java.util.Arrays;

public class MoveElementToEnd {

    // O(n) time and O(1) space
    private static void moveElementToEnd(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // left < right check is necessary otherwise right might keep on decreasing
            // eventually becoming less than left and swapping wrong element
            while (array[right] == target && left < right) {
                right--;
            }

            if (array[left] == target) {
                swap(array, left, right);
            }

            left++;
        }
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 2, 2, 2, 3, 2, 2};
        int target = 2;
        moveElementToEnd(array, target);
        System.out.println("After moving "+target+" to the end. The resulting array is : " + Arrays.toString(array));
    }
}
