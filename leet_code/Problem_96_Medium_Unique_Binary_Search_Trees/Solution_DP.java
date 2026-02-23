package leet_code.Problem_96_Medium_Unique_Binary_Search_Trees;

public class Solution_DP {

    /**
     * Calculates the number of structurally unique BSTs with n nodes.
     * Uses Dynamic Programming (Catalan numbers logic).
     * Tính số lượng các BST có cấu trúc duy nhất với n nút.
     * Sử dụng Quy hoạch động (logic số Catalan).
     */
    public int numTrees(int n) {
        // dp[i] will store the number of unique BSTs with i nodes
        // dp[i] sẽ lưu trữ số lượng BST duy nhất với i nút
        int[] dp = new int[n + 1];

        // Base cases
        // Các trường hợp cơ sở
        dp[0] = 1; // Empty tree
        dp[1] = 1; // Tree with one node

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // j node is the root
                // j-1 nodes are in the left subtree
                // i-j nodes are in the right subtree
                // Nút j là gốc
                // j-1 nút nằm trong cây con bên trái
                // i-j nút nằm trong cây con bên phải
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: n = 3
        System.out.println("Test Case 1 (n=3): " + solution.numTrees(3));
        // Expected: 5

        // Test Case 2: n = 1
        System.out.println("Test Case 2 (n=1): " + solution.numTrees(1));
        // Expected: 1
    }
}
