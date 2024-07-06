package com.example.cyclicsort;

import java.util.Arrays;

public class FirstMissingPositive {

    // O(n) time and O(1) space
    private static int firstMissingPositiveInteger(int[] nums) {
        int index = 0;

        while (index < nums.length) {
            int correctIndex = nums[index] - 1;

            if (correctIndex >= 0 && correctIndex < nums.length && nums[correctIndex] != nums[index]) {
                int temp = nums[index];
                nums[index] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {-1, 3, 5, 7, 1},
                {1, 5, 4, 3, 2},
                {-1, 0, 2, 1, 4},
                {1, 4, 3}
        };
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tThe first missing positive integar in the list " + Arrays.toString(A[i]) + " is:");
            System.out.println("\t" + firstMissingPositiveInteger(A[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
