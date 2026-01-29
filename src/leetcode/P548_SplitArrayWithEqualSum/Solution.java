package leetcode.P548_SplitArrayWithEqualSum;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean splitArray(int[] nums) {
        if (nums.length < 7)
            return false;

        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // Iterate for the middle cut j
        // Lặp cho điểm cắt giữa j
        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();

            // Check left part for cut i
            // Kiểm tra phần bên trái cho điểm cắt i
            for (int i = 1; i < j - 1; i++) {
                if (prefixSum[i - 1] == prefixSum[j - 1] - prefixSum[i]) {
                    set.add(prefixSum[i - 1]);
                }
            }

            // Check right part for cut k
            // Kiểm tra phần bên phải cho điểm cắt k
            for (int k = j + 2; k < n - 1; k++) {
                if (prefixSum[k - 1] - prefixSum[j] == prefixSum[n - 1] - prefixSum[k]) {
                    if (set.contains(prefixSum[k - 1] - prefixSum[j])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
