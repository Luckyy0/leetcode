package leet_code.Problem_82_Medium_Remove_Duplicates_From_Sorted_List_II;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        sb.append("[");
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution_Iterative {

    /**
     * Deletes all nodes that have duplicate numbers.
     * Uses a sentinel/dummy node to handle removals at the head.
     * Xóa tất cả các nút có số bị trùng lặp.
     * Sử dụng nút canh gác/dummy để xử lý việc xóa tại đầu danh sách.
     */
    public ListNode deleteDuplicates(ListNode head) {
        // Sentinel node to simplify logic
        // Nút canh gác để đơn giản hóa logic
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel;

        while (head != null) {
            // Check if it's the beginning of a duplicate sequence
            // Kiểm tra xem có phải bắt đầu chuỗi trùng lặp không
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                // Bỏ qua tất cả các nút có cùng giá trị
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev node to the node after the duplicate sequence
                // Kết nối nút prev với nút sau chuỗi trùng lặp
                prev.next = head.next;
            } else {
                // If no duplicate, move prev along the list
                // Nếu không trùng lặp, di chuyển prev dọc theo danh sách
                prev = prev.next;
            }
            // Move head to the next node
            // Di chuyển head sang nút tiếp theo
            head = head.next;
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: [1,2,3,3,4,4,5]
        ListNode l1 = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println("Test Case 1: " + solution.deleteDuplicates(l1));
        // Expected: [1, 2, 5]

        // Test Case 2: [1,1,1,2,3]
        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println("Test Case 2: " + solution.deleteDuplicates(l2));
        // Expected: [2, 3]
    }
}
