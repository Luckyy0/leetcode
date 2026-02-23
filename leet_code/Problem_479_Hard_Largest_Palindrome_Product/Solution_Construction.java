package leet_code.Problem_479_Hard_Largest_Palindrome_Product;

public class Solution_Construction {

    /**
     * Finds the largest palindrome product of two n-digit numbers.
     * Strategy: Iterate left-half of palindromes in descending order and check for
     * n-digit factors.
     * Time: Efficient searching, typically much faster than brute force.
     */
    public int largestPalindrome(int n) {
        // Special case for n=1, as the loop logic expects >1 digits for the product in
        // some implementations,
        // or specifically 1-digit product is "9" (3*3 or 1*9).
        if (n == 1)
            return 9;

        int upper = (int) Math.pow(10, n) - 1;
        int lower = (int) Math.pow(10, n - 1);

        // Iterate through possible left halves of the palindrome
        // The palindrome will have 2*n digits max.
        // We start from the largest possible left half: e.g. for n=2 using 99 -> 9999.
        for (int i = upper; i >= lower; i--) {
            long palindrome = createPalindrome(i);

            // Search for factors
            // We only need to check factors j such that j*j >= palindrome roughly
            // Or simply iterate j downwards from upper.
            for (long j = upper; j * j >= palindrome; j--) {
                if (palindrome % j == 0) {
                    long factor2 = palindrome / j;
                    if (factor2 >= lower && factor2 <= upper) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }

        return -1; // Should not reach here
    }

    private long createPalindrome(int leftHalf) {
        String s = Integer.toString(leftHalf);
        String rev = new StringBuilder(s).reverse().toString();
        return Long.parseLong(s + rev);
    }

    public static void main(String[] args) {
        Solution_Construction solution = new Solution_Construction();
        System.out.println("Result (n=2): " + solution.largestPalindrome(2)); // 987 (9009 % 1337)
        System.out.println("Result (n=1): " + solution.largestPalindrome(1)); // 9
    }
}
