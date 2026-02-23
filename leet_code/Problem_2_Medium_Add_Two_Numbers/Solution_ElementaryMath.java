package leet_code.Problem_2_Medium_Add_Two_Numbers;

public class Solution_ElementaryMath {

    /**
     * Definition for singly-linked list.
     * Định nghĩa cho danh sách liên kết đơn.
     */
    public static class ListNode {
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

    /**
     * Computes the sum of two numbers represented by linked lists.
     * Tính tổng của hai số được đại diện bởi các danh sách liên kết.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to simplify result list construction
        // Nút giả đầu danh sách để đơn giản hóa việc xây dựng danh sách kết quả
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Iterate while there are nodes left in l1 or l2, or there is a carry
        // Duyệt trong khi còn nút trong l1 hoặc l2, hoặc vẫn còn số nhớ
        while (l1 != null || l2 != null || carry != 0) {
            // Get values, use 0 if node is null
            // Lấy giá trị, dùng 0 nếu nút là null
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate sum and update carry
            // Tính tổng và cập nhật số nhớ
            int sum = x + y + carry;
            carry = sum / 10;

            // Create new node with the digit part of the sum
            // Tạo nút mới với phần chữ số của tổng
            current.next = new ListNode(sum % 10);

            // Move pointers
            // Di chuyển các con trỏ
            current = current.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummyHead.next;
    }

    /**
     * Helper to print list for testing.
     * Hàm hỗ trợ in danh sách để kiểm thử.
     */
    public static void printList(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null)
                System.out.print(", ");
            node = node.next;
        }
        System.out.println("]");
    }

    /**
     * Helper to create list from array.
     * Hàm hỗ trợ tạo danh sách từ mảng.
     */
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution_ElementaryMath solution = new Solution_ElementaryMath();

        // Test Case 1: [2,4,3] + [5,6,4] = [7,0,8]
        ListNode l1 = createList(new int[] { 2, 4, 3 });
        ListNode l2 = createList(new int[] { 5, 6, 4 });
        System.out.print("Test Case 1: ");
        printList(solution.addTwoNumbers(l1, l2));

        // Test Case 2: [0] + [0] = [0]
        ListNode l3 = createList(new int[] { 0 });
        ListNode l4 = createList(new int[] { 0 });
        System.out.print("Test Case 2: ");
        printList(solution.addTwoNumbers(l3, l4));

        // Test Case 3: [9,9,9,9,9,9,9] + [9,9,9,9] = [8,9,9,9,0,0,0,1]
        ListNode l5 = createList(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        ListNode l6 = createList(new int[] { 9, 9, 9, 9 });
        System.out.print("Test Case 3: ");
        printList(solution.addTwoNumbers(l5, l6));
    }
}
