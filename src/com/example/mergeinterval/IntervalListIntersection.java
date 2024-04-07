package com.example.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {

    public static void main(String[] args) {
        int[][][] inputIntervalLista = {
                {{1, 2}},
                {{1, 4}, {5, 6}, {9, 15}},
                {{3, 6}, {8, 16}, {17, 25}},
                {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}},
                {{1, 3}, {5, 6}, {7, 8}, {12, 15}}
        };

        int[][][] inputIntervalListb = {
                {{1, 2}},
                {{2, 4}, {5, 7}, {9, 15}},
                {{2, 3}, {10, 15}, {18, 23}},
                {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}},
                {{2, 4}, {7, 10}}
        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(intervalsIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(m + n) time and O(n) space
    private static int[][] intervalsIntersection(int[][] interval1, int[][] interval2) {
        if (interval1.length == 0 || interval2.length == 0) {
            return new int[][]{};
        }

        int i = 0, j = 0;
        List<int[]> arrayList = new ArrayList<>();

        while (i < interval1.length && j < interval2.length) {
            int start = Math.max(interval1[i][0], interval2[j][0]);
            int end = Math.min(interval1[i][1], interval2[j][1]);

            if (start <= end) {
                arrayList.add(new int[]{start, end});
            }

            if (interval1[i][1] <= interval2[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return arrayList.toArray(new int[][]{});
    }
}
