package leetcode.P2181_MergeNodesInBetweenZeros;

import leetcode.common.ListNode;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode curr = head.next; // Skip first 0
        int currentSum = 0;

        while (curr != null) {
            if (curr.val == 0) {
                // End of segment
                if (currentSum > 0) { // Should always be valid per problem
                    tail.next = new ListNode(currentSum);
                    tail = tail.next;
                    currentSum = 0;
                }
            } else {
                currentSum += curr.val;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
