package com.example.fastandslowpointers;

import java.util.Arrays;

public class DuplicateNumbers {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 2, 3, 5, 4},
                {2, 4, 5, 4, 1, 3},
                {1, 6, 3, 5, 1, 2, 7, 4},
                {1, 2, 2, 4, 3},
                {3, 1, 3, 5, 6, 4, 2}
        };
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tnums = "+ Arrays.toString(nums[i]));
            System.out.println("\tDuplicate number = "+ findDuplicate(nums[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(n) time and O(1) space
    private static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // First traverse till they meet
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        // Move slow pointer to beginning
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
