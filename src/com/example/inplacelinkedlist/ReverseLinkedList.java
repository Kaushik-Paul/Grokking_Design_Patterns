package com.example.inplacelinkedlist;

import java.util.LinkedList;

public class ReverseLinkedList {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ReverseLinkedList() {
        this.head = null;
    }

    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    private void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            insertNodeAtHead(lst[i]);
        }
    }

    private void insertNodeAtHead(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    private void printListWithForwardArrow() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }

    // O(n) time and O(1) space
    private void reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        head = previous;
    }

    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {3, 2, 1},
                {10},
                {1, 2}
        };

        for (int i = 0; i < input.length; i++) {
            ReverseLinkedList linkedList = new ReverseLinkedList();
            linkedList.createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            linkedList.printListWithForwardArrow();
            System.out.print("\n\tReversed linked list: ");
            linkedList.reverse();
            linkedList.printListWithForwardArrow();
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}