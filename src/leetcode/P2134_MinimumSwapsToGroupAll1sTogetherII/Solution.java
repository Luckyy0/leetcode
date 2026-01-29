package leetcode.P2134_MinimumSwapsToGroupAll1sTogetherII;

public class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int x : nums)
            ones += x;

        if (ones == 0)
            return 0;

        int maxOnesInWindow = 0;
        int currentOnes = 0;

        // Window size 'ones'.
        // Sliding over array extended by wrapping.
        // We can just iterate 2*n, but logically window slides n times.
        // Or i from 0 to 2*n.

        for (int i = 0; i < 2 * n; i++) {
            if (nums[i % n] == 1)
                currentOnes++;

            if (i >= ones) {
                if (nums[(i - ones) % n] == 1)
                    currentOnes--;
            }

            if (i >= ones - 1) { // Window full size
                maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
            }
        }

        return ones - maxOnesInWindow;
    }
}
