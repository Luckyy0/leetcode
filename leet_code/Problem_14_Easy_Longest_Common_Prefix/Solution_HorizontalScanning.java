package leet_code.Problem_14_Easy_Longest_Common_Prefix;

public class Solution_HorizontalScanning {

    /**
     * Finds the longest common prefix.
     * Uses Horizontal Scanning approach.
     * Tìm tiền tố chung dài nhất.
     * Sử dụng phương pháp Quét Ngang.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initialize prefix with the first string
        // Khởi tạo tiền tố với chuỗi đầu tiên
        String prefix = strs[0];

        // Iterate through the rest of the strings
        // Duyệt qua các chuỗi còn lại
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix
            // Trong khi chuỗi hiện tại không bắt đầu bằng tiền tố
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                // Rút ngắn tiền tố đi một ký tự từ cuối
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, there is no common prefix
                // Nếu tiền tố trở nên rỗng, không có tiền tố chung
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_HorizontalScanning solution = new Solution_HorizontalScanning();

        // Test Case 1
        String[] s1 = { "flower", "flow", "flight" };
        System.out.println("Test Case 1: " + solution.longestCommonPrefix(s1));
        // Expected: "fl"

        // Test Case 2
        String[] s2 = { "dog", "racecar", "car" };
        System.out.println("Test Case 2: " + solution.longestCommonPrefix(s2));
        // Expected: ""

        // Test Case 3: Empty
        String[] s3 = {};
        System.out.println("Test Case 3: " + solution.longestCommonPrefix(s3));
        // Expected: ""
    }
}
