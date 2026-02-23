package leet_code.Problem_28_Easy_Find_The_Index_Of_The_First_Occurrence_In_A_String;

public class Solution_SlidingWindow {

    /**
     * Finds the first occurrence of needle in haystack.
     * Uses Sliding Window (Brute Force) approach.
     * Tìm lần xuất hiện đầu tiên của needle trong haystack.
     * Sử dụng phương pháp Cửa sổ trượt (Vét cạn).
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int hLen = haystack.length();
        int nLen = needle.length();

        // Iterate through haystack where the remaining part is sufficient for needle
        // Duyệt qua haystack nơi phần còn lại đủ cho needle
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if substring matches needle
            // Kiểm tra xem chuỗi con có khớp với needle không
            boolean match = true;
            for (int j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();

        // Test Case 1
        String h1 = "sadbutsad";
        String n1 = "sad";
        System.out.println("Test Case 1: " + solution.strStr(h1, n1));
        // Expected: 0

        // Test Case 2
        String h2 = "leetcode";
        String n2 = "leeto";
        System.out.println("Test Case 2: " + solution.strStr(h2, n2));
        // Expected: -1
    }
}
