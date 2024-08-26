package com.example.dfs;

public class EvaluateExpressionTree extends BinarySearchTree {
    private Node root;

    // O(n) time and O(h) space
    private int evaluateExpressionTree(Node root) {
        if (root.value >= 0) {
            return root.value;
        }

        int leftValue = evaluateExpressionTree(root.left);
        int rightValue = evaluateExpressionTree(root.right);

        if (root.value == -1) {
            return leftValue + rightValue;
        }

        if (root.value == -2) {
            return leftValue - rightValue;
        }

        if (root.value == -3) {
            return leftValue / rightValue;
        }

        return leftValue * rightValue;
    }

    public static void main(String[] args) {
        EvaluateExpressionTree tree = new EvaluateExpressionTree();
        tree.root = new Node(-1);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(-3);
        tree.root.left.left = new Node(-4);
        tree.root.left.right = new Node(2);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(3);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(3);
        System.out.println("The tree is ");
        tree.traversal(tree.root);
        System.out.println();
        int result = tree.evaluateExpressionTree(tree.root);
        System.out.println("The evaluation of the binary tree is: " + result);
    }
}
