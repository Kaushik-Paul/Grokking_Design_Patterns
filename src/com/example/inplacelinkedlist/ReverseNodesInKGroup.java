package com.example.inplacelinkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseNodesInKGroup {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ReverseNodesInKGroup() {
        this.head = null;
    }

    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    private void createLinkedList(List<Integer> lst) {
        for (int i = lst.size() - 1; i >= 0; i--) {
            insertNodeAtHead(lst.get(i));
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

    private void reverseKGroups(int k) {
        Node ptr = new Node(0);
        ptr.next = head;

        while (ptr != null) {

            Node tracker = ptr;

            for (int i = 0; i < k; i++) {
                if (tracker == null) {
                    break;
                }
                tracker = tracker.next;
            }

            if (tracker == null) {
                break;
            }

            Node[] updatesNodes = reverseLinkedList(ptr.next, k);
            Node previous = updatesNodes[0];
            Node current = updatesNodes[1];

            Node lastNodeOfReversedGroup = ptr.next;
            lastNodeOfReversedGroup.next = current;
            ptr.next = previous;
            ptr = lastNodeOfReversedGroup;
        }

        head = head.next;
    }

    private Node[] reverseLinkedList(Node ptr, int k) {
        Node current = ptr;
        Node previous = null;
        Node next = null;
        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        return new Node[]{previous, current};
    }

    public static void main(String[] args) {
        List<List<Integer>> inputList = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                Arrays.asList(3, 4, 5, 6, 2, 8, 7, 7),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(1)
        ));

        List<Integer> k = new ArrayList<>(Arrays.asList(3, 2, 1, 7, 1));

        for (int i = 0; i < inputList.size(); ++i) {
            ReverseNodesInKGroup linkedList = new ReverseNodesInKGroup();
            linkedList.createLinkedList(inputList.get(i));

            System.out.print((i + 1) + ".\tLinked list: ");
            linkedList.printListWithForwardArrow();
            System.out.println();

            System.out.print("\n\tReversed linked list: ");
            linkedList.reverseKGroups( k.get(i));
            linkedList.printListWithForwardArrow();
            System.out.println();

            String hyphens = new String(new char[100]).replace('\0', '-');
            System.out.println(hyphens);
        }
    }
}
