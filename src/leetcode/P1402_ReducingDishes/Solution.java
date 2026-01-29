package leetcode.P1402_ReducingDishes;

import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        // Process from largest to smallest (end to start)
        int suffixSum = 0;
        int res = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (suffixSum + satisfaction[i] > 0) {
                suffixSum += satisfaction[i];
                res += suffixSum;
            } else {
                break;
            }
        }

        return res;
    }
}
