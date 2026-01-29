package leetcode.P1721_SwappingNodesInALinkedList;

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = head;
        // Find kth node from start
        for (int i = 1; i < k; i++) {
            p1 = p1.next;
        }
        ListNode first = p1;

        // Find kth node from end
        ListNode slow = head;
        ListNode fast = p1;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode second = slow;

        // Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
