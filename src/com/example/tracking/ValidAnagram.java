package com.example.tracking;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // O(n) time and O(1) space
    private static boolean isAnagram(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < string1.length(); i++) {
            char ch = string1.charAt(i);
            if (frequencies.containsKey(ch)) {
                frequencies.put(ch, frequencies.get(ch) + 1);
            } else {
                frequencies.put(ch, 1);
            }
        }

        for (int i = 0; i < string2.length(); i++) {
            char ch = string2.charAt(i);

            if (frequencies.containsKey(ch)) {
                frequencies.put(ch, frequencies.get(ch) - 1);
            } else {
                return false;
            }
        }

        for (int count : frequencies.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] str1List = {"listen", "race", "elbow", "cat", "inch"};
        String[] str2List = {"silent", "cares", "below", "act", "chin"};

        for (int i = 0; i < str1List.length; i++) {
            System.out.print((i + 1) + ".");
            System.out.println("\tstr1: \"" + str1List[i] + "\"");
            System.out.println("\tstr2: \"" + str2List[i] + "\"");
            System.out.println("\t\"" + str2List[i] + "\" is an anagram of \"" + str1List[i] + "\": "
                    + isAnagram(str1List[i], str2List[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
