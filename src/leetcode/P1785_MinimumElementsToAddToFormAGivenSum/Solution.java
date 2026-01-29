package leetcode.P1785_MinimumElementsToAddToFormAGivenSum;

public class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums)
            sum += num;

        long diff = Math.abs(goal - sum);
        // Ceiling division: (diff + limit - 1) / limit
        return (int) ((diff + limit - 1) / limit);
    }
}
