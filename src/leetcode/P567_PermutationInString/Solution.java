package leetcode.P567_PermutationInString;

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Initialize counts for first window
        // Khởi tạo số đếm cho cửa sổ đầu tiên
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Slide the window
        // Trượt cửa sổ
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(count1, count2))
                return true;

            // Move window right: remove out-going char, add in-coming char
            // Di chuyển cửa sổ sang phải: xóa ký tự đi ra, thêm ký tự đi vào
            count2[s2.charAt(i) - 'a']--;
            count2[s2.charAt(i + s1.length()) - 'a']++;
        }

        // Check last window
        // Kiểm tra cửa sổ cuối cùng
        return matches(count1, count2);
    }

    private boolean matches(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }
}
