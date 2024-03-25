package com.example.fastandslowpointers;

public class HappyNumber {
    public static void main(String[] args) {
        int[] a = {1, 5, 19, 25, 7};
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ".\tInput Number: " + a[i]);
            String output = isHappyNumber(a[i]) ? "True" : "False";

            System.out.println("\n\tIs it a happy number? " + output);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(log n) time and O(1) space
    private static boolean isHappyNumber(int input) {
        int slowPointer = input;
        int fastPointer = sumOfDigits(input);

        while (fastPointer != 1 && slowPointer != fastPointer) {
            slowPointer = sumOfDigits(slowPointer);
            fastPointer = sumOfDigits(sumOfDigits(fastPointer));
        }

        return fastPointer == 1;
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int temp = num % 10;
            num = num / 10;

            sum = sum + (temp * temp);
        }

        return sum;
    }
}
