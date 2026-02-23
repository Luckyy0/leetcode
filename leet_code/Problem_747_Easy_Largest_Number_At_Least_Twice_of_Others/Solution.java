package leet_code.Problem_747_Easy_Largest_Number_At_Least_Twice_of_Others;

public class Solution {

    /**
     * Finds the dominant index.
     * Strategy: Find largest and second largest numbers.
     * Time: O(N), Space: O(1).
     */
    public int dominantIndex(int[] nums) {
        int maxIndex = -1;
        int max1 = -1;
        int max2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                // Update both max1 and max2
                max2 = max1;
                max1 = nums[i];
                maxIndex = i;
            } else if (nums[i] > max2) {
                // Update only max2
                max2 = nums[i];
            }
        }

        // Check dominance condition
        if (max1 >= 2 * max2) {
            return maxIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.dominantIndex(new int[] { 3, 6, 1, 0 })); // 1
        System.out.println("Result 2: " + sol.dominantIndex(new int[] { 1, 2, 3, 4 })); // -1
    }
}
