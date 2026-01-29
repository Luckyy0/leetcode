package leetcode.P328_OddEvenLinkedList;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + (next != null ? "->" + next : "");
        }
    }

    /**
     * Problem 328: Odd Even Linked List
     * Approach: Two Pointers
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1->2->3->4->5 -> 1->3->5->2->4
        ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        runTest(solution, h1, "1->3->5->2->4");

        // 2->1->3->5->6->4->7 -> 2->3->6->7->1->5->4
        ListNode h2 = new ListNode(2,
                new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        runTest(solution, h2, "2->3->6->7->1->5->4");
    }

    private static void runTest(Solution s, ListNode head, String expected) {
        ListNode result = s.oddEvenList(head);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result != null && result.toString().equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
