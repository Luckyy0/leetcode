package leet_code.Problem_651_Medium_4_Keys_Keyboard;

public class Solution_DP {

    /**
     * Calculates the maximum number of 'A's after n keystrokes.
     * Strategy: DP where we explore all possible "points of copy".
     * Time: O(N^2), Space: O(N).
     */
    public int maxA(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Option 1: Just press 'A'
            dp[i] = dp[i - 1] + 1;

            // Option 2: Copy from a previous state j and paste repeatedly
            // j is the number of 'A's when we hit Ctrl-A + Ctrl-C (takes 2 steps)
            // Steps used for copying/pasting: i - j
            // Number of Ctrl-Vs = (i - j) - 2
            // Total multiplier = 1 (original) + number of Ctrl-Vs = i - j - 1
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution_DP sol = new Solution_DP();
        System.out.println("Max A's for n=3: " + sol.maxA(3)); // 3
        System.out.println("Max A's for n=7: " + sol.maxA(7)); // 9
    }
}
