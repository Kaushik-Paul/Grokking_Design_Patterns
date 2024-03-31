package com.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        String[] inputs = {
                "abcabcbb",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };
        for (int i = 0; i < inputs.length; i++) {
            int str = findLongestSubstring(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring: " + str);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(n) time and O(1) space
    private static int findLongestSubstring(String string) {
        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        int stringLength = string.length();
        int longestSubstring = 0;
        int startPointer = 0;
        int endPointer = 0;

        while (endPointer < stringLength) {
            char currentCharacter = string.charAt(endPointer);

            if (lastSeenIndex.containsKey(currentCharacter)) {
                // Check if its within current window
                if (lastSeenIndex.get(currentCharacter) >= startPointer) {
                    longestSubstring = Math.max(longestSubstring, endPointer - startPointer);

                    // Move the start pointer to the last occurred index + 1
                    startPointer = lastSeenIndex.get(currentCharacter) + 1;
                }

                // Update the last occurred index
                lastSeenIndex.replace(currentCharacter, endPointer);

            } else {
                lastSeenIndex.put(currentCharacter, endPointer);
            }

            endPointer++;
        }

        // For last index
        longestSubstring = Math.max(longestSubstring, endPointer - startPointer);

        return longestSubstring;
    }
}
