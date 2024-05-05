package com.example.dfs;

public class InvertBinaryTree extends BinarySearchTree {

    private void invertTree(Node root) {
        root = invertTreeHelper(root);
    }

    // O(n) time and O(1) space
    private Node invertTreeHelper(Node node) {
        if (node == null) {
            return null;
        }

        swapNode(node);
        invertTreeHelper(node.left);
        invertTreeHelper(node.right);
        return node;
    }

    private void swapNode(Node node) {
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        int[] array1 = new int[]{100, 50, 200, 25, 75, 125, 350};
        Node root1 = invertBinaryTree.convertArrayToBst(array1);

        System.out.println("1.\tBinary Tree");
        invertBinaryTree.traversal(root1);

        System.out.println("\n\tMirrored binary tree: ");
        invertBinaryTree.invertTree(root1);
        invertBinaryTree.traversal(root1);

        System.out.println(new String(new char[100]).replace('\0', '-'));

        int[] array2 = new int[]{100, 50, 200, 25, 110, 125, 350};
        Node root2 = invertBinaryTree.convertArrayToBst(array2);

        System.out.println("2.\tBinary Tree");
        invertBinaryTree.traversal(root2);

        System.out.println("\n\tMirrored binary tree: ");
        invertBinaryTree.invertTree(root2);
        invertBinaryTree.traversal(root2);

        System.out.println(new String(new char[100]).replace('\0', '-'));

        int[] array3 = new int[]{100, 50, 200, 25, 75, 90, 350};
        Node root3 = invertBinaryTree.convertArrayToBst(array3);

        System.out.println("3.\tBinary Tree");
        invertBinaryTree.traversal(root3);

        System.out.println("\n\tMirrored binary tree: ");
        invertBinaryTree.invertTree(root3);
        invertBinaryTree.traversal(root3);

        System.out.println(new String(new char[100]).replace('\0', '-'));

        int[] array4 = new int[]{100, 200, 300, 400, 500};
        Node root4 = invertBinaryTree.convertArrayToBst(array4);

        System.out.println("4.\tBinary Tree");
        invertBinaryTree.traversal(root4);

        System.out.println("\n\tMirrored binary tree: ");
        invertBinaryTree.invertTree(root4);
        invertBinaryTree.traversal(root4);

        System.out.println(new String(new char[100]).replace('\0', '-'));

        int[] array5 = new int[]{1, 2, 3, 4, -1, -1, 5};
        Node root5 = invertBinaryTree.convertArrayToBst(array5);

        System.out.println("5.\tBinary Tree");
        invertBinaryTree.traversal(root5);

        System.out.println("\n\tMirrored binary tree: ");
        invertBinaryTree.invertTree(root5);
        invertBinaryTree.traversal(root5);

        System.out.println(new String(new char[100]).replace('\0', '-'));
    }
}
