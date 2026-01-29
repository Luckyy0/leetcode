package leetcode.P1871_JumpGameVII;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1')
            return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachableCount = 0;

        for (int i = 1; i < n; i++) {
            // Add new available jump source entering the window
            if (i >= minJump && dp[i - minJump]) {
                reachableCount++;
            }

            // Remove old jump source leaving the window
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachableCount--;
            }

            if (reachableCount > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}
