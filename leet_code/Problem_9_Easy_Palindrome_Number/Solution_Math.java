package leet_code.Problem_9_Easy_Palindrome_Number;

public class Solution_Math {

    /**
     * Checks if an integer is a palindrome without converting to string.
     * Uses O(log N) Time and O(1) Space.
     * Kiểm tra xem một số nguyên có phải là số đối xứng không mà không cần chuyển
     * đổi thành chuỗi.
     * Sử dụng O(log N) Thời gian và O(1) Không gian.
     */
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes.
        // 2. Numbers ending in 0 are not palindromes unless the number is 0.
        // Các trường hợp đặc biệt:
        // 1. Số âm không phải là số đối xứng.
        // 2. Số kết thúc bằng 0 không phải là số đối xứng trừ khi số đó là 0.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;

        // Loop until we have processed half of the digits
        // Lặp cho đến khi chúng ta đã xử lý một nửa số chữ số
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is odd, we can get rid of the middle digit by
        // revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x =
        // 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to
        // itself), we can simply get rid of it.
        // Khi độ dài là lẻ, chúng ta có thể loại bỏ chữ số giữa bằng revertedNumber/10
        // Ví dụ khi đầu vào là 12321, cuối vòng lặp chúng ta có x = 12, revertedNumber
        // = 123,
        // vì chữ số giữa không quan trọng trong số đối xứng (nó luôn bằng chính nó),
        // chúng ta có thể đơn giản loại bỏ nó.
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1
        int x1 = 121;
        System.out.println("Test Case 1: " + solution.isPalindrome(x1));
        // Expected: true

        // Test Case 2
        int x2 = -121;
        System.out.println("Test Case 2: " + solution.isPalindrome(x2));
        // Expected: false

        // Test Case 3
        int x3 = 10;
        System.out.println("Test Case 3: " + solution.isPalindrome(x3));
        // Expected: false

        // Test Case 4
        int x4 = 0;
        System.out.println("Test Case 4: " + solution.isPalindrome(x4));
        // Expected: true
    }
}
