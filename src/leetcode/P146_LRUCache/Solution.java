package leetcode.P146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 146: LRU Cache
 * Approach: HashMap + Doubly Linked List
 * 
 * Theoretical Basis:
 * - HashMap provides O(1) keyed access.
 * - Doubly Linked List provides O(1) insertion/deletion at both ends and
 * middle.
 * - Combining them allows O(1) get and put with LRU eviction.
 */
public class Solution {

    static class LRUCache {

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int k, int v) {
                this.key = k;
                this.value = v;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> map;
        private final Node head;
        private final Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                if (map.size() >= capacity) {
                    // Evict LRU (last node before dummy tail)
                    Node lru = tail.prev;
                    removeNode(lru);
                    map.remove(lru.key);
                }
                Node newNode = new Node(key, value);
                addNode(newNode);
                map.put(key, newNode);
            }
        }

        // Internal helper: removes node from list
        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Internal helper: adds node to front of list
        private void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Internal helper: moves existing node to front
        private void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println("get(1): " + lRUCache.get(1)); // 1
        lRUCache.put(3, 3); // evicts key 2
        System.out.println("get(2): " + lRUCache.get(2)); // -1
        lRUCache.put(4, 4); // evicts key 1
        System.out.println("get(1): " + lRUCache.get(1)); // -1
        System.out.println("get(3): " + lRUCache.get(3)); // 3
        System.out.println("get(4): " + lRUCache.get(4)); // 4
    }
}
