package leetcode.P2122_RecoverTheOriginalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;

        // nums[0] is smallest, so it must be lower[something].
        // corresponding higher[something] is nums[0] + 2k.
        // It corresponds to some nums[i].
        // Since k > 0, nums[i] > nums[0].

        for (int i = 1; i <= n * 2 - 1; i++) { // Can optimize range, surely higher[0] is somewhere?
            int diff = nums[i] - nums[0];
            if (diff > 0 && diff % 2 == 0) {
                int k = diff / 2;
                int[] original = check(nums, k, n);
                if (original != null)
                    return original;
            }
        }
        return new int[0];
    }

    private int[] check(int[] nums, int k, int n) {
        boolean[] used = new boolean[nums.length];
        int[] res = new int[n];
        int idx = 0;
        int twoK = 2 * k;

        // two pointers
        int r = 1; // pointer to find higher

        for (int l = 0; l < nums.length; l++) {
            if (used[l])
                continue;

            if (idx == n)
                return res; // Should be handled inside logic usually

            int lowerVal = nums[l];
            int target = lowerVal + twoK;

            // Move r to find target
            if (r <= l)
                r = l + 1;
            while (r < nums.length && (used[r] || nums[r] < target)) {
                r++;
            }

            if (r < nums.length && nums[r] == target) {
                used[l] = true;
                used[r] = true;
                res[idx++] = lowerVal + k;
            } else {
                return null;
            }
        }
        return res;
    }
}
