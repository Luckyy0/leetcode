package leetcode.P458_PoorPigs;

public class Solution {

    /**
     * Problem 458: Poor Pigs
     * Approach: Information Theory (Base-P)
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = minutesToTest / minutesToDie;
        int states = rounds + 1;

        // We need states^pigs >= buckets
        // pigs >= log(buckets) / log(states)
        return (int) Math.ceil(Math.log(buckets) / Math.log(states) - 1e-10);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 1000, 15, 60 -> rounds=4, states=5. 5^x >= 1000 => 5^4=625, 5^5=3125. Result:
        // 5.
        runTest(sol, 1000, 15, 60, 5);

        // 4, 15, 15 -> rounds=1, states=2. 2^x >= 4 => x=2. Result: 2.
        runTest(sol, 4, 15, 15, 2);
    }

    private static void runTest(Solution sol, int b, int d, int t, int expected) {
        int result = sol.poorPigs(b, d, t);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
