package com.example.strings;

import java.util.*;

public class Semordnilap {

    // O(m * n) time and O(m * n) space
    private static List<String[]> getListPairs(String[] strings) {
        List<String[]> listPairs = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(List.of(strings));

        for (String string : strings) {
            StringBuilder stringBuilder = new StringBuilder(string);
            String reverseString = stringBuilder.reverse().toString();
            if (wordSet.contains(reverseString) && !string.equals(reverseString)) {
                listPairs.add(new String[]{string, reverseString});
                wordSet.remove(string);
                wordSet.remove(reverseString);
            }
        }

        return listPairs;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"diaper", "abc", "test", "cba", "repaid"};
        List<String[]> pairList = getListPairs(strings);
        System.out.print("The List Pairs for the string is: ");
        pairList.forEach(string -> System.out.print(Arrays.toString(string) + ", "));
    }
}
