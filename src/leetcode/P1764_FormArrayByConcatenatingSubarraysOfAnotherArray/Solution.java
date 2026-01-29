package leetcode.P1764_FormArrayByConcatenatingSubarraysOfAnotherArray;

public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int idx = 0;
        int n = nums.length;

        for (int[] group : groups) {
            boolean found = false;
            // Try to find group starting at i >= idx
            for (int i = idx; i <= n - group.length; i++) {
                if (matches(nums, i, group)) {
                    idx = i + group.length;
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }

        return true;
    }

    private boolean matches(int[] nums, int start, int[] group) {
        for (int i = 0; i < group.length; i++) {
            if (nums[start + i] != group[i])
                return false;
        }
        return true;
    }
}
