package com.example.mergeinterval;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(n) time and O(n) space
    private static int[][] insertInterval(int[][] existingInterval, int[] newInterval) {
        if (existingInterval.length == 0) {
            return new int[][]{};
        }

        LinkedList<int[]> linkedList = new LinkedList<>();
        int i = 0;

        // Traverse till the new interval arrives
        while (i < existingInterval.length && existingInterval[i][0] < newInterval[0]) {
            linkedList.add(existingInterval[i]);
            i++;
        }

        int[] previousInterval = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        if (i > 0) {
            previousInterval = linkedList.getLast();
        }

        // If it's an overlapping interval then update the last interval otherwise add the new interval
        if (newInterval[0] <= previousInterval[1]) {
            previousInterval[1] = Math.max(previousInterval[1], newInterval[1]);
        } else {
            linkedList.add(newInterval);
        }

        // Traverse through the existing intervals
        while (i < existingInterval.length) {
            int[] currentInterval = existingInterval[i];
            int currentStartPosition = currentInterval[0];
            int currentEndPosition = currentInterval[1];

            previousInterval = linkedList.getLast();
            int previousEndPosition = previousInterval[1];

            if (currentStartPosition <= previousEndPosition) {
                previousInterval[1] = Math.max(currentEndPosition, previousEndPosition);
            } else {
                linkedList.add(currentInterval);
            }
            i++;
        }

        return linkedList.toArray(new int[][]{});

    }


}
