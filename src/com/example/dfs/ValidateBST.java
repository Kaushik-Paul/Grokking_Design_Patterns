package com.example.dfs;

public class ValidateBST extends BinarySearchTree {

    private boolean validateBst(Node root) {
        return validateBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // minValue <= Node.value < maxValue
    // O(n) time and O(d) space
    private boolean validateBstHelper(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.value < minValue || root.value >= maxValue) {
            return false;
        }

        return validateBstHelper(root.left, minValue, root.value) && validateBstHelper(root.right, root.value, maxValue);
    }

    public static void main(String[] args) {
        ValidateBST bst = new ValidateBST();
        int[] bstValues = new int[]{10, 5, 15, 2, 5, 1, 12, 13, 22, 14, 13};
        Node root = bst.convertArrayToBst(bstValues);
        bst.traversal(root);

        boolean isValidBst = bst.validateBst(root);
        System.out.println("The BST is valid ?: " + isValidBst);
    }
}
