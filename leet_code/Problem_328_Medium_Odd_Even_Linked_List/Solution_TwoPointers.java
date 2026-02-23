package leet_code.Problem_328_Medium_Odd_Even_Linked_List;

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
     * Rearranges list to odd-even.
     * Uses Two Pointers.
     * Time: O(N), Space: O(1).
     * 
     * Sắp xếp lại danh sách thành lẻ-chẵn.
     * Sử dụng Hai Con trỏ.
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // While even and even.next are valid (odd is always valid if even is valid)
        // Trong khi even và even.next hợp lệ (odd luôn hợp lệ nếu even hợp lệ)
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        // Connect tail of odd to head of even
        // Kết nối đuôi của lẻ với đầu của chẵn
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: [1,2,3,4,5]
        ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode r1 = solution.oddEvenList(h1);
        System.out.print("Result 1: ");
        printList(r1);

        // Test Case 2: [2,1,3,5,6,4,7]
        ListNode h2 = new ListNode(2,
                new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ListNode r2 = solution.oddEvenList(h2);
        System.out.print("Result 2: ");
        printList(r2);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
