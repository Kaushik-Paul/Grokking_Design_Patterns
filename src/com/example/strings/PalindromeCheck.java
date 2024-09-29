package com.example.strings;

public class PalindromeCheck {

    // O(n) time and O(1) space
    private static boolean isPalindromeIteration(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left <= right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // O(n) time and O(n) space
    private static boolean isPalindromeRecursion(String string) {
        return isPalindromeRecursionHelper(string, 0);
    }

    private static boolean isPalindromeRecursionHelper(String string, int index) {
        int left = index;
        int right = string.length() - index - 1;

        if (left >= right) {
            return true;
        }

        if (string.charAt(left) != string.charAt(right)) {
            return false;
        }

        return isPalindromeRecursionHelper(string, index + 1);
    }

    public static void main(String[] args) {
        String str = "abcdcba";
        if (isPalindromeIteration(str)) {
            System.out.println("It is Palindrome (using the iteration function)");
        } else {
            System.out.println("Not a Palindrome (using the iteration function)");
        }

        if (isPalindromeRecursion(str)) {
            System.out.println("It is Palindrome (using the recursion function)");
        } else {
            System.out.println("Not a Palindrome (using the recursion function)");
        }
    }
}
