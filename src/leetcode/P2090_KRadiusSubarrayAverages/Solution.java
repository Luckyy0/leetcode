package leetcode.P2090_KRadiusSubarrayAverages;

import java.util.Arrays;

public class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        long windowSum = 0;
        int windowSize = 2 * k + 1;

        if (n < windowSize)
            return res;

        for (int i = 0; i < n; i++) {
            windowSum += nums[i];

            if (i >= windowSize - 1) {
                // Determine center index
                int center = i - k;
                res[center] = (int) (windowSum / windowSize);

                // Remove left element
                windowSum -= nums[i - windowSize + 1];
            }
        }

        return res;
    }
}
