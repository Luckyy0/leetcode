package leet_code.Problem_424_Medium_Longest_Repeating_Character_Replacement;

public class Solution_SlidingWindow {

    /**
     * Finds the length of the longest repeating character replacement.
     * Uses Sliding Window approach.
     * Time: O(N), Space: O(1).
     * 
     * Tìm độ dài của chuỗi con có ký tự lặp lại dài nhất sau khi thay thế.
     * Sử dụng phương pháp Cửa sổ trượt.
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            // Update frequency of current character
            // Cập nhật tần suất của ký tự hiện tại
            maxFreq = Math.max(maxFreq, ++count[s.charAt(right) - 'A']);

            // Check if window is valid: (size - maxFreq) <= k
            // Kiểm tra xem cửa sổ có hợp lệ không: (kích thước - tần suất lớn nhất) <= k
            if ((right - left + 1) - maxFreq > k) {
                // Shrink window from left
                // Thu nhỏ cửa sổ từ bên trái
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // maxLen is the maximum size the window has reached
            // maxLen là kích thước tối đa mà cửa sổ đạt được
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();

        // Test Case 1: "ABAB", k=2 -> 4
        System.out.println("Result 1: " + solution.characterReplacement("ABAB", 2));

        // Test Case 2: "AABABBA", k=1 -> 4
        System.out.println("Result 2: " + solution.characterReplacement("AABABBA", 1));
    }
}
