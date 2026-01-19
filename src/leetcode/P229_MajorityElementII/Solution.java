package leetcode.P229_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 229: Majority Element II
     * Approach: Boyer-Moore Voting Algorithm (Extended for n/3)
     * 
     * Theoretical Basis:
     * - Track 2 potentially winning candidates.
     * - Verify their counts at the end.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        // Phase 1: Candidate Selection
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Verification
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (candidate1 != null && num == candidate1)
                count1++;
            if (candidate2 != null && num == candidate2)
                count2++;
        }

        int n = nums.length;
        if (count1 > n / 3)
            result.add(candidate1);
        if (count2 > n / 3)
            result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,2,3] -> [3]
        runTest(solution, new int[] { 3, 2, 3 });

        // [1] -> [1]
        runTest(solution, new int[] { 1 });

        // [1,2] -> [1,2] (n=2, n/3=0. counts are 1. 1>0 ok)
        runTest(solution, new int[] { 1, 2 });

        // [1,1,1,3,3,2,2,2]
        // n=8, n/3=2. Needs > 2 (i.e. 3).
        // 1: 3, 2: 3, 3: 2. Result: [1, 2]
        runTest(solution, new int[] { 1, 1, 1, 3, 3, 2, 2, 2 });
    }

    private static void runTest(Solution s, int[] nums) {
        List<Integer> result = s.majorityElement(nums);
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
