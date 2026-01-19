package leetcode.P169_MajorityElement;

public class Solution {

    /**
     * Problem 169: Majority Element
     * Approach: Boyer-Moore Voting Algorithm
     * 
     * Theoretical Basis:
     * - The majority element appears more than N/2 times.
     * - In a sequence of votes, the majority will always remain after
     * cancellations.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,2,3] -> 3
        runTest(solution, new int[] { 3, 2, 3 }, 3);

        // [2,2,1,1,1,2,2] -> 2
        runTest(solution, new int[] { 2, 2, 1, 1, 1, 2, 2 }, 2);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.majorityElement(nums);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
