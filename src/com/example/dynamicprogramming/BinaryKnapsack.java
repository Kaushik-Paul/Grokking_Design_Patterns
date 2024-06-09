package com.example.dynamicprogramming;

import java.util.Arrays;

public class BinaryKnapsack {

    // O(n) space and O(n) time
    private static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findMaxKnapsackProfitHelper(capacity, weights, values, weights.length, dp);

    }

    private static int findMaxKnapsackProfitHelper(int capacity, int[] weights, int[] values, int n, int[][] dp) {
        if (n == 0 || capacity <= 0) {
            return 0;
        }

        // If it already exists return it otherwise calculate
        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        if (weights[n - 1] <= capacity) {
            dp[n][capacity] = Math.max(values[n - 1] + findMaxKnapsackProfitHelper(capacity - weights[n - 1], weights, values, n - 1, dp),
                    findMaxKnapsackProfitHelper(capacity, weights, values, n - 1, dp));
        } else {
            dp[n][capacity] = findMaxKnapsackProfitHelper(capacity, weights, values, n - 1, dp);
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int[][] weights = {
                { 1, 2, 3, 5 },
                { 4 },
                { 2 },
                { 3, 6, 10, 7, 2 },
                { 3, 6, 10, 7, 2, 12, 15, 10, 13, 20 }
        };

        int[][] values = {
                { 1, 5, 4, 8 },
                { 2 },
                { 3 },
                { 12, 10, 15, 17, 13 },
                { 12, 10, 15, 17, 13, 12, 30, 15, 18, 20 }
        };

        int[] capacity = { 6, 3, 3, 10, 20 };

        for (int i = 0; i < values.length; ++i) {
            System.out.print(i + 1);
            System.out.println(". We have a knapsack of capacity " + capacity[i] + " and we are given the following list of item values and weights:");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            System.out.println("Weights   |     Values");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            for (int j = 0; j < values[i].length; ++j)
                System.out.printf("%-10d|%6d\n", weights[i][j], values[i][j]);
            int result = findMaxKnapsackProfit(capacity[i], weights[i], values[i]);
            System.out.println("\nThe maximum we can earn is: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println();
        }
    }

}
