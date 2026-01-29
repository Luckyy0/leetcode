package leetcode.P1885_CountPairsInTwoArrays;

import java.util.Arrays;

public class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }

        Arrays.sort(diff);

        long count = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (diff[l] + diff[r] > 0) {
                count += (r - l);
                r--;
            } else {
                l++;
            }
        }

        return count;
    }
}
