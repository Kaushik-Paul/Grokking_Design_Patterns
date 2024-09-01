package com.example.greedytechniques;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {

    // O(n) time and O(1) space
    private static int findTandemBicycleSpeed(Integer[] redShirtSpeeds, Integer[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(blueShirtSpeeds);
        Arrays.sort(redShirtSpeeds);
        int totalSpeed = 0;

        if (fastest) {
            Arrays.sort(redShirtSpeeds, Collections.reverseOrder());
        }

        for (int i = 0; i < blueShirtSpeeds.length; i++) {
            totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }

        return totalSpeed;
    }

    public static void main(String[] args) {
        Integer[] redShirtSpeeds = {5, 5, 3, 9, 2};
        Integer[] blueShirtSpeeds = {3, 6, 7, 2, 1};
        System.out.println("The Fastest Speed for tandem bike is: " + findTandemBicycleSpeed(redShirtSpeeds, blueShirtSpeeds, true));
        System.out.println("The Slowest Speed for tandem bike is: " + findTandemBicycleSpeed(redShirtSpeeds, blueShirtSpeeds, false));

    }
}
