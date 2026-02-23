package leet_code.Problem_21_Easy_Merge_Two_Sorted_Lists;

public class Solution_Iterative {

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
     * Merges two sorted linked lists.
     * Uses Iterative approach.
     * Gộp hai danh sách liên kết đã sắp xếp.
     * Sử dụng phương pháp Lặp.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Use a dummy node to act as the head of the new list
        // Sử dụng một nút giả để đóng vai trò là đầu của danh sách mới
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining part of the list
        // Gắn phần còn lại của danh sách
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
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

    /**
     * Helper to create list from array.
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

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1
        ListNode l1 = createList(new int[] { 1, 2, 4 });
        ListNode l2 = createList(new int[] { 1, 3, 4 });
        System.out.print("Test Case 1: ");
        printList(solution.mergeTwoLists(l1, l2));
        // Expected: [1, 1, 2, 3, 4, 4]

        // Test Case 2
        ListNode l3 = createList(new int[] {});
        ListNode l4 = createList(new int[] {});
        System.out.print("Test Case 2: ");
        printList(solution.mergeTwoLists(l3, l4));
        // Expected: []

        // Test Case 3
        ListNode l5 = createList(new int[] {});
        ListNode l6 = createList(new int[] { 0 });
        System.out.print("Test Case 3: ");
        printList(solution.mergeTwoLists(l5, l6));
        // Expected: [0]
    }
}
