package leet_code.Problem_83_Easy_Remove_Duplicates_From_Sorted_List;

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
     * Deletes duplicates from a sorted linked list.
     * Keeps exactly one copy of each unique element.
     * Xóa các phần tử trùng lặp khỏi danh sách liên kết đã sắp xếp.
     * Giữ lại chính xác một bản sao của mỗi phần tử duy nhất.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            // If the next node has the same value, skip it
            // Nếu nút tiếp theo có cùng giá trị, hãy bỏ qua nó
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Otherwise, move to the next node
                // Nếu không, chuyển sang nút tiếp theo
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: [1,1,2]
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.println("Test Case 1: " + solution.deleteDuplicates(l1));
        // Expected: [1, 2]

        // Test Case 2: [1,1,2,3,3]
        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println("Test Case 2: " + solution.deleteDuplicates(l2));
        // Expected: [1, 2, 3]
    }
}
