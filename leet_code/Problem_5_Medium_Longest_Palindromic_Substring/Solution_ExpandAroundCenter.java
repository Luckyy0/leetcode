package leet_code.Problem_5_Medium_Longest_Palindromic_Substring;

public class Solution_ExpandAroundCenter {

    // Variables to keep track of the longest palindrome found
    // Biến để theo dõi chuỗi đối xứng dài nhất được tìm thấy
    private int maxLen = 0;
    private int start = 0;

    /**
     * Finds the longest palindromic substring using Expand Around Center approach.
     * Time Complexity: O(N^2), Space Complexity: O(1).
     * Tìm chuỗi con đối xứng dài nhất sử dụng phương pháp Mở rộng Quanh Tâm.
     * Độ phức tạp thời gian: O(N^2), Độ phức tạp không gian: O(1).
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        // Reset state for new call
        // Đặt lại trạng thái cho lần gọi mới
        maxLen = 0;
        start = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            // Assume odd length, try to extend Palindrome from center i
            // Giả sử độ dài lẻ, cố gắng mở rộng Chuỗi đối xứng từ tâm i
            expandPalindrome(s, i, i);

            // Assume even length, try to extend Palindrome from center i and i+1
            // Giả sử độ dài chẵn, cố gắng mở rộng Chuỗi đối xứng từ tâm i và i+1
            expandPalindrome(s, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * Helper method to expand from the middle.
     * Hàm hỗ trợ để mở rộng từ giữa.
     */
    private void expandPalindrome(String s, int left, int right) {
        // While within bounds and characters match
        // Trong khi còn nằm trong giới hạn và các ký tự khớp nhau
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Length of the palindrome is: (right - 1) - (left + 1) + 1 = right - left - 1
        // Độ dài của chuỗi đối xứng là: (right - 1) - (left + 1) + 1 = right - left - 1
        // Note: left and right are currently at invalid positions (one step too far)
        // Lưu ý: left và right hiện đang ở vị trí không hợp lệ (đi quá một bước)
        int currentLen = right - left - 1;

        if (currentLen > maxLen) {
            maxLen = currentLen;
            start = left + 1; // Start index of the valid palindrome / Chỉ số bắt đầu của chuỗi đối xứng hợp
                              // lệ
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_ExpandAroundCenter solution = new Solution_ExpandAroundCenter();

        // Test Case 1
        String s1 = "babad";
        String r1 = solution.longestPalindrome(s1);
        System.out.println("Test Case 1: " + r1);
        // Expected: "bab" or "aba"

        // Test Case 2
        String s2 = "cbbd";
        String r2 = solution.longestPalindrome(s2);
        System.out.println("Test Case 2: " + r2);
        // Expected: "bb"

        // Test Case 3: Single char
        String s3 = "a";
        String r3 = solution.longestPalindrome(s3);
        System.out.println("Test Case 3: " + r3);
        // Expected: "a"

        // Test Case 4: Full palindrome
        String s4 = "racecar";
        String r4 = solution.longestPalindrome(s4);
        System.out.println("Test Case 4: " + r4);
        // Expected: "racecar"
    }
}
