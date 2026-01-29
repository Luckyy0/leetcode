package leetcode.P2121_IntervalsBetweenIdenticalElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] result = new long[n];

        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> info : indexMap.values()) {
            int size = info.size();
            long[] prefixSum = new long[size + 1];
            for (int i = 0; i < size; i++) {
                prefixSum[i + 1] = prefixSum[i] + info.get(i);
            }

            for (int i = 0; i < size; i++) {
                long currIdx = info.get(i);

                // Left part: i elements before (indices 0 to i-1)
                // Sum (currIdx - idx_m) = i * currIdx - sum(idx_0..idx_m)
                long leftSum = (long) i * currIdx - prefixSum[i];

                // Right part: (size - 1 - i) elements after
                // Sum (idx_m - currIdx) = sum(idx_after) - (size - 1 - i) * currIdx
                long sumTotal = prefixSum[size];
                long sumBeforeAndSelf = prefixSum[i + 1];
                long sumAfter = sumTotal - sumBeforeAndSelf;

                long rightSum = sumAfter - (long) (size - 1 - i) * currIdx;

                result[(int) currIdx] = leftSum + rightSum;
            }
        }

        return result;
    }
}
