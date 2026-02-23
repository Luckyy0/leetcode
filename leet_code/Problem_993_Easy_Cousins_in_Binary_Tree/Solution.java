package leet_code.Problem_993_Easy_Cousins_in_Binary_Tree;

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
 * Problem 993: Cousins in Binary Tree
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class Solution {

    // Variables to store depth and parent information for nodes x and y
    private int xDepth = -1;
    private int yDepth = -1;
    private TreeNode xParent = null;
    private TreeNode yParent = null;

    /**
     * Determines if two nodes are cousins.
     * Strategy: DFS Traversal to find depth and parent.
     * 
     * @param root The root of the tree.
     * @param x    Value of the first node.
     * @param y    Value of the second node.
     * @return True if they are cousins, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Hai nút được gọi là "anh em họ" (cousins) khi và chỉ khi:
     *         - Chúng có CA NGAU độ sâu (depth) trong cây.
     *         - Chúng KHÁC cha mẹ (parent).
     *         2. Sử dụng thuật toán Duyệt theo chiều sâu (DFS) để tìm hai giá trị
     *         `x` và `y`.
     *         3. Truyền kèm thông tin về `node` hiện tại, `parent` của nó, và
     *         `depth` (độ sâu hiện tại).
     *         4. Khi gặp giá trị `x` hoặc `y`, lưu lại `parent` và `depth` của
     *         chúng vào các biến toàn cục (global variables).
     *         5. Sau khi quét xong cây (hoặc ít nhất là khi đã tìm thấy cả hai
     *         nút), kiểm tra 2 điều kiện `xDepth == yDepth` và `xParent !=
     *         yParent`.
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        // Reset variables directly before logic (good practice if solver instance is
        // reused)
        xDepth = -1;
        yDepth = -1;
        xParent = null;
        yParent = null;

        dfs(root, null, 0, x, y);

        // Return true if depths are same and parents are DIFFERENT
        return (xDepth == yDepth) && (xParent != yParent);
    }

    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) {
            return;
        }

        // If we found 'x', record its depth and parent
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        }
        // If we found 'y', record its depth and parent
        else if (node.val == y) {
            yDepth = depth;
            yParent = parent;
        }

        // Recurse deeper if we haven't found both
        // Optimization: stop early if both found
        if (xDepth != -1 && yDepth != -1) {
            return;
        }

        dfs(node.left, node, depth + 1, x, y);
        dfs(node.right, node, depth + 1, x, y);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example: root = [1,2,3,4], x=4, y=3 -> false
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        System.out.println("Result: " + sol.isCousins(root1, 4, 3)); // false
    }
}
