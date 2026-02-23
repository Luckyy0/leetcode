package leet_code.Problem_706_Easy_Design_HashMap;

public class MyHashMap {

    // Internal node structure to represent key-value pairs
    private static class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int CAPACITY = 10007; // Prime number
    private Node[] buckets;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        buckets = new Node[CAPACITY];
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = buckets[index];
        while (true) {
            if (curr.key == key) {
                curr.val = value; // Update existing key
                return;
            }
            if (curr.next == null)
                break;
            curr = curr.next;
        }
        curr.next = new Node(key, value); // Append to chain
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key)
                return curr.val;
            curr = curr.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        if (curr == null)
            return;

        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(3)); // -1
        map.put(2, 1);
        System.out.println(map.get(2)); // 1
        map.remove(2);
        System.out.println(map.get(2)); // -1
    }
}
