package leetcode.P2148_CountElementsWithStrictlySmallerAndGreaterElements;

public class Solution {
    public int countElements(int[] nums) {
        if (nums.length == 0)
            return 0;
        int min = nums[0];
        int max = nums[0];
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int count = 0;
        for (int x : nums) {
            if (x > min && x < max) {
                count++;
            }
        }
        return count;
    }
}
