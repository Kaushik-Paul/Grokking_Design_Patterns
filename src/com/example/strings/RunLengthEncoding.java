package com.example.strings;

public class RunLengthEncoding {

    // O(n) time and O(n) space
    private static String runLengthEncoding(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int currentRunLength = 1;

        for (int i = 1; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            char previousCharacter = string.charAt(i - 1);

            if (currentCharacter != previousCharacter || currentRunLength == 9) {
                stringBuilder.append(currentRunLength);
                stringBuilder.append(previousCharacter);
                currentRunLength = 0;
            }

            currentRunLength++;
        }

        stringBuilder.append(currentRunLength);
        stringBuilder.append(string.charAt(string.length() - 1));

        return new String(stringBuilder);
    }

    public static void main(String[] args) {
        String string = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println("The Run Line Encoding for the string is: " + runLengthEncoding(string));
    }
}
