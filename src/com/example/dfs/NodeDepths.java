package com.example.dfs;

public class NodeDepths extends BinarySearchTree {
    private Node root;

    private int nodeDepth(Node root) {
        return nodeDepthHelper(root, 0);
    }

    // O(n) time and O(h) space
    private int nodeDepthHelper(Node root, int currentDepth) {
        if (root == null) {
            return 0;
        }

        return currentDepth + nodeDepthHelper(root.left, currentDepth + 1) +
                nodeDepthHelper(root.right, currentDepth + 1);
    }

    public static void main(String[] args) {
        NodeDepths tree = new NodeDepths();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        System.out.println("The tree is ");
        tree.traversal(tree.root);
        System.out.println();
        int depth = tree.nodeDepth(tree.root);
        System.out.println("The total depth of the binary tree is: " + depth);
    }
}
