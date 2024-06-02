package com.example.subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    // O(4^n) time and O(n) space
    private static List<String> generateCombinations(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(n, 0, 0, stringBuilder, results);
        return results;
    }

    private static void backtrack(int n, int leftCount, int rightCount, StringBuilder stringBuilder, List<String> results) {
        if (leftCount >= n && rightCount >= n) {
            results.add(stringBuilder.toString());
            return;
        }

        if (leftCount < n) {
            stringBuilder.append("(");
            backtrack(n, leftCount + 1, rightCount, stringBuilder, results);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if (rightCount < leftCount) {
            stringBuilder.append(")");
            backtrack(n, leftCount, rightCount + 1, stringBuilder, results);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> result;
        int[] n = {1, 2, 3, 4, 5};
        for (int i = 0; i < n.length; i++) {

            System.out.println (i+1 + ".\tn = "+ n[i]);
            System.out.println ("\tAll combinations of valid balanced parentheses:");
            result = generateCombinations(n[i]);
            for (String string : result) {
                System.out.println("\t\t" + string);
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
