package com.example.dfs;

import java.util.ArrayList;
import java.util.List;

public class BranchSums extends BinarySearchTree {
    private Node root;

    private List<Integer> branchSum(Node root) {
        List<Integer> sums = new ArrayList<>();
        branchSumHelper(root, 0, sums);
        return sums;
    }

    // O(n) time and O(n) space
    private void branchSumHelper(Node root, int runningSum, List<Integer> sums) {
        if (root == null) {
            return;
        }

        runningSum = runningSum + root.value;

        if (root.left == null && root.right == null) {
            sums.add(runningSum);
        }

        branchSumHelper(root.left, runningSum, sums);
        branchSumHelper(root.right, runningSum, sums);
    }

    public static void main(String[] args) {
        BranchSums tree = new BranchSums();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        System.out.println("The tree is ");
        tree.traversal(tree.root);
        System.out.println();
        List<Integer> list = tree.branchSum(tree.root);
        System.out.println("The Branch Sum of these particular tree is : " + list);
    }
}
