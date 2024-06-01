package com.example.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    // O(k^n * n) time and O(k * n) space
    private List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        Map<Character, String[]> digitsMapping = new HashMap<>();
        digitsMapping.put('1', new String[]{""});
        digitsMapping.put('2', new String[]{"a", "b", "c"});
        digitsMapping.put('3', new String[]{"d", "e", "f"});
        digitsMapping.put('4', new String[]{"g", "h", "i"});
        digitsMapping.put('5', new String[]{"j", "k", "l"});
        digitsMapping.put('6', new String[]{"m", "n", "o"});
        digitsMapping.put('7', new String[]{"p", "q", "r", "s"});
        digitsMapping.put('8', new String[]{"t", "u", "v"});
        digitsMapping.put('9', new String[]{"w", "x", "y", "z"});
        backtrack(0, new StringBuilder(), digits, digitsMapping, combinations);

        return combinations;
    }

    private void backtrack(int currentIndex, StringBuilder stringBuilder, String digits, Map<Character, String[]> digitsMapping, List<String> combinations) {
        if (digits.length() == stringBuilder.length()) {
            combinations.add(stringBuilder.toString());
            return;
        }

        char digit = digits.charAt(currentIndex);
        String[] letterCombinations = digitsMapping.get(digit);

        for (String letter : letterCombinations) {
            stringBuilder.append(letter);
            backtrack(currentIndex + 1, stringBuilder, digits, digitsMapping, combinations);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args){
        LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
        String[] digitsArray = {"23", "73", "426", "78", "925", "2345"};
        for(int i = 0; i < digitsArray.length; i++){
            System.out.println((i + 1)+ ".\tAll letter combinations for  "+digitsArray[i]+ ": "+ sol.letterCombinations(digitsArray[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
