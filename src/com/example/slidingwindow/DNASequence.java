package com.example.slidingwindow;

import java.util.*;

public class DNASequence {

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) +
                    "\n\n\tRepeated sequences: " + findRepeatedSequences(inputsString.get(i), inputsK.get(i)));
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

    // O(n) time and O(n) space
    private static Set<String> findRepeatedSequences(String string, int k) {
        int length = string.length();

        if (length < k) {
            return new HashSet<>();
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        int a = 4;
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = map.get(string.charAt(i));
        }

        int hashValue = 0;
        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i < length - k + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers[j] * (int) Math.pow(a, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers[i - 1] * (int) Math.pow(a, k - 1)) * a) + numbers[i + k - 1];
            }

            if (hashSet.contains(hashValue)) {
                output.add(string.substring(i, i + k));
            } else {
                hashSet.add(hashValue);
            }
        }

        return output;
    }
}
