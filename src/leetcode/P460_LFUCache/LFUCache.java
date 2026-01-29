package leetcode.P460_LFUCache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private static class Node {
        int key, val, freq;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private static class DLList {
        Node head, tail;
        int size;

        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
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

        Node removeTail() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private final int capacity;
    private int curSize;
    private int minFreq;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DLList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            updateFreq(node);
        } else {
            if (curSize == capacity) {
                DLList minFreqList = freqMap.get(minFreq);
                Node toRemove = minFreqList.removeTail();
                cache.remove(toRemove.key);
                curSize--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            minFreq = 1;
            DLList newList = freqMap.computeIfAbsent(1, k -> new DLList());
            newList.addAtHead(newNode);
            curSize++;
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        DLList newList = freqMap.computeIfAbsent(node.freq, k -> new DLList());
        newList.addAtHead(node);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1)); // return 1
        lfu.put(3, 3); // evicts key 2 (key 2 and 3 both freq 1, but 2 is LRU)
        System.out.println(lfu.get(2)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3
        lfu.put(4, 4); // evicts key 1 (key 1 freq 2, key 3 freq 2? No, let's trace:
                       // 1. put(1,1) [1,f1,t1]
                       // 2. put(2,2) [1,f1,t1], [2,f1,t2]
                       // 3. get(1) [1,f2,t3], [2,f1,t2] -> minFreq=1
                       // 4. put(3,3) evict 2. Cache: [1,f2,t3], [3,f1,t4]. minFreq=1.
                       // 5. get(2) -1
                       // 6. get(3) Cache: [1,f2,t3], [3,f2,t5]. minFreq=2.
                       // 7. put(4,4) evict 1 (both freq 2, but 1 is LRU). Cache: [3,f2,t5], [4,f1,t6].
        System.out.println(lfu.get(1)); // return -1
        System.out.println(lfu.get(3)); // return 3
        System.out.println(lfu.get(4)); // return 4
    }
}
