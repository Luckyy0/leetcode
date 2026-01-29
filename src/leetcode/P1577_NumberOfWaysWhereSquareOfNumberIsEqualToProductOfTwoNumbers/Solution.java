package leetcode.P1577_NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return countPairs(nums1, nums2) + countPairs(nums2, nums1);
    }

    private int countPairs(int[] targets, int[] sources) {
        Map<Long, Integer> productFreq = new HashMap<>();
        int n = sources.length;

        // Calculate all pair products from sources
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long prod = (long) sources[i] * sources[j];
                productFreq.put(prod, productFreq.getOrDefault(prod, 0) + 1);
            }
        }

        int count = 0;
        // Check squares of targets
        for (int val : targets) {
            long square = (long) val * val;
            if (productFreq.containsKey(square)) {
                count += productFreq.get(square);
            }
        }

        return count;
    }
}
