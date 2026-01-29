package leetcode.P687_LongestUnivaluePath;

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

class Solution {
    int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLen;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int arrowLeft = 0, arrowRight = 0;

        // If node matches child, extend the path length
        // Nếu nút khớp với con, hãy kéo dài độ dài đường đi
        if (node.left != null && node.left.val == node.val) {
            arrowLeft = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight = right + 1;
        }

        // Update global max using combined left and right paths
        // Cập nhật max toàn cục bằng cách kết hợp các đường đi trái và phải
        maxLen = Math.max(maxLen, arrowLeft + arrowRight);

        // Return the best single branch to be used by parent
        // Trả về nhánh đơn tốt nhất để nút cha sử dụng
        return Math.max(arrowLeft, arrowRight);
    }
}
