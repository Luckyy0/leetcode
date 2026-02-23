package leet_code.Problem_70_Easy_Climbing_Stairs;

public class Solution_DP {

    /**
     * Calculates the number of ways to climb a staircase of n steps.
     * Uses optimized Dynamic Programming (space-saving Fibonacci).
     * Tính số cách leo cầu thang n bậc.
     * Sử dụng Quy hoạch động tối ưu (Fibonacci tiết kiệm không gian).
     */
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        System.out.println("Test Case 1 (n=2): " + solution.climbStairs(2));
        // Expected: 2

        // Test Case 2
        System.out.println("Test Case 2 (n=3): " + solution.climbStairs(3));
        // Expected: 3

        // Test Case 3
        System.out.println("Test Case 3 (n=4): " + solution.climbStairs(4));
        // Expected: 5
    }
}
