package leetcode.P1753_MaximumScoreFromRemovingStones;

import java.util.Arrays;

public class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] nums = { a, b, c };
        Arrays.sort(nums);
        int x = nums[0];
        int y = nums[1];
        int z = nums[2];

        if (x + y <= z) {
            return x + y;
        } else {
            return (x + y + z) / 2;
        }
    }
}
