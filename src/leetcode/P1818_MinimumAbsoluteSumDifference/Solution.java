package leetcode.P1818_MinimumAbsoluteSumDifference;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        long sumDiff = 0;
        int n = nums1.length;
        TreeSet<Integer> set = new TreeSet<>();

        for (int x : nums1)
            set.add(x);

        for (int i = 0; i < n; i++) {
            sumDiff += Math.abs(nums1[i] - nums2[i]);
        }

        long maxReduction = 0;

        for (int i = 0; i < n; i++) {
            int originalDiff = Math.abs(nums1[i] - nums2[i]);
            int target = nums2[i];

            // Find closest in nums1 to target
            Integer floor = set.floor(target);
            Integer ceiling = set.ceiling(target);

            if (floor != null) {
                long newDiff = Math.abs(floor - target);
                maxReduction = Math.max(maxReduction, originalDiff - newDiff);
            }
            if (ceiling != null) {
                long newDiff = Math.abs(ceiling - target);
                maxReduction = Math.max(maxReduction, originalDiff - newDiff);
            }
        }

        return (int) ((sumDiff - maxReduction) % MOD);
    }
}
