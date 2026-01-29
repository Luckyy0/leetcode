package leetcode.P2074_ReverseNodesInEvenLengthGroups;

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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prevGroupTail = null;
        ListNode curr = head;
        int groupSize = 1;

        while (curr != null) {
            // Check actual size of this group
            int count = 0;
            ListNode iter = curr;
            while (iter != null && count < groupSize) {
                iter = iter.next;
                count++;
            }
            // Group nodes are from 'curr' to 'iter' (exclusive of iter)
            // Number of nodes is 'count'.

            if (count % 2 == 0) {
                // Reverse [curr, ..., nodeBeforeIter]
                // prevGroupTail.next needs to point to newHead
                // And newTail.next needs to point to iter

                ListNode prev = iter; // Initially point newTail's next to the node after group
                ListNode c = curr;
                ListNode n = null;
                // How many to reverse? 'count' times.

                // We need reference to newTail which is current 'curr'
                ListNode newTail = curr;
                ListNode newHead = null; // Will be last processed

                for (int i = 0; i < count; i++) {
                    n = c.next;
                    c.next = prev;
                    prev = c;
                    c = n;
                }
                newHead = prev;

                if (prevGroupTail == null) {
                    head = newHead;
                } else {
                    prevGroupTail.next = newHead;
                }

                prevGroupTail = newTail; // newTail is now end of this group
                curr = iter; // Continue from next group

            } else {
                // Just advance prevGroupTail
                for (int i = 0; i < count; i++) {
                    prevGroupTail = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return head;
    }
}
