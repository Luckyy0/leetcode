package leet_code.Problem_634_Medium_Find_the_Derangement_of_An_Array;

public class Solution_DP {

    /**
     * Finds the number of derangements for n elements.
     * Strategy: DP with formula D(n) = (n-1) * (D(n-1) + D(n-2)).
     * Time: O(N), Space: O(1).
     */
    public int findDerangement(int n) {
        if (n <= 1)
            return 0;
        if (n == 2)
            return 1;

        long MOD = 1000000007;
        long d_prev2 = 0; // D(1)
        long d_prev1 = 1; // D(2)
        long current = 0;

        for (int i = 3; i <= n; i++) {
            // Formula: D(i) = (i - 1) * (D(i-1) + D(i-2))
            current = ((i - 1) * (d_prev1 + d_prev2)) % MOD;

            // Advance states
            d_prev2 = d_prev1;
            d_prev1 = current;
        }

        return (int) (n == 2 ? 1 : current);
    }

    public static void main(String[] args) {
        Solution_DP sol = new Solution_DP();
        System.out.println("Derangements for n=3: " + sol.findDerangement(3)); // 2
        System.out.println("Derangements for n=2: " + sol.findDerangement(2)); // 1
    }
}
