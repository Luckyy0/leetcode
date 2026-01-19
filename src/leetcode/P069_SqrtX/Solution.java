package leetcode.P069_SqrtX;

public class Solution {

    /**
     * Problem 69: Sqrt(x)
     * Approach: Binary Search
     * Time Complexity: O(log x)
     * Space Complexity: O(1)
     */
    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        int lo = 1;
        int hi = x;
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // Avoid overflow: instead of mid * mid <= x, check mid <= x / mid
            if (mid <= x / mid) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 4, 2);
        runTest(solution, 8, 2);
        runTest(solution, 0, 0);
        runTest(solution, 1, 1);
        runTest(solution, 2147395599, 46339); // Square of 46340 is > Integer.MAX_VALUE
    }

    private static void runTest(Solution s, int x, int expected) {
        System.out.println("Input: " + x);
        int result = s.mySqrt(x);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
