package leetcode.P374_GuessNumberHigherOrLower;

public class Solution {

    // Mock API
    int pick;

    private int guess(int num) {
        if (num > pick)
            return -1;
        if (num < pick)
            return 1;
        return 0;
    }

    // For testing setting pick
    public void setPick(int p) {
        this.pick = p;
    }

    /**
     * Problem 374: Guess Number Higher or Lower
     * Approach: Binary Search
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int guessNumber(int n) {
        long low = 1; // Use long to avoid overflow when calculating mid?
        // Actually mid computation with int is safe if low+(high-low)/2
        // Constraint n up to 2^31 - 1 (Integer.MAX_VALUE).
        // Using int with correct formula is fine.
        int l = 1;
        int r = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = guess(m);

            if (res == 0) {
                return m;
            } else if (res == -1) {
                // My guess (m) > pick. Pick is lower.
                r = m - 1;
            } else {
                // My guess (m) < pick. Pick is higher.
                l = m + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 10, pick 6 -> 6
        solution.setPick(6);
        runTest(solution, 10, 6);

        // 1, pick 1 -> 1
        solution.setPick(1);
        runTest(solution, 1, 1);

        // 2, pick 2 -> 2
        solution.setPick(2);
        runTest(solution, 2, 2);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.guessNumber(n);
        System.out.println("n: " + n + ", pick: " + s.pick + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
