package com.example.fastandslowpointers;

import java.util.Arrays;

public class CircularArrayLoop {

    public static void main(String[] args) {
        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(n ^ 2) time and O(1) space
    private static boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean forward = nums[i] >= 0;
            int slowPointer = i;
            int fastPointer = i;

            while (true) {
                slowPointer = nextStep(nums, slowPointer);

                if (notACycle(nums, forward, slowPointer)) {
                    break;
                }

                fastPointer = nextStep(nums, fastPointer);

                if (notACycle(nums, forward, fastPointer)) {
                    break;
                }

                fastPointer = nextStep(nums, fastPointer);

                if (notACycle(nums, forward, fastPointer)) {
                    break;
                }

                if (slowPointer == fastPointer) {
                    return true;
                }

            }
        }

        return false;

    }

    private static int nextStep(int[] nums, int position) {
        int size = nums.length;
        int nextStep = (nums[position] + position) % size;

        if (nextStep < 0) {
            nextStep += size;
        }
        return nextStep;
    }

    // If direction is changed or moving the pointer brings it back to same position
    private static boolean notACycle(int[] nums, boolean prevDirection, int position) {
        boolean currentDirection = nums[position] >= 0;

        if (prevDirection != currentDirection || Math.abs(nums[position]) % nums.length == 0) {
            return true;
        }

        return false;
    }
}
