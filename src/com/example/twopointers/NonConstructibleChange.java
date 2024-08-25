package com.example.twopointers;

import java.util.Arrays;

public class NonConstructibleChange {

    // O(n) time and O(1) space
    private static int nonConstructibleChange(int[] array) {
        Arrays.sort(array);

        int currentChangeCreated = 0;

        for (int coin : array) {
            if (coin > currentChangeCreated + 1) {
                return currentChangeCreated + 1;
            } else {
                currentChangeCreated += coin;
            }
        }

        return currentChangeCreated + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 1, 1, 2, 3, 22};
        System.out.println("The least Non Constructible change is: " + nonConstructibleChange(array));

    }
}
