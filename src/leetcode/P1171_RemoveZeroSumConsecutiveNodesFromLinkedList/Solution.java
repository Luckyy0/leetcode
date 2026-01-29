package leetcode.P1171_RemoveZeroSumConsecutiveNodesFromLinkedList;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;

        // Pass 1: Record last node for each prefix sum
        ListNode curr = dummy;
        while (curr != null) {
            prefix += curr.val;
            map.put(prefix, curr);
            curr = curr.next;
        }

        // Pass 2: Connect nodes
        prefix = 0;
        curr = dummy;
        while (curr != null) {
            prefix += curr.val;
            curr.next = map.get(prefix).next; // Skip zero sum part
            curr = curr.next;
        }

        return dummy.next;
    }
}
