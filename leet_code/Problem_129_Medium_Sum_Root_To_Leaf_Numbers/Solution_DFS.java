package leet_code.Problem_129_Medium_Sum_Root_To_Leaf_Numbers;

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

    /**
     * Calculates the total sum of all root-to-leaf numbers.
     * Uses Depth-First Search (DFS) to traverse paths and accumulate values.
     * 
     * Tính tổng số của tất cả các con số từ gốc đến lá.
     * Sử dụng Tìm kiếm theo chiều sâu (DFS) để duyệt qua các đường đi và tích lũy
     * giá trị.
     */
    public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }

    private int sumHelper(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Calculate current value for this path: (Previous sum * 10) + current node val
        // Tính giá trị hiện tại cho đường đi này: (Tổng trước đó * 10) + giá trị nút
        // hiện tại
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the accumulated sum for this path
        // Nếu là nút lá, trả về tổng tích lũy cho đường đi này
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Otherwise, recurse to left and right children and return their total
        // Nếu không phải, đệ quy xuống nút con trái và phải và trả về tổng của chúng
        return sumHelper(node.left, currentSum) + sumHelper(node.right, currentSum);
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: [1,2,3] -> (12 + 13) = 25
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 1: " + solution.sumNumbers(t1));
        // Expected: 25

        // Test Case 2: [4,9,0,5,1] -> (495 + 491 + 40) = 1026
        TreeNode t2 = new TreeNode(4,
                new TreeNode(9, new TreeNode(5), new TreeNode(1)),
                new TreeNode(0));
        System.out.println("Test Case 2: " + solution.sumNumbers(t2));
        // Expected: 1026
    }
}
