package leetcode.P725_SplitLinkedListInParts;

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

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 1. Calculate N
        int N = 0;
        ListNode curr = head;
        while (curr != null) {
            N++;
            curr = curr.next;
        }

        int width = N / k;
        int rem = N % k;

        ListNode[] res = new ListNode[k];
        curr = head;
        for (int i = 0; i < k; i++) {
            Node headOfPart = curr;
            // First 'rem' parts get extra node
            int currentSize = width + (i < rem ? 1 : 0);

            for (int j = 0; j < currentSize - 1; j++) {
                if (curr != null)
                    curr = curr.next;
            }

            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null; // Sever the connection
                curr = nextPart;
            }

            res[i] = headOfPart;
        }

        return res;
    }
}
