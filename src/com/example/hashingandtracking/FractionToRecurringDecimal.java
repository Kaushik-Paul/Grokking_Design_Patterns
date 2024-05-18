package com.example.hashingandtracking;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    // O(pd) time and O(pd) space where pd is the lowest denominator we can
    // get after simplifying the expression numerator/denominator
    private static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> reminderMap = new HashMap<>();

        if (numerator * denominator < 0) {
            result.append("-");
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }

        int quotient = numerator / denominator;
        int reminder = (numerator % denominator) * 10;

        result.append(quotient);

        if (reminder == 0) {
            return result.toString();
        } else {
            result.append(".");
        }

        while (reminder != 0) {
            if (reminderMap.containsKey(reminder)) {
                int beginning = reminderMap.get(reminder);
                String left = result.substring(0, beginning);
                String right = result.substring(beginning);
                result = new StringBuilder(left + "(" + right + ")");
                return result.toString();
            } else {
                reminderMap.put(reminder, result.length());
                quotient = reminder / denominator;
                reminder = (reminder % denominator) * 10;
                result.append(quotient);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] inputs = { { 0, 4 }, { 4, 2 }, { 5, 333 }, { 2, 3 }, { 47, 18 }, { 93, 7 }, { -5, 333 }, { 47, -18 },
                { -4, -2 } };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1 + ".\tInput: fraction_to_decimal(");
            for (int j = 0; j < inputs[i].length - 1; j++) {
                System.out.print(inputs[i][j]);
                System.out.print(", ");
            }
            System.out.println(inputs[i][inputs[i].length - 1] + ")");
            String result = fractionToDecimal(inputs[i][0], inputs[i][1]);
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
