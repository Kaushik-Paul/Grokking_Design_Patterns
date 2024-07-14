package com.example.bitwisemanipulation;

public class ComplementOfBase10 {

    // O(n) time and O(1) space
    private static int findBitwiseComplement(int num) {
        if (num == 0) {
            return 1;
        }

        int numLength = (int) (double) (int) (Math.log(num) / Math.log(2)) + 1;
        int bit1Set = (1 << numLength);

        return num ^ bit1Set;
    }

    public static void main(String[] args) {
        int[] decimalValues = {42, 233, 100, 999999, 54};

        for (int i = 0; i < decimalValues.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tInput: " + decimalValues[i]);
            System.out.print("\n\tBitwise complement of " + decimalValues[i] + " is: ");
            System.out.println(findBitwiseComplement(decimalValues[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
