package leet_code.Problem_707_Medium_Design_Linked_List;

public class MyLinkedList {

    // Internal node structure for doubly linked list
    private static class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    private int size;
    private Node head, tail; // Sentinel (Dummy) nodes

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node. */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        Node curr = head;
        // Optimization: Choose direction to traverse
        if (index + 1 < size - index) {
            for (int i = 0; i <= index; i++)
                curr = curr.next;
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++)
                curr = curr.prev;
        }
        return curr.val;
    }

    /** Add a node of value val before the first element. */
    public void addAtHead(int val) {
        addNode(head, head.next, val);
    }

    /** Append a node of value val as the last element. */
    public void addAtTail(int val) {
        addNode(tail.prev, tail, val);
    }

    /** Add a node of value val before the index-th node. */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index < 0)
            index = 0;

        Node pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++)
                pred = pred.next;
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; i++)
                succ = succ.prev;
            pred = succ.prev;
        }
        addNode(pred, succ, val);
    }

    /** Delete the index-th node. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        Node pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++)
                pred = pred.next;
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++)
                succ = succ.prev;
            pred = succ.prev.prev;
        }

        size--;
        pred.next = succ;
        succ.prev = pred;
    }

    /** Helper function to insert a node between two existing nodes. */
    private void addNode(Node pred, Node succ, int val) {
        size++;
        Node newNode = new Node(val);
        newNode.prev = pred;
        newNode.next = succ;
        pred.next = newNode;
        succ.prev = newNode;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        System.out.println(list.get(1)); // 2
        list.deleteAtIndex(1);
        System.out.println(list.get(1)); // 3
    }
}
