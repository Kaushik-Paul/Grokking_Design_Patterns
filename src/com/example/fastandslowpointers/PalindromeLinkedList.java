package com.example.fastandslowpointers;

import java.util.LinkedList;

public class PalindromeLinkedList {

    private static Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public PalindromeLinkedList() {
        head = null;
    }

    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    private void insertNodeAtHead(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    private void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            insertNodeAtHead(lst[i]);
        }
    }

    private void printListWithForwardArrow()
    {
        Node tempNode = head;

        while (tempNode != null) {
            System.out.print(tempNode.value); // print node value
            tempNode = tempNode.next;
            if (tempNode != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }

    private Node reverseLinkedList(Node node) {
        Node currentNode = node;
        Node previousNode = null;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

    private boolean compareTwoHalves(Node firstHalf, Node secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.value != secondHalf.value) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // O(n) time and O(1) space
    private boolean palindrome() {
        Node slowNode = head;
        Node fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        Node revertData = reverseLinkedList(slowNode);
        boolean isPalindrome = compareTwoHalves(head, revertData);
        reverseLinkedList(revertData);

        return isPalindrome;
    }

    public static void main(String[] args) {
        int[][] input={
                {2, 4, 6, 4, 2},
                {0, 3, 5, 5, 0},
                {9, 27, 4, 4, 27, 9},
                {5, 4, 7, 9, 4, 5},
                {5, 10, 15, 20, 15, 10, 5}
        };

        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            PalindromeLinkedList linkedList = new PalindromeLinkedList();
            linkedList.createLinkedList(input[i]);
            System.out.print(".\tLinked list:  ");
            linkedList.printListWithForwardArrow();
            System.out.print("\tIs it a palindrome?  ");
            boolean result = linkedList.palindrome();
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
