package leetcode.P1367_LinkedListInBinaryTree;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode node) {
        if (head == null)
            return true;
        if (node == null)
            return false;

        if (head.val != node.val)
            return false;

        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }
}
