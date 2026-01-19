package leetcode.P021_MergeTwoSortedLists;

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
     * Problem 21: Merge Two Sorted Lists
     * Approach: Iterative
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
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
        ListNode l1 = createList(new int[] { 1, 2, 4 });
        ListNode l2 = createList(new int[] { 1, 3, 4 });
        runTest(solution, l1, l2, new int[] { 1, 1, 2, 3, 4, 4 });

        // Test Case 2
        ListNode l3 = createList(new int[] {});
        ListNode l4 = createList(new int[] {});
        runTest(solution, l3, l4, new int[] {});

        // Test Case 3
        ListNode l5 = createList(new int[] {});
        ListNode l6 = createList(new int[] { 0 });
        runTest(solution, l5, l6, new int[] { 0 });
    }

    private static void runTest(Solution s, ListNode l1, ListNode l2, int[] expected) {
        System.out.print("Input L1: ");
        printList(l1);
        System.out.print("Input L2: ");
        printList(l2);

        ListNode result = s.mergeTwoLists(l1, l2);

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
