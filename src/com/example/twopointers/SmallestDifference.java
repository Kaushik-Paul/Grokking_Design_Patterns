package com.example.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestDifference {

    // O(mlog(m) + nlog(n)) time and O(1) space
    private static int[] findDifference(int[] array1, int[] array2) {
        int[] smallestDifference = new int[2];
        int pointer1 = 0;
        int pointer2 = 0;
        int smallest = Integer.MAX_VALUE;

        while (pointer1 < array1.length && pointer2 < array2.length) {
            int currentSum = Math.abs(array1[pointer1] - array2[pointer2]);
            if (currentSum < smallest) {
                smallest = currentSum;
                smallestDifference[0] = array1[pointer1];
                smallestDifference[1] = array2[pointer2];
            }

            if (array1[pointer1] > array2[pointer2]) {
                pointer2++;
            } else if (array1[pointer1] < array2[pointer2]) {
                pointer1++;
            } else {
                return new int[]{array1[pointer1], array2[pointer2]};
            }
        }

        return smallestDifference;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{-1, 5, 10, 20, 28, 3};
        int[] array2 = new int[]{26, 134, 135, 15, 17};
        int[] s = findDifference(array1, array2);
        System.out.println("The Smallest Difference value of the two arrays is : " + Arrays.toString(s));
    }
}
