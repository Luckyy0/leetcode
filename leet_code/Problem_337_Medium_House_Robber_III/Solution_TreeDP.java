package leet_code.Problem_337_Medium_House_Robber_III;

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

public class Solution_TreeDP {

    /**
     * Robs max money from binary tree.
     * Uses Tree DP (DFS returning 2 states).
     * Time: O(N), Space: O(H).
     * 
     * Cướp số tiền tối đa từ cây nhị phân.
     * Sử dụng DP trên Cây (DFS trả về 2 trạng thái).
     */
    public int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    // Returns [money if rob root, money if NOT rob root]
    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        // Option 1: Rob this node. Cannot rob immediate children.
        // Lựa chọn 1: Cướp nút này. Không thể cướp con trực tiếp.
        int rob = root.val + left[1] + right[1];

        // Option 2: Do not rob this node. Can rob children (or not).
        // Lựa chọn 2: Không cướp nút này. Có thể cướp con (hoặc không).
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { rob, notRob };
    }

    public static void main(String[] args) {
        Solution_TreeDP solution = new Solution_TreeDP();

        // Test Case 1: [3,2,3,null,3,null,1] -> 7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        System.out.println("Max Money 1: " + solution.rob(root1));

        // Test Case 2: [3,4,5,1,3,null,1] -> 9
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        System.out.println("Max Money 2: " + solution.rob(root2));
    }
}
