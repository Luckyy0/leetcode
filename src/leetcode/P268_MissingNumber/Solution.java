package leetcode.P268_MissingNumber;

public class Solution {

    /**
     * Problem 268: Missing Number
     * Approach: XOR
     * 
     * Theoretical Basis:
     * - a ^ a = 0
     * - XOR all indices and all values. The result is the missing index/value.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n;

        for (int i = 0; i < n; i++) {
            missing ^= i ^ nums[i];
        }

        return missing;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,0,1] -> 2
        runTest(solution, new int[] { 3, 0, 1 }, 2);

        // [0,1] -> 2
        runTest(solution, new int[] { 0, 1 }, 2);

        // [9,6,4,2,3,5,7,0,1] -> 8
        runTest(solution, new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }, 8);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.missingNumber(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
