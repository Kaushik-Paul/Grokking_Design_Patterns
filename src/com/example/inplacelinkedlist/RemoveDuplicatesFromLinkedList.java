package com.example.inplacelinkedlist;

public class RemoveDuplicatesFromLinkedList {

    private static Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public RemoveDuplicatesFromLinkedList() {
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
    private void removeDuplicate() {
        Node currentNode = head;

        while (currentNode != null) {
            Node nextDistinctNode = currentNode.next;

            while (nextDistinctNode != null && currentNode.value == nextDistinctNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }

            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromLinkedList linkedList = new RemoveDuplicatesFromLinkedList();

        int[] input = {1, 1, 3, 4, 4, 4, 5, 6, 6};
        linkedList.createLinkedList(input);
        System.out.print("\tInput linked list:  ");
        linkedList.printListWithForwardArrow();
        System.out.print("\n\tAfter removing duplicate value from linked list: ");
        linkedList.removeDuplicate();
        linkedList.printListWithForwardArrow();
        System.out.println("\n" + new String(new char[100]).replace('\0', '-'));
    }
}
