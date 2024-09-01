package com.example.greedytechniques;

import java.util.Arrays;

public class MinimumWaitingTime {

    // O(n log n) time and O(1) space
    private static int minimumWaitingTime(int[] array) {
        int minimumWaiting = 0;
        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            int duration = array[i] * (array.length - (i + 1));
            minimumWaiting += duration;
        }

        return minimumWaiting;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 2, 6};
        System.out.println("The Minimum Waiting Time is: " + minimumWaitingTime(array));
    }
}
