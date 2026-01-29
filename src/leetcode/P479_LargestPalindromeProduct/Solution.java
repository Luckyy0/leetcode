package leetcode.P479_LargestPalindromeProduct;

public class Solution {

    /**
     * Problem 479: Largest Palindrome Product
     * Approach: Palindrome Generation + Factor Check
     * 
     * Time Complexity: O(10^N) in practice
     * Space Complexity: O(1)
     */
    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;

        long upper = (long) Math.pow(10, n) - 1;
        long lower = (long) Math.pow(10, n - 1);

        for (long left = upper; left >= lower; left--) {
            long palindrome = createPalindrome(left);

            // Check if palindrome can be factored into two n-digit numbers
            for (long f = upper; f * f >= palindrome; f--) {
                if (palindrome % f == 0) {
                    long other = palindrome / f;
                    if (other >= lower && other <= upper) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }

        return -1;
    }

    private long createPalindrome(long left) {
        String s = String.valueOf(left);
        String rev = new StringBuilder(s).reverse().toString();
        return Long.parseLong(s + rev);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // n=2 -> 987 (99 * 91 = 9009, 9009 % 1337 = 987)
        System.out.println("Result: " + sol.largestPalindrome(2) + " (Expected: 987)");

        // n=1 -> 9
        System.out.println("Result: " + sol.largestPalindrome(1) + " (Expected: 9)");

        // n=3 -> 123
        // 993 * 913 = 906609. 906609 % 1337 = 123.
        System.out.println("Result: " + sol.largestPalindrome(3) + " (Expected: 123)");
    }
}
