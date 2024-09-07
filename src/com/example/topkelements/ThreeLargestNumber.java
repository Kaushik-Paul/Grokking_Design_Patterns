package com.example.topkelements;

public class ThreeLargestNumber {

    // O(n) time and O(1) space
    private static int[] findThreeLargestNumber(int[] array) {
        int[] largestArray = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            updateLargest(num, largestArray);
        }

        return largestArray;
    }

    private static void updateLargest(int num, int[] largestArray) {
        if (largestArray[2] == Integer.MIN_VALUE || largestArray[2] < num) {
            shiftAndUpdate(num, largestArray, 2);
        } else if (largestArray[1] == Integer.MIN_VALUE || largestArray[1] < num) {
            shiftAndUpdate(num, largestArray, 1);
        } else if (largestArray[0] == Integer.MIN_VALUE || largestArray[0] < num) {
            shiftAndUpdate(num, largestArray, 0);
        }
    }

    private static void shiftAndUpdate(int num, int[] largestArray, int index) {
        for (int i = 0; i < index; i++) {
            largestArray[i] = largestArray[i + 1];
        }

        largestArray[index] = num;
    }

    public static void main(String[] args) {
        int[] array = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int [] largest= findThreeLargestNumber(array);
        System.out.format("The Three largest numbers are : %d , %d , %d ",largest[0],largest[1],largest[2]);
    }
}
