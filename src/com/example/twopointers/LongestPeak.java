package com.example.twopointers;

public class LongestPeak {

    // O(n) time and O(1) space
    private static int longestPeak(int[] array) {
        int longestPeak = 0;
        int index = 1;

        while (index < array.length - 1) {
            boolean isPeak = array[index] > array[index - 1] && array[index] > array[index + 1];

            if (!isPeak) {
                index++;
                continue;
            }

            int leftIdx = index - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx--;
            }

            int rightIdx = index + 2;
            while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx++;
            }

            int currentLongestPeak = rightIdx - leftIdx - 1;
            longestPeak = Math.max(currentLongestPeak, longestPeak);

            index = rightIdx;
        }

        return longestPeak;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println("The Longest Peak of the current array is : " + longestPeak(array));
    }
}
