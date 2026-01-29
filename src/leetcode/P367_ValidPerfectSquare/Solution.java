package leetcode.P367_ValidPerfectSquare;

public class Solution {

    /**
     * Problem 367: Valid Perfect Square
     * Approach: Binary Search
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public boolean isPerfectSquare(int num) {
        if (num < 1)
            return false; // Though constraint says >= 1

        long low = 1;
        long high = num; // Or high = num / 2 for num > 1?
        // sqrt(2^31) is ~46340. High can be limited to 46340 or simply use long.
        // Actually high = num is safe with long sq.

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sq = mid * mid;

            if (sq == num) {
                return true;
            } else if (sq < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 16 -> true
        runTest(solution, 16, true);

        // 14 -> false
        runTest(solution, 14, false);

        // 1 -> true
        runTest(solution, 1, true);

        // 2147483647 -> false
        runTest(solution, Integer.MAX_VALUE, false);
    }

    private static void runTest(Solution s, int num, boolean expected) {
        boolean result = s.isPerfectSquare(num);
        System.out.println("Num: " + num + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
