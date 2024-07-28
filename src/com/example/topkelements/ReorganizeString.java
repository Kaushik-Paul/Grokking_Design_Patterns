package com.example.topkelements;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    // O(n) time and O(1) space
    private static String reorganizeString(String string) {
        Map<Character, Integer> charCounter = new HashMap<>();
        for (char ch : string.toCharArray()) {
            charCounter.put(ch, charCounter.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue <Map.Entry <Character, Integer>> maxFreqChar = new PriorityQueue <Map.Entry <Character, Integer>> (
                (item1, item2) -> item2.getValue() - item1.getValue());

        maxFreqChar.addAll(charCounter.entrySet());

        Map.Entry <Character, Integer> previous = null;
        StringBuilder result = new StringBuilder(string.length());
        while (!maxFreqChar.isEmpty() || previous!=null) {

            if (previous != null && maxFreqChar.isEmpty())
                return "";

            Map.Entry <Character, Integer> currentEntry = maxFreqChar.poll();
            int count=currentEntry.getValue()-1;
            result.append(currentEntry.getKey());

            if(previous!=null){
                maxFreqChar.add(previous);
                previous=null;
            }

            if(count != 0){
                previous = new AbstractMap.SimpleEntry<>(currentEntry.getKey(), count);

            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] inputs = {
                "programming",
                "hello",
                "fofjjb",
                "abbacdde",
                "aba",
                "awesome",
                "aaab",
                "aab"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string: \"" + inputs[i] + "\"");

            String output = reorganizeString(inputs[i]);
            output = (output.isEmpty()) ? "''" : output;

            System.out.println("\tReorganized string: \"" + output + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
