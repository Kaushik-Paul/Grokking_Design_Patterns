package com.example.customdatastructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private int linkedListLength;
    private Map<Integer, Integer> cacheMap;

    private class Node {
        int key;
        int value;
        Node previous;
        Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.linkedListLength = 0;
        cacheMap = new HashMap<>(this.capacity);
    }

    private void addFirstList(int key, int value) {
        Node newNode = new Node(key, value);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }

        this.linkedListLength++;
    }

    private void getValueList(int key) {
        Node temp = this.head;

        while (temp != null) {
            if (temp.key == key) {
                break;
            }
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        int value = temp.value;

        removeList(key);
        addFirstList(key, value);
    }

    private void removeLastList() {
        if (this.tail == null) {
            return;
        }
        this.tail = this.tail.previous;
        this.tail.next = null;
        this.linkedListLength--;
    }

    private void removeList(int key) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.key == key) {
                break;
            }

            temp = temp.next;
        }

        if (temp == null) {
            return;
        }
        if (temp.previous != null) {
            temp.previous.next = temp.next;
        }

        if (temp.next != null) {
            temp.next.previous = temp.previous;
        }

        if (temp == this.head) {
            this.head = this.head.next;
        }

        if (temp == this.tail) {
            this.tail = this.tail.previous;

            if (this.tail != null) {
                this.tail.next = null;
            }
        }
        temp = null;

        this.linkedListLength--;
    }

    private void setValueList(int key, int newValue) {
        removeList(key);
        addFirstList(key, newValue);
    }

    private int getValue(int key) {
        if (this.cacheMap.containsKey(key)) {
            getValueList(key);
        }
        return this.cacheMap.getOrDefault(key, -1);
    }

    private void setValue(int key, int value) {
        if (this.cacheMap.containsKey(key)) {
            setValueList(key, value);
        } else {
            if (this.linkedListLength < this.capacity) {
                addFirstList(key, value);
            } else {
                removeLastList();
                addFirstList(key, value);
            }
        }

        this.cacheMap.put(key, value);
    }

    void print() {
        System.out.print("Cache current size: " + this.linkedListLength + ", ");
        System.out.print("Cache contents: {");
        Node iter = this.head;
        while (iter != null) {
            System.out.print("{" + iter.key + ": " + iter.value + "}");
            iter = iter.next;
            if (iter != null)
            {
                System.out.print(", ");
            }
        }

        System.out.print("}\n");
        System.out.println(new String(new char[100]).replace('\0', '-'));
    }

    // O(1) time and O(n) space
    public static void main(String[] args) {
        int cacheCapacity = 2;
        LRUCache cache = new LRUCache(cacheCapacity);
        System.out.println("Initial state of cache");
        System.out.println("Cache capacity: " + cacheCapacity);
        cache.print();

        int[] keys = {10, 10, 15, 20, 15, 25, 5};
        String[] values = {"20", "get", "25", "40", "get", "85", "5"};

        for (int i = 0; i < keys.length; i++) {
            if (values[i].equals("get")) {
                System.out.println("Getting by Key: " + keys[i]);
                System.out.println("Cached value returned: " + (cache.getValue(keys[i])));
            } else {
                System.out.println("Setting cache: Key: " + keys[i] + ", Value: " + values[i]);
                cache.setValue(keys[i], Integer.parseInt(values[i]));
            }
            cache.print();
        }
    }
}
