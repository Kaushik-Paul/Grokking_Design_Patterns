package com.example.strings;

public class LongestPalindromicSubstring {

    // O(n^2) time and O(1) space
    private static String longestPalindromeSubstring(String string) {
        String longestSubstring = string.substring(0, 1);
        int longest = 1;
        String even, odd;

        for (int i = 1; i < string.length(); i++) {
            odd = getLongestSubstringFrom(string, i - 1, i + 1);
            even = getLongestSubstringFrom(string, i - 1, i);
            int currentLongest = Math.max(odd.length(), even.length());
            longest = Math.max(longest, currentLongest);

            if (longest > longestSubstring.length()) {
                if (longest == odd.length()) {
                    longestSubstring = odd;
                } else {
                    longestSubstring = even;
                }
            }
        }

        return longestSubstring;
    }

    private static String getLongestSubstringFrom(String string, int startIdx, int endIdx) {
        while (startIdx >= 0 && endIdx < string.length()) {
            if (string.charAt(startIdx) != string.charAt(endIdx)) {
                break;
            }

            startIdx--;
            endIdx++;
        }

        return string.substring(startIdx + 1, endIdx);
    }

    public static void main(String[] args) {
        String string = "abaxyzzyxf";
        System.out.println("The Longest Palindrome Substring of " + string + " is : " + longestPalindromeSubstring(string));

    }
}
