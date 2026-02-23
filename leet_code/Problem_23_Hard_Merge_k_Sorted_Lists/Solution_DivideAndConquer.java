package leet_code.Problem_23_Hard_Merge_k_Sorted_Lists;

public class Solution_DivideAndConquer {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
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
     * Merges k sorted linked lists using Divide and Conquer.
     * Time Complexity: O(N log k).
     * Gộp k danh sách liên kết đã sắp xếp sử dụng Chia để Trị.
     * Độ phức tạp thời gian: O(N log k).
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int interval = 1;
        int len = lists.length;

        while (interval < len) {
            for (int i = 0; i < len - interval; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    /**
     * Helper to merge two sorted lists (Same as Problem 21).
     * Hàm hỗ trợ gộp hai danh sách đã sắp xếp (Giống bài 21).
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    /**
     * Helper to create list.
     */
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    /**
     * Helper to print list.
     */
    public static void printList(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null)
                System.out.print(", ");
            node = node.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution_DivideAndConquer solution = new Solution_DivideAndConquer();

        // Test Case 1
        ListNode l1 = createList(new int[] { 1, 4, 5 });
        ListNode l2 = createList(new int[] { 1, 3, 4 });
        ListNode l3 = createList(new int[] { 2, 6 });
        ListNode[] input1 = { l1, l2, l3 };
        System.out.print("Test Case 1: ");
        printList(solution.mergeKLists(input1));
        // Expected: [1, 1, 2, 3, 4, 4, 5, 6]

        // Test Case 2
        ListNode[] input2 = {};
        System.out.print("Test Case 2: ");
        printList(solution.mergeKLists(input2));
        // Expected: []

        // Test Case 3
        ListNode l4 = createList(new int[] {});
        ListNode[] input3 = { l4 };
        System.out.print("Test Case 3: ");
        printList(solution.mergeKLists(input3));
        // Expected: []
    }
}
