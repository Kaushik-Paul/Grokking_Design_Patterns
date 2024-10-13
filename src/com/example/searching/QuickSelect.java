package com.example.searching;

public class QuickSelect {
    private static int quickSelect(int[] array, int k) {
        return quickSelectHelper(array, 0, array.length - 1, k - 1);
    }

    // O(n) time and O(1) space
    private static int quickSelectHelper(int[] array, int startIdx, int endIdx, int position) {
        while (startIdx <= endIdx) {
            int pivotIdx = startIdx;
            int leftIdx = startIdx + 1;
            int rightIdx = endIdx;

            while (leftIdx <= rightIdx) {
                if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                    swap(array, leftIdx, rightIdx);
                }

                if (array[leftIdx] <= array[pivotIdx]) {
                    leftIdx++;
                }

                if (array[rightIdx] >= array[pivotIdx]) {
                    rightIdx--;
                }
            }

            swap(array, pivotIdx, rightIdx);

            if (rightIdx > position) {
                endIdx = rightIdx - 1;
            } else if (rightIdx < position) {
                startIdx = rightIdx + 1;
            } else {
                return array[rightIdx];
            }
        }

        return -1;
    }

    private static void swap(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 7, 6, 3};
        int pos = 3;

        int num = quickSelect(array, pos);
        System.out.println("The " + pos + "th smallest element in the array is : " + num);
    }
}
