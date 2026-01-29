package leetcode.P1019_NextGreaterNodeInLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        int[] res = new int[vals.size()];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < vals.size(); i++) {
            while (!stack.isEmpty() && vals.get(stack.peek()) < vals.get(i)) {
                res[stack.pop()] = vals.get(i);
            }
            stack.push(i);
        }

        return res;
    }
}
