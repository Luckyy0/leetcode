package leetcode.P445_AddTwoNumbersII;

import java.util.Stack;

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
     * Problem 445: Add Two Numbers II
     * Approach: Two Stacks
     * 
     * Time Complexity: O(N + M)
     * Space Complexity: O(N + M)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            carry = sum / 10;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // l1 = [7,2,4,3], l2 = [5,6,4] -> [7,8,0,7]
        ListNode l1_1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2_1 = new ListNode(5, new ListNode(6, new ListNode(4)));
        runTest(sol, l1_1, l2_1);
    }

    private static void runTest(Solution sol, ListNode l1, ListNode l2) {
        ListNode result = sol.addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
