package leetcode.P441_ArrangingCoins;

public class Solution {

    /**
     * Problem 441: Arranging Coins
     * Approach: Binary Search
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int arrangeCoins(int n) {
        long low = 0;
        long high = n;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sum = mid * (mid + 1) / 2;

            if (sum == n) {
                return (int) mid;
            } else if (sum < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) high;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 5 -> 2
        runTest(sol, 5, 2);

        // 8 -> 3
        runTest(sol, 8, 3);

        // 1 -> 1
        runTest(sol, 1, 1);

        // 2147483647 -> 65535
        runTest(sol, Integer.MAX_VALUE, 65535);
    }

    private static void runTest(Solution sol, int n, int expected) {
        int result = sol.arrangeCoins(n);
        System.out.println("n: " + n + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
