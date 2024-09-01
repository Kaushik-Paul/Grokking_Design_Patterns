package com.example.greedytechniques;

import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {

    // O(n log n) time and O(1) space
    private static boolean isClassPhotoPossible(Integer[] redShirtHeights, Integer[] blueShirtHeights) {
        Arrays.sort(redShirtHeights, Collections.reverseOrder());
        Arrays.sort(blueShirtHeights, Collections.reverseOrder());

        boolean blueShirtFirstRow = redShirtHeights[0] > blueShirtHeights[0];

        for (int i = 0; i < redShirtHeights.length; i++) {
            int redShirtHeight = redShirtHeights[i];
            int blueShirtHeight = blueShirtHeights[i];

            if (blueShirtFirstRow) {
                if (blueShirtHeight > redShirtHeight) {
                    return false;
                }
            } else {
                if (redShirtHeight > blueShirtHeight) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] redShirtHeights = {5, 8, 1, 3, 4};
        Integer[] blueShirtHeights = {6, 9, 2, 4, 5};

        System.out.println("Is Class Photo Possible: " + isClassPhotoPossible(redShirtHeights, blueShirtHeights));
    }
}
