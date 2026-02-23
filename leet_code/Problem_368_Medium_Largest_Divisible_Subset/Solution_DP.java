package leet_code.Problem_368_Medium_Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_DP {

    /**
     * Finds the largest divisible subset.
     * Uses DP (Similar to LIS).
     * Time: O(N^2), Space: O(N).
     * 
     * Tìm tập con chia hết lớn nhất.
     * Sử dụng Quy hoạch động (Tương tự LIS).
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 0;
        int maxIdx = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        // Reconstruct subset
        List<Integer> result = new ArrayList<>();
        while (maxIdx != -1) {
            result.add(0, nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [1,2,3] -> [1,2] or [1,3]
        System.out.println("Result 1: " + solution.largestDivisibleSubset(new int[] { 1, 2, 3 }));

        // Test Case 2: [1,2,4,8] -> [1,2,4,8]
        System.out.println("Result 2: " + solution.largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));
    }
}
