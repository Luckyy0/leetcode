package leetcode.P432_AllOoneDataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    private static class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Node head, tail; // Dummy head and tail
    private Map<String, Integer> keyCountMap;
    private Map<Integer, Node> countNodeMap;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        keyCountMap = new HashMap<>();
        countNodeMap = new HashMap<>();
    }

    public void inc(String key) {
        int currentCount = keyCountMap.getOrDefault(key, 0);
        keyCountMap.put(key, currentCount + 1);

        Node currNode = countNodeMap.get(currentCount);
        Node nextNode = countNodeMap.get(currentCount + 1);

        if (nextNode == null) {
            nextNode = addNodeAfter(currNode == null ? head : currNode, currentCount + 1);
        }

        nextNode.keys.add(key);
        if (currNode != null) {
            currNode.keys.remove(key);
            if (currNode.keys.isEmpty()) {
                removeNode(currNode);
            }
        }
    }

    public void dec(String key) {
        if (!keyCountMap.containsKey(key))
            return;

        int currentCount = keyCountMap.get(key);
        Node currNode = countNodeMap.get(currentCount);

        if (currentCount == 1) {
            keyCountMap.remove(key);
        } else {
            keyCountMap.put(key, currentCount - 1);
            Node prevNode = countNodeMap.get(currentCount - 1);
            if (prevNode == null) {
                prevNode = addNodeAfter(currNode.prev, currentCount - 1);
            }
            prevNode.keys.add(key);
        }

        currNode.keys.remove(key);
        if (currNode.keys.isEmpty()) {
            removeNode(currNode);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private Node addNodeAfter(Node node, int count) {
        Node newNode = new Node(count);
        countNodeMap.put(count, newNode);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        return newNode;
    }

    private void removeNode(Node node) {
        countNodeMap.remove(node.count);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println("Max: " + allOne.getMaxKey()); // "hello"
        System.out.println("Min: " + allOne.getMinKey()); // "hello"
        allOne.inc("world");
        System.out.println("Max: " + allOne.getMaxKey()); // "hello"
        System.out.println("Min: " + allOne.getMinKey()); // "world"
    }
}
