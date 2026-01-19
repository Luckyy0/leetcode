package leetcode.P009_PalindromeNumber;

public class Solution {

    /**
     * Problem 9: Palindrome Number
     * Approach: Revert half of the number
     * Time Complexity: O(log(x))
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindrome.
        // 2. Numbers ending with 0 are not palindrome unless the number is 0.
        // Các trường hợp đặc biệt:
        // 1. Số âm không phải là đối xứng.
        // 2. Số tận cùng bằng 0 không phải là đối xứng trừ khi số đó là 0.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        // Keep adding digits to revertedNumber until it catches up to x
        // Tiếp tục thêm các chữ số vào revertedNumber cho đến khi nó bắt kịp x
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is odd, we can get rid of the middle digit by
        // revertedNumber/10
        // Khi độ dài là lẻ, ta có thể loại bỏ chữ số ở giữa bằng revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x =
        // 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palindrome (it will always equal to
        // itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 121, true);
        runTest(solution, -121, false);
        runTest(solution, 10, false);
        runTest(solution, 0, true);
        runTest(solution, 1221, true);
        runTest(solution, 12321, true);
        runTest(solution, 123, false);
    }

    private static void runTest(Solution s, int input, boolean expected) {
        System.out.println("Input: " + input);
        boolean result = s.isPalindrome(input);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
