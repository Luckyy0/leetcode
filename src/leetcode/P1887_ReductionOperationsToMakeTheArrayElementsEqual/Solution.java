package leetcode.P1887_ReductionOperationsToMakeTheArrayElementsEqual;

import java.util.Arrays;

public class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ops = 0;
        int steps = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                steps++;
            }
            ops += steps;
        }

        return ops;
    }
}
