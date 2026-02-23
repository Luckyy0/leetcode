package leet_code.Problem_818_Hard_Race_Car;

import java.util.Arrays;

public class Solution {

    /**
     * Finds the shortest sequence of instructions to reach target.
     * Strategy: Dynamic Programming.
     * Time: O(target * log(target)), Space: O(target).
     */
    public int racecar(int target) {
        // dp[i] is the minimum instructions to reach target i starting from 0, speed 1
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= target; i++) {
            // Find k such that 2^(k-1) - 1 < i <= 2^k - 1
            int k = (int) Math.ceil(Math.log(i + 1) / Math.log(2));

            // Case 1: Perfect match
            if (i == (1 << k) - 1) {
                dp[i] = k;
                continue;
            }

            // Case 2: Overstep and reverse
            // Directions: k 'A's (reach 2^k-1), 1 'R', then reach the rest (2^k-1 - i)
            dp[i] = k + 1 + dp[(1 << k) - 1 - i];

            // Case 3: Understep, reverse back, reverse again
            // Directions: k-1 'A's, 1 'R', j 'A's back, 1 'R', then reach the rest
            for (int j = 0; j < k - 1; j++) {
                int distReached = (1 << (k - 1)) - (1 << j);
                dp[i] = Math.min(dp[i], (k - 1) + 1 + j + 1 + dp[i - distReached]);
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.racecar(3)); // 2
        System.out.println("Result 2: " + sol.racecar(6)); // 5
    }
}
