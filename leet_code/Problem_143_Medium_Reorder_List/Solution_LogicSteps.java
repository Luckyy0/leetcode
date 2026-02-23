package leet_code.Problem_143_Medium_Reorder_List;

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

public class Solution_LogicSteps {

    /**
     * Reorders a singly linked list in-place.
     * Pattern: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...
     * Time: O(N), Space: O(1).
     * 
     * Tái cấu trúc danh sách liên kết đơn tại chỗ.
     * Thời gian: O(N), Không gian: O(1).
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle
        // Bước 1: Tìm điểm giữa
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        // Bước 2: Đảo ngược nửa sau
        // Second half starts after 'slow'
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Split the list

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: Merge the two halves
        // Bước 3: Trộn hai nửa
        // First half starts at head, second starts at prev
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    public static void main(String[] args) {
        Solution_LogicSteps solution = new Solution_LogicSteps();

        // Test Case 1: [1,2,3,4] -> [1,4,2,3]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.reorderList(head1);
        printList(head1);

        // Test Case 2: [1,2,3,4,5] -> [1,5,2,4,3]
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.reorderList(head2);
        printList(head2);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}
