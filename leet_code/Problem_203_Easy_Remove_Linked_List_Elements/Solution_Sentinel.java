package leet_code.Problem_203_Easy_Remove_Linked_List_Elements;

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

public class Solution_Sentinel {

    /**
     * Removes all elements with value 'val' from the linked list.
     * Uses a Sentinel (Dummy) node to handle edge cases simply.
     * Time: O(N), Space: O(1).
     * 
     * Xóa tất cả các phần tử có giá trị 'val' khỏi danh sách liên kết.
     * Sử dụng nút Sentinel (Nút giả) để xử lý các trường hợp biên một cách đơn
     * giản.
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                // Skip the next node
                // Bỏ qua nút tiếp theo
                curr.next = curr.next.next;
            } else {
                // Move forward only if we didn't delete
                // Chỉ di chuyển tiếp nếu chúng ta không xóa
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution_Sentinel solution = new Solution_Sentinel();

        // Test Case 1: [1,2,6,3,4,5,6], val=6 -> [1,2,3,4,5]
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode result = solution.removeElements(head, 6);
        printList(result);

        // Test Case 2: [7,7,7,7], val=7 -> []
        ListNode head2 = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        ListNode result2 = solution.removeElements(head2, 7);
        printList(result2);
    }

    private static void printList(ListNode head) {
        System.out.print("List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
