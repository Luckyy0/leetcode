package leetcode.P817_LinkedListComponents;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);

        int components = 0;
        ListNode curr = head;
        boolean inComponent = false;

        while (curr != null) {
            if (set.contains(curr.val)) {
                if (!inComponent) {
                    components++;
                    inComponent = true;
                }
            } else {
                inComponent = false;
            }
            curr = curr.next;
        }

        return components;
    }
}
