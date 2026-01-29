package leetcode.P1968_ArrayWithElementsNotEqualToAverageOfNeighbors;

import java.util.Arrays;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[n];

        int l = 0, r = (n + 1) / 2; // Split point
        // If n=5, r=3. Left [0,1,2], Right [3,4].

        int idx = 0;
        // Interleave: S, L, S, L
        // Left part is Small, Right part is Large.
        // Actually to ensure L > S neighbours, we should put Small at 0, 2, 4... and
        // Large at 1, 3...
        // Wait, Small elements are [0...mid]. Large [mid+1...n-1].
        // 0 -> res[0]
        // mid -> res[1] (Large)
        // 1 -> res[2]
        // mid+1 -> res[3]

        // Correct logic:
        int i = 0; // Small ptr
        int j = (n + 1) / 2; // Large ptr. For n=5, j=3. Elements at 0,1,2 are small. 3,4 large.

        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                // Even index: put small
                res[k] = nums[i++];
            } else {
                // Odd index: put large
                res[k] = nums[j++];
            }
        }

        return res;
    }
}
