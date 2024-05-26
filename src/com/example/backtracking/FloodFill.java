package com.example.backtracking;

import java.util.Arrays;

public class FloodFill {

    // O(m * n) time and O(m * n) space
    private static int[][] floodFill(int[][] grid, int row, int col, int target) {
        if (grid[row][col] == target) {
            return grid;
        }

        int oldTarget = grid[row][col];
        dfs(grid, row, col, oldTarget, target);
        return grid;
    }

    private static void dfs(int[][] grid, int row, int col, int oldTarget, int target) {
        if (grid[row][col] == oldTarget) {
            grid[row][col] = target;
        } else {
            return;
        }

        int rowLength = grid.length;
        int colLength = grid[0].length;

        if (col + 1 < colLength) {
            dfs(grid, row, col + 1, oldTarget, target);
        }

        if (row - 1 >= 0) {
            dfs(grid, row - 1, col, oldTarget, target);
        }

        if (col - 1 >= 0) {
            dfs(grid, row, col - 1, oldTarget, target);
        }

        if (row + 1 < rowLength) {
            dfs(grid, row + 1, col, oldTarget, target);
        }

    }

    public static void main(String[] args){
        int[][][] grids = {
                {{1, 1, 0, 1, 0},
                        {0, 0, 0, 0, 1},
                        {0, 0, 0, 1, 1},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0}},

                {{1, 1, 0, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 1},
                        {1, 1, 1, 1}},

                {{9, 9, 6, 9},
                        {6, 9, 9, 6},
                        {6, 9, 9, 9},
                        {9, 9, 9, 9}},

                {{1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {0, 1, 1, 0},
                        {1, 0, 1, 1}},

                {{1, 2, 0, 0},
                        {3, 1, 3, 6},
                        {7, 2, 1, 5},
                        {1, 9, 2, 1}}
        };

        int[] sr = {4, 2, 2, 2, 1};
        int[] sc = {3, 3, 1, 3, 1};
        int[] target = {3, 2, 1, 0, 4};

        for (int i = 0; i < grids.length; i++) {
            System.out.println((i + 1) + ".\t Grid before flood fill: " + Arrays.deepToString(grids[i]));
            System.out.println("\t Starting row and column are: (" + sr[i] + ", " + sc[i] + ")");
            System.out.println("\t Target value: " + target[i]);

            int[][] result = floodFill(grids[i], sr[i], sc[i], target[i]);
            System.out.println("\t After perform flood fill: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
