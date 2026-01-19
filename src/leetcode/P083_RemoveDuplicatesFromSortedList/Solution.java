package leetcode.P083_RemoveDuplicatesFromSortedList;

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
     * Problem 83: Remove Duplicates from Sorted List
     * Approach: Iteration (Linear Scan)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // Skip the next node
                curr.next = curr.next.next;
                // Don't advance curr, check next one against current again
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    // Helper: Create list
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

        ListNode l1 = createList(new int[] { 1, 1, 2 });
        runTest(solution, l1, new int[] { 1, 2 });

        ListNode l2 = createList(new int[] { 1, 1, 2, 3, 3 });
        runTest(solution, l2, new int[] { 1, 2, 3 });
    }

    private static void runTest(Solution s, ListNode head, int[] expected) {
        System.out.print("Input: ");
        printList(head);
        ListNode result = s.deleteDuplicates(head);
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
