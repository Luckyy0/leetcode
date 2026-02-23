package leet_code.Problem_866_Medium_Prime_Palindrome;

/**
 * Problem 866: Prime Palindrome
 * https://leetcode.com/problems/prime-palindrome/
 */
public class Solution {

    /**
     * Finds the smallest prime palindrome >= n.
     * Strategy: Generate palindromes of odd lengths and check for primality.
     * 
     * @param n Starting integer.
     * @return Smallest prime palindrome.
     * 
     *         Tóm tắt chiến lược:
     *         1. Hầu hết các số đối xứng có số chữ số chẵn đều chia hết cho 11 (trừ
     *         số 11).
     *         2. Do đó, chúng ta chỉ cần tạo ra các số đối xứng có số chữ số lẻ và
     *         số 11 (trường hợp đặc biệt).
     *         3. Việc tạo số đối xứng từ một "gốc" (nửa đầu) hiệu quả hơn việc kiểm
     *         tra
     *         từng số.
     */
    public int primePalindrome(int n) {
        // Special case: handled separately because all other even-length
        // palindromes are divisible by 11.
        if (8 <= n && n <= 11)
            return 11;

        // Search for odd-length palindromes (1, 3, 5, 7, 9 positions)
        // Root i goes from 1 to 100,000 to generate palindromes up to 10^9
        for (int i = 1; i < 100000; i++) {
            // Generate odd-length palindrome from root i
            // e.g., i=123 -> palindrome = 123 + "21" = 12321
            int p = generatePalindrome(i);

            if (p >= n && isPrime(p)) {
                return p;
            }
        }

        return -1;
    }

    /**
     * Generates an odd-length palindrome using root as the first half and middle
     * digit.
     * Example: 123 -> 12321
     */
    private int generatePalindrome(int root) {
        int res = root;
        int temp = root / 10;
        while (temp > 0) {
            res = res * 10 + (temp % 10);
            temp /= 10;
        }
        return res;
    }

    private boolean isPrime(int x) {
        if (x < 2)
            return false;
        if (x % 2 == 0)
            return x == 2;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.primePalindrome(6)); // 7
        System.out.println("Result: " + sol.primePalindrome(8)); // 11
        System.out.println("Result: " + sol.primePalindrome(13)); // 101
    }
}
