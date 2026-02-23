package leet_code.Problem_979_Medium_Distribute_Coins_in_Binary_Tree;

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
 * Problem 979: Distribute Coins in Binary Tree
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */
public class Solution {

    // Global variable to count moves
    private int moves = 0;

    /**
     * Calculates the minimum number of moves to distribute coins.
     * Strategy: Post-order DFS calculating Excess Flow.
     * 
     * @param root Root of the tree.
     * @return Minimum moves.
     * 
     *         Tóm tắt chiến lược:
     *         1. Số lượng đồng xu cần di chuyển qua một cạnh nối nút cha và nút con
     *         chính bằng số lượng đồng xu "thừa" hoặc "thiếu" của cây con đó.
     *         Ví dụ: Nếu một cây con có tổng cộng 5 xu và 3 nút, nó thừa 2 xu. 2 xu
     *         này bắt buộc phải đi lên qua cạnh nối với cha.
     *         Nếu nó có 1 xu và 3 nút, nó thiếu 2 xu. 2 xu này bắt buộc phải đi
     *         xuống từ cha.
     *         2. Ta sử dụng duyệt cây theo thứ tự Post-order (Con trước Cha sau).
     *         3. Hàm `dfs(node)` trả về số lượng xu thừa (`dương`) hoặc thiếu
     *         (`âm`) của cây con có gốc tại `node`.
     *         - Nếu `node == null`, trả về 0.
     *         - Gọi đệ quy cho con trái -> `L` và con phải -> `R`.
     *         - Số lần di chuyển qua cạnh trái là `abs(L)`, qua cạnh phải là
     *         `abs(R)`.
     *         Cộng dồn vào biến `moves`.
     *         - Số lượng xu thừa của nút hiện tại trả về cho cha là:
     *         `node.val` (số xu hiện có) + `L` (nhận từ trái) + `R` (nhận từ phải)
     *         - 1 (giữ lại cho chính nó).
     *         4. Trả về `moves`.
     */
    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calculate excess flow from children
        int leftExcess = dfs(node.left);
        int rightExcess = dfs(node.right);

        // Add the absolute flow (moves needed) to global count
        // abs(leftExcess) is the number of coins moving up/down the left edge
        moves += Math.abs(leftExcess) + Math.abs(rightExcess);

        // Return excess flow to parent
        // Current node needs 1 coin.
        // It has 'val' coins initially.
        // It receives 'leftExcess' and 'rightExcess'.
        // So balance is (val + left + right - 1).
        return node.val + leftExcess + rightExcess - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [3,0,0]
        TreeNode r1 = new TreeNode(3);
        r1.left = new TreeNode(0);
        r1.right = new TreeNode(0);
        System.out.println("Result: " + sol.distributeCoins(r1)); // 2

        // Example 2: [0,3,0]
        TreeNode r2 = new TreeNode(0);
        r2.left = new TreeNode(3);
        r2.right = new TreeNode(0);
        System.out.println("Result: " + sol.distributeCoins(r2)); // 3
    }
}
