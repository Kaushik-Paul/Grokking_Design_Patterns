package com.example.slidingwindow;

import java.util.Arrays;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int[][] inputs = {
                {1,2,4,2,5,7,2,4,9,0,9},
                {7,1,5,3,6,4},
                {7,6,4,3,1},
                {2,6,8,7,8,7,9,4,1,2,4,5,8},
                {1,4,2}
        };
        for (int i = 0; i < inputs.length; i++) {
            int[] currentInput = inputs[i];
            int maxProfit = maxProfit(currentInput);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + Arrays.toString(currentInput));
            System.out.println("\n\tMax Profit: " + maxProfit);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(n) time and O(1) space
    private static int maxProfit(int[] prices) {
        int buyStock = 0;
        int sellStock = 1;
        int maxProfit = 0;

        while (sellStock < prices.length) {
            if (prices[sellStock] > prices[buyStock]) {
                maxProfit = Math.max(maxProfit, prices[sellStock] - prices[buyStock]);
            } else {
                buyStock = sellStock;
            }

            sellStock++;
        }

        return maxProfit;
    }
}
