package com.example.strings;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    // O(m + n) time and O(c) space
    private static boolean isGeneratingDocumentPossible(String characters, String document) {
        Map<Character, Integer> characterFrequency = new HashMap<>();

        for (char ch : characters.toCharArray()) {
            characterFrequency.put(ch, characterFrequency.getOrDefault(ch, 0) + 1);
        }

        for (char ch : document.toCharArray()) {
            if (characterFrequency.getOrDefault(ch, 0) == 0) {
                return false;
            }

            characterFrequency.put(ch, characterFrequency.get(ch) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        String characters = "BSte!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the BeSt!";
        System.out.println("Is it possible to generate document: " + isGeneratingDocumentPossible(characters, document));
    }
}
