package leetcode.P1671_MinimumNumberOfRemovalsToMakeMountainArray;

import java.util.Arrays;

public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lbs = new int[n]; // Longest increasing subsequence ending at i
        int[] rbs = new int[n]; // Longest decreasing subsequence starting at i

        // Compute LBS
        Arrays.fill(lbs, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lbs[i] = Math.max(lbs[i], lbs[j] + 1);
                }
            }
        }

        // Compute RBS
        Arrays.fill(rbs, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    rbs[i] = Math.max(rbs[i], rbs[j] + 1);
                }
            }
        }

        int maxMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lbs[i] > 1 && rbs[i] > 1) {
                maxMountain = Math.max(maxMountain, lbs[i] + rbs[i] - 1);
            }
        }

        return n - maxMountain;
    }
}
