package com.example.twopointers;

public class MonotonicArray {

    // O(n) time and O(1) space
    private static boolean isMonotonic(int[] array) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                isDecreasing = false;
            }

            if (array[i] > array[i + 1]) {
                isIncreasing = false;
            }
        }

        return isDecreasing || isIncreasing;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        if (isMonotonic(array)) {
            System.out.println("The array is monotonic (without using direction)");
        } else {
            System.out.println("The array is not Monotonic (without using direction)");
        }
    }
}
