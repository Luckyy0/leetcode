package leet_code.Problem_445_Medium_Add_Two_Numbers_II;

import java.util.*;

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

public class Solution_Stack {

    /**
     * Adds two numbers represented by linked lists (MSB first).
     * Strategy: Use stacks to reverse traversal order.
     * Time: O(m+n), Space: O(m+n).
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();

            int sum = n1 + n2 + carry;
            ListNode newNode = new ListNode(sum % 10);

            // Insert at the beginning of the result list
            newNode.next = head;
            head = newNode;

            carry = sum / 10;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();
        // l1 = [7,2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode res = solution.addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
