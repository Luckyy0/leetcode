package leet_code.Problem_369_Medium_Plus_One_Linked_List;

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

public class Solution_TwoPointers {

    /**
     * Plus one to number represented as linked list.
     * Uses Two Pointers to find the rightmost non-nine digit.
     * Time: O(N), Space: O(1).
     * 
     * Cộng một vào số được đại diện bởi danh sách liên kết.
     * Sử dụng hai con trỏ để tìm chữ số khác chín ngoài cùng bên phải.
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode notNine = dummy;

        // 1. Find the rightmost node that is not 9
        // 1. Tìm nút ngoài cùng bên phải không phải số 9
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != 9) {
                notNine = curr;
            }
            curr = curr.next;
        }

        // 2. Increment this node
        // 2. Tăng giá trị nút này lên 1
        notNine.val++;

        // 3. Set all subsequent nodes to 0
        // 3. Đặt tất cả các nút phía sau thành 0
        curr = notNine.next;
        while (curr != null) {
            curr.val = 0;
            curr = curr.next;
        }

        return dummy.val != 0 ? dummy : head;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: [1,2,3] -> [1,2,4]
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode r1 = solution.plusOne(l1);
        printList(r1);

        // Test Case 2: [9,9,9] -> [1,0,0,0]
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode r2 = solution.plusOne(l2);
        printList(r2);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? "->" : ""));
            head = head.next;
        }
        System.out.println();
    }
}
