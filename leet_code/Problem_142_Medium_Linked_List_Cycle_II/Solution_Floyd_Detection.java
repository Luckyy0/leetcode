package leet_code.Problem_142_Medium_Linked_List_Cycle_II;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution_Floyd_Detection {

    /**
     * Finds the node where the cycle begins in a linked list.
     * Uses two phases: detection and entry point search.
     * O(N) time and O(1) space.
     * 
     * Tìm nút nơi chu trình bắt đầu trong một danh sách liên kết.
     * Sử dụng hai giai đoạn: phát hiện và tìm kiếm điểm bắt đầu.
     * Thời gian O(N) và không gian O(1).
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect Cycle
        // Giai đoạn 1: Phát hiện chu trình
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        // Phase 2: Find entry point
        // Giai đoạn 2: Tìm điểm bắt đầu
        // Reset fast to head and move both at the same speed
        // Đặt lại fast về head và di chuyển cả hai với cùng tốc độ
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // or fast
    }

    public static void main(String[] args) {
        Solution_Floyd_Detection solution = new Solution_Floyd_Detection();

        // Test Case 1: [3,2,0,-4], pos = 1 (entry is node 2)
        ListNode head = new ListNode(3);
        ListNode entry = new ListNode(2);
        head.next = entry;
        ListNode node3 = new ListNode(0);
        entry.next = node3;
        ListNode node4 = new ListNode(-4);
        node3.next = node4;
        node4.next = entry; // cycle starts at 2

        ListNode result = solution.detectCycle(head);
        if (result != null) {
            System.out.println("Cycle entry node value: " + result.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}
