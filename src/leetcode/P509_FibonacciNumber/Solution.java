package leetcode.P509_FibonacciNumber;

public class Solution {

    /**
     * Problem 509: Fibonacci Number
     * Approach: Iterative with space optimization
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int fib(int n) {
        if (n <= 1)
            return n;

        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // F(2) -> 1
        System.out.println("Result F(2): " + sol.fib(2));

        // F(4) -> 3
        System.out.println("Result F(4): " + sol.fib(4));

        // F(10) -> 55
        System.out.println("Result F(10): " + sol.fib(10));
    }
}
