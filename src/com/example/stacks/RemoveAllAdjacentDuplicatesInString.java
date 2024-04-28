package com.example.stacks;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    // O(n) time and O(1) space
    private static String removeDuplicates(String input) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();

        for (char ch : charArray) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }

    // Driver code
    public static void main(String[] args) {
        String[] inputs = {
                "g",
                "ggaabcdeb",
                "abbddaccaaabcd",
                "aannkwwwkkkwna",
                "abbabccblkklu"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tRemove duplicates from string: '" + inputs[i] + "'");
            String resultingString = removeDuplicates(inputs[i]);
            System.out.println("\tString after removing duplicates: " + resultingString);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
