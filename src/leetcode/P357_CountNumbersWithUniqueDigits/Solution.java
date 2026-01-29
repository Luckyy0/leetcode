package leetcode.P357_CountNumbersWithUniqueDigits;

public class Solution {

    /**
     * Problem 357: Count Numbers with Unique Digits
     * Approach: Combinatorics / DP
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int ans = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;

        for (int i = 2; i <= n && availableNumber > 0; i++) {
            uniqueDigits = uniqueDigits * availableNumber;
            ans += uniqueDigits;
            availableNumber--;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 2 -> 91
        runTest(solution, 2, 91);

        // 0 -> 1
        runTest(solution, 0, 1);

        // 3 -> 739
        runTest(solution, 3, 739);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.countNumbersWithUniqueDigits(n);
        System.out.println("n: " + n + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
