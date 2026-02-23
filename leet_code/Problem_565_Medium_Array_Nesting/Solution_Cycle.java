package leet_code.Problem_565_Medium_Array_Nesting;

public class Solution_Cycle {

    /**
     * Finds the longest length of a set created by nesting index-value pairs.
     * Strategy: Detect disjoint cycles in the permutation.
     * Time: O(N), Space: O(1) by modifying array.
     */
    public int arrayNesting(int[] nums) {
        int maxLen = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Only process if not visited
            if (nums[i] != -1) {
                int count = 0;
                int current = i;

                while (nums[current] != -1) {
                    int next = nums[current];
                    nums[current] = -1; // Mark as visited
                    current = next;
                    count++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution_Cycle solution = new Solution_Cycle();
        int[] nums = { 5, 4, 0, 3, 1, 6, 2 };
        System.out.println("Max Nesting: " + solution.arrayNesting(nums)); // 4
    }
}
