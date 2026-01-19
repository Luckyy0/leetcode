package leetcode.P128_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 128: Longest Consecutive Sequence
     * Approach: HashSet with Sequence Start Detection
     * 
     * Theoretical Basis:
     * - HashSet gives O(1) lookup
     * - Only start counting from sequence starts (numbers where num-1 is not in
     * set)
     * - This ensures each number is processed at most twice → O(N)
     * - Sequence start = number n where n-1 is not in the set
     * 
     * Time Complexity: O(N) - each number processed at most twice
     * Space Complexity: O(N) - for HashSet
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            // Only count if this is a sequence start
            // (i.e., num-1 is not in the set)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [100,4,200,1,3,2] -> 4
        runTest(solution, new int[] { 100, 4, 200, 1, 3, 2 }, 4);

        // Test 2: [0,3,7,2,5,8,4,6,0,1] -> 9
        runTest(solution, new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }, 9);

        // Test 3: Empty array -> 0
        runTest(solution, new int[] {}, 0);

        // Test 4: Single element -> 1
        runTest(solution, new int[] { 5 }, 1);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.longestConsecutive(nums);
        System.out.println("Array length: " + nums.length);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
