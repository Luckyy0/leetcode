package leetcode.P398_RandomPickIndex;

import java.util.Random;

public class Solution {

    /**
     * Problem 398: Random Pick Index
     * Approach: Reservoir Sampling
     * 
     * Time Complexity: O(N) per pick call
     * Space Complexity: O(N) to store the array
     */
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // Pick index i with probability 1/count
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 3 };
        Solution solution = new Solution(nums);

        // Pick 3: should be 2, 3, or 4
        System.out.println("Pick 3: " + solution.pick(3));
        System.out.println("Pick 3: " + solution.pick(3));

        // Pick 1: should be 0
        System.out.println("Pick 1: " + solution.pick(1));

        // Pick 2: should be 1
        System.out.println("Pick 2: " + solution.pick(2));
    }
}
