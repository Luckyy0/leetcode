package leet_code.Problem_611_Medium_Valid_Triangle_Number;

import java.util.Arrays;

public class Solution_TwoPointers {

    /**
     * Counts the number of valid triplets for a triangle.
     * Strategy: Sort and use Two Pointers.
     * Time: O(N^2), Space: O(log N).
     */
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        // Sorting is the key to reducing complexity
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        // Fix the largest side 'c' at index i
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            // Check potential 'a' and 'b' using two pointers
            while (left < right) {
                // If a + b > c, then every pair with (left...right, right) works
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right--; // Try a smaller 'b'
                } else {
                    left++; // Sum too small, need larger 'a'
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();
        int[] nums = { 2, 2, 3, 4 };
        System.out.println("Valid triangle count: " + solution.triangleNumber(nums)); // 3
    }
}
