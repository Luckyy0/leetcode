package leet_code.Problem_625_Medium_Minimum_Factorization;

public class Solution_Greedy {

    /**
     * Finds the smallest positive integer b whose digit multiplication equals a.
     * Strategy: Greedy factorization from 9 down to 2.
     * Time: O(log a), Space: O(1).
     */
    public int solution(int a) {
        // Special case for single digit input
        if (a < 2)
            return a;

        long res = 0;
        long multiplier = 1;

        // Try to find factors from 9 down to 2 (greedy)
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                // Add the digit to the result in correct positional order
                res = i * multiplier + res;
                multiplier *= 10;
                a /= i;
            }
        }

        // If a is not 1, it means it has prime factors > 7
        if (a > 1)
            return 0;

        // Check if the result fits in 32-bit integer
        return res > Integer.MAX_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        Solution_Greedy sol = new Solution_Greedy();
        System.out.println("Result for 48: " + sol.solution(48)); // 68
        System.out.println("Result for 15: " + sol.solution(15)); // 35
    }
}
