package leetcode.P414_ThirdMaximumNumber;

public class Solution {

    /**
     * Problem 414: Third Maximum Number
     * Approach: Constant Space Tracking (Three Variables)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int thirdMax(int[] nums) {
        Long first = null;
        Long second = null;
        Long third = null;

        for (int n : nums) {
            long current = (long) n;

            // Skip if already tracked
            if ((first != null && current == first) ||
                    (second != null && current == second) ||
                    (third != null && current == third)) {
                continue;
            }

            if (first == null || current > first) {
                third = second;
                second = first;
                first = current;
            } else if (second == null || current > second) {
                third = second;
                second = current;
            } else if (third == null || current > third) {
                third = current;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,2,1] -> 1
        runTest(solution, new int[] { 3, 2, 1 }, 1);

        // [1,2] -> 2
        runTest(solution, new int[] { 1, 2 }, 2);

        // [2,2,3,1] -> 1
        runTest(solution, new int[] { 2, 2, 3, 1 }, 1);

        // [Integer.MIN_VALUE]
        runTest(solution, new int[] { Integer.MIN_VALUE }, Integer.MIN_VALUE);
    }

    private static void runTest(Solution sol, int[] nums, int expected) {
        int result = sol.thirdMax(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
