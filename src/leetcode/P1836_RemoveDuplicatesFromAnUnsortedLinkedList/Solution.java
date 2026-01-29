package leetcode.P1836_RemoveDuplicatesFromAnUnsortedLinkedList;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public class ListNode {
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

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> counts = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            counts.put(curr.val, counts.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        curr = head;

        while (curr != null) {
            if (counts.get(curr.val) > 1) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
