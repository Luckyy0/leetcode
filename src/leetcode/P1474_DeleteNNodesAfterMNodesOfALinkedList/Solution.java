package leetcode.P1474_DeleteNNodesAfterMNodesOfALinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;

        while (curr != null) {
            // Keep m nodes
            for (int i = 0; i < m - 1 && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null)
                break;

            // Start deleting
            ListNode temp = curr.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = temp;
        }

        return head;
    }
}
