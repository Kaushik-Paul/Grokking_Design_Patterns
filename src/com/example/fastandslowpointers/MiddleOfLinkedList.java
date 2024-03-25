package com.example.fastandslowpointers;

import java.util.LinkedList;

public class MiddleOfLinkedList {

    private static Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public MiddleOfLinkedList() {
        head = null;
    }

    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(int newValue) {
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
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            insertNodeAtHead(lst[i]);
        }
    }

    public void printListWithForwardArrow() {
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

    // O(n) time and O(1) space
    private int middleNodeValue() {
        Node slowNode = head;
        Node fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode.value;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 2, 1}, {10}, {1, 2}};

        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            MiddleOfLinkedList linkedList = new MiddleOfLinkedList();
            linkedList.createLinkedList(input[i]);
            System.out.print(".\tInput linked list:  ");
            linkedList.printListWithForwardArrow();
            System.out.print("\tMiddle of the linked list is:  " );
            System.out.println(linkedList.middleNodeValue());
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
