package leet_code.Problem_3_Medium_Longest_Substring_Without_Repeating_Characters;

public class Solution_SlidingWindow {

    /**
     * Finds the length of the longest substring without repeating characters using
     * Sliding Window.
     * Tìm độ dài của chuỗi con dài nhất không lặp lại ký tự sử dụng Cửa Sổ Trượt.
     */
    public int lengthOfLongestSubstring(String s) {
        // Handle edge case
        // Xử lý trường hợp biên
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Use integer array as a direct access table for characters (ASCII)
        // Using 256 to cover extended ASCII, just in case.
        // Sử dụng mảng số nguyên làm bảng truy cập trực tiếp cho các ký tự (ASCII)
        // Dùng 256 để bao phủ ASCII mở rộng, đề phòng.
        int[] lastSeenIndices = new int[256];

        // Initialize with -1 to indicate character not seen yet
        // Khởi tạo với -1 để chỉ ra ký tự chưa được nhìn thấy
        for (int i = 0; i < 256; i++) {
            lastSeenIndices[i] = -1;
        }

        int maxLength = 0;
        int left = 0;

        // Iterate with right pointer
        // Duyệt với con trỏ phải
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            int prevIndex = lastSeenIndices[currentChar];

            // If character was seen within the current window, move left pointer
            // Note: We check `prevIndex >= left` to ensure we don't go backwards
            // Nếu ký tự đã được thấy trong cửa sổ hiện tại, di chuyển con trỏ trái
            // Lưu ý: Chúng ta kiểm tra `prevIndex >= left` để đảm bảo không đi lùi
            if (prevIndex != -1 && prevIndex >= left) {
                left = prevIndex + 1;
            }

            // Update the last seen index of the character
            // Cập nhật chỉ số xuất hiện cuối cùng của ký tự
            lastSeenIndices[currentChar] = right;

            // Update max length
            // Cập nhật độ dài tối đa
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();

        // Test Case 1
        String s1 = "abcabcbb";
        System.out.println("Test Case 1: " + solution.lengthOfLongestSubstring(s1));
        // Expected: 3

        // Test Case 2
        String s2 = "bbbbb";
        System.out.println("Test Case 2: " + solution.lengthOfLongestSubstring(s2));
        // Expected: 1

        // Test Case 3
        String s3 = "pwwkew";
        System.out.println("Test Case 3: " + solution.lengthOfLongestSubstring(s3));
        // Expected: 3

        // Test Case 4: Edge case empty
        System.out.println("Test Case 4: " + solution.lengthOfLongestSubstring(""));
        // Expected: 0

        // Test Case 5: Space
        System.out.println("Test Case 5: " + solution.lengthOfLongestSubstring(" "));
        // Expected: 1
    }
}
