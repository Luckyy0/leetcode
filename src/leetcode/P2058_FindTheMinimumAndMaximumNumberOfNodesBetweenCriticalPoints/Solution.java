package leetcode.P2058_FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints;

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[] { -1, -1 };

        int minDistance = Integer.MAX_VALUE;
        int firstIdx = -1;
        int lastIdx = -1;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // head is 0, curr starts at 1

        while (curr.next != null) {
            ListNode next = curr.next;

            if ((curr.val > prev.val && curr.val > next.val) ||
                    (curr.val < prev.val && curr.val < next.val)) {

                // Found critical point
                if (firstIdx == -1) {
                    firstIdx = index;
                } else {
                    minDistance = Math.min(minDistance, index - lastIdx);
                }
                lastIdx = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        if (firstIdx == -1 || firstIdx == lastIdx)
            return new int[] { -1, -1 };

        return new int[] { minDistance, lastIdx - firstIdx };
    }
}
