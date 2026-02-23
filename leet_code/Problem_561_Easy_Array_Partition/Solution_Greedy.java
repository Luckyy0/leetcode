package leet_code.Problem_561_Easy_Array_Partition;

import java.util.Arrays;

public class Solution_Greedy {

    /**
     * Maximizes the sum of min(ai, bi) by pairing adjacent elements in sorted
     * array.
     * Strategy: Sort and take every other element starting from index 0.
     * Time: O(N log N), Space: O(1).
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[] nums = { 1, 4, 3, 2 };
        System.out.println("Max Sum: " + solution.arrayPairSum(nums)); // 4
    }
}
