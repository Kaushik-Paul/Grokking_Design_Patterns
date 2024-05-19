package com.example.tracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutation {

    // O(n) time and O(1) space (since string contains only lower alphabet characters)
    private static boolean permutePalindrome(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();
        int oddFrequencyCount = 0;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (frequencies.containsKey(ch)) {
                frequencies.put(ch, frequencies.get(ch) + 1);
            } else {
                frequencies.put(ch, 1);
            }
        }

        for (char ch : frequencies.keySet()) {
            if (frequencies.get(ch) % 2 != 0) {
                oddFrequencyCount++;
            }
        }

        return oddFrequencyCount <= 1;
    }

    public static void main(String[] args) {
        List< String > strArray = Arrays.asList("baefeab", "abc", "xzz", "jjadd", "kllk");
        for (int i = 0; i < strArray.size(); i++) {
            System.out.println(i + 1 + ".\tInput string: " + strArray.get(i));
            boolean result = permutePalindrome(strArray.get(i));
            if (result) System.out.println("\n\tInput string has permutations that are palindromes");
            else System.out.println("\n\tInput string does not have a permutation that's a palindrome");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
