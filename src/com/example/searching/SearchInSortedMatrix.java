package com.example.searching;

public class SearchInSortedMatrix {

    // O(n) time and O(1) space
    private static int[] searchInMatrix(int[][] array, int target) {
        int[] result = {-1, -1};
        int row = 0;
        int col = array[0].length - 1;

        while (row < array.length && col >= 0) {
            if (target < array[row][col]) {
                col--;
            } else if (target > array[row][col]) {
                row++;
            } else {
                result[0] = row;
                result[1] = col;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,   4,  7,   12,  15,  1000},
                {2,   5,  19,  31,  32,  1001},
                {3,   8,  24,  33,  35,  1002},
                {40, 41,  42,  44,  45,  1003},
                {99, 100, 103, 106, 128, 1004}
        };
        int[] store = searchInMatrix(array, 44);
        if (store[0] == -1) {
            System.out.println("The number is not present in the matrix");
        } else {
            System.out.println("The number is present in the location [" + store[0] + " , " + store[1] + "] of the matrix");
        }
    }
}
