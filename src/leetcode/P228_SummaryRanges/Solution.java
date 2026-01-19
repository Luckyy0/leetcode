package leetcode.P228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 228: Summary Ranges
     * Approach: Linear Scan
     * 
     * Theoretical Basis:
     * - Since sorted, adjacent numbers (diff == 1) belong to same range.
     * - Break range when diff > 1.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // Check if we reached the end or found a gap
            // Using logic: if i == length OR nums[i] != nums[i-1] + 1
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // Range ended at i-1
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }

                // Start new range
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [0,1,2,4,5,7] -> ["0->2","4->5","7"]
        runTest(solution, new int[] { 0, 1, 2, 4, 5, 7 });

        // [0,2,3,4,6,8,9] -> ["0","2->4","6","8->9"]
        runTest(solution, new int[] { 0, 2, 3, 4, 6, 8, 9 });

        // [] -> []
        runTest(solution, new int[] {});
    }

    private static void runTest(Solution s, int[] nums) {
        List<String> result = s.summaryRanges(nums);
        System.out.print("Input: [");
        if (nums.length > 0) {
            for (int i = 0; i < Math.min(nums.length, 5); i++)
                System.out.print(nums[i] + (i < nums.length - 1 || nums.length > 5 ? "," : ""));
            if (nums.length > 5)
                System.out.print("...");
        }
        System.out.println("]");
        System.out.println("Output: " + result);
        System.out.println("-----------------");
    }
}
