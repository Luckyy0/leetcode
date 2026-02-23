package leet_code.Problem_222_Medium_Count_Complete_Tree_Nodes;

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

public class Solution_BinarySearch {

    /**
     * Counts nodes in a complete binary tree.
     * Uses the property of complete trees to skip counting full subtrees.
     * Time: O(log^2 N), Space: O(log N).
     * 
     * Đếm số nút trong cây nhị phân hoàn chỉnh.
     * Sử dụng tính chất của cây hoàn chỉnh để bỏ qua việc đếm các cây con đầy đủ.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            // Left subtree is a full binary tree of height leftDepth.
            // Nodes = (2^leftDepth - 1) + 1 (root) + countNodes(right)
            // = 2^leftDepth + countNodes(right)
            // (1 << leftDepth) represents 2^leftDepth
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // Right subtree is a full binary tree of height rightDepth.
            // Nodes = (2^rightDepth - 1) + 1 (root) + countNodes(left)
            // = 2^rightDepth + countNodes(left)
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    // Helper to get depth of the leftmost path
    // Hàm bổ trợ để lấy chiều cao của đường đi bên trái nhất
    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();

        // Test Case 1: [1,2,3,4,5,6] -> 6
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        System.out.println("Node count 1: " + solution.countNodes(root1));

        // Test Case 2: [] -> 0
        System.out.println("Node count 2: " + solution.countNodes(null));

        // Test Case 3: [1] -> 1
        System.out.println("Node count 3: " + solution.countNodes(new TreeNode(1)));
    }
}
