package leetcode.P024_SwapNodesInPairs;

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
     * Problem 24: Swap Nodes in Pairs
     * Approach: Iterative
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            // Nodes to swap
            ListNode first = curr;
            ListNode second = curr.next;

            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Re-position pointers
            prev = first;
            curr = first.next;
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
        ListNode l1 = createList(new int[] { 1, 2, 3, 4 });
        runTest(solution, l1, new int[] { 2, 1, 4, 3 });

        // Test Case 2
        ListNode l2 = createList(new int[] {});
        runTest(solution, l2, new int[] {});

        // Test Case 3
        ListNode l3 = createList(new int[] { 1 });
        runTest(solution, l3, new int[] { 1 });

        // Test Case 4: Odd length
        ListNode l4 = createList(new int[] { 1, 2, 3 });
        runTest(solution, l4, new int[] { 2, 1, 3 });
    }

    private static void runTest(Solution s, ListNode head, int[] expected) {
        System.out.print("Input: ");
        printList(head);

        ListNode result = s.swapPairs(head);

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
