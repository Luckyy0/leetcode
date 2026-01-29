package leetcode.P1477_FindTwoNonOverlappingSubArraysEachWithTargetSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // best[i] stores min length of subarray with sum target in arr[0...i]
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        Map<Integer, Integer> map = new HashMap<>(); // prefix -> index
        map.put(0, -1);
        int sum = 0;
        int minSumLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);

            if (map.containsKey(sum - target)) {
                int startIdx = map.get(sum - target);
                int len = i - startIdx;

                // Check if we can form a pair
                // Pair needs to end at or before startIdx.
                // startIdx is index BEFORE the actual subarray starts.
                // Actual subarray is (startIdx+1 ... i).
                // So previous subarray must end at startIdx.
                if (startIdx != -1 && best[startIdx] != Integer.MAX_VALUE) {
                    minSumLen = Math.min(minSumLen, len + best[startIdx]);
                }

                // Update best[i]
                int prevBest = (i > 0) ? best[i - 1] : Integer.MAX_VALUE;
                best[i] = Math.min(prevBest, len);
            } else {
                best[i] = (i > 0) ? best[i - 1] : Integer.MAX_VALUE;
            }
        }

        return minSumLen == Integer.MAX_VALUE ? -1 : minSumLen;
    }
}
