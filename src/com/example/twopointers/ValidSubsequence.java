package com.example.twopointers;

public class ValidSubsequence {

    // O(n) time and O(1) space
    private static boolean validateSubsequence(int[] array, int[] subsequence) {
        int arrayIdx = 0, subsequenceIdx = 0;

        while (arrayIdx < array.length && subsequenceIdx < subsequence.length) {
            if (array[arrayIdx] == subsequence[subsequenceIdx]) {
                subsequenceIdx++;
            }
            arrayIdx++;
        }

        return subsequenceIdx == subsequence.length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        int[] subsequence = new int[]{1, 6, -1, 10};
        System.out.println("Is it a valid subsequence: " + validateSubsequence(array, subsequence));
    }
}
