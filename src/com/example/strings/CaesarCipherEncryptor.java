package com.example.strings;

public class CaesarCipherEncryptor {

    // O(n) time and O(n) space
    private static String caesarCipherEncryptor(String string, int key) {
        key = key % 26;
        char[] charArray = string.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char ch = getNextNumber(charArray[i], key);
            charArray[i] = ch;
        }

        return new String(charArray);
    }

    private static char getNextNumber(char ch, int key) {
        int value = ch + key;

        if (value > 122) {
            value = value - 26;
        } else if (value < 97) {
            value = value + 26;
        }

        return (char) value;
    }

    public static void main(String[] args) {
        String str = "xyz";
        System.out.println("The converted String of " + str + " is : " + caesarCipherEncryptor(str, 54));
        System.out.println("The converted String of " + str + " is : " + caesarCipherEncryptor(str, -2));
    }
}
