package leetcode.P368_LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 368: Largest Divisible Subset
     * Approach: Sorting + DP (LIS Variant)
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums); // O(N log N)
        int n = nums.length;

        int[] dp = new int[n]; // dp[i] = length of largest subset ending at i
        int[] prev = new int[n]; // prev[i] = index of previous element in subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int maxIdx = 0;

        // DP: O(N^2)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If nums[i] is divisible by nums[j] (since sorted, nums[i] >= nums[j])
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        // Reconstruct path
        List<Integer> result = new ArrayList<>();
        int curr = maxIdx;
        while (curr != -1) {
            result.add(nums[curr]);
            curr = prev[curr];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3] -> [1,2] or [1,3]
        runTest(solution, new int[] { 1, 2, 3 });

        // [1,2,4,8] -> [1,2,4,8]
        runTest(solution, new int[] { 1, 2, 4, 8 });
    }

    private static void runTest(Solution s, int[] nums) {
        List<Integer> result = s.largestDivisibleSubset(nums);
        System.out.println("Input: " + Arrays.toString(nums) + " -> Result: " + result);

        // Validation logic
        boolean valid = true;
        if (result.isEmpty() && nums.length > 0)
            valid = false; // Should return at least 1 element
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                int a = result.get(i);
                int b = result.get(j);
                if (a % b != 0 && b % a != 0) {
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
