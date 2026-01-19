package leetcode.P234_PalindromeLinkedList;

public class Solution {

    static class ListNode {
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
     * Problem 234: Palindrome Linked List
     * Approach: Find middle, reverse second half, compare.
     * 
     * Theoretical Basis:
     * - O(N) time, O(1) space requires in-place modification.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        // Note: For odd length, slow is middle (e.g. 3 in 1-2-3-2-1). Reverse starts
        // from 3 (or 2 depending on pref).
        // Let's reverse starting from slow.
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // 3. Compare
        ListNode p1 = firstHalf;
        ListNode p2 = secondHalf;
        boolean result = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. Restore list (optional but recommended practice)
        // reverseList(secondHalf);

        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,2,1] -> true
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        runTest(solution, n1, true);

        // [1,2] -> false
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        m1.next = m2;

        runTest(solution, m1, false);
    }

    private static void runTest(Solution s, ListNode head, boolean expected) {
        boolean result = s.isPalindrome(head);
        System.out.println("Is Palindrome? " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
