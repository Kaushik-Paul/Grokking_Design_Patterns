package com.example.graphs;

import java.util.*;

public class BusRoutes {

    // O(r * s) time and O(r * s) space
    // Where r is the total number of routes and s is the number of stations.
    private static int minimumBuses(int[][] routes, int source, int destination) {
        // Create bus available for stations
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                adjacencyList.putIfAbsent(station, new HashSet<>());
                adjacencyList.get(station).add(i);
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{source, 0});

        Set<Integer> visitedBus = new HashSet<>();

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int station = current[0];
            int busTaken = current[1];

            if (station == destination) {
                return busTaken;
            }

            if (adjacencyList.containsKey(station)) {
                for (int bus : adjacencyList.get(station)) {
                    if (!visitedBus.contains(bus)) {
                        for (int s : routes[bus]) {
                            deque.add(new int[]{s, busTaken + 1});
                        }

                        visitedBus.add(bus);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][][] routes = {
                {{2, 5, 7}, {4, 6, 7}},
                {{1, 12}, {4, 5, 9}, {9, 19}, {10, 12, 13}},
                {{1, 12}, {10, 5, 9}, {4, 19}, {10, 12, 13}},
                {{1, 9, 7, 8}, {3, 6, 7}, {4, 9}, {8, 2, 3, 7}, {2, 4, 5}},
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        };
        int[] src = {2, 9, 1, 1, 4};
        int[] dest = {6, 12, 9, 5, 6};

        for (int i = 0; i < routes.length; i++) {
            System.out.print((i + 1) + ".\tBus Routes: ");
            System.out.print(Arrays.deepToString(routes[i]));
            System.out.println();
            System.out.println("\tSource: " + src[i]);
            System.out.println("\tDestination: " + dest[i]);
            System.out.println("\n\tMinimum Buses Required: " + minimumBuses(routes[i], src[i], dest[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
