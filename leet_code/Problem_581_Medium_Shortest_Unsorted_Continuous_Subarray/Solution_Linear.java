package leet_code.Problem_581_Medium_Shortest_Unsorted_Continuous_Subarray;

public class Solution_Linear {

    /**
     * Finds the length of the shortest unsorted continuous subarray.
     * Strategy: Two-pass scan to find violating boundaries.
     * Time: O(N), Space: O(1).
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0;

        int end = -1;
        int maxSoFar = nums[0];

        // Pass 1: Find the right boundary (end)
        for (int i = 1; i < n; i++) {
            if (nums[i] < maxSoFar) {
                end = i;
            } else {
                maxSoFar = nums[i];
            }
        }

        if (end == -1)
            return 0; // Already sorted

        int start = 0;
        int minSoFar = nums[n - 1];

        // Pass 2: Find the left boundary (start)
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > minSoFar) {
                start = i;
            } else {
                minSoFar = nums[i];
            }
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        Solution_Linear solution = new Solution_Linear();
        int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
        System.out.println("Shortest unsorted length: " + solution.findUnsortedSubarray(nums)); // 5
    }
}
