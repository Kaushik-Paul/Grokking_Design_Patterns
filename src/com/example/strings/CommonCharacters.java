package com.example.strings;

import java.util.*;

public class CommonCharacters {

    // O(m * n) time and O(n) space
    private static List<Character> getCommonCharacters(String[] strings) {
        List<Character> commonCharacters = new ArrayList<>();
        Map<Character, Integer> frequencyOfCharacter = new HashMap<>();

        for (String string : strings) {
            // Change string to set and then check
            string.chars()
                    .mapToObj(ch -> (char) ch)
                    .distinct()
                    .forEach(ch -> frequencyOfCharacter.put(ch, frequencyOfCharacter.getOrDefault(ch, 0) + 1));
        }

        for (char ch : frequencyOfCharacter.keySet()) {
            if (frequencyOfCharacter.get(ch) == strings.length) {
                commonCharacters.add(ch);
            }
        }

        return commonCharacters;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "bcd", "cbaccd"};

        List<Character> commonCharacters = getCommonCharacters(strings);
        System.out.println("The common characters for the string is: " + commonCharacters);
    }
}
