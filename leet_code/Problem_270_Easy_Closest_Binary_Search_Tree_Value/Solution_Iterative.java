package leet_code.Problem_270_Easy_Closest_Binary_Search_Tree_Value;

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

public class Solution_Iterative {

    /**
     * Finds the closest value to target in BST.
     * Uses Iterative Binary Search logic.
     * Time: O(H), Space: O(1).
     * 
     * Tìm giá trị gần nhất với target trong BST.
     * Sử dụng logic Tìm kiếm Nhị phân Lặp.
     */
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            int val = root.val;

            // Check if current val is closer than current closest
            // Comparison logic handles floating point properly with abs
            // Kiểm tra xem val hiện tại có gần hơn closest hiện tại không
            // Logic so sánh xử lý số thực đúng cách với abs
            if (Math.abs(val - target) < Math.abs(closest - target)) {
                closest = val;
            } else if (Math.abs(val - target) == Math.abs(closest - target)) {
                // OPTIONAL: If distances are equal, pick smaller value?
                // Problem doesn't specify, but often min value is preferred tie breaker.
                // Assuming arbitrary choice is fine or problem guarantees unique answer.
                // Here we simply update or not.
            }

            // Navigate
            // Điều hướng
            if (target < val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: [4,2,5,1,3], 3.714286 -> 4
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Closest 1: " + solution.closestValue(root, 3.714286));
    }
}
