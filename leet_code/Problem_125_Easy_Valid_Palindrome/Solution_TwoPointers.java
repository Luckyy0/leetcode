package leet_code.Problem_125_Easy_Valid_Palindrome;

public class Solution_TwoPointers {

    /**
     * Checks if a string is a valid palindrome after filtering non-alphanumeric
     * characters and ignoring case.
     * Use two pointers for O(N) time and O(1) space.
     * 
     * Kiểm tra xem một chuỗi có phải là chuỗi đối xứng hợp lệ sau khi lọc các
     * ký tự không phải chữ và số và bỏ qua chữ hoa chữ thường.
     * Sử dụng hai con trỏ để đạt thời gian O(N) và không gian O(1).
     */
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer until it points to a letter or digit
            // Di chuyển con trỏ trái cho đến khi nó trỏ vào chữ cái hoặc chữ số
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer until it points to a letter or digit
            // Di chuyển con trỏ phải cho đến khi nó trỏ vào chữ cái hoặc chữ số
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare the characters in lowercase
            // So sánh các ký tự dưới dạng chữ thường
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move both pointers inward
            // Di chuyển cả hai con trỏ vào trong
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1: "A man, a plan, a canal: Panama"
        System.out.println("Test Case 1: " + solution.isPalindrome("A man, a plan, a canal: Panama"));
        // Expected: true

        // Test Case 2: "race a car"
        System.out.println("Test Case 2: " + solution.isPalindrome("race a car"));
        // Expected: false

        // Test Case 3: " "
        System.out.println("Test Case 3: " + solution.isPalindrome(" "));
        // Expected: true
    }
}
