package com.example.dfs;

public class DiameterOfBinaryTree extends BinarySearchTree {
    int diameter;

    public DiameterOfBinaryTree() {
        this.diameter = 0;
    }

    // O(n) time and O(n) space
    private int diameterOfBinaryTree(Node root) {
        this.diameter = 0;
        return diameterOfBinaryTreeHelper(root);
    }

    private int diameterOfBinaryTreeHelper(Node node) {
        if (node == null) {
            return -1;
        }

        int left = 1 + diameterOfBinaryTreeHelper(node.left);
        int right = 1 + diameterOfBinaryTreeHelper(node.right);
        this.diameter = Math.max(this.diameter, left + right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

        int[] array1 = new int[]{2, 1, 4, 3, 5, 6, 7, 8, 9, 10, 11};
        Node root1 = diameterOfBinaryTree.convertArrayToBst(array1);

        System.out.println("1.\tBinary Tree");
        diameterOfBinaryTree.traversal(root1);

        System.out.println("\n\tDiameter of binary tree: " + diameterOfBinaryTree.diameterOfBinaryTree(root1));

        System.out.println(new String(new char[100]).replace('\0', '-'));

        int[] array2 = new int[]{100, 50, 200, 25, 110, 125, 350};
        Node root2 = diameterOfBinaryTree.convertArrayToBst(array2);

        System.out.println("2.\tBinary Tree");
        diameterOfBinaryTree.traversal(root2);

        System.out.println("\n\tDiameter of binary tree: " + diameterOfBinaryTree.diameterOfBinaryTree(root2));

        System.out.println(new String(new char[100]).replace('\0', '-'));

        int[] array3 = new int[]{100, 50, 200, 25, 75, 90, 350};
        Node root3 = diameterOfBinaryTree.convertArrayToBst(array3);

        System.out.println("3.\tBinary Tree");
        diameterOfBinaryTree.traversal(root3);

        System.out.println("\n\tDiameter of binary tree: " + diameterOfBinaryTree.diameterOfBinaryTree(root3));

        System.out.println(new String(new char[100]).replace('\0', '-'));

        int[] array4 = new int[]{100, 200, 300, 400, 500};
        Node root4 = diameterOfBinaryTree.convertArrayToBst(array4);

        System.out.println("4.\tBinary Tree");
        diameterOfBinaryTree.traversal(root4);

        System.out.println("\n\tDiameter of binary tree: " + diameterOfBinaryTree.diameterOfBinaryTree(root4));

        System.out.println(new String(new char[100]).replace('\0', '-'));

        int[] array5 = new int[]{1, 2, 3, 4, -1, -1, 5};
        Node root5 = diameterOfBinaryTree.convertArrayToBst(array5);

        System.out.println("5.\tBinary Tree");
        diameterOfBinaryTree.traversal(root5);

        System.out.println("\n\tDiameter of binary tree: " + diameterOfBinaryTree.diameterOfBinaryTree(root5));

        System.out.println(new String(new char[100]).replace('\0', '-'));
    }

}
