package leetcode.P365_WaterAndJugProblem;

public class Solution {

    /**
     * Problem 365: Water and Jug Problem
     * Approach: Math (GCD)
     * 
     * Time Complexity: O(log(min(x, y)))
     * Space Complexity: O(1)
     */
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 3, 5, 4 -> true
        runTest(solution, 3, 5, 4, true);

        // 2, 6, 5 -> false
        runTest(solution, 2, 6, 5, false);

        // 1, 2, 3 -> true
        runTest(solution, 1, 2, 3, true);
    }

    private static void runTest(Solution s, int x, int y, int target, boolean expected) {
        boolean result = s.canMeasureWater(x, y, target);
        System.out.println(
                "x:" + x + ", y:" + y + ", target:" + target + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
