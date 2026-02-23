package leet_code.Problem_968_Hard_Binary_Tree_Cameras;

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
 * Problem 968: Binary Tree Cameras
 * https://leetcode.com/problems/binary-tree-cameras/
 */
public class Solution {

    // Global variable to count cameras
    private int cameras = 0;

    /**
     * Finds the minimum number of cameras needed.
     * Strategy: Greedy DFS (Post-order).
     * 
     * @param root Root of the tree.
     * @return Minimum cameras.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng thuật toán tham lam trên cây (Greedy DFS) theo thứ tự
     *         Post-order (dưới lên).
     *         2. Mục tiêu: Đặt camera sao cho phủ được nhiều nút nhất. Tốt nhất là
     *         camera nằm ở nút cha để phủ được cha, chính nó và con.
     *         Tránh đặt camera ở lá (vì chỉ phủ được lá và cha của lá).
     *         3. Định nghĩa 3 trạng thái cho mỗi nút:
     *         - State 0: Chưa được phủ (Not Covered). Nút này cần cha của nó đặt
     *         camera để giám sát.
     *         - State 1: Có Camera (Has Camera). Nút này có camera, nó sẽ phủ cha
     *         nó.
     *         - State 2: Đã được phủ (Covered). Nút này không có camera nhưng đã
     *         được con của nó phủ.
     *         4. Logic chuyển trạng thái (duyệt từ lá lên):
     *         - Nếu nút con trả về 0 (con chưa được phủ): BẮT BUỘC phải đặt camera
     *         tại nút hiện tại.
     *         -> Tăng `cameras`, trả về 1.
     *         - Nếu nút con trả về 1 (con có camera): Nút hiện tại đã được con phủ.
     *         -> Trả về 2.
     *         - Nếu nút con trả về 2 (con đã được phủ nhưng không có camera tại đó
     *         để giúp cha):
     *         Nút hiện tại trở thành chưa được phủ (cần cha nó giúp).
     *         -> Trả về 0.
     *         5. Lưu ý nút NULL (ảo) được coi là State 2 (Đã được phủ) để không ảnh
     *         hưởng đến thuật toán.
     *         6. Tại gốc (`root`), nếu DFS trả về 0 (gốc chưa được phủ vì không có
     *         cha), cần thêm 1 camera nữa.
     */
    public int minCameraCover(TreeNode root) {
        cameras = 0;
        // If root needs coverage (returns 0), add one more camera
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    // Returns the state of the node
    // 0: Not Covered
    // 1: Has Camera
    // 2: Covered
    private int dfs(TreeNode node) {
        if (node == null) {
            // Null nodes are considered covered and do not need cameras.
            return 2;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // Priority 1: If any child is not covered, we MUST place a camera here
        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }

        // Priority 2: If any child has a camera, this node is covered
        if (left == 1 || right == 1) {
            return 2;
        }

        // Priority 3: Children are covered (state 2) but don't provide coverage to
        // parent.
        // This node needs to be covered by its parent.
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [0,0,null,0,0]
        TreeNode r1 = new TreeNode(0);
        r1.left = new TreeNode(0);
        r1.left.left = new TreeNode(0);
        r1.left.right = new TreeNode(0);
        System.out.println("Result: " + sol.minCameraCover(r1)); // 1

        // Example 2: [0,0,null,0,null,0,null,null,0]
        TreeNode r2 = new TreeNode(0);
        r2.left = new TreeNode(0);
        r2.left.left = new TreeNode(0);
        r2.left.left.left = new TreeNode(0);
        r2.left.left.left.right = new TreeNode(0);
        System.out.println("Result: " + sol.minCameraCover(r2)); // 2
    }
}
