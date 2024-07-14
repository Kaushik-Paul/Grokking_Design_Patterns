package com.example.bitwisemanipulation;

import java.util.Arrays;

public class TwoSingleNumbers {

    // O(n) time and O(1) space
    public static int[] twoSingleNumbers(int[] nums) {
        int bitwiseXOR = 0;
        for (int num : nums) {
            bitwiseXOR ^= num;
        }

        int bitwiseMask = bitwiseXOR & -bitwiseXOR;

        int result = 0;

        for (int num : nums) {
            if ((num & bitwiseMask) != 0) {
                result ^= num;
            }
        }

        return new int[]{result, bitwiseXOR ^ result};
    }

    // Driver code
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 2, 3},
                {4, 4, 3, 2, 3, 5},
                {1, 1, 7, 4, 5, 5, 8, 8},
                {1, 0},
                {9, 8, 8, 7, 6, 6, 4, 4}
        };

        for (int i = 0; i < arr.length; i++) {
            int[] result = twoSingleNumbers(arr[i]);
            System.out.print(i + 1 + ".\tInput list:" + Arrays.toString(arr[i]));
            System.out.print("\n\tTwo Singles numbers in a list: " + Arrays.toString(result) + "\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
