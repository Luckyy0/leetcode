package leetcode.P477_TotalHammingDistance;

public class Solution {

    /**
     * Problem 477: Total Hamming Distance
     * Approach: Bit-by-bit contribution counting
     * 
     * Time Complexity: O(32 * N) = O(N)
     * Space Complexity: O(1)
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;

        for (int k = 0; k < 31; k++) {
            int countOne = 0;
            for (int num : nums) {
                if (((num >> k) & 1) == 1) {
                    countOne++;
                }
            }
            total += countOne * (n - countOne);
        }

        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [4,14,2] -> 6
        int[] n1 = { 4, 14, 2 };
        runTest(sol, n1, 6);

        // [4,14,4] -> 4
        int[] n2 = { 4, 14, 4 };
        runTest(sol, n2, 4);
    }

    private static void runTest(Solution sol, int[] nums, int expected) {
        int result = sol.totalHammingDistance(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
