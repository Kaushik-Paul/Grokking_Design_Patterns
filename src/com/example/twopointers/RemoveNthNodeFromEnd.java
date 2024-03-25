package com.example.twopointers;

public class RemoveNthNodeFromEnd {

    private static Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public RemoveNthNodeFromEnd() {
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

    // O(n) time and O(1) space
    public void removeNthLastNode(int num) {
        Node slowNode = head;
        Node fastNode = head;

        int n = num;
        while (n != 0) {
            fastNode = fastNode.next;
            n--;
        }

        if (fastNode == null) {
            assert head != null;
            head = head.next;
            return;
        }

        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        slowNode.next = slowNode.next.next;
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

    public static void main(String[] args) {
        int[][] inputs = {
                {23, 89, 10, 5, 67, 39, 70,28},
                {34, 53, 6, 95, 38, 28, 17, 63, 16, 76},
                {288, 224, 275, 390, 4, 383, 330, 60, 193},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12}
        };

        int[] n = {4, 1, 6, 9, 11};

        for (int i = 0; i < inputs.length; i++) {
            RemoveNthNodeFromEnd linkedList = new RemoveNthNodeFromEnd();
            linkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            linkedList.printListWithForwardArrow();
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            linkedList.removeNthLastNode(n[i]);
            linkedList.printListWithForwardArrow();
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
