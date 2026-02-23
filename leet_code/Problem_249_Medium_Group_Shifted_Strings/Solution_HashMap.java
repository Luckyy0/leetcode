package leet_code.Problem_249_Medium_Group_Shifted_Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Groups strings that belong to the same shifting sequence.
     * Uses normalization (shifting first char to 'a') to generate keys.
     * Time: O(N * L), Space: O(N * L).
     * 
     * Nhóm các chuỗi thuộc cùng một chuỗi dịch chuyển.
     * Sử dụng chuẩn hóa (dịch chuyển ký tự đầu về 'a') để tạo khóa.
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = generateKey(s);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Generates a canonical key by shifting the string so it starts with 'a'
    // Tạo khóa chính tắc bằng cách dịch chuyển chuỗi sao cho nó bắt đầu bằng 'a'
    private String generateKey(String s) {
        char[] chars = s.toCharArray();
        // Calculate offset to make the first character 'a'
        // Tính toán độ lệch để biến ký tự đầu tiên thành 'a'
        int offset = chars[0] - 'a';

        for (int i = 0; i < chars.length; i++) {
            // Shift char by offset, handle wrapping
            // Dịch chuyển ký tự theo độ lệch, xử lý quay vòng
            char original = chars[i];
            char shifted = (char) (original - offset);

            if (shifted < 'a') {
                shifted += 26;
            }
            chars[i] = shifted;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1
        String[] s1 = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
        List<List<String>> res1 = solution.groupStrings(s1);
        System.out.println("Groups 1: " + res1);

        // Test Case 2
        String[] s2 = { "a" };
        List<List<String>> res2 = solution.groupStrings(s2);
        System.out.println("Groups 2: " + res2);
    }
}
