package leet_code.Problem_267_Medium_Palindrome_Permutation_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_Backtracking {

    /**
     * Finds all palindromic permutations.
     * Uses Backtracking to generate permutations of the half-string.
     * Time: O((N/2)!), Space: O(N).
     * 
     * Tìm tất cả các hoán vị palindrome.
     * Sử dụng Quay lui để tạo các hoán vị của nửa chuỗi.
     */
    public List<String> generatePalindromes(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        // Count frequencies
        // Đếm tần suất
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Form the half string and identify the middle character
        // Tạo nửa chuỗi và xác định ký tự giữa
        List<Character> half = new ArrayList<>();
        String mid = "";
        int oddCount = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) {
                mid = String.valueOf(key);
                oddCount++;
            }

            // Add half the count to the half list
            // Thêm một nửa số lượng vào danh sách nửa chuỗi
            for (int i = 0; i < val / 2; i++) {
                half.add(key);
            }
        }

        // If more than 1 character has odd count, palindrome is impossible
        // Nếu có nhiều hơn 1 ký tự có số lượng lẻ, không thể tạo palindrome
        if (oddCount > 1) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[half.size()];

        // Sort to handle duplicates during permutation generation
        // Sắp xếp để xử lý trùng lặp trong quá trình tạo hoán vị
        Collections.sort(half);

        generate(half, mid, used, new StringBuilder(), result);

        return result;
    }

    private void generate(List<Character> half, String mid, boolean[] used, StringBuilder sb, List<String> result) {
        if (sb.length() == half.size()) {
            // Construct the full palindrome: half + mid + reverse(half)
            // Xây dựng palindrome đầy đủ: nửa + giữa + đảo ngược(nửa)
            result.add(sb.toString() + mid + sb.reverse().toString());
            // Reverse back to keep sb state correct for backtracking (though sb is local to
            // this path logic if passed by val, but here SB is mutable ref)
            // Actually, sb.reverse() modifies it in place. We MUST reverse it back!
            sb.reverse();
            return;
        }

        for (int i = 0; i < half.size(); i++) {
            // Skip used characters
            // Bỏ qua ký tự đã sử dụng
            if (used[i])
                continue;

            // Skip duplicates: if current is same as previous and previous was NOT used in
            // this current recursions step (it means it was backtracked and we are trying a
            // new branch with same val)
            // Bỏ qua trùng lặp: nếu ký tự hiện tại giống ký tự trước và ký tự trước CHƯA
            // được sử dụng
            if (i > 0 && half.get(i) == half.get(i - 1) && !used[i - 1])
                continue;

            used[i] = true;
            sb.append(half.get(i));

            generate(half, mid, used, sb, result);

            // Backtrack
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: "aabb" -> ["abba","baab"]
        System.out.println("Palindromes 1: " + solution.generatePalindromes("aabb"));

        // Test Case 2: "abc" -> []
        System.out.println("Palindromes 2: " + solution.generatePalindromes("abc"));
    }
}
