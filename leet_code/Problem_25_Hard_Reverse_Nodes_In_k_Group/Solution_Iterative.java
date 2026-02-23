package leet_code.Problem_25_Hard_Reverse_Nodes_In_k_Group;

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
     * Reverses nodes in k-group.
     * Uses Iterative approach.
     * Đảo ngược các nút trong nhóm k.
     * Sử dụng phương pháp Lặp.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        // Count length
        // Đếm độ dài
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        for (int i = 0; i < n / k; i++) {
            // Start of the group to be reversed
            // Đầu của nhóm cần đảo ngược
            ListNode groupStart = curr;
            ListNode prev = null;

            // Reverse k nodes
            // Đảo ngược k nút
            for (int j = 0; j < k; j++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // prev is now the new head of this group
            // curr is now the start of the next group (or null)
            // prev bây giờ là đầu mới của nhóm này
            // curr bây giờ là đầu của nhóm tiếp theo (hoặc null)

            // Connect previous group to new head
            // Kết nối nhóm trước với đầu mới
            prevGroupEnd.next = prev;

            // Connect new tail (old total head) to next group start
            // Kết nối đuôi mới (đầu cũ) với đầu nhóm tiếp theo
            groupStart.next = curr;

            // Move prevGroupEnd to the end of this group
            // Di chuyển prevGroupEnd đến cuối nhóm này
            prevGroupEnd = groupStart;
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
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1
        ListNode l1 = createList(new int[] { 1, 2, 3, 4, 5 });
        int k1 = 2;
        System.out.print("Test Case 1: ");
        printList(solution.reverseKGroup(l1, k1));
        // Expected: [2, 1, 4, 3, 5]

        // Test Case 2
        ListNode l2 = createList(new int[] { 1, 2, 3, 4, 5 });
        int k2 = 3;
        System.out.print("Test Case 2: ");
        printList(solution.reverseKGroup(l2, k2));
        // Expected: [3, 2, 1, 4, 5]
    }
}
