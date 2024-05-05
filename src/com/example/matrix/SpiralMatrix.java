package com.example.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    // O(n ^ 2) time and O(n) space
     private static List<Integer> spiralOrder(int[][] input) {
        List<Integer> resultMatrix = new ArrayList<>();
        int rowLength = input.length;
        int colLength = input[0].length;
        int row = 0;
        int col = -1;
        int direction = 1;

        while (rowLength > 0 && colLength > 0) {
            for (int i = 0; i < colLength; i++) {
                col += direction;
                resultMatrix.add(input[row][col]);
            }
            rowLength--;

            for (int i = 0; i < rowLength; i++) {
                row += direction;
                resultMatrix.add(input[row][col]);
            }

            colLength--;

            direction *= -1;

        }

        return resultMatrix;
    }

    // O(n) time and O(n) space
    public static List<Integer> spiralOrder2(int[][] array) {
        List<Integer> integerList = new ArrayList<>();
        int startRow = 0, endRow = array.length - 1;
        int startCol = 0, endCol = array[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                integerList.add(array[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++) {
                integerList.add(array[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--) {
                integerList.add(array[endRow][col]);
            }
            for (int row = endRow - 1; row >= startRow + 1; row--) {
                integerList.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return integerList;
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{1}},
                {{6}, {2}},
                {{2, 14, 8}, {12, 7, 14}},
                {{3, 1, 1}, {15, 12, 13}, {4, 14, 12}, {10, 5, 11}},
                {{10, 1, 14, 11, 14}, {13, 4, 8, 2, 13}, {10, 19, 1, 6, 8}, {20, 10, 8, 2, 12}, {15, 6, 8, 8, 18}}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tMatrix:");
            Arrays.stream(inputs[i]).map(Arrays::toString).forEach(System.out::println);

            System.out.println("\n\tSpiral order: " + spiralOrder2(inputs[i]));

            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
