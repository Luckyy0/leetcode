package leetcode.P369_PlusOneLinkedList;

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

        @Override
        public String toString() {
            return val + (next != null ? "->" + next.toString() : "");
        }
    }

    /**
     * Problem 369: Plus One Linked List
     * Approach: Rightmost Non-Nine Node
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode notNine = dummy;
        ListNode curr = head;

        // Find the rightmost non-nine node
        while (curr != null) {
            if (curr.val != 9) {
                notNine = curr;
            }
            curr = curr.next;
        }

        // Increment that node
        notNine.val++;

        // All subsequent nodes become 0
        curr = notNine.next;
        while (curr != null) {
            curr.val = 0;
            curr = curr.next;
        }

        // If dummy was used (i.e. number of digits increased), return dummy
        // Otherwise return dummy.next
        return dummy.val == 1 ? dummy : dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3] -> [1,2,4]
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        runTest(solution, l1, "1->2->4");

        // [9,9] -> [1,0,0]
        ListNode l2 = new ListNode(9, new ListNode(9));
        runTest(solution, l2, "1->0->0");

        // [0] -> [1]
        ListNode l3 = new ListNode(0);
        runTest(solution, l3, "1");
    }

    private static void runTest(Solution s, ListNode head, String expected) {
        ListNode result = s.plusOne(head);
        String resStr = result.toString();
        System.out.println("Result: " + resStr + " (Expected: " + expected + ")");
        if (resStr.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
