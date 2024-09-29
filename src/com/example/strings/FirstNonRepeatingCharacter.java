package com.example.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    // O(n) time and O(1) space
    private static int getFirstNonRepeatingCharacter(String string) {
        Map<Character, Integer> frequencyOfCharacters = new HashMap<>();
        for (char ch : string.toCharArray()) {
            frequencyOfCharacters.put(ch, frequencyOfCharacters.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (frequencyOfCharacters.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String string = "abcdcaf";
        System.out.println("The First Non Repeating Character is: " + getFirstNonRepeatingCharacter(string));
    }
}
