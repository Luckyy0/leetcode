package leetcode.P025_ReverseNodesInKGroup;

public class Solution {

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
     * Problem 25: Reverse Nodes in k-Group
     * Approach: Iterative
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        // Count length
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        curr = head;

        while (count >= k) {
            // Reverse k nodes: curr -> ... -> next
            // We adjust pointers k-1 times to reverse k nodes
            // Example k=3: 1->2->3. prev points to before 1.
            // 1. Move 2 to front of 1.
            // 2. Move 3 to front of 2.

            // prev is fixed at the node BEFORE the group reversing
            // curr is fixed at the FIRST node of the group (which becomes TAIL)
            // nxt is the node being moved to the front (next of curr)

            for (int i = 0; i < k - 1; i++) {
                ListNode nxt = curr.next;
                curr.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
            }

            // After reversing group, curr is now the last node of the reversed group
            // So prev becomes curr for the next iteration
            prev = curr;
            curr = curr.next; // curr moves to the start of the next group
            count -= k;
        }

        return dummy.next;
    }

    // Helper: Create list from array
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Helper: Print list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null)
                System.out.print(",");
            curr = curr.next;
        }
        System.out.println("]");
    }

    // Helper: Compare
    public static boolean compareList(ListNode head, int[] expected) {
        ListNode curr = head;
        for (int val : expected) {
            if (curr == null || curr.val != val)
                return false;
            curr = curr.next;
        }
        return curr == null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        ListNode l1 = createList(new int[] { 1, 2, 3, 4, 5 });
        runTest(solution, l1, 2, new int[] { 2, 1, 4, 3, 5 });

        // Test Case 2
        ListNode l2 = createList(new int[] { 1, 2, 3, 4, 5 });
        runTest(solution, l2, 3, new int[] { 3, 2, 1, 4, 5 }); // 3,2,1 reversed, 4,5 remain

        // Test Case 3: k = 1
        ListNode l3 = createList(new int[] { 1, 2 });
        runTest(solution, l3, 1, new int[] { 1, 2 });

        // Test Case 4: Same length
        ListNode l4 = createList(new int[] { 1, 2 });
        runTest(solution, l4, 2, new int[] { 2, 1 });
    }

    private static void runTest(Solution s, ListNode head, int k, int[] expected) {
        System.out.print("Input: ");
        printList(head);
        System.out.println("k = " + k);

        ListNode result = s.reverseKGroup(head, k);

        System.out.print("Output: ");
        printList(result);

        if (compareList(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
