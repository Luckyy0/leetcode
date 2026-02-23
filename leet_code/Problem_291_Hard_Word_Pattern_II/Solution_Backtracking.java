package leet_code.Problem_291_Hard_Word_Pattern_II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_Backtracking {

    /**
     * Checks if s matches pattern.
     * Uses Backtracking to try all possible mappings.
     * Time: Exponential, Space: O(M) recursion depth.
     * 
     * Kiểm tra xem s có khớp với pattern không.
     * Sử dụng Quay lui để thử tất cả các ánh xạ có thể.
     */
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return backtrack(pattern, 0, s, 0, map, set);
    }

    private boolean backtrack(String pattern, int pIdx, String s, int sIdx,
            Map<Character, String> map, Set<String> set) {
        // Base case: both reach end
        // Trường hợp cơ sở: cả hai đều đến cuối
        if (pIdx == pattern.length() && sIdx == s.length()) {
            return true;
        }
        // If one finishes but not other, false
        // Nếu một cái kết thúc nhưng cái kia thì không, sai
        if (pIdx == pattern.length() || sIdx == s.length()) {
            return false;
        }

        char c = pattern.charAt(pIdx);

        // If char is already mapped
        // Nếu ký tự đã được ánh xạ
        if (map.containsKey(c)) {
            String w = map.get(c);

            // Check if s starts with w at sIdx
            // Kiểm tra xem s có bắt đầu bằng w tại sIdx không
            if (!s.startsWith(w, sIdx)) {
                return false;
            }

            // Continue matching
            // Tiếp tục khớp
            return backtrack(pattern, pIdx + 1, s, sIdx + w.length(), map, set);
        } else {
            // Char is not mapped, try to map it to a substring starting at sIdx
            // Ký tự chưa được ánh xạ, thử ánh xạ nó với một chuỗi con bắt đầu tại sIdx
            for (int k = sIdx + 1; k <= s.length(); k++) {
                String newWord = s.substring(sIdx, k);

                // Bijection check: value must not be used by other char
                // Kiểm tra song ánh: giá trị không được phép bị ký tự khác sử dụng
                if (set.contains(newWord)) {
                    continue;
                }

                // Track state
                // Theo dõi trạng thái
                map.put(c, newWord);
                set.add(newWord);

                if (backtrack(pattern, pIdx + 1, s, k, map, set)) {
                    return true;
                }

                // Backtrack
                // Quay lui
                map.remove(c);
                set.remove(newWord);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: "abab", "redblueredblue" -> true
        System.out.println("Match 1: " + solution.wordPatternMatch("abab", "redblueredblue"));

        // Test Case 2: "aabb", "xyzabcxzyabc" -> false
        System.out.println("Match 2: " + solution.wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
}
