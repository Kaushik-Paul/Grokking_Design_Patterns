package com.example.dfs;

import java.util.Arrays;

// This will be a common class for common binary search Tree operations
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void traversal(Node root) {
        inOrderTraversal(root);
        System.out.print("NULL");
        System.out.println();
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " -> ");
        inOrderTraversal(root.right);
    }

    public Node convertArrayToBst(int[] array) {
        Arrays.sort(array);
        this.root = convertArrayToBstHelper(array, 0, array.length - 1);
        return this.root;
    }

    public Node getHeadNode() {
        return this.root;
    }

    // O(n) time and O(n) space
    private Node convertArrayToBstHelper(int[] array, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        Node newNode = new Node(array[middle]);
        newNode.left = convertArrayToBstHelper(array, left, middle - 1);
        newNode.right = convertArrayToBstHelper(array, middle + 1, right);
        return newNode;
    }
}
