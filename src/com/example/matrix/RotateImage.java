package com.example.matrix;

import java.util.Arrays;

public class RotateImage {

    // O(n^2) time and O(1) space
    private static int[][] rotateImage(int[][] input) {
        int n = input.length;

        for (int row = 0; row < n / 2; row++) {
            for (int column = row; column < n - row - 1; column++) {
                int temp = input[row][column];
                input[row][column] = input[column][n - 1 - row];
                input[column][n - 1 - row] = temp;

                temp = input[row][column];
                input[row][column] = input[n - 1 - row][n - 1 - column];
                input[n - 1 - row][n - 1 - column] = temp;

                temp = input[row][column];
                input[row][column] = input[n - 1 - column][row];
                input[n - 1 - column][row] = temp;
            }
        }

        return input;
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{1}},
                {{6, 9}, {2, 7}},
                {{2, 14, 8}, {12, 7, 14}, {3, 3, 7}},
                {{3, 1, 1, 7}, {15, 12, 13, 13}, {4, 14, 12, 4}, {10, 5, 11, 12}},
                {{10, 1, 14, 11, 14}, {13, 4, 8, 2, 13}, {10, 19, 1, 6, 8}, {20, 10, 8, 2, 12}, {15, 6, 8, 8, 18}}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tMatrix:");
            Arrays.stream(inputs[i]).map(Arrays::toString).forEach(System.out::println);

            System.out.println("\n\tRotated matrix:");
            Arrays.stream(rotateImage(inputs[i])).map(Arrays::toString).forEach(System.out::println);

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
