package leetcode.P1669_MergeInBetweenLinkedLists;

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = null;
        ListNode afterB = list1;

        // Find split points
        // Iterate to find index a-1 and b+1
        // Indices are 0-based
        for (int i = 0; i <= b; i++) {
            if (i == a - 1)
                prevA = afterB;
            afterB = afterB.next;
        }
        // afterB is now at b+1

        // Find tail of list2
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        // Splice
        prevA.next = list2;
        tail2.next = afterB;

        return list1;
    }
}
