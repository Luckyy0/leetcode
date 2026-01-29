package leetcode.P319_BulbSwitcher;

public class Solution {

    /**
     * Problem 319: Bulb Switcher
     * Approach: Math (Count Perfect Squares)
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 3 -> 1
        runTest(solution, 3, 1);

        // 0 -> 0
        runTest(solution, 0, 0);

        // 1 -> 1
        runTest(solution, 1, 1);

        // 4 -> 2 (1, 4 are squares)
        runTest(solution, 4, 2);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.bulbSwitch(n);
        System.out.println("n: " + n + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
