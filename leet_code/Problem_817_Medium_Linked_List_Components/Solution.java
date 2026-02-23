package leet_code.Problem_817_Medium_Linked_List_Components;

import java.util.HashSet;
import java.util.Set;

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
     * Counts the number of connected components in nums.
     * Strategy: Use HashSet for O(1) lookup. Count components at their "end" nodes.
     * Time: O(N + M), Space: O(M).
     */
    public int numComponents(ListNode head, int[] nums) {
        // Step 1: Put all numbers in a Set for fast lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int componentCount = 0;
        ListNode curr = head;

        // Step 2: Traverse the linked list
        while (curr != null) {
            // If current node's value is in the subset
            if (set.contains(curr.val)) {
                // A component is counted at its last node.
                // It's the last node of a component if:
                // - It's the end of the list (curr.next == null)
                // - OR the next node is not in the set (!set.contains(curr.next.val))
                if (curr.next == null || !set.contains(curr.next.val)) {
                    componentCount++;
                }
            }
            curr = curr.next;
        }

        return componentCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [0,1,2,3], nums = [0,1,3]
        ListNode head1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        int[] n1 = { 0, 1, 3 };
        System.out.println("Result 1: " + sol.numComponents(head1, n1)); // 2
    }
}
