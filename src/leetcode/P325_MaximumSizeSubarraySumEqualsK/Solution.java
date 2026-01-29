package leetcode.P325_MaximumSizeSubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 325: Maximum Size Subarray Sum Equals k
     * Approach: Prefix Sum + HashMap
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<>(); // Long for sum safety
        map.put(0L, -1);

        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // we need sum - prevSum = k => prevSum = sum - k
            long target = sum - k;

            if (map.containsKey(target)) {
                maxLen = Math.max(maxLen, i - map.get(target));
            }

            // Only add if not present to keep the leftmost index (for max length)
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,-1,5,-2,3], k=3 -> 4
        runTest(solution, new int[] { 1, -1, 5, -2, 3 }, 3, 4);

        // [-2,-1,2,1], k=1 -> 2
        runTest(solution, new int[] { -2, -1, 2, 1 }, 1, 2);
    }

    private static void runTest(Solution s, int[] nums, int k, int expected) {
        int result = s.maxSubArrayLen(nums, k);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
