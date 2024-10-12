package com.example.twopointers;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    // O(n) time and O(n) space
    private static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; i++) {
                result.add(array[startRow][i]);
            }

            for (int j = startRow + 1; j <= endRow; j++) {
                result.add(array[j][endCol]);
            }

            for (int i = endCol - 1; i >= startCol; i--) {
                result.add(array[endRow][i]);
            }

            for (int j = endRow - 1; j >= startRow + 1; j--) {
                result.add(array[j][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        List<Integer> s = spiralTraverse(array);
        System.out.println("Spiral Traversal using Iteration : " + s);
    }
}
