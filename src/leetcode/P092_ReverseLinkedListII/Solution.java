package leetcode.P092_ReverseLinkedListII;

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
     * Problem 92: Reverse Linked List II
     * Approach: One Pass Iterative
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // Move prev to node at 'left - 1'
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // curr is node at 'left'
        ListNode curr = prev.next;

        // Reverse sublist
        // We move the node that is next to curr (curr.next) to be after prev
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
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

        ListNode l1 = createList(new int[] { 1, 2, 3, 4, 5 });
        runTest(solution, l1, 2, 4, new int[] { 1, 4, 3, 2, 5 });

        ListNode l2 = createList(new int[] { 5 });
        runTest(solution, l2, 1, 1, new int[] { 5 });
    }

    private static void runTest(Solution s, ListNode head, int left, int right, int[] expected) {
        System.out.print("Input: ");
        printList(head);
        System.out.println("left=" + left + ", right=" + right);
        ListNode result = s.reverseBetween(head, left, right);
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
