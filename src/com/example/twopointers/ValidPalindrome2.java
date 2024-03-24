package com.example.twopointers;

public class ValidPalindrome2 {
    // Write a function that takes a string as input and checks
    // whether it can be a valid palindrome by removing at most
    // one character from it.
    public static void main(String[] arg) {
        String[] testCase = {
                "madame",
                "dead",
                "abca",
                "tebbem",
                "eeccccbebaeeabebccceea",
                "abcdedadedecba"
        };
        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case # " + (k + 1));
            System.out.println(willBePalindrome(testCase[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(n) time and O(1) space
    private static boolean willBePalindrome(String string) {
        boolean oneChanceTaken = false;

        int startIdx = 0;
        int endIdx = string.length() - 1;

        while (startIdx < endIdx) {
            if (string.charAt(startIdx) != string.charAt(endIdx)) {
                if (oneChanceTaken) {
                    return false;
                } else {
                    if (string.charAt(startIdx + 1) == string.charAt(endIdx)) {
                        startIdx++;
                    } else {
                        endIdx --;
                    }
                    oneChanceTaken = true;
                }
            } else {
                startIdx++;
                endIdx--;
            }
        }
        return true;
    }

}
