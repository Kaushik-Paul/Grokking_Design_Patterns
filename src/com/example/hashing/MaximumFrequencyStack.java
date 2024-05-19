package com.example.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

    Map<Integer, Integer> frequency;
    Map<Integer, Stack<Integer>> group;
    int maxFrequency;

    // Use constructor to initialize the FreqStack object
    public MaximumFrequencyStack() {
        this.frequency = new HashMap < > ();
        this.group = new HashMap< >();
        this.maxFrequency = 0;
    }

    // O(1) time and O(n) space
    public void push(int value) {
        int freq = frequency.getOrDefault(value, 0) + 1;
        this.frequency.put(value, freq);

        if (freq > this.maxFrequency) {
            this.maxFrequency = freq;
        }

        this.group.computeIfAbsent(freq, z -> new Stack<>()).push(value);
    }

    public int pop() {
        int show;

        if (this.maxFrequency > 0) {
            show = this.group.get(maxFrequency).pop();
            this.frequency.put(show, this.frequency.get(show) - 1);

            if (this.group.get(maxFrequency).isEmpty()) {
                maxFrequency--;
            }
        } else {
            return -1;
        }

        return show;
    }

    public static void main(String[] args) {
        int[] inputs = {5, 7, 7, 7, 4, 5, 3};
        MaximumFrequencyStack obj = new MaximumFrequencyStack();
        for (int input : inputs) {
            obj.push(input);
        }

        System.out.println("\tInput Stack: " + Arrays.toString(inputs) + "\n");

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tPopping out the most frequent value...");
            System.out.println("\tValue removed from stack is: " + obj.pop());
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
