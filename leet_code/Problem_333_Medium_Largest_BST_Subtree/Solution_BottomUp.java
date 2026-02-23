package leet_code.Problem_333_Medium_Largest_BST_Subtree;

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

public class Solution_BottomUp {

    private class SubtreeInfo {
        boolean isBST;
        int size;
        int min;
        int max;

        SubtreeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    private int maxBSTSize = 0;

    /**
     * Finds size of largest BST subtree.
     * Uses Bottom-Up DFS.
     * Time: O(N), Space: O(H).
     * 
     * Tìm kích thước cây con BST lớn nhất.
     * Sử dụng DFS Từ dưới lên.
     */
    public int largestBSTSubtree(TreeNode root) {
        postOrder(root);
        return maxBSTSize;
    }

    private SubtreeInfo postOrder(TreeNode node) {
        if (node == null) {
            return new SubtreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        SubtreeInfo left = postOrder(node.left);
        SubtreeInfo right = postOrder(node.right);

        if (left.isBST && right.isBST && left.max < node.val && node.val < right.min) {
            int size = left.size + 1 + right.size;
            maxBSTSize = Math.max(maxBSTSize, size);

            int minVal = (node.left == null) ? node.val : left.min;
            int maxVal = (node.right == null) ? node.val : right.max;

            return new SubtreeInfo(true, size, minVal, maxVal);
        }

        return new SubtreeInfo(false, 0, 0, 0);
    }

    public static void main(String[] args) {
        Solution_BottomUp solution = new Solution_BottomUp();

        // Test Case 1: [10,5,15,1,8,null,7] -> 3
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println("Largest BST Size 1: " + solution.largestBSTSubtree(root));

        // Test Case 2: [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
        // This is a complex tree construction manually
        // Let's rely on logic correctness.
    }
}
