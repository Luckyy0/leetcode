package leet_code.Problem_708_Medium_Insert_into_a_Sorted_Circular_Linked_List;

/**
 * Definition for a Node.
 */
class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

public class Solution {

    /**
     * Inserts a value into a sorted circular linked list.
     * Strategy: Single pass check for intermediate, wrap-around, and uniform cases.
     * Time: O(N), Space: O(1).
     */
    public Node insert(Node head, int insertVal) {
        // Case: Empty list
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        boolean inserted = false;

        do {
            // Case 1: Intermediate position
            if (prev.val <= insertVal && insertVal <= curr.val) {
                inserted = true;
            }
            // Case 2: Wrap-around point (descending edge)
            else if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    inserted = true;
                }
            }

            if (inserted) {
                prev.next = new Node(insertVal, curr);
                return head;
            }

            prev = curr;
            curr = curr.next;
        } while (prev != head);

        // Case 3: All nodes have same value, or we looped back to head
        prev.next = new Node(insertVal, curr);
        return head;
    }
}
