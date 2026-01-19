package leetcode.P109_ConvertSortedListToBinarySearchTree;

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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Problem 109: Convert Sorted List to Binary Search Tree
     * Approach: Slow-Fast Pointer + Recursion
     * 
     * Theoretical Basis:
     * - Similar to Problem 108 but with linked list (no random access)
     * - Use slow-fast pointer technique to find middle element
     * - Middle becomes root, left half becomes left subtree, right half becomes
     * right subtree
     * - Slow moves 1 step, fast moves 2 steps; when fast reaches end, slow is at
     * middle
     * 
     * Time Complexity: O(N log N) - each level traverses to find middle
     * Space Complexity: O(log N) - recursion stack for balanced tree
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // Find middle and the node before middle
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now the middle node
        TreeNode root = new TreeNode(slow.val);

        // Disconnect left half from middle
        if (prev != null) {
            prev.next = null;
            root.left = sortedListToBST(head);
        }

        // Right half starts after middle
        root.right = sortedListToBST(slow.next);

        return root;
    }

    // Helper: create list from array
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

    // Helper: print inorder to verify BST property
    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Helper: calculate height
    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [-10,-3,0,5,9]
        ListNode head1 = createList(new int[] { -10, -3, 0, 5, 9 });
        TreeNode root1 = solution.sortedListToBST(head1);
        System.out.print("Inorder: ");
        printInorder(root1);
        System.out.println();
        System.out.println("Height: " + getHeight(root1));
        System.out.println("-----------------");

        // Test 2: Empty list
        TreeNode root2 = solution.sortedListToBST(null);
        System.out.println("Empty list result: " + (root2 == null ? "null" : "not null"));
        System.out.println("-----------------");

        // Test 3: Single element
        ListNode head3 = new ListNode(5);
        TreeNode root3 = solution.sortedListToBST(head3);
        System.out.print("Inorder: ");
        printInorder(root3);
        System.out.println();
        System.out.println("-----------------");
    }
}
