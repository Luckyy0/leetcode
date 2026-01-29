package leetcode.P2046_SortLinkedListAlreadySortedUsingAbsoluteValues;

class ListNode {
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

public class Solution {
    public ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val < 0) {
                // Remove curr from its position
                prev.next = curr.next;

                // Move curr to head
                curr.next = head;
                head = curr;

                // Update curr (prev stays same, as next changed)
                curr = prev.next;
            } else {
                // Move forward
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}
