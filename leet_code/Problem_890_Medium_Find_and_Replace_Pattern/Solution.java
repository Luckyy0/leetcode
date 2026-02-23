package leet_code.Problem_890_Medium_Find_and_Replace_Pattern;

import java.util.*;

/**
 * Problem 890: Find and Replace Pattern
 * https://leetcode.com/problems/find-and-replace-pattern/
 */
public class Solution {

    /**
     * Finds words that match the pattern.
     * Strategy: Normalize strings to a canonical form and compare.
     * 
     * @param words   List of words.
     * @param pattern Pattern string.
     * @return List of matching words.
     * 
     *         Tóm tắt chiến lược:
     *         1. Hai chuỗi khớp nhau (đẳng hình) nếu chúng có cùng cấu trúc ánh xạ
     *         ký tự.
     *         2. Để kiểm tra, ta chuyển đổi mỗi chuỗi về "dạng chính tắc"
     *         (canonical form).
     *         3. Cách chuyển đổi: Gán cho ký tự xuất hiện đầu tiên một ID là 0, ký
     *         tự
     *         khác biệt thứ hai là 1, v.v. Các lần xuất hiện lặp lại sẽ dùng lại ID
     *         đã gán.
     *         Ví dụ: "abb" -> [0, 1, 1], "mee" -> [0, 1, 1].
     *         4. So sánh dạng chính tắc của mỗi từ với dạng chính tắc của pattern.
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] p = normalize(pattern);

        for (String w : words) {
            if (Arrays.equals(p, normalize(w))) {
                res.add(w);
            }
        }

        return res;
    }

    /**
     * Converts a string to its canonical integer array representation.
     */
    private int[] normalize(String s) {
        int[] res = new int[s.length()];
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int id = 0;

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (map[charIndex] == -1) {
                map[charIndex] = id++;
            }
            res[i] = map[charIndex];
        }

        return res;

        /*
         * Note on Map Implementation:
         * Using int[26] avoids object allocation overhead of HashMap<Character,
         * Integer>
         * and is faster for small alphabets.
         */
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
        String pattern = "abb";

        System.out.println("Result: " + sol.findAndReplacePattern(words, pattern));
        // [mee, aqq]
    }
}
