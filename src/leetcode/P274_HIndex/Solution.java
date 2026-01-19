package leetcode.P274_HIndex;

public class Solution {

    /**
     * Problem 274: H-Index
     * Approach: Bucket Sort (Counting Sort)
     * 
     * Theoretical Basis:
     * - H-Index bounded by N.
     * - Use count array to find max k where count(papers >= k) >= k.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,0,6,1,5] -> 3 (3 papers >= 3: 3,6,5)
        runTest(solution, new int[] { 3, 0, 6, 1, 5 }, 3);

        // [1,3,1] -> 1 (1 paper >= 1: 3. Wait. 1,3,1. 3 papers >= 1. Yes. 1 works.
        // Try 2? papers >= 2: Only '3'. Count 1. 1 < 2. No. Max is 1.)
        runTest(solution, new int[] { 1, 3, 1 }, 1);

        // [100] -> 1
        runTest(solution, new int[] { 100 }, 1);

        // [0] -> 0
        runTest(solution, new int[] { 0 }, 0);
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
