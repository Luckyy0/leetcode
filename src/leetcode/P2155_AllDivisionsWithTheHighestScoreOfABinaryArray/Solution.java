package leetcode.P2155_AllDivisionsWithTheHighestScoreOfABinaryArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        for (int x : nums)
            totalOnes += x;

        int zerosLeft = 0;
        int onesRight = totalOnes;

        int maxScore = zerosLeft + onesRight;
        List<Integer> result = new ArrayList<>();
        result.add(0);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zerosLeft++;
            } else {
                onesRight--;
            }

            int score = zerosLeft + onesRight;
            if (score > maxScore) {
                maxScore = score;
                result.clear();
                result.add(i + 1);
            } else if (score == maxScore) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
