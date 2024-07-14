package com.example.bitwisemanipulation;

public class FindTheDifference {

    // O(n) time and O(1) space
    private static int extraCharacterIndex(String string1, String string2) {
        int result = 0;
        int strLength1 = string1.length();
        int strLength2 = string2.length();

        for (int i = 0; i < strLength1; i++) {
            result ^= string1.charAt(i);
        }

        for (int i = 0; i < strLength2; i++) {
            result ^= string2.charAt(i);
        }

        if (strLength1 >= strLength2) {
            return string1.indexOf((char) result);
        } else {
            return string2.indexOf((char) result);
        }
    }

    public static void main(String[] args) {
        String[] string1 = {
                "wxyz",
                "cbda",
                "jlkmn",
                "courae",
                "hello"
        };
        String[] string2 = {
                "zwxgy",
                "abc",
                "klmn",
                "couearg",
                "helo"
        };
        for (int i = 0; i < string1.length; i++) {
            System.out.println(i + 1 + ".\tString1 = " + string1[i] + " \n\tString2 = " + string2[i]);
            System.out.println("\n\tThe extra character is at index: "  + extraCharacterIndex(string1[i], string2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
