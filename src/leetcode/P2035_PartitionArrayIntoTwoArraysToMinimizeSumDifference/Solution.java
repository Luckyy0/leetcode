package leetcode.P2035_PartitionArrayIntoTwoArraysToMinimizeSumDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int x : nums)
            totalSum += x;

        List<Integer>[] leftSums = generateSums(Arrays.copyOfRange(nums, 0, n));
        List<Integer>[] rightSums = generateSums(Arrays.copyOfRange(nums, n, 2 * n));

        for (List<Integer> list : rightSums) {
            Collections.sort(list);
        }

        int minDiff = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> left = leftSums[k];
            List<Integer> right = rightSums[n - k];

            for (int lVal : left) {
                int target = (totalSum / 2) - lVal; // Approximation of S/2 - lVal
                // We want R_val s.t. lVal + R_val ~ S/2.
                // Binary search for Closest in right

                int idx = Collections.binarySearch(right, target);
                if (idx < 0)
                    idx = -idx - 1;

                if (idx < right.size()) {
                    int rVal = right.get(idx);
                    int sumA = lVal + rVal;
                    int sumB = totalSum - sumA;
                    minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
                }
                if (idx > 0) {
                    int rVal = right.get(idx - 1);
                    int sumA = lVal + rVal;
                    int sumB = totalSum - sumA;
                    minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
                }
            }
        }

        return minDiff;
    }

    private List<Integer>[] generateSums(int[] arr) {
        int n = arr.length;
        List<Integer>[] sums = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            sums[i] = new ArrayList<>();

        // Iterate masks
        for (int mask = 0; mask < (1 << n); mask++) {
            int currentSum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    currentSum += arr[i];
                    count++;
                }
            }
            sums[count].add(currentSum);
        }
        return sums;
    }
}
