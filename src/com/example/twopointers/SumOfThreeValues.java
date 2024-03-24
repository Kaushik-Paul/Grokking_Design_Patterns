package com.example.twopointers;

import java.util.Arrays;

public class SumOfThreeValues {

    public static void main(String[] args) {
        int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
                {-1, 2, 1, -4, 5, -3},
                {2, 3, 4, 1, 7, 9},
                {1, -1, 0},
                {2, 4, 2, 7, 6, 3, 1}};

        int[] testList = {10, 7, 20, -1, 8};


        for (int i=0; i<testList.length; i++) {
            System.out.print(i+1);
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

            if (findSumOfThree(numsList[i], testList[i])) {
                System.out.println("\tSum for " + testList[i] + " exists ");
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }

            System.out.println("-------------------------------------------------------------------");
        }
    }

    // O(n^2) time and O(1) space
    private static boolean findSumOfThree(int[] input, int target) {
        // Sort the array
        Arrays.sort(input);

        for (int i = 0; i < input.length - 2; i++) {
            int startIdx = i + 1;
            int endIdx = input.length - 1;

            while (startIdx < endIdx) {
                int triplets = input[i] + input[startIdx] + input[endIdx];

                if (triplets < target) {
                    startIdx++;
                } else if (triplets > target) {
                    endIdx--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
