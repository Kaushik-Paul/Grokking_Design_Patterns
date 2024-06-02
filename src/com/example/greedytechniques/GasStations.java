package com.example.greedytechniques;

import java.util.Arrays;

public class GasStations {

    // O(n) time and O(1) space
    private static int gasStationJourney(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int startingPosition = 0;
        int currentGas = 0;

        for (int i = 0; i < gas.length - 1; i++) {
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                currentGas = 0;
                startingPosition = i + 1;
            }
        }

        return startingPosition;
    }

    public static void main(String[] args) {

        int[][] gas = {
                {1, 2, 3, 4, 5},
                {2, 3, 4},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 10},
                {1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5}
        };
        int[][] cost = {
                {3, 4, 5, 1, 2},
                {3, 4, 5},
                {1, 2, 3, 4, 5},
                {2, 2, 1, 3, 1},
                {1, 0, 1, 2, 3},
                {1, 2, 3, 4, 5}
        };
        for (int i = 0; i < cost.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tGas: " + Arrays.toString(gas[i]));
            System.out.println("\tCost: " + Arrays.toString(cost[i]));
            System.out.println("\tThe index of the gas station we can start our journey from is "+ gasStationJourney(gas[i], cost[i])+ " (If it's -1, then that means no solution exists)");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
