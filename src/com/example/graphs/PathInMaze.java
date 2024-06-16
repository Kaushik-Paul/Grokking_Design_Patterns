package com.example.graphs;

import java.util.*;

public class PathInMaze {

    // O(n * m) time and O(n^2) space
    private static int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();
        int cycles = 0;

        for (int[] corridor : corridors) {
            int room1 = corridor[0];
            int room2 = corridor[1];

            neighbours.putIfAbsent(room1, new HashSet<>());
            neighbours.putIfAbsent(room2, new HashSet<>());

            neighbours.get(room1).add(room2);
            neighbours.get(room2).add(room1);

            cycles += getIntersectionLength(neighbours.get(room1), neighbours.get(room2));
        }

        return cycles;
    }

    private static int getIntersectionLength(Set<Integer> neighbours1, Set<Integer> neighbours2) {
        int count = 0;

        for (int currentRoom : neighbours1) {
            if (neighbours2.contains(currentRoom)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nList = {5, 4, 5, 5, 4};
        int[][][] corridorsList = {
                {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}},
                {{1, 2}, {3, 4}},
                {{1, 2}, {5, 2}, {4, 1}, {3, 1}, {3, 4}},
                {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}, {1, 5}},
                {{1, 2}, {2, 3}, {3, 4}}
        };

        for (int i = 0; i < nList.length; i++) {
            System.out.println((i + 1) + ".\t n: " + nList[i]);
            System.out.println("\t corridors: " + Arrays.deepToString(corridorsList[i]));
            System.out.println("\t cycles: " + numberOfPaths(nList[i], corridorsList[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
