package leet_code.Problem_338_Easy_Counting_Bits;

public class Solution_DP {

    /**
     * Counts bits for numbers 0 to n.
     * Uses DP relation: f[i] = f[i >> 1] + (i & 1).
     * Time: O(N), Space: O(1) (excluding output).
     * 
     * Đếm bit cho các số từ 0 đến n.
     * Sử dụng quan hệ DP: f[i] = f[i >> 1] + (i & 1).
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // i >> 1 is i/2.
            // i & 1 is the last bit (1 if odd, 0 if even).
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: 2
        int[] r1 = solution.countBits(2);
        System.out.print("Result 1: ");
        for (int x : r1)
            System.out.print(x + " ");
        System.out.println();

        // Test Case 2: 5
        int[] r2 = solution.countBits(5);
        System.out.print("Result 2: ");
        for (int x : r2)
            System.out.print(x + " ");
        System.out.println();
    }
}
