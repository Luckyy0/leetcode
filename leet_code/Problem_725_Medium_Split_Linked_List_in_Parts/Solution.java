package leet_code.Problem_725_Medium_Split_Linked_List_in_Parts;

/**
 * Definition for singly-linked list.
 */
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

    /**
     * Splits a linked list into k parts as evenly as possible.
     * Strategy: Count length, calculate split sizes, and decouple pointers.
     * Time: O(N + K), Space: O(K) for result.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Count total length
        int totalLen = 0;
        ListNode curr = head;
        while (curr != null) {
            totalLen++;
            curr = curr.next;
        }

        // Step 2: Determine base size and extra nodes
        int baseSize = totalLen / k;
        int extraNodes = totalLen % k;

        ListNode[] result = new ListNode[k];
        curr = head;
        ListNode prev = null;

        // Step 3: Split the list
        for (int i = 0; i < k; i++) {
            result[i] = curr;
            // First 'extraNodes' parts get 1 extra node each
            int currentPartLen = baseSize + (i < extraNodes ? 1 : 0);

            for (int j = 0; j < currentPartLen; j++) {
                prev = curr;
                if (curr != null)
                    curr = curr.next;
            }

            // Decouple current part from the rest
            if (prev != null) {
                prev.next = null;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8,
                        new ListNode(9, new ListNode(10))))))))));
        ListNode[] res = sol.splitListToParts(head, 3);
        for (ListNode part : res) {
            System.out.print("[");
            while (part != null) {
                System.out.print(part.val + (part.next != null ? "," : ""));
                part = part.next;
            }
            System.out.println("]");
        }
    }
}
