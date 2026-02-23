package leet_code.Problem_86_Medium_Partition_List;

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

public class Solution_TwoPointers {

    /**
     * Partitions a linked list around a value x.
     * Nodes less than x come before nodes greater than or equal to x.
     * Preserves relative order.
     * Phân tách danh sách liên kết xung quanh giá trị x.
     * Các nút nhỏ hơn x đứng trước các nút lớn hơn hoặc bằng x.
     * Giữ nguyên thứ tự tương đối.
     */
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes for the two partitions
        // Các nút dummy cho hai phần phân tách
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                // Node goes to the 'before' list
                // Nút được đưa vào danh sách 'trước'
                before.next = head;
                before = before.next;
            } else {
                // Node goes to the 'after' list
                // Nút được đưa vào danh sách 'sau'
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Connect the two lists
        // Kết nối hai danh sách
        // IMPORTANT: Set the end of the second list to null to avoid cycles
        // QUAN TRỌNG: Đặt phần cuối của danh sách thứ hai thành null để tránh vòng lặp
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: [1,4,3,2,5,2], x = 3
        ListNode l1 = new ListNode(1,
                new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        System.out.println("Test Case 1: " + solution.partition(l1, 3));
        // Expected: [1, 2, 2, 4, 3, 5]

        // Test Case 2: [2,1], x = 2
        ListNode l2 = new ListNode(2, new ListNode(1));
        System.out.println("Test Case 2: " + solution.partition(l2, 2));
        // Expected: [1, 2]
    }
}
