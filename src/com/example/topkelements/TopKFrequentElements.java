package com.example.topkelements;

import java.util.*;

public class TopKFrequentElements {

    // O(n log n) time and O(n + k) space
    private static List<Integer> topKFrequent(int[] input, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            numFrequencyMap.put(input[i], numFrequencyMap.getOrDefault(input[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            topKElements.add(entry);
            if (topKElements.size() > k) {
                topKElements.poll();
            }
        }

        List<Integer> topNumbers = new ArrayList<>(k);
        while (!topKElements.isEmpty()) {
            topNumbers.add(topKElements.poll().getKey());
        }
        Collections.sort(topNumbers);
        return topNumbers;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 3, 5, 12, 11, 12, 11, 12, 5},
                {1, 3, 5, 14, 18, 14, 5},
                {2, 3, 4, 5, 6, 7, 7},
                {9, 8, 7, 6, 6, 5, 4, 3, 2, 1},
                {2, 4, 3, 2, 3, 4, 5, 4, 4, 4},
                {1, 1, 1, 1, 1, 1},
                {2, 3}
        };
        int[] inputK = {3, 2, 1, 1, 3, 4, 2};
        for (int i = 0; i < inputK.length; i++) {
            List<Integer> result = topKFrequent(inputs[i], inputK[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput: (" + Arrays.toString(inputs[i]) + ", " + inputK[i] + ")");
            System.out.println("\n\tTop " + inputK[i] + " frequent elements: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
