package leetcode.P2189_NumberOfWaysToBuildHouseOfCards;

public class Solution {
    Integer[][] memo;

    public int houseOfCards(int n) {
        // Max triangles in bottom row approximately n/3.
        // n=500 -> ~170.
        memo = new Integer[n + 1][n / 2 + 2];
        return solve(n, 0);
    }

    // rem: remaining cards
    // prev: triangles in the row ABOVE the one we are building now.
    // Wait. Logic: Top row k1, next k2 (>= k1+1)...
    // So if we build top-down:
    // Call: solve(n, 0).
    // Loop k from prev + 1.

    private int solve(int rem, int prev) {
        if (rem == 0)
            return 1;
        if (memo[rem][prev] != null)
            return memo[rem][prev];

        int count = 0;
        // Try next row having k triangles
        // k must be > prev
        // Cost: 3*k - 1

        for (int k = prev + 1;; k++) {
            int cost = 3 * k - 1;
            if (cost > rem)
                break;

            count += solve(rem - cost, k);
        }

        return memo[rem][prev] = count;
    }
}
