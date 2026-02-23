package leet_code.Problem_237_Medium_Delete_Node_In_A_Linked_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution_CopyValue {

    /**
     * Deletes a node from a linked list without access to the head.
     * Uses the "Copy next node's value and delete next node" trick.
     * Time: O(1), Space: O(1).
     * 
     * Xóa một nút khỏi danh sách liên kết mà không cần quyền truy cập vào head.
     * Sử dụng mẹo "Sao chép giá trị nút tiếp theo và xóa nút tiếp theo".
     */
    public void deleteNode(ListNode node) {
        // Since we know the node is not the tail, node.next is guaranteed to exist.
        // Vì chúng ta biết nút không phải là đuôi, node.next được đảm bảo tồn tại.

        // 1. Copy the value of the next node to the current node
        // 1. Sao chép giá trị của nút tiếp theo vào nút hiện tại
        node.val = node.next.val;

        // 2. Point current node to next.next (skipping the next node)
        // 2. Trỏ nút hiện tại đến next.next (bỏ qua nút tiếp theo)
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Solution_CopyValue solution = new Solution_CopyValue();

        // 4->5->1->9. Delete 5.
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode nodeToDelete = head.next; // 5

        solution.deleteNode(nodeToDelete);

        // Print list
        ListNode curr = head;
        System.out.print("List: ");
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        // Expected: 4 1 9
    }
}
