package leetcode.P1569_NumberOfWaysToReorderArrayToGetSameBST;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final long MOD = 1_000_000_007;
    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Precompute combinations (Pascal's Triangle)
        combinations = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            combinations[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) ((dfs(list) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            int val = nums.get(i);
            if (val < root) {
                left.add(val);
            } else {
                right.add(val);
            }
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);

        int totalNodes = left.size() + right.size();
        long combs = combinations[totalNodes][left.size()];

        return (combs * leftWays % MOD) * rightWays % MOD;
    }
}
