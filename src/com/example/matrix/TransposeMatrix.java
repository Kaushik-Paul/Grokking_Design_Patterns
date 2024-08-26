package com.example.matrix;

public class TransposeMatrix {

    // O(n ^ 2) time and O(n ^ 2) space
    private static int[][] transposeMatrix(int[][] array) {
        int[][] transposeArray = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                transposeArray[i][j] = array[j][i];
            }
        }

        return transposeArray;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.printf("%4d", col);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Before Transposing Matrix");
        printMatrix(array);

        int[][] transposeArray = transposeMatrix(array);
        System.out.println("After Transposing Matrix");
        printMatrix(transposeArray);
    }
}
