package com.example.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // O(n * n!) time and O(n) space
    private static List<String> permuteWord(String word) {
        List<String> results = new ArrayList<>();
        permuteStringRec(word, 0, results);
        return results;
    }

    private static void permuteStringRec(String word, int currentIdx, List<String> results) {
        if (currentIdx == word.length() - 1) {
            results.add(word);
            return;
        }

        for (int index = currentIdx; index < word.length(); index++) {
            String swappedString = swapCharacter(word, currentIdx, index);
            permuteStringRec(swappedString, currentIdx + 1, results);
        }
    }

    private static String swapCharacter(String word, int index1, int index2) {
        char[] charArray = word.toCharArray();
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
        return new String(charArray);
    }

    public static void main(String[] args) {
        String[] inputWord = {"ab", "bad", "abcd"};
        for (int index = 0; index < inputWord.length; index++) {
            List<String> permutedWords = permuteWord(inputWord[index]);
            System.out.println(index + 1 + ".\t Input string: '" + inputWord[index] + "'");
            System.out.println("\t All possible permutations are: " + permutedWords);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
