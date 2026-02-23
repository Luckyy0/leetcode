package leet_code.Problem_276_Medium_Paint_Fence;

public class Solution_DP {

    /**
     * Calculates the number of ways to paint the fence.
     * Uses Dynamic Programming with O(1) space.
     * Time: O(N), Space: O(1).
     * 
     * Tính số cách sơn hàng rào.
     * Sử dụng Quy hoạch động với không gian O(1).
     */
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        if (n == 2)
            return k * k;

        int prev2 = k; // Ways for 1 post
        int prev1 = k * k; // Ways for 2 posts
        int current = 0;

        for (int i = 3; i <= n; i++) {
            // Recurrence: total[i] = (k - 1) * (total[i-1] + total[i-2])
            // Công thức truy hồi: total[i] = (k - 1) * (total[i-1] + total[i-2])
            current = (k - 1) * (prev1 + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: n=3, k=2 -> 6
        System.out.println("Ways 1: " + solution.numWays(3, 2));

        // Test Case 2: n=7, k=2 -> 42
        System.out.println("Ways 2: " + solution.numWays(7, 2));
    }
}
