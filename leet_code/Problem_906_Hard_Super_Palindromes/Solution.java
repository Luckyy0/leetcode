package leet_code.Problem_906_Hard_Super_Palindromes;

/**
 * Problem 906: Super Palindromes
 * https://leetcode.com/problems/super-palindromes/
 */
public class Solution {

    /**
     * Counts the number of super palindromes in the given range.
     * Strategy: Iterate through potential square roots (P) which must be
     * palindromes.
     * 
     * @param left  Lower bound string.
     * @param right Upper bound string.
     * @return Count.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một số X là siêu palindrome nếu X là palindrome và X = P^2 với P
     *         là palindrome.
     *         2. Thay vì duyệt X từ L đến R (lên tới 10^18), ta duyệt P từ 1 đến
     *         sqrt(R) (lên tới 10^9).
     *         3. Số lượng palindrome P nhỏ hơn 10^9 là khá nhỏ (khoảng 2*10^5).
     *         4. Ta tạo tất cả các palindrome P bằng cách lấy một nửa đầu (k) và
     *         phản chiếu nó.
     *         - Ví dụ k=123 -> P=12321 (lẻ) hoặc P=123321 (chẵn).
     *         5. Với mỗi P, tính X = P^2.
     *         6. Kiểm tra xem X có nằm trong đoạn [L, R] và X có phải là palindrome
     *         không.
     */
    public int superpalindromesInRange(String left, String right) {
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);
        int ans = 0;

        // Iterate through possible "seeds" to construct palindromes P
        // Since sqrt(10^18) = 10^9, P has at most 9-10 digits.
        // The seed/half part will have at most 5 digits.
        final int MAGIC = 100000;

        // Generate ODD length palindromes
        // e.g. k=12 -> 121
        for (int k = 1; k < MAGIC; k++) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int j = sb.length() - 2; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            long p = Long.parseLong(sb.toString());
            long sq = p * p;

            if (sq > R)
                break; // Optimization: sq increases as k increases
            if (sq >= L && isPalindrome(sq)) {
                ans++;
            }
        }

        // Generate EVEN length palindromes
        // e.g. k=12 -> 1221
        for (int k = 1; k < MAGIC; k++) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int j = sb.length() - 1; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            long p = Long.parseLong(sb.toString());
            long sq = p * p;

            if (sq > R)
                break;
            if (sq >= L && isPalindrome(sq)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isPalindrome(long x) {
        long original = x;
        long reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return original == reverse;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.superpalindromesInRange("4", "1000")); // 4 (4, 9, 121, 484)
        System.out.println("Result: " + sol.superpalindromesInRange("1", "2")); // 1 (1)
    }
}
