package leetcode.P086_PartitionList;

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
     * Problem 86: Partition List
     * Approach: Two Pointer Lists
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Terminate the after list
        after.next = null;

        // Connect before list to after list
        before.next = afterHead.next;

        return beforeHead.next;
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

        ListNode l1 = createList(new int[] { 1, 4, 3, 2, 5, 2 });
        runTest(solution, l1, 3, new int[] { 1, 2, 2, 4, 3, 5 });

        ListNode l2 = createList(new int[] { 2, 1 });
        runTest(solution, l2, 2, new int[] { 1, 2 });
    }

    private static void runTest(Solution s, ListNode head, int x, int[] expected) {
        System.out.print("Input: ");
        printList(head);
        System.out.println("x = " + x);
        ListNode result = s.partition(head, x);
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
