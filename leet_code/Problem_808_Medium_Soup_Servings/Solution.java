package leet_code.Problem_808_Medium_Soup_Servings;

public class Solution {

    // Memoization table
    private double[][] memo = new double[201][201];

    /**
     * Calculates the probability that soup A finishes first or at the same time as
     * B.
     * Strategy: Scaling (divide by 25) + Memoized DP + Threshold check.
     * Time: O(1) effectively (capped at 200x200), Space: O(1).
     */
    public double soupServings(int n) {
        // As n increases, soup A is much more likely to empty first
        // because it is consumed at an average rate of 2.5 per operation
        // compared to soup B's 1.5.
        if (n >= 5000) {
            return 1.0;
        }

        // Scale n to chunks of 25ml
        int N = (n + 24) / 25;

        return solve(N, N);
    }

    private double solve(int a, int b) {
        // Base cases
        if (a <= 0 && b <= 0)
            return 0.5; // Finished together
        if (a <= 0)
            return 1.0; // A finished first
        if (b <= 0)
            return 0.0; // B finished first (A still has some)

        if (memo[a][b] > 0)
            return memo[a][b];

        // Equal probability for 4 operations: (100-0), (75-25), (50-50), (25-75)
        // Scaled by 25: (4-0), (3-1), (2-2), (1-3)
        double res = 0.25 * (solve(a - 4, b) +
                solve(a - 3, b - 1) +
                solve(a - 2, b - 2) +
                solve(a - 1, b - 3));

        return memo[a][b] = res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.soupServings(50)); // 0.625
        System.out.println("Result 2: " + sol.soupServings(100)); // 0.71875
        System.out.println("Result 3: " + sol.soupServings(10 ^ 9)); // 1.0
    }
}
