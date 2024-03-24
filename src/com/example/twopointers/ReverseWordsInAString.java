package com.example.twopointers;

import java.util.Arrays;
import java.util.List;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        List<String> stringsToReverse = Arrays.asList(
                "Hello World",
                "a   string   with   multiple   spaces",
                "Case Sensitive Test 1234",
                "a 1 b 2 c 3 d 4 e 5",
                "     trailing spaces",
                "case test interesting an is this"
        );

        for (int i = 0; i < stringsToReverse.size(); i++) {
            System.out.println((i + 1) + ".\tOriginal string: '" + stringsToReverse.get(i) + "'");
            System.out.println("\tReversed string: '" + reverseWords(stringsToReverse.get(i)) + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(n) time and O(n) space
    private static String reverseWords(String sentence) {
        // Trim the sentence
        sentence = sentence.replaceAll("\\s{2,}", " ").trim();

        char[] charArray = sentence.toCharArray();

        // Reverse the sentence
        strRev(charArray, 0, charArray.length - 1);

        for (int startIdx = 0, endIdx = 0; endIdx <= charArray.length; endIdx++) {
            if (endIdx == charArray.length || charArray[endIdx] == ' ') {
                strRev(charArray, startIdx, endIdx - 1);
                startIdx = endIdx + 1;
            }
        }

        return new String(charArray);
    }

    // A function that reverses characters from startRev to endRev in place
    private static void strRev(char[] word, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = word[startRev];
            word[startRev] = word[endRev];
            word[endRev] = temp;
            startRev++;
            endRev--;
        }
    }
}
