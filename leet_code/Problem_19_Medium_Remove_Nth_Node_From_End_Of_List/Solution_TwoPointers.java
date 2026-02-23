package leet_code.Problem_19_Medium_Remove_Nth_Node_From_End_Of_List;

public class Solution_TwoPointers {

    /**
     * Definition for singly-linked list.
     * Định nghĩa cho danh sách liên kết đơn.
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
     * Removes the nth node from the end of the list.
     * Uses Two Pointers approach (one pass).
     * Xóa nút thứ n từ cuối danh sách.
     * Sử dụng phương pháp Hai Con Trỏ (một lần duyệt).
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Use a dummy node to handle edge case where head is removed
        // Sử dụng nút giả để xử lý trường hợp biên khi head bị xóa
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n + 1 steps ahead
        // Di chuyển con trỏ first về phía trước n + 1 bước
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        // Di chuyển cả hai con trỏ cho đến khi first đến cuối
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Now second is pointing to the node before the one to be deleted
        // Remove the nth node from end
        // Lúc này second đang trỏ đến nút trước nút cần xóa
        // Xóa nút thứ n từ cuối
        second.next = second.next.next;

        return dummy.next;
    }

    /**
     * Helper to print list.
     * Hàm hỗ trợ in danh sách.
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
     * Hàm hỗ trợ tạo danh sách từ mảng.
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
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        ListNode h1 = createList(new int[] { 1, 2, 3, 4, 5 });
        int n1 = 2;
        System.out.print("Test Case 1: ");
        printList(solution.removeNthFromEnd(h1, n1));
        // Expected: [1, 2, 3, 5]

        // Test Case 2
        ListNode h2 = createList(new int[] { 1 });
        int n2 = 1;
        System.out.print("Test Case 2: ");
        printList(solution.removeNthFromEnd(h2, n2));
        // Expected: []

        // Test Case 3
        ListNode h3 = createList(new int[] { 1, 2 });
        int n3 = 1;
        System.out.print("Test Case 3: ");
        printList(solution.removeNthFromEnd(h3, n3));
        // Expected: [1]
    }
}
