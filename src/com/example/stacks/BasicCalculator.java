
package com.example.stacks;

import java.util.Stack;

public class BasicCalculator {

    // O(n) time and O(n) time
    private static int calculator(String string) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int signValue = 1;
        int number = 0;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + Character.getNumericValue(ch);
            } else if (ch == '+' || ch == '-') {
                result += number * signValue;
                if (ch == '+') {
                    signValue = 1;
                } else {
                    signValue = -1;
                }
                number = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(signValue);
                result = 0;
                signValue = 1;
                number = 0;
            } else if (ch == ')') {
                result += number * signValue;

                int signValuePop = stack.pop();
                result *= signValuePop;

                int secondValue = stack.pop();
                result += secondValue;
                number = 0;
            }
        }

        return result + number * signValue;
    }

    public static void main(String[] args) {
        String[] input = {
                "4 + (52 - 12) + 99",
                "(31 + 7) - (5 - 2)",
                "(12 - 9 + 4) + (7 - 5)",
                "8 - 5 + (19 - 11) + 6 + (10 + 3)",
                "56 - 44 - (27 - 17 - 1) + 7"
        };
        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + "." + "\tGiven Expression: " + input[i]);
            System.out.println("\tThe result is:  " + calculator(input[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
