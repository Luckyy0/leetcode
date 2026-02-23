package leet_code.Problem_523_Medium_Continuous_Subarray_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution_PrefixMod {

    /**
     * Checks for continuous subarray sum multiple of k.
     * Strategy: Prefix sum modulo k with HashMap tracking index.
     * Time: O(N), Space: O(min(N, K)).
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map stores <remainder, first_index>
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize with remainder 0 at index -1
        // This handles case where a subarray from index 0 is valid.
        map.put(0, -1);

        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            // Calculate modulo
            int remainder = runningSum % k;

            // Java % operator can return negative if dividend is negative.
            // Problem constraints say nums[i] >= 0, so runningSum >= 0.
            // But generally: if (remainder < 0) remainder += k;

            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                // Check if length is at least 2
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                // Only put if not exist, to keep the leftmost index (longest subarray)
                // Though here we just need ANY valid length >= 2, keeping leftmost is
                // fine/better.
                map.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_PrefixMod solution = new Solution_PrefixMod();
        int[] nums = { 23, 2, 4, 6, 7 };
        int k = 6;
        System.out.println("Result: " + solution.checkSubarraySum(nums, k)); // true
    }
}
