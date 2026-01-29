package leetcode.P1714_SumOfSpecialEvenlySpacedElementsInArray;

public class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int) Math.sqrt(n);
        int MOD = 1_000_000_007;

        // dp[stride][index]
        // Note: strides 1 to B
        int[][] dp = new int[B + 1][n];

        for (int stride = 1; stride <= B; stride++) {
            for (int i = n - 1; i >= 0; i--) {
                long val = nums[i];
                if (i + stride < n) {
                    val = (val + dp[stride][i + stride]) % MOD;
                }
                dp[stride][i] = (int) val;
            }
        }

        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int index = queries[k][0];
            int stride = queries[k][1];

            if (stride <= B) {
                result[k] = dp[stride][index];
            } else {
                long sum = 0;
                for (int i = index; i < n; i += stride) {
                    sum = (sum + nums[i]) % MOD;
                }
                result[k] = (int) sum;
            }
        }

        return result;
    }
}
