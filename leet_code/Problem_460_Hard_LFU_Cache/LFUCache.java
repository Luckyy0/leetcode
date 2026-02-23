package leet_code.Problem_460_Hard_LFU_Cache;

import java.util.*;

public class LFUCache {

    class Node {
        int key, val, freq;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoubleLinkedList {
        Node head, tail;
        int size;

        DoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addAtHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private int capacity, minFreq, currentSize;
    private Map<Integer, Node> cache;
    private Map<Integer, DoubleLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            update(node);
        } else {
            if (currentSize == capacity) {
                // Evict LFU then LRU
                DoubleLinkedList minList = freqMap.get(minFreq);
                Node toRemove = minList.removeLast();
                cache.remove(toRemove.key);
                currentSize--;
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            minFreq = 1; // New node always starts with freq 1
            DoubleLinkedList newList = freqMap.computeIfAbsent(1, k -> new DoubleLinkedList());
            newList.addAtHead(newNode);
            currentSize++;
        }
    }

    private void update(Node node) {
        int oldFreq = node.freq;
        DoubleLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        DoubleLinkedList newList = freqMap.computeIfAbsent(node.freq, k -> new DoubleLinkedList());
        newList.addAtHead(node);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println("Get 1: " + lfu.get(1)); // return 1
        lfu.put(3, 3); // evicts key 2
        System.out.println("Get 2: " + lfu.get(2)); // return -1 (not found)
    }
}
