package leetcode.P019_RemoveNthNodeFromEndOfList;

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
     * Problem 19: Remove Nth Node From End of List
     * Approach: One Pass using Two Pointers
     * Time Complexity: O(L)
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null)
                return head; // Should not happen based on constraints
            fast = fast.next;
        }

        // If fast is null, n equals the length of list, so we remove the head
        if (fast == null) {
            return head.next;
        }

        // Move both until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from end
        slow.next = slow.next.next;

        return head;
    }

    // Helper to create list
    public static ListNode createList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Helper to print list
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

    // Helper to compare content
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
        ListNode head1 = createList(new int[] { 1, 2, 3, 4, 5 });
        runTest(solution, head1, 2, new int[] { 1, 2, 3, 5 });

        // Test Case 2
        ListNode head2 = createList(new int[] { 1 });
        runTest(solution, head2, 1, new int[] {});

        // Test Case 3
        ListNode head3 = createList(new int[] { 1, 2 });
        runTest(solution, head3, 1, new int[] { 1 });

        // Test Case 4: Remove head
        ListNode head4 = createList(new int[] { 1, 2 });
        runTest(solution, head4, 2, new int[] { 2 });
    }

    private static void runTest(Solution s, ListNode head, int n, int[] expected) {
        System.out.print("Input: ");
        printList(head);
        System.out.println("n = " + n);

        ListNode result = s.removeNthFromEnd(head, n);

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
