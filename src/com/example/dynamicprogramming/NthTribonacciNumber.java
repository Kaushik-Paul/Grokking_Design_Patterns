package com.example.dynamicprogramming;

public class NthTribonacciNumber {

    // O(n) time and O(1) space
    private static int findTribonacci(int input) {
        if (input < 3) {
            return input;
        }

        int firstNumber = 0, secondNumber = 1, thirdNumber = 1;

        for (int i = 3; i <= input; i++) {
            int temp = firstNumber + secondNumber + thirdNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            thirdNumber = temp;
        }

        return thirdNumber;
    }

    public static void main(String[] args) {
        int[] inputList = {4, 5, 25};
        int index = 0;
        for (int input : inputList) {
            System.out.println((++index)+ ". The "+ input+ "th Tribonacci number is:  "
                    + findTribonacci(input));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
