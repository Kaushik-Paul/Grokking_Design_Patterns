package com.example.hashing;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    // O(n) time and O(n) space
    private static boolean isIsomorphic(String string1, String string2) {
        Map<Character, Character> mapStr1Str2 = new HashMap<>();
        Map<Character, Character> mapStr2Str1 = new HashMap<>();
        int i = 0, j = 0;

        while (i < string1.length()) {
            char ch1 = string1.charAt(i++);
            char ch2 = string2.charAt(j++);

            if (mapStr1Str2.containsKey(ch1) && mapStr1Str2.get(ch1) != ch2) {
                return false;
            }

            if (mapStr2Str1.containsKey(ch2) && mapStr2Str1.get(ch2) != ch1) {
                return false;
            }

            mapStr1Str2.put(ch1, ch2);
            mapStr2Str1.put(ch2, ch1);
        }

        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String[] A = {"egg", "foo", "paper", "badc", "aaeaa"};
        String[] B = {"all", "bar", "title", "baba", "uuxyy"};
        for (int i = 0; i < A.length; i++) {
            System.out.println((i + 1) + ".\tString 1 = " + A[i]);
            System.out.println("\tString 2 = " + B[i]);
            System.out.println("\n\tIsomorphic String ? " + isIsomorphic(A[i], B[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
