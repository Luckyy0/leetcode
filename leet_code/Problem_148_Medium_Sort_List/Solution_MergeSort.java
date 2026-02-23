package leet_code.Problem_148_Medium_Sort_List;

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

public class Solution_MergeSort {

    /**
     * Sorts a linked list in O(N log N) time using Merge Sort.
     * Uses top-down recursion (O(log N) stack space).
     * 
     * Sắp xếp danh sách liên kết trong thời gian O(N log N) bằng Sắp xếp trộn.
     * Sử dụng đệ quy từ trên xuống (không gian ngăn xếp O(log N)).
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle of the list
        // Bước 1: Tìm điểm giữa của danh sách
        ListNode mid = getMiddle(head);
        ListNode nextToMid = mid.next;
        mid.next = null; // Detach the first half

        // Step 2: Recursively sort both halves
        // Bước 2: Đệ quy sắp xếp cả hai nửa
        ListNode left = sortList(head);
        ListNode right = sortList(nextToMid);

        // Step 3: Merge the sorted halves
        // Bước 3: Trộn các nửa đã sắp xếp
        return merge(left, right);
    }

    // Helper: Find middle using slow and fast pointers
    private ListNode getMiddle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        // fast.next.next check to stop slow at the node before true middle for detach
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper: Merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Append remaining nodes
        if (l1 != null)
            curr.next = l1;
        if (l2 != null)
            curr.next = l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution_MergeSort solution = new Solution_MergeSort();

        // Test Case 1: [4,2,1,3]
        ListNode head1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode sorted1 = solution.sortList(head1);
        printList(sorted1); // Expected: 1 -> 2 -> 3 -> 4

        // Test Case 2: [-1,5,3,4,0]
        ListNode head2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode sorted2 = solution.sortList(head2);
        printList(sorted2); // Expected: -1 -> 0 -> 3 -> 4 -> 5
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}
