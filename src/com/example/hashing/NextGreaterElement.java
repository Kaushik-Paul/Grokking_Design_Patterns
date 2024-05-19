package com.example.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    // O(n) time and O(n) space
    private static int[] nextGreaterElement(int[] num1, int[] num2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : num2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] result = new int[num1.length];

        for (int i = 0; i < num1.length; i++) {
            result[i] = map.get(num1[i]);
        }

        return result;
    }


    // Driver code
    public static void main(String[] args) {
        int[][] A = {
                {2, 4},
                {3, 2, 5},
                {14, 45, 52},
                {1, 3, 2},
                {4, 2},
                {0}
        };
        int[][] B = {
                {1, 2, 3, 4},
                {2, 3, 5, 1},
                {52, 14, 45, 65},
                {1, 3, 2, 4, 5},
                {1, 2, 4, 3},
                {0}
        };

        int x = 1;
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tNums 1 = " + Arrays.toString(A[i]));
            System.out.println("\tNums 2 = " + Arrays.toString(B[i]));
            System.out.print("");
            System.out.println("\tThe Next Greater Element Array = " + Arrays.toString(nextGreaterElement(A[i], B[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
