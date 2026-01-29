package leetcode.P1340_JumpGameV;

class Solution {
    int[] dp;
    int n;
    int[] arr;
    int d;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        this.n = arr.length;
        dp = new int[n];

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(i));
        }
        return result;
    }

    private int dfs(int i) {
        if (dp[i] != 0)
            return dp[i];

        int max = 0;

        // Right
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if (arr[j] >= arr[i])
                break; // Blocked
            max = Math.max(max, dfs(j));
        }

        // Left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i])
                break; // Blocked
            max = Math.max(max, dfs(j));
        }

        dp[i] = 1 + max;
        return dp[i];
    }
}
