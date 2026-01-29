package leetcode.P334_IncreasingTripletSubsequence;

public class Solution {

    /**
     * Problem 334: Increasing Triplet Subsequence
     * Approach: Greedy (Two Pointers / Variables)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                // n > first && n > second
                // And since second is set only if there was a smaller 'first' before it
                // we have a triplet.
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,4,5] -> true
        runTest(solution, new int[] { 1, 2, 3, 4, 5 }, true);

        // [5,4,3,2,1] -> false
        runTest(solution, new int[] { 5, 4, 3, 2, 1 }, false);

        // [2,1,5,0,4,6] -> true
        // 2 -> f=2
        // 1 -> f=1
        // 5 -> s=5 (old f was 1 or 2, doesn't matter, valid seq exists ending at 5)
        // 0 -> f=0
        // 4 -> s=4 (f=0 before this, or old f=1 before this)
        // 6 -> >s(4) -> true. (0, 4, 6) or (1, 4, 6) or (2, 5, 6).
        runTest(solution, new int[] { 2, 1, 5, 0, 4, 6 }, true);
    }

    private static void runTest(Solution s, int[] nums, boolean expected) {
        boolean result = s.increasingTriplet(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
