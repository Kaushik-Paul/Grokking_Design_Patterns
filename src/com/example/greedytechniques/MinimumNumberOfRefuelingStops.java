package com.example.greedytechniques;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {

    // O(n * log n) time and O(n) space
    private static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int minimumNumberOfStops = 0;
        int maximumDistance = startFuel;
        int i = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (target > maximumDistance) {
            if (i < stations.length && maximumDistance >= stations[i][0]) {
                maxHeap.add(stations[i][1]);
                i++;
            } else if (maxHeap.isEmpty()) {
                return -1;
            } else {
                maximumDistance += maxHeap.poll();
                minimumNumberOfStops++;
            }
        }

        return minimumNumberOfStops;
    }
    
    public static void main(String[] args) {
        int[] target = {120, 15, 570, 1360};
        int[] startFuel = {10, 3, 140, 380};
        int[][][] stations = {
                {{10, 60},{20, 25},{30, 30},{60, 40}},
                {{2, 5},{3, 1},{6, 3},{12,6 }},
                {{140, 200}, {160, 130}, {310, 200}, {330, 250}},
                {{310, 160}, {380, 620}, {700, 89}, {850, 190}, {990, 360}}
        };
        for(int i=0;i<target.length;i++){
            System.out.print(i+1);
            System.out.println(".\tStations: "+ Arrays.deepToString(stations[i]));
            System.out.println("\tTarget fuel: "+target[i]);
            System.out.println("\tStart fuel: "+startFuel[i]);
            System.out.println("\tMinimum number of Refueling stops: " + minRefuelStops(target[i], startFuel[i], stations[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
