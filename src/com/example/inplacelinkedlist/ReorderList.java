package com.example.inplacelinkedlist;

import java.util.Arrays;
import java.util.List;

public class ReorderList {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ReorderList() {
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

    // O(n) time and O(1) space
    private void reorderList() {
        if (head == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node current = slow;
        Node prev = null;
        Node next = null;

        // Reverse the 2nd half
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Merge 1st half and 2nd half
        Node first = head;
        Node second = prev;

        while (second.next != null) {
            Node temp = first.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = temp;
        }
    }

    public static void main(String[] args) {
        ReorderList obj1 = new ReorderList();
        List<Integer> inputList = Arrays.asList(1, 1, 2, 2, 3, -1, 10, 12);
        obj1.createLinkedList(inputList);
        System.out.print("1.\tOrignal list: ");
        obj1.printListWithForwardArrow();
        obj1.reorderList();
        System.out.print("\tAfter folding: ");
        obj1.printListWithForwardArrow();
        System.out.println(new String(new char[100]).replace('\0', '-'));

        ReorderList obj2 = new ReorderList();
        List<Integer> inputList1 = Arrays.asList(10, 20, -22, 21, -12);
        obj2.createLinkedList(inputList1);
        System.out.print("2.\tOrignal list: ");
        obj2.printListWithForwardArrow();
        obj2.reorderList();
        System.out.print("\tAfter folding: ");
        obj2.printListWithForwardArrow();
        System.out.println(new String(new char[100]).replace('\0', '-'));

        ReorderList obj3 = new ReorderList();
        List<Integer> inputList2 = Arrays.asList(1, 1, 1);
        obj3.createLinkedList(inputList2);
        System.out.print("3.\tOrignal list: ");
        obj3.printListWithForwardArrow();
        obj3.reorderList();
        System.out.print("\tAfter folding: ");
        obj3.printListWithForwardArrow();
        System.out.println(new String(new char[100]).replace('\0', '-'));

        ReorderList obj4 = new ReorderList();
        List<Integer> inputList3 = Arrays.asList(-2, -5, -6, 0, -1, -4);
        obj4.createLinkedList(inputList3);
        System.out.print("4.\tOrignal list: ");
        obj4.printListWithForwardArrow();
        obj4.reorderList();
        System.out.print("\tAfter folding: ");
        obj4.printListWithForwardArrow();
        System.out.println(new String(new char[100]).replace('\0', '-'));

        ReorderList obj5 = new ReorderList();
        List<Integer> inputList4 = Arrays.asList(3, 1, 5, 7, -4, -2, -1, -6);
        obj5.createLinkedList(inputList4);
        System.out.print("5.\tOrignal list: ");
        obj5.printListWithForwardArrow();
        obj5.reorderList();
        System.out.print("\tAfter folding: ");
        obj5.printListWithForwardArrow();
        System.out.println(new String(new char[100]).replace('\0', '-'));
    }
}
