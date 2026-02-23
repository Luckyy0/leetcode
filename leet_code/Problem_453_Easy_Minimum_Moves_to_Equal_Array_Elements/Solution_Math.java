package leet_code.Problem_453_Easy_Minimum_Moves_to_Equal_Array_Elements;

public class Solution_Math {

    /**
     * Finds min moves to make all elements equal.
     * Incrementing n-1 is equivalent to decrementing 1.
     * Moves = Sum(nums[i] - min).
     * Time: O(N), Space: O(1).
     */
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int min = nums[0];
        long sum = 0;

        for (int num : nums) {
            sum += num;
            if (num < min)
                min = num;
        }

        // Final moves = Sum - n * min
        return (int) (sum - (long) nums.length * min);
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        int[] nums = { 1, 2, 3 };
        System.out.println("Result: " + solution.minMoves(nums)); // 3
    }
}
