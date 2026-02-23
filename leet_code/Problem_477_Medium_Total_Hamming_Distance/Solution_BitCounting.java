package leet_code.Problem_477_Medium_Total_Hamming_Distance;

public class Solution_BitCounting {

    /**
     * Calculates the sum of Hamming distances for all pairs.
     * Strategy: Iterate through each bit position (0-31). Contribution = count(1) *
     * count(0).
     * Time: O(N), Space: O(1).
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;

        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int num : nums) {
                // Check if the i-th bit is set
                if ((num & (1 << i)) != 0) {
                    ones++;
                }
            }
            int zeros = n - ones;
            // Each 1 pairs with each 0 to contribute 1 to distance at this bit position
            total += ones * zeros;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution_BitCounting solution = new Solution_BitCounting();
        int[] nums = { 4, 14, 2 };
        System.out.println("Result: " + solution.totalHammingDistance(nums)); // 6
    }
}
