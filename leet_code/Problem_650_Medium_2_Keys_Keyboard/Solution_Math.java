package leet_code.Problem_650_Medium_2_Keys_Keyboard;

public class Solution_Math {

    /**
     * Finds the minimum steps to get n 'A's using Copy All and Paste.
     * Strategy: The result is the sum of prime factors of n.
     * Time: O(sqrt(n)), Space: O(1).
     */
    public int minSteps(int n) {
        if (n == 1)
            return 0;

        int steps = 0;
        int divisor = 2;

        while (n > 1) {
            // Factorize n and add factors to steps
            while (n % divisor == 0) {
                steps += divisor;
                n /= divisor;
            }
            divisor++;
        }

        return steps;
    }

    public static void main(String[] args) {
        Solution_Math sol = new Solution_Math();
        System.out.println("Steps for n=3: " + sol.minSteps(3)); // 3
        System.out.println("Steps for n=9: " + sol.minSteps(9)); // 6
        System.out.println("Steps for n=1: " + sol.minSteps(1)); // 0
    }
}
