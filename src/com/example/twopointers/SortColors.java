package com.example.twopointers;

import java.util.Arrays;

public class SortColors {

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + Arrays.toString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));

            System.out.println("======================================================");
        }
    }

    private static void swap(int[] inputs, int position1, int position2) {
        int temp = inputs[position1];
        inputs[position1] = inputs[position2];
        inputs[position2] = temp;
    }

    // O(n) time and O(1) space
    private static int[] sortColors(int[] colors) {
        int startIdx = 0;
        int currentIdx = 0;
        int endIdx = colors.length - 1;

        while (currentIdx <= endIdx) {
            // If it is red
            if (colors[currentIdx] == 0) {
                // If start is not 0 then swap and move cursors
                if (colors[startIdx] != 0) {
                    swap(colors, startIdx, currentIdx);
                }
                startIdx++;
                currentIdx++;
            } else if (colors[currentIdx] == 1) {
                // Just traverse
                currentIdx++;
            } else {
                // If end is not 1 then swap and move cursors
                if (colors[endIdx] != 2) {
                    swap(colors, currentIdx, endIdx);
                }
                endIdx--;
            }
        }
        return colors;
    }
}
