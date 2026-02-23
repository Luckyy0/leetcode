package leet_code.Problem_716_Hard_Max_Stack;

import java.util.*;

public class MaxStack {

    // Doubly Linked List Node to store values in stack order
    private static class Node {
        int val;
        Node prev, next;

        Node(int v) {
            this.val = v;
        }
    }

    private Node head, tail; // DLL boundaries
    private TreeMap<Integer, List<Node>> map; // Maps value to all its instances in DLL

    public MaxStack() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    /**
     * Pushes value onto stack. Time: O(log N).
     */
    public void push(int x) {
        Node newNode = new Node(x);
        // Add to tail of DLL (Stack top)
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;

        // Add to TreeMap
        map.computeIfAbsent(x, k -> new ArrayList<>()).add(newNode);
    }

    /**
     * Removes top of stack. Time: O(log N).
     */
    public int pop() {
        Node top = tail.prev;
        removeNode(top);

        // Remove from TreeMap
        List<Node> list = map.get(top.val);
        list.remove(list.size() - 1);
        if (list.isEmpty())
            map.remove(top.val);

        return top.val;
    }

    /**
     * Peek top of stack. Time: O(1).
     */
    public int top() {
        return tail.prev.val;
    }

    /**
     * Retrieves current maximum. Time: O(log N).
     */
    public int peekMax() {
        return map.lastKey();
    }

    /**
     * Removes the most recent instance of maximum. Time: O(log N).
     */
    public int popMax() {
        int maxVal = map.lastKey();
        List<Node> list = map.get(maxVal);
        Node nodeToPop = list.remove(list.size() - 1);
        if (list.isEmpty())
            map.remove(maxVal);

        removeNode(nodeToPop);
        return maxVal;
    }

    // Helper to unlink a node from DLL
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        MaxStack st = new MaxStack();
        st.push(5);
        st.push(1);
        st.push(5);
        System.out.println(st.top()); // 5
        System.out.println(st.popMax()); // 5
        System.out.println(st.top()); // 1
        System.out.println(st.peekMax()); // 5
        System.out.println(st.pop()); // 1
        System.out.println(st.top()); // 5
    }
}
