package com.example.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    // O(n ^ 2) time and O(n) space
    private static List<int[]> findSumOfThree(int[] array, int target) {
        Arrays.sort(array);
        List<int[]> threeNumberSum = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {
            int leftIdx = i + 1;
            int rightIdx = array.length - 1;

            while (leftIdx < rightIdx) {
                int currentSum = array[i] + array[leftIdx] + array[rightIdx];

                if (currentSum < target) {
                    leftIdx++;
                } else if (currentSum > target) {
                    rightIdx--;
                } else {
                    threeNumberSum.add(new int[]{array[i], array[leftIdx], array[rightIdx]});
                    leftIdx++;
                    rightIdx--;
                }
            }
        }

        return threeNumberSum;
    }

    public static void main(String[] args) {
        int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
                {-1, 2, 1, -4, 5, -3},
                {2, 3, 4, 1, 7, 9},
                {1, -1, 0},
                {2, 4, 2, 7, 6, 3, 1},
                {12, 3, 1, 2, -6, 5, -8, 6}};

        int[] testList = {10, 7, 20, -1, 8, 0};


        for (int i=0; i<testList.length; i++) {
            System.out.print(i+1);
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

            List<int[]> threeNumberSum = findSumOfThree(numsList[i], testList[i]);

            if (!threeNumberSum.isEmpty()) {
                System.out.println("\tSum for " + testList[i] + " exists ");
                System.out.println("\tThose are " + Arrays.deepToString(threeNumberSum.toArray()));
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }

            System.out.println("-------------------------------------------------------------------");
        }
    }

}
