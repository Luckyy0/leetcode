package leetcode.P023_MergeKSortedLists;

import java.util.PriorityQueue;

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
     * Problem 23: Merge k Sorted Lists
     * Approach: Min Heap (Priority Queue)
     * Time Complexity: O(N log k)
     * Space Complexity: O(k)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add heads to heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }

    // Helper: Create list from array
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Helper: Print list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null)
                System.out.print(",");
            curr = curr.next;
        }
        System.out.println("]");
    }

    // Helper: Compare
    public static boolean compareList(ListNode head, int[] expected) {
        ListNode curr = head;
        for (int val : expected) {
            if (curr == null || curr.val != val)
                return false;
            curr = curr.next;
        }
        return curr == null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        ListNode[] lists1 = new ListNode[] {
                createList(new int[] { 1, 4, 5 }),
                createList(new int[] { 1, 3, 4 }),
                createList(new int[] { 2, 6 })
        };
        runTest(solution, lists1, new int[] { 1, 1, 2, 3, 4, 4, 5, 6 });

        // Test Case 2
        runTest(solution, new ListNode[] {}, new int[] {});

        // Test Case 3
        runTest(solution, new ListNode[] { createList(new int[] {}) }, new int[] {});
    }

    private static void runTest(Solution s, ListNode[] lists, int[] expected) {
        System.out.print("Input: [");
        for (int i = 0; i < Math.min(lists.length, 3); i++) {
            System.out.print("List" + i + " ");
        }
        System.out.println("...]");

        ListNode result = s.mergeKLists(lists);

        System.out.print("Output: ");
        printList(result);

        if (compareList(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
