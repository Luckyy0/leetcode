package leetcode.P382_LinkedListRandomNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Problem 382: Linked List Random Node
     * Approach: ArrayList Copy (For speed)
     * Note: Reservoir Sampling is the O(1) space solution.
     * 
     * Time Complexity: O(N) init, O(1) getRandom
     * Space Complexity: O(N)
     */
    private List<Integer> list;
    private Random rand;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        rand = new Random();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    /**
     * Reservoir Sampling Implementation (For reference/follow-up)
     * Time: O(N) per call. Space: O(1).
     */
    /*
     * private ListNode head;
     * public Solution(ListNode head) { this.head = head; this.rand = new Random();
     * }
     * public int getRandom() {
     * int scope = 1;
     * int chosen = 0;
     * ListNode curr = head;
     * while (curr != null) {
     * if (rand.nextDouble() < 1.0 / scope) {
     * chosen = curr.val;
     * }
     * scope++;
     * curr = curr.next;
     * }
     * return chosen;
     * }
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        Solution solution = new Solution(head);

        // Test distribution manually if needed, or just function
        System.out.println("Random: " + solution.getRandom());
        System.out.println("Random: " + solution.getRandom());
        System.out.println("Random: " + solution.getRandom());
    }
}
