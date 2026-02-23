package leet_code.Problem_893_Medium_Groups_of_Special_Equivalent_Strings;

import java.util.*;

/**
 * Problem 893: Groups of Special-Equivalent Strings
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/
 */
public class Solution {

    /**
     * Counts the number of special-equivalent groups.
     * Strategy: Generate a canonical signature for each string.
     * 
     * @param words Array of strings.
     * @return Number of groups.
     * 
     *         Tóm tắt chiến lược:
     *         1. Hai chuỗi đẳng trị đặc biệt nếu tập hợp ký tự ở vị trí chẵn giống
     *         nhau
     *         VÀ tập hợp ký tự ở vị trí lẻ giống nhau.
     *         2. Với mỗi chuỗi, ta tạo một "chữ ký" bằng cách đếm số lần xuất hiện
     *         của từng ký tự ('a'-'z') tại các vị trí chẵn và lẻ riêng biệt.
     *         3. Sử dụng mảng đếm kích thước 52 (26 cho chẵn, 26 cho lẻ).
     *         4. Chuyển mảng đếm thành chuỗi (Arrays.toString) để làm khóa cho
     *         HashSet.
     *         5. Số lượng phần tử trong HashSet chính là số nhóm.
     */
    public int numSpecialEquivGroups(String[] words) {
        Set<String> seen = new HashSet<>();

        for (String s : words) {
            // Index 0-25: count for even positions
            // Index 26-51: count for odd positions
            int[] count = new int[52];

            for (int i = 0; i < s.length(); i++) {
                int charIdx = s.charAt(i) - 'a';
                if (i % 2 == 0) {
                    count[charIdx]++;
                } else {
                    count[charIdx + 26]++;
                }
            }

            // Convert the count array to a unique string key
            seen.add(Arrays.toString(count));
        }

        return seen.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] w1 = { "abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx" };
        System.out.println("Groups: " + sol.numSpecialEquivGroups(w1)); // 3

        String[] w2 = { "abc", "acb", "bac", "bca", "cab", "cba" };
        System.out.println("Groups: " + sol.numSpecialEquivGroups(w2)); // 3
    }
}
