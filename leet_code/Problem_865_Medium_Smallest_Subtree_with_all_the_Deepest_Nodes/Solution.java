package leet_code.Problem_865_Medium_Smallest_Subtree_with_all_the_Deepest_Nodes;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
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
 * Problem 865: Smallest Subtree with all the Deepest Nodes
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class Solution {

    /**
     * Helper class to return both depth and the local candidate node.
     */
    private class Result {
        int depth;
        TreeNode node;

        Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    /**
     * Finds the smallest subtree containing all deepest nodes.
     * Strategy: Post-order traversal to calculate depth and find LCA.
     * 
     * @param root The root of the tree.
     * @return The root of the smallest subtree.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta dùng đệ quy để tính độ sâu của hai phía trái và phải.
     *         1. Nếu độ sâu trái == phải: Nút hiện tại là tổ tiên chung thấp nhất
     *         của
     *         các nút sâu nhất trong nhánh này.
     *         2. Nếu một bên sâu hơn: Nút tổ tiên cần tìm nằm ở bên sâu hơn đó.
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(0, null);
        }

        Result left = dfs(node.left);
        Result right = dfs(node.right);

        // If left and right subtrees have the same maximum depth,
        // then current node is the candidate for LCA.
        if (left.depth == right.depth) {
            return new Result(left.depth + 1, node);
        }
        // Otherwise, the candidate is in the deeper subtree.
        else if (left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        } else {
            return new Result(right.depth + 1, right.node);
        }
    }
}
