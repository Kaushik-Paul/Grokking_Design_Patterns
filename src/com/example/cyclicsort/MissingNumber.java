package com.example.cyclicsort;

public class MissingNumber {

    // O(n) time and O(1) space
    private static int findMissingNumber(int[] inputNumber) {
        int index = 0;
        int numLength = inputNumber.length;

        while (index <= numLength - 1) {
            int value = inputNumber[index];

            if (value < numLength && value != index) {
                int temp = inputNumber[index];
                inputNumber[index] = inputNumber[value];
                inputNumber[value] = temp;
            } else if (value >= numLength) {
                index++;
            } else {
                index++;
            }
        }

        for (int i = 0; i < numLength; i++) {
            if (inputNumber[i] != i) {
                return i;
            }
        }

        return numLength;
    }

    public static void main(String[] args) {
        int[][] inputNumbers = {
                {4, 0, 3, 1},
                {8, 3, 5, 2, 4, 6, 0, 1},
                {1, 2, 3, 4, 6, 7, 8, 9, 10, 11},
                {0},
                {1, 2, 3, 0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23}
        };

        for (int i = 0; i < inputNumbers.length; i++) {
            System.out.print(i + 1 + ".\tnums: [");

            for (int j = 0; j < inputNumbers[i].length - 1; j++) {
                System.out.print(inputNumbers[i][j]);
                System.out.print(", ");
            }

            System.out.println(inputNumbers[i][inputNumbers[i].length - 1] + "]");

            System.out.println("\n\tMissing number: " + findMissingNumber(inputNumbers[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
