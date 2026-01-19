package leetcode.P264_UglyNumberII;

public class Solution {

    /**
     * Problem 264: Ugly Number II
     * Approach: Dynamic Programming with Three Pointers
     * 
     * Theoretical Basis:
     * - Merge three sorted lists: (1*2, 2*2, 3*2...), (1*3, 2*3...), (1*5...)
     * - Use pointers to track current position in each conceptual list.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {
            int factor2 = ugly[p2] * 2;
            int factor3 = ugly[p3] * 3;
            int factor5 = ugly[p5] * 5;

            int min = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = min;

            // Advance pointers (using separate if's to handle duplicates like 6=2*3=3*2)
            if (min == factor2)
                p2++;
            if (min == factor3)
                p3++;
            if (min == factor5)
                p5++;
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 10 -> 12
        runTest(solution, 10, 12);

        // 1 -> 1
        runTest(solution, 1, 1);

        // 11 -> 15 (Series: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15)
        runTest(solution, 11, 15);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.nthUglyNumber(n);
        System.out.println("n=" + n + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
