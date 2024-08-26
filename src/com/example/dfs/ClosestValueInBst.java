package com.example.dfs;

public class ClosestValueInBst extends BinarySearchTree {

    private int closestValueInBst(Node root, int target) {
        return closestValueInBstHelper(root, target, Integer.MAX_VALUE);
    }

    // O(log n) time and O(n) space
    private int closestValueInBstHelper(Node root, int target, int currentClosest) {
        if (root == null) {
            return currentClosest;
        }

        if (Math.abs(target - currentClosest) > Math.abs(target - root.value)) {
            currentClosest = root.value;
        }

        if (target < root.value) {
            return closestValueInBstHelper(root.left, target, currentClosest);
        } else if (target > root.value) {
            return closestValueInBstHelper(root.right, target, currentClosest);
        } else {
            return currentClosest;
        }
    }

    public static void main(String[] args) {
        ClosestValueInBst closestValueInBst = new ClosestValueInBst();
        int[] array1 = new int[]{10, 5, 15, 2, 5, 13, 22, 1, 14};
        int target1 = 12;
        Node root1 = closestValueInBst.convertArrayToBst(array1);

        System.out.println("1.\tBinary Tree");
        closestValueInBst.traversal(root1);

        int value = closestValueInBst.closestValueInBst(root1, target1);
        System.out.println("Closest value to binary search tree is : " + value);

        System.out.println(new String(new char[100]).replace('\0', '-'));
    }
}
