package leet_code.Problem_147_Medium_Insertion_Sort_List;

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

public class Solution_Insertion {

    /**
     * Sorts a singly linked list using insertion sort.
     * Time Complexity: O(N^2), Space Complexity: O(1).
     * 
     * Sắp xếp danh sách liên kết đơn bằng phương pháp sắp xếp chèn.
     * Độ phức tạp thời gian: O(N^2), Độ phức tạp không gian: O(1).
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node as the starting point of the sorted list
        // Nút giả đóng vai trò là điểm bắt đầu của danh sách đã sắp xếp
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            // Store the next node to continue with the unsorted part
            // Lưu nút tiếp theo để tiếp tục với phần chưa được sắp xếp
            ListNode nextTemp = curr.next;

            // Find the correct position in the sorted list starting from dummy
            // Tìm vị trí chính xác trong danh sách đã sắp xếp bắt đầu từ dummy
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            // Chèn curr vào giữa prev và prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in the original list
            // Di chuyển đến nút tiếp theo trong danh sách ban đầu
            curr = nextTemp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution_Insertion solution = new Solution_Insertion();

        // Test Case 1: [4,2,1,3]
        ListNode head1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode sorted1 = solution.insertionSortList(head1);
        printList(sorted1); // Expected: 1 -> 2 -> 3 -> 4

        // Test Case 2: [-1,5,3,4,0]
        ListNode head2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode sorted2 = solution.insertionSortList(head2);
        printList(sorted2); // Expected: -1 -> 0 -> 3 -> 4 -> 5
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
