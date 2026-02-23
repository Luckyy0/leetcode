package leet_code.Problem_87_Hard_Scramble_String;

import java.util.*;

public class Solution_Memoization {

    private Map<String, Boolean> memo = new HashMap<>();

    /**
     * Determines if s2 is a scrambled string of s1.
     * Uses recursion with memoization and frequency pruning.
     * Xác định xem s2 có phải là chuỗi xáo trộn của s1 không.
     * Sử dụng đệ quy với ghi nhớ và tỉa nhánh theo tần suất.
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;

        String key = s1 + "#" + s2;
        if (memo.containsKey(key))
            return memo.get(key);

        // Frequency check pruning
        // Tỉa nhánh kiểm tra tần suất
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                memo.put(key, false);
                return false;
            }
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: No swap (Trường hợp 1: Không tráo đổi)
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Swap (Trường hợp 2: Tráo đổi)
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Solution_Memoization solution = new Solution_Memoization();

        // Test Case 1: s1 = "great", s2 = "rgeat"
        System.out.println("Test Case 1: " + solution.isScramble("great", "rgeat"));
        // Expected: true

        // Test Case 2: s1 = "abcde", s2 = "caebd"
        solution.memo.clear();
        System.out.println("Test Case 2: " + solution.isScramble("abcde", "caebd"));
        // Expected: false

        // Test Case 3: s1 = "a", s2 = "a"
        solution.memo.clear();
        System.out.println("Test Case 3: " + solution.isScramble("a", "a"));
        // Expected: true
    }
}
