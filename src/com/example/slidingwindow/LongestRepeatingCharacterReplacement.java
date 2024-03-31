package com.example.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("aabccbb", "abbcb", "abccde", "abbcab", "bbbbbbbbb");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }

    // O(n) time and O(1) space
    private static int longestRepeatingCharacterReplacement(String string, int replacement) {
        int stringLength = string.length();
        Map<Character, Integer> characterFrequency = new HashMap<>();
        int mostFreqCharacter = 0;
        int maxSubstringLength = 0;
        int startPointer = 0;
        int endPointer = 0;

        while (endPointer < stringLength) {
            char currentCharacter = string.charAt(endPointer);

            // Update frequency map
            characterFrequency.put(currentCharacter, characterFrequency.getOrDefault(currentCharacter, 0) + 1);

            // Update most frequent character
            mostFreqCharacter = Math.max(mostFreqCharacter, characterFrequency.get(currentCharacter));

            if (endPointer - startPointer + 1 - mostFreqCharacter > replacement) {
                // Update frequency
                char startCharacter = string.charAt(startPointer);
                characterFrequency.put(startCharacter, characterFrequency.get(startCharacter) - 1);
                startPointer++;
            }

            maxSubstringLength = Math.max(maxSubstringLength, endPointer - startPointer + 1);
            endPointer++;
        }

        return maxSubstringLength;
    }
}
