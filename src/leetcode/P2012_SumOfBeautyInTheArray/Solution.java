package leetcode.P2012_SumOfBeautyInTheArray;

public class Solution {
    public int sumOfBeauty(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        maxLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        int score = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > maxLeft[i - 1] && nums[i] < minRight[i + 1]) {
                score += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                score += 1;
            }
        }

        return score;
    }
}
