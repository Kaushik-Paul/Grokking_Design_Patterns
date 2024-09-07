package com.example.recursion;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {
    private Map<Integer, Integer> fibonacciMap;

    public NthFibonacci() {
        fibonacciMap = new HashMap<>();
        fibonacciMap.put(1, 0);
        fibonacciMap.put(2, 1);
    }

    // O(n) time and O(n) space
    private int getFibonacciRecursion(int target) {
        if (fibonacciMap.containsKey(target)) {
            return fibonacciMap.get(target);
        }

        int fibonacciValue = getFibonacciRecursion(target - 1) + getFibonacciRecursion(target - 2);
        fibonacciMap.put(target, fibonacciValue);
        return fibonacciValue;
    }

    // O(n) time and O(1) space
    private int getFibonacciIteration(int target) {
        int[] fibonacciArray = new int[2];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;

        int counter = 3;
        int nextFibonacci;
        while (target >= counter) {
            nextFibonacci = fibonacciArray[0] + fibonacciArray[1];
            fibonacciArray[0] = fibonacciArray[1];
            fibonacciArray[1] = nextFibonacci;
            counter++;
        }

        if (target <= 1) {
            return fibonacciArray[0];
        }

        return fibonacciArray[1];
    }

    public static void main(String[] args) {
        NthFibonacci nthFibonacci = new NthFibonacci();
        int target = 7;
        int fibonacci = nthFibonacci.getFibonacciRecursion(10); // 34
        System.out.println("The fibonacci number at " + target + " position is: " + fibonacci);
    }
}
