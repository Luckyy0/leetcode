package leet_code.Problem_76_Hard_Minimum_Window_Substring;

import java.util.*;

public class Solution_SlidingWindow {

    /**
     * Finds the minimum window substring containing all characters of t.
     * Uses the sliding window technique with O(m + n) complexity.
     * Tìm chuỗi con cửa sổ tối thiểu chứa tất cả các ký tự của t.
     * Sử dụng kỹ thuật cửa sổ trượt với độ phức tạp O(m + n).
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        // Bản đồ tần suất cho các ký tự trong t
        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        int required = dictT.size();
        int formed = 0;

        // Map for characters in the current window
        // Bản đồ cho các ký tự trong cửa sổ hiện tại
        Map<Character, Integer> windowCounts = new HashMap<>();

        // (length, left, right)
        int[] ans = { -1, 0, 0 };

        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Contract the window while it is valid
            // Thu hẹp cửa sổ khi nó vẫn hợp lệ
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update best answer
                // Cập nhật câu trả lời tốt nhất
                int windowLen = right - left + 1;
                if (ans[0] == -1 || windowLen < ans[0]) {
                    ans[0] = windowLen;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();

        // Test Case 1
        System.out.println("Test Case 1: " + solution.minWindow("ADOBECODEBANC", "ABC"));
        // Expected: "BANC"

        // Test Case 2
        System.out.println("Test Case 2: " + solution.minWindow("a", "a"));
        // Expected: "a"

        // Test Case 3
        System.out.println("Test Case 3: " + solution.minWindow("a", "aa"));
        // Expected: ""
    }
}
