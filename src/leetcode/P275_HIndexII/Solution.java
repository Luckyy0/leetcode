package leetcode.P275_HIndexII;

public class Solution {

    /**
     * Problem 275: H-Index II
     * Approach: Binary Search
     * 
     * Theoretical Basis:
     * - Find first index i such that citations[i] >= n - i.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = n - mid;

            if (citations[mid] >= count) {
                // Condition met, try to get even more papers (move left)
                high = mid - 1;
            } else {
                // Condition not met (value too small), need to pick fewer papers with higher
                // values (move right)
                low = mid + 1;
            }
        }

        return n - low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [0,1,3,5,6] -> 3
        runTest(solution, new int[] { 0, 1, 3, 5, 6 }, 3);

        // [1,2,100] -> 2
        runTest(solution, new int[] { 1, 2, 100 }, 2);

        // [0] -> 0
        runTest(solution, new int[] { 0 }, 0);

        // [100] -> 1
        runTest(solution, new int[] { 100 }, 1);
    }

    private static void runTest(Solution s, int[] citations, int expected) {
        int result = s.hIndex(citations);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
