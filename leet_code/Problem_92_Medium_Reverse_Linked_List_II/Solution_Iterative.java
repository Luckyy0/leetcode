package leet_code.Problem_92_Medium_Reverse_Linked_List_II;

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
     * Reverses the linked list from left to right.
     * Uses a single-pass iterative approach.
     * Đảo ngược danh sách liên kết từ vị trí left đến right.
     * Sử dụng phương pháp duyệt một lần.
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to (left-1) position
        // Di chuyển prev đến vị trí (left-1)
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // start will be at left position
        // start sẽ ở vị trí left
        ListNode start = prev.next;
        // then will be the node that will be moved to the beginning of the reversible
        // part
        // then sẽ là nút sẽ được đưa lên đầu đoạn cần đảo ngược
        ListNode then = start.next;

        // Perform reverse right - left times
        // Thực hiện đảo ngược right - left lần
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: [1,2,3,4,5], left = 2, right = 4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Test Case 1: " + solution.reverseBetween(l1, 2, 4));
        // Expected: [1, 4, 3, 2, 5]

        // Test Case 2: [5], left = 1, right = 1
        ListNode l2 = new ListNode(5);
        System.out.println("Test Case 2: " + solution.reverseBetween(l2, 1, 1));
        // Expected: [5]
    }
}
