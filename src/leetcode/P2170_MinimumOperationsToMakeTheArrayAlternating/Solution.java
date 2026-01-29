package leetcode.P2170_MinimumOperationsToMakeTheArrayAlternating;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumOperations(int[] nums) {
        if (nums.length <= 1)
            return 0;

        Map<Integer, Integer> evenFreq = new HashMap<>();
        Map<Integer, Integer> oddFreq = new HashMap<>();

        int n = nums.length;
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenFreq.put(nums[i], evenFreq.getOrDefault(nums[i], 0) + 1);
                evenCount++;
            } else {
                oddFreq.put(nums[i], oddFreq.getOrDefault(nums[i], 0) + 1);
                oddCount++;
            }
        }

        int[] topEven = getTop2(evenFreq);
        int[] topOdd = getTop2(oddFreq);

        // top[0] is count, top[1] is val
        // Actually we need Val and Count.
        // Let's store [Val, Count].

        // topEven: [[Val1, Count1], [Val2, Count2]]

        int[][] e = getTopK(evenFreq);
        int[][] o = getTopK(oddFreq);

        if (e[0][0] != o[0][0]) {
            // Best even and Best odd are different numbers
            return n - (e[0][1] + o[0][1]);
        } else {
            // Conflict
            // Option 1: Keep e[0], pick o[1]
            int keep1 = e[0][1] + o[1][1];
            // Option 2: Keep o[0], pick e[1]
            int keep2 = o[0][1] + e[1][1];

            return n - Math.max(keep1, keep2);
        }
    }

    private int[][] getTopK(Map<Integer, Integer> map) {
        // Returns top 2 [Val, Count]
        // If map empty or size 1, pad with [0, 0]
        int bestVal = 0, bestCount = 0;
        int secondVal = 0, secondCount = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            if (count > bestCount) {
                secondCount = bestCount;
                secondVal = bestVal;
                bestCount = count;
                bestVal = val;
            } else if (count > secondCount) {
                secondCount = count;
                secondVal = val;
            }
        }

        return new int[][] { { bestVal, bestCount }, { secondVal, secondCount } };
    }
}
