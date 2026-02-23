package leet_code.Problem_124_Hard_Binary_Tree_Maximum_Path_Sum;

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
    private int maxSum;

    /**
     * Finds the maximum path sum in a binary tree.
     * The path can start and end anywhere.
     * 
     * Tìm tổng đường đi tối đa trong một cây nhị phân.
     * Đường đi có thể bắt đầu và kết thúc ở bất cứ đâu.
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculateGain(root);
        return maxSum;
    }

    /**
     * Helper function that calculates the maximum gain a node can contribute
     * to its parent, while updating the global maxSum for any "arch" path.
     * 
     * Hàm bổ trợ tính toán lợi nhuận tối đa mà một nút có thể đóng góp
     * cho cha của nó, đồng thời cập nhật maxSum toàn cục cho bất kỳ đường đi "vòm"
     * nào.
     */
    private int calculateGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recurse on children. If gain is negative, treat it as 0.
        // Đệ quy trên các con. Nếu lợi nhuận âm, coi như bằng 0.
        int leftGain = Math.max(calculateGain(node.left), 0);
        int rightGain = Math.max(calculateGain(node.right), 0);

        // The current node as the "highest" point (arch) of a path
        // Nút hiện tại là điểm "cao nhất" (vòm) của một đường đi
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global max
        // Cập nhật giá trị tối đa toàn cục
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the max gain current node can give to its parent
        // (Must only choose ONE branch)
        // Trả về lợi nhuận tối đa nút hiện tại có thể cung cấp cho cha của nó
        // (Chỉ được chọn MỘT nhánh)
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: [1,2,3] -> Max is 6
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 1: " + solution.maxPathSum(t1));

        // Test Case 2: [-10,9,20,null,null,15,7] -> Max is 42
        TreeNode t2 = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test Case 2: " + solution.maxPathSum(t2));
    }
}
