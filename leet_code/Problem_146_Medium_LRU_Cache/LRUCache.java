package leet_code.Problem_146_Medium_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {

    // Node class for Doubly Linked List
    // Lớp nút cho Danh sách liên kết kép
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head; // Dummy head (Most recently used side)
    private final Node tail; // Dummy tail (Least recently used side)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy boundaries
        // Khởi tạo các ranh giới giả
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // Move to front because it was recently used
        // Di chuyển lên đầu vì nó vừa được sử dụng
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            // New node creation
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);

            // If capacity exceeded, remove LRU item
            // Nếu vượt quá dung lượng, hãy loại bỏ mục ít dùng nhất
            if (map.size() > capacity) {
                Node lruNode = removeTail();
                map.remove(lruNode.key);
            }
        } else {
            // Update existing node
            node.value = value;
            moveToHead(node);
        }
    }

    // Helper: Add node to the front (next to dummy head)
    // Hỗ trợ: Thêm nút vào đầu (cạnh nút đầu giả)
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Helper: Remove an existing node from its current position
    // Hỗ trợ: Loại bỏ một nút hiện có khỏi vị trí hiện tại của nó
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Combine removal and adding to move a node to the front
    // Hỗ trợ: Kết hợp việc xóa và thêm để di chuyển một nút lên đầu
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Helper: Remove the node right before the dummy tail (Least Recently Used)
    // Hỗ trợ: Loại bỏ nút ngay trước nút đuôi giả (Ít được sử dụng nhất gần đây)
    private Node removeTail() {
        Node lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache: {1=1}
        lruCache.put(2, 2); // cache: {2=2, 1=1}
        System.out.println("Get 1: " + lruCache.get(1)); // 1, cache: {1=1, 2=2}
        lruCache.put(3, 3); // LRU was 2, evicts 2. cache: {3=3, 1=1}
        System.out.println("Get 2: " + lruCache.get(2)); // -1
        lruCache.put(4, 4); // LRU was 1, evicts 1. cache: {4=4, 3=3}
        System.out.println("Get 1: " + lruCache.get(1)); // -1
        System.out.println("Get 3: " + lruCache.get(3)); // 3
        System.out.println("Get 4: " + lruCache.get(4)); // 4
    }
}
