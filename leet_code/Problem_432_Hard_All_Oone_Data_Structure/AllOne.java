package leet_code.Problem_432_Hard_All_Oone_Data_Structure;

import java.util.*;

public class AllOne {

    // Node class for Doubly Linked List of buckets
    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int c) {
            this.count = c;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> keyToNode;
    private Node head, tail; // Dummies

    public AllOne() {
        keyToNode = new HashMap<>();
        head = new Node(0);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (keyToNode.containsKey(key)) {
            Node curr = keyToNode.get(key);
            Node next = curr.next;

            if (next.count != curr.count + 1) {
                next = insertAfter(curr, curr.count + 1);
            }

            next.keys.add(key);
            keyToNode.put(key, next);

            curr.keys.remove(key);
            if (curr.keys.isEmpty())
                removeNode(curr);
        } else {
            Node first = head.next;
            if (first.count != 1) {
                first = insertAfter(head, 1);
            }
            first.keys.add(key);
            keyToNode.put(key, first);
        }
    }

    public void dec(String key) {
        Node curr = keyToNode.get(key);
        if (curr.count == 1) {
            keyToNode.remove(key);
        } else {
            Node prev = curr.prev;
            if (prev.count != curr.count - 1) {
                prev = insertAfter(curr.prev, curr.count - 1);
            }
            prev.keys.add(key);
            keyToNode.put(key, prev);
        }

        curr.keys.remove(key);
        if (curr.keys.isEmpty())
            removeNode(curr);
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    // Helper: Insert a new node with 'count' after 'prevNode'
    private Node insertAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        return newNode;
    }

    // Helper: Remove node from DLL
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println("Max: " + allOne.getMaxKey()); // "hello"
        System.out.println("Min: " + allOne.getMinKey()); // "hello"
        allOne.inc("leet");
        System.out.println("Max: " + allOne.getMaxKey()); // "hello"
        System.out.println("Min: " + allOne.getMinKey()); // "leet"
    }
}
