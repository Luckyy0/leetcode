package leet_code.Problem_61_Medium_Rotate_List;

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

public class Solution_Circular {

    /**
     * Rotates the linked list to the right by k places.
     * Uses a circular list strategy.
     * Xoay danh sách liên kết sang phải k vị trí.
     * Sử dụng chiến lược danh sách vòng.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Calculate length and find tail
        // Tính độ dài và tìm đuôi
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        // 2. Adjust k
        k = k % length;
        if (k == 0)
            return head;

        // 3. Make the list circular
        // Biến danh sách thành vòng
        tail.next = head;

        // 4. Find the new tail: (length - k - 1) steps from head
        // Tìm đuôi mới: (length - k - 1) bước từ head
        int stepsToNewTail = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5. Break the circle
        // Phá vỡ vòng tròn
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Solution_Circular solution = new Solution_Circular();

        // Helper to create list
        ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Test Case 1 (k=2): " + solution.rotateRight(h1, 2));
        // Expected: [4, 5, 1, 2, 3]

        ListNode h2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.out.println("Test Case 2 (k=4): " + solution.rotateRight(h2, 4));
        // Expected: [2, 0, 1]
    }
}
