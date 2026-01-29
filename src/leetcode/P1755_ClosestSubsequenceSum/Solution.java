package leetcode.P1755_ClosestSubsequenceSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();

        generateSums(nums, 0, mid, 0, leftSums);
        generateSums(nums, mid, n, 0, rightSums);

        Collections.sort(rightSums);

        int minDiff = Integer.MAX_VALUE;

        for (int s : leftSums) {
            int target = goal - s;

            // Binary search in rightSums for closest to target
            int idx = Collections.binarySearch(rightSums, target);
            if (idx >= 0)
                return 0; // Found exact match

            int insertPoint = -(idx + 1);

            if (insertPoint < rightSums.size()) {
                minDiff = Math.min(minDiff, Math.abs(goal - (s + rightSums.get(insertPoint))));
            }
            if (insertPoint > 0) {
                minDiff = Math.min(minDiff, Math.abs(goal - (s + rightSums.get(insertPoint - 1))));
            }
        }

        return minDiff;
    }

    private void generateSums(int[] nums, int start, int end, int currentSum, List<Integer> sums) {
        if (start == end) {
            sums.add(currentSum);
            return;
        }

        generateSums(nums, start + 1, end, currentSum, sums);
        generateSums(nums, start + 1, end, currentSum + nums[start], sums);
    }
}
