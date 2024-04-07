package com.example.topkelements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    private PriorityQueue<Integer> topKHeap;
    private int k;


    public KthLargestElement(int k, int[] nums) {
        this.k = k;
        topKHeap = new PriorityQueue<>();

        for (int element : nums) {
            add(element);
        }
    }

    private int add(int num) {
        if (topKHeap.size() < k) {
            topKHeap.offer(num);
        } else if (topKHeap.peek() < num) {
            topKHeap.poll();
            topKHeap.offer(num);
        }

        return topKHeap.peek();
    }

    // O(n log k) time and O(k) space
    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 10};
        int[] temp = {3, 6, 9, 10};
        System.out.print("Initial stream: ");
        printArray(nums);
        System.out.println("\nk: " + 3);
        KthLargestElement kLargest = new KthLargestElement(3, nums);
        int[] val = {4, 7, 10, 8, 15};
        for (int i = 0; i < val.length; i++) {
            System.out.println("\tAdding a new number " + val[i] + " to the stream");
            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = val[i];
            System.out.print("\tNumber stream: ");
            printArray(temp);
            System.out.println("\n\tKth largest element in the stream: " + kLargest.add(val[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
