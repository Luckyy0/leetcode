package leetcode.P002_AddTwoNumbers;

public class Solution {
    /**
     * Definition for singly-linked list.
     */
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
     * Problem 2: Add Two Numbers
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(max(m, n))
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummyHead.next;
    }

    // Helper to print list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    // Helper to create list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 342 + 465 = 807
        ListNode l1 = createList(new int[] { 2, 4, 3 });
        ListNode l2 = createList(new int[] { 5, 6, 4 });
        System.out.print("Input: l1 = ");
        printList(l1);
        System.out.print("Input: l2 = ");
        printList(l2);
        ListNode res1 = solution.addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printList(res1); // Expected: 7 -> 0 -> 8
        System.out.println("-----------------");

        // Test Case 2: 0 + 0 = 0
        l1 = createList(new int[] { 0 });
        l2 = createList(new int[] { 0 });
        System.out.print("Input: l1 = ");
        printList(l1);
        System.out.print("Input: l2 = ");
        printList(l2);
        ListNode res2 = solution.addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printList(res2); // Expected: 0
        System.out.println("-----------------");

        // Test Case 3: 9999999 + 9999 = 10009998
        l1 = createList(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        l2 = createList(new int[] { 9, 9, 9, 9 });
        System.out.print("Input: l1 = ");
        printList(l1);
        System.out.print("Input: l2 = ");
        printList(l2);
        ListNode res3 = solution.addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printList(res3); // Expected: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
    }
}
