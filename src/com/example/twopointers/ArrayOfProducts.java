package com.example.twopointers;

import java.util.Arrays;

public class ArrayOfProducts {

    // O(n) time and O(1) space
    private static int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];
        int product = 1;

        for (int num : array) {
            product *= num;
        }

        for (int i = 0; i < array.length; i++) {
            result[i] = product / array[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, -1, 4, 2};
        System.out.println("The Product Of Arrays is: " + (Arrays.toString(arrayOfProducts(array))));
    }
}
