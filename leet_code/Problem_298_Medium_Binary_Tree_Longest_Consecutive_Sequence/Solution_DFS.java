package leet_code.Problem_298_Medium_Binary_Tree_Longest_Consecutive_Sequence;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution_DFS {

    private int maxLength = 0;

    /**
     * Finds the longest consecutive sequence path.
     * Uses Top-Down DFS.
     * Time: O(N), Space: O(H).
     * 
     * Tìm đường dẫn chuỗi liên tiếp dài nhất.
     * Sử dụng DFS Từ trên xuống.
     */
    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, root.val, 0); // initial count 0, will become 1 inside
        return maxLength;
    }

    private void dfs(TreeNode node, int parentVal, int currentLength) {
        if (node == null) {
            return;
        }

        // Check continuity
        // Kiểm tra tính liên tục
        if (node.val == parentVal + 1) {
            currentLength++;
        } else {
            currentLength = 1;
        }

        maxLength = Math.max(maxLength, currentLength);

        dfs(node.left, node.val, currentLength);
        dfs(node.right, node.val, currentLength);
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: 1->3->4->5. Longest 3-4-5 (3)
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        System.out.println("Longest 1: " + solution.longestConsecutive(root));
    }
}
