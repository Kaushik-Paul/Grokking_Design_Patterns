package com.example.dynamicprogramming;

public class CountingBits {

    // O(n) time and O(1) space
    private static int[] countingBits(int inputBit) {
        int[] result = new int[inputBit + 1];

        if (inputBit <= 0) {
            return result;
        }

        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= inputBit; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i / 2] + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] inputBits = { 1, 2, 3, 4, 5, 10 };

        for (int i = 0; i < inputBits.length; ++i) {
            System.out.println((i + 1) + ".\t Bits: " + inputBits[i]);
            int[] result = countingBits(inputBits[i]);
            System.out.println("\t Counting bits: " + java.util.Arrays.toString(result));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
