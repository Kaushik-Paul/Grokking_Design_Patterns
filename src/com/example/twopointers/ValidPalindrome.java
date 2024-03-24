package com.example.twopointers;

public class ValidPalindrome {
    public static void main(String[] arg) {
        String[] testCase = {
                "RACECAR",
                "ABBA",
                "TART"
        };
        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case # " + (k + 1));
            System.out.println(isPalindrome(testCase[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static boolean isPalindrome(String string) {
        int startIdx = 0;
        int endIdx = string.length() - 1;

        while (startIdx < endIdx) {
            if (string.charAt(startIdx) != string.charAt(endIdx)) {
                return false;
            }
            startIdx++;
            endIdx--;
        }

        return true;
    }
}
