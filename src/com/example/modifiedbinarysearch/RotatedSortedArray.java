package com.example.modifiedbinarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArray {

    public static void main(String[] args) {
        List<int[]> numList = new ArrayList<>();
        numList.add(new int[]{5, 6, 7, 1, 2, 3, 4});
        numList.add(new int[]{40, 50, 60, 10, 20, 30});
        numList.add(new int[]{47, 58, 69, 72, 83, 94, 12, 24, 35});
        numList.add(new int[]{77, 82, 99, 105, 5, 13, 28, 41, 56, 63});
        numList.add(new int[]{48, 52, 57, 62, 68, 72, 5, 7, 12, 17, 21, 28, 33, 37, 41});

        List<Integer> targetList = Arrays.asList(1, 50, 12, 56, 5);

        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + Arrays.toString(numList.get(i)) +
                    "\n\tTarget " + targetList.get(i) + " found at index " +
                    binarySearchRotated(numList.get(i), targetList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    // O(log n) time and O(1) space
    public static int binarySearchRotated(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (nums[middle] == target) {
            return middle;
        }

        // If Left half is sorted 
        if (nums[left] <= nums[middle]) {
            if (nums[middle] >= target && nums[left] <= target) {
                return binarySearch(nums, left, middle - 1, target);
            } else {
                return binarySearch(nums, middle + 1, right, target);
            }
        } else {
            if (nums[middle] <= target && nums[right] >= target) {
                return binarySearch(nums, middle + 1, right, target);
            } else {
                return binarySearch(nums, left, middle - 1, target);
            } 
        } 
    }
}
