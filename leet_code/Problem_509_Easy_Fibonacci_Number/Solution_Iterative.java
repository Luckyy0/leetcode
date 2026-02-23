package leet_code.Problem_509_Easy_Fibonacci_Number;

public class Solution_Iterative {

    /**
     * Calculates F(n).
     * Strategy: Iterative space optimized DP.
     * Time: O(N), Space: O(1).
     */
    public int fib(int n) {
        if (n <= 1)
            return n;

        int a = 0; // F(0)
        int b = 1; // F(1)

        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();
        System.out.println("Result 2: " + solution.fib(2)); // 1
        System.out.println("Result 4: " + solution.fib(4)); // 3
    }
}
