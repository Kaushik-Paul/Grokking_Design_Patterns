package com.example.cyclicsort;

import java.util.Arrays;

public class CorruptPair {

    // O(n) time and O(1) space
    private static int[] findCorruptPair(int[] nums) {
        int index = 0;
        int duplicated = 0;
        int missing = 0;

        while (index < nums.length) {
            int value = nums[index] - 1;

            if (nums[index] != nums[value]) {
                int temp = nums[index];
                nums[index] = nums[value];
                nums[value] = temp;
            } else {
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                duplicated = nums[i];
                missing = i + 1;
            }
        }

        return new int[]{missing, duplicated};
    }

    public static void main(String[] args) {

        int[][] array = {{3, 1, 2, 5, 2},
                {3, 1, 2, 3, 6, 4},
                {4, 1, 2, 1, 6, 3},
                {4, 3, 4, 5, 1},
                {5, 3, 5, 6, 2, 1}};

        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tGiven array: " + Arrays.toString(array[i]));
            System.out.print("\n\tCorrupt pair: ");
            System.out.print(findCorruptPair(array[i])[0]);
            System.out.print(", ");
            System.out.println(findCorruptPair(array[i])[1]);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
