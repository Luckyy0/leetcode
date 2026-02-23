package leet_code.Problem_705_Easy_Design_HashSet;

import java.util.LinkedList;

public class MyHashSet {
    private final int CAPACITY = 769; // A prime number to reduce collisions
    private LinkedList<Integer>[] buckets;

    /**
     * Initialize your data structure here.
     */
    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * Hash function to map keys to bucket indices.
     */
    private int hash(int key) {
        return key % CAPACITY;
    }

    public void add(int key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        // Using Integer object to remove by value, not by index
        buckets[index].remove(Integer.valueOf(key));
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }

    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(1);
        hs.add(2);
        System.out.println(hs.contains(1)); // true
        System.out.println(hs.contains(3)); // false
        hs.add(2);
        System.out.println(hs.contains(2)); // true
        hs.remove(2);
        System.out.println(hs.contains(2)); // false
    }
}
