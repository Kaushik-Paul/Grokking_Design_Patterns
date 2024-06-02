package com.example.greedytechniques;

import java.util.Arrays;

public class BoatsToSavePeople {

    // O(n log n) time and O(1) space
    private static int rescueBoats(int[] person, int limit) {
        Arrays.sort(person);
        int left = 0;
        int right = person.length - 1;
        int numberOfBoats = 0;

        while (left <= right) {
            if (person[left] + person[right] <= limit) {
                left++;
            }
            right--;
            numberOfBoats++;
        }

        return numberOfBoats;
    }

    public static void main(String[] args) {
        int[][] people = {{1, 2}, {3, 2, 2, 1}, {3, 5, 3, 4}, {5, 5, 5, 5}, {1, 2, 3, 4}, {1, 2, 3}, {3, 4, 5}};
        int[] limit = {3, 3, 5, 5, 5, 3, 5};

        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + "\tWeights = " + Arrays.toString(people[i]));
            System.out.println("\tWeight Limit = " + limit[i]);
            System.out.println("\tThe minimum number of boats required to save people are "
                    + rescueBoats(people[i], limit[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
