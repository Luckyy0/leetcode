package leetcode.P061_RotateList;

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
     * Problem 61: Rotate List
     * Approach: Cycle and Break
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // 1. Find length and tail
        ListNode oldTail = head;
        int n = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            n++;
        }

        // 2. Reduce k
        k = k % n;
        if (k == 0)
            return head;

        // 3. Connect tail to head
        oldTail.next = head;

        // 4. Find new tail (at index n - k - 1, if 0-indexed)
        // We need to move n - k steps from the beginning (which is oldTail.next)
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        // 5. Break cycle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
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

        ListNode l1 = createList(new int[] { 1, 2, 3, 4, 5 });
        runTest(solution, l1, 2, new int[] { 4, 5, 1, 2, 3 });

        ListNode l2 = createList(new int[] { 0, 1, 2 });
        runTest(solution, l2, 4, new int[] { 2, 0, 1 });
    }

    private static void runTest(Solution s, ListNode head, int k, int[] expected) {
        System.out.print("Input: ");
        printList(head);
        System.out.println("k = " + k);

        ListNode result = s.rotateRight(head, k);

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
