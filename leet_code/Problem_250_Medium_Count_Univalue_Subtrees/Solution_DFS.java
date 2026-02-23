package leet_code.Problem_250_Medium_Count_Univalue_Subtrees;

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

public class Solution_DFS {

    private int count = 0;

    /**
     * Counts the number of uni-value subtrees.
     * Uses Bottom-Up DFS.
     * Time: O(N), Space: O(H).
     * 
     * Đếm số lượng cây con đơn trị.
     * Sử dụng DFS từ dưới lên.
     */
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        isUnival(root);
        return count;
    }

    // Returns true if the subtree rooted at 'node' is uni-value
    // Trả về true nếu cây con có gốc tại 'node' là đơn trị
    private boolean isUnival(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean left = isUnival(node.left);
        boolean right = isUnival(node.right);

        // If both children are uni-value subtrees
        // Nếu cả hai con đều là cây con đơn trị
        if (left && right) {
            // Check if values match
            // Kiểm tra xem giá trị có khớp không
            if (node.left != null && node.left.val != node.val) {
                return false;
            }
            if (node.right != null && node.right.val != node.val) {
                return false;
            }

            // If we reached here, this node itself forms a uni-value subtree
            // Nếu đến đây, nút này tự tạo thành một cây con đơn trị
            count++;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: [5,1,5,5,5,null,5] -> 4
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println("Count 1: " + solution.countUnivalSubtrees(root));
    }
}
