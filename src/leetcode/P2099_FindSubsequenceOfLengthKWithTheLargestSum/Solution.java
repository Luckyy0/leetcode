package leetcode.P2099_FindSubsequenceOfLengthKWithTheLargestSum;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort by value descending
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        // Take top k
        int[][] topK = Arrays.copyOf(pairs, k);

        // Sort by index ascending to restore order
        Arrays.sort(topK, (a, b) -> Integer.compare(a[1], b[1]));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK[i][0];
        }
        return res;
    }
}
