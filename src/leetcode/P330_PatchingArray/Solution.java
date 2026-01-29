package leetcode.P330_PatchingArray;

public class Solution {

    /**
     * Problem 330: Patching Array
     * Approach: Greedy
     * 
     * Time Complexity: O(M + log N)
     * Space Complexity: O(1)
     */
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patches++;
            }
        }

        return patches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,3], 6 -> 1
        runTest(solution, new int[] { 1, 3 }, 6, 1);

        // [1,5,10], 20 -> 2
        runTest(solution, new int[] { 1, 5, 10 }, 20, 2);

        // [1,2,2], 5 -> 0
        runTest(solution, new int[] { 1, 2, 2 }, 5, 0);
    }

    private static void runTest(Solution s, int[] nums, int n, int expected) {
        int result = s.minPatches(nums, n);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
