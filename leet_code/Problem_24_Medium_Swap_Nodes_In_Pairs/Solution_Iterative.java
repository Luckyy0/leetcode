package leet_code.Problem_24_Medium_Swap_Nodes_In_Pairs;

public class Solution_Iterative {

    /**
     * Definition for singly-linked list.
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
     * Swaps every two adjacent nodes.
     * Uses Iterative approach.
     * Hoán đổi mỗi hai nút liền kề.
     * Sử dụng phương pháp Lặp.
     */
    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify head operations
        // Nút giả để đơn giản hóa các thao tác với đầu danh sách
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping
            // Hoán đổi
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move prev to the next pair (which starts from 'first', now the second node in
            // current pair)
            // Di chuyển prev đến cặp tiếp theo (bắt đầu từ 'first', hiện là nút thứ hai
            // trong cặp hiện tại)
            prev = first;
        }

        return dummy.next;
    }

    /**
     * Helper to create list.
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

    /**
     * Helper to print list.
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

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1
        ListNode l1 = createList(new int[] { 1, 2, 3, 4 });
        System.out.print("Test Case 1: ");
        printList(solution.swapPairs(l1));
        // Expected: [2, 1, 4, 3]

        // Test Case 2
        ListNode l2 = createList(new int[] {});
        System.out.print("Test Case 2: ");
        printList(solution.swapPairs(l2));
        // Expected: []

        // Test Case 3
        ListNode l3 = createList(new int[] { 1 });
        System.out.print("Test Case 3: ");
        printList(solution.swapPairs(l3));
        // Expected: [1]
    }
}
