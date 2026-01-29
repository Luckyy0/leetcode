package leetcode.P1224_MaximumEqualFrequency;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(); // num -> freq
        Map<Integer, Integer> freqCount = new HashMap<>(); // freq -> count of occurrences of this freq
        int maxFreq = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            // Decrement old freq count
            int oldC = count.getOrDefault(x, 0);
            if (oldC > 0) {
                freqCount.put(oldC, freqCount.get(oldC) - 1);
            }

            // Increment new freq
            int newC = oldC + 1;
            count.put(x, newC);
            freqCount.put(newC, freqCount.getOrDefault(newC, 0) + 1);
            maxFreq = Math.max(maxFreq, newC);

            boolean ok = false;
            // Case 1: Max freq 1 (1, 2, 3, 4, 5) -> remove any one, rest freq 1 or empty.
            // Correct.
            if (maxFreq == 1)
                ok = true;
            // Case 2: One maxFreq, rest maxFreq-1. (e.g. 2,2, 3,3, 4,4,4). Remove 4 -> all
            // freq 2.
            else if (freqCount.get(maxFreq) * maxFreq + freqCount.getOrDefault(maxFreq - 1, 0) * (maxFreq - 1) == i + 1
                    && freqCount.get(maxFreq) == 1)
                ok = true;
            // Case 3: All maxFreq, plus one single element separate (freq 1). (e.g. 2,2,
            // 3,3, 5). Remove 5 -> all freq 2.
            else if (freqCount.get(maxFreq) * maxFreq + 1 == i + 1 && freqCount.get(1) == 1)
                ok = true;

            if (ok)
                res = i + 1;
        }

        return res;
    }
}
