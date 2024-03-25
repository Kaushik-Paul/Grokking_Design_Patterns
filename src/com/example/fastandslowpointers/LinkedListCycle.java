package com.example.fastandslowpointers;

import java.util.LinkedList;

import static java.lang.reflect.Array.getLength;

public class LinkedListCycle {

    private static Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedListCycle() {
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

    public void printListWithForwardArrow()
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

    public void printListWithForwardArrowLoop()
    {
        Node tempNode = head;

        while (tempNode != null) {
            System.out.print(tempNode.value); // print node value
            tempNode = tempNode.next;
            if (tempNode != null) {
                System.out.print(" → ");
            }
        }
    }

    private void addCycleToLinkedList(int num) {
        int length = getLength();
        Node lastNode = getNode(length - 1);
        lastNode.next = getNode(num);
    }

    private Node getNode(int position) {
        Node tempNode = head;

        while (position != 0) {
            tempNode = tempNode.next;
            position--;
        }

        return tempNode;
    }

    private int getLength() {
        int length = 0;
        Node tempNode = head;

        while (tempNode != null) {
            tempNode = tempNode.next;
            length++;
        }

        return length;
    }

    // O(n) time and O(1) space
    private static boolean detectCycle() {
        Node slowNode = head;
        Node fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (slowNode == fastNode) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] input = { { 2, 4, 6, 8, 10, 12 }, { 1, 3, 5, 7, 9, 11 },
                { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 } };
        int[] pos = { 0, -1, 1, -1, 2 };
        for (int i = 0; i < input.length; i++) {
            LinkedListCycle linkedList = new LinkedListCycle();
            linkedList.createLinkedList(input[i]);
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                linkedList.printListWithForwardArrow();
            } else {
                linkedList.printListWithForwardArrowLoop();
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                linkedList.addCycleToLinkedList(pos[i]);
            }
            System.out.println("\n\tDetected Cycle =  " + detectCycle());
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
