package com.example.inplacelinkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseNodeInEvenLengthGroup {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ReverseNodeInEvenLengthGroup() {
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

    // O(n) time and O(1) time
    private void reverseEvenLengthGroups() {
        Node prev = head;

        Node current, reverse, currentNext, previousNext, node = null;

        int groupLen = 2;
        int numNodes = 0;

        while (prev.next != null) {

            node = prev;
            numNodes = 0;

            for (int i = 0; i < groupLen; i++) {
                if (node.next == null) {
                    break;
                }

                numNodes += 1;
                node = node.next;
            }

            // If odd number then skip the groupLen
            if (numNodes % 2 != 0) {
                prev = node;
            } else {
                reverse = node.next;
                current = prev.next;

                for (int j = 0; j < numNodes; j++) {
                    currentNext = current.next;
                    current.next = reverse;
                    reverse = current;
                    current = currentNext;
                }

                // updating the prev pointer after reversal of the even group
                previousNext = prev.next;
                prev.next = node;
                prev = previousNext;
            }

            // increment 1 by one and move to the next group
            groupLen += 1;

        }
    }

    public static void main(String[] args) {

        // Declaring and creating a linked list
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4);
        List<Integer> inputList1 = Arrays.asList(10, 11, 12, 13, 14);
        List<Integer> inputList2 = List.of(15);
        List<Integer> inputList3 = Arrays.asList(16, 17);

        ReverseNodeInEvenLengthGroup inputLinkList1 = new ReverseNodeInEvenLengthGroup();
        inputLinkList1.createLinkedList(inputList);

        ReverseNodeInEvenLengthGroup inputLinkList2 = new ReverseNodeInEvenLengthGroup();
        inputLinkList2.createLinkedList(inputList1);

        ReverseNodeInEvenLengthGroup inputLinkList3 = new ReverseNodeInEvenLengthGroup();
        inputLinkList3.createLinkedList(inputList2);

        ReverseNodeInEvenLengthGroup inputLinkList4 = new ReverseNodeInEvenLengthGroup();
        inputLinkList4.createLinkedList(inputList3);

        List<ReverseNodeInEvenLengthGroup> list = new LinkedList<>();
        list.add(inputLinkList1);
        list.add(inputLinkList2);
        list.add(inputLinkList3);
        list.add(inputLinkList4);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ".\tIf we reverse the even length groups of the linked list:");
            list.get(i).printListWithForwardArrow();
            System.out.println("\n\n\twe will get: \t");
            list.get(i).reverseEvenLengthGroups();
            list.get(i).printListWithForwardArrow();
            System.out.print("\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
