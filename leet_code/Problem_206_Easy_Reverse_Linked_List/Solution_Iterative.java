package leet_code.Problem_206_Easy_Reverse_Linked_List;

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

public class Solution_Iterative {

    /**
     * Reverses a singly linked list.
     * Uses the iterative approach with O(1) space.
     * 
     * Đảo ngược một danh sách liên kết đơn.
     * Sử dụng phương pháp lặp với không gian O(1).
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // Save the next node
            // Lưu nút tiếp theo
            ListNode nextTemp = curr.next;

            // Reverse the link
            // Đảo ngược liên kết
            curr.next = prev;

            // Move pointers forward
            // Di chuyển con trỏ về phía trước
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: [1,2,3,4,5] -> [5,4,3,2,1]
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.reverseList(head);
        printList(result);

        // Test Case 2: [1,2] -> [2,1]
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode result2 = solution.reverseList(head2);
        printList(result2);
    }

    private static void printList(ListNode head) {
        System.out.print("Reversed List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
