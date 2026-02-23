package leet_code.Problem_876_Easy_Middle_of_the_Linked_List;

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

/**
 * Problem 876: Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class Solution {

    /**
     * Finds the middle node of a linked list.
     * Strategy: Two-pointer (Fast and Slow).
     * 
     * @param head The start of the list.
     * @return The middle node.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta sử dụng hai con trỏ: 'slow' đi 1 bước và 'fast' đi 2 bước
     *         mỗi lần.
     *         Khi 'fast' đi đến cuối danh sách (null hoặc có next là null),
     *         'slow' sẽ dừng lại ở đúng vị trí giữa của danh sách.
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // While fast can still move 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next; // Slow move 1 step
            fast = fast.next.next; // Fast move 2 steps
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [1,2,3,4,5] -> Output 3
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Middle Value: " + sol.middleNode(l1).val);

        // Example 2: [1,2,3,4,5,6] -> Output 4
        ListNode l2 = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println("Middle Value: " + sol.middleNode(l2).val);
    }
}
