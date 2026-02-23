package leet_code.Problem_141_Easy_Linked_List_Cycle;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution_Floyd {

    /**
     * Determines if a linked list has a cycle.
     * Uses Floyd's Tortoise and Hare algorithm for O(N) time and O(1) space.
     * 
     * Xác định xem danh sách liên kết có chu trình hay không.
     * Sử dụng thuật toán Rùa và Thỏ của Floyd mang lại thời gian O(N) và không gian
     * O(1).
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer by 2 and slow by 1.
        // If they meet, there's a cycle.
        // Di chuyển con trỏ nhanh 2 bước và chậm 1 bước.
        // Nếu chúng gặp nhau, có một chu trình.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_Floyd solution = new Solution_Floyd();

        // Test Case 1: Cycle exists
        // 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle
        System.out.println("Test Case 1 (Cycle): " + solution.hasCycle(head1));

        // Test Case 2: No cycle
        // 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Test Case 2 (No Cycle): " + solution.hasCycle(head2));
    }
}
