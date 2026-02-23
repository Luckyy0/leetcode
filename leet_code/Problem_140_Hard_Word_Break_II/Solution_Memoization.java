package leet_code.Problem_140_Hard_Word_Break_II;

import java.util.*;

public class Solution_Memoization {

    // Global memo map to store results for substrings
    // Bản đồ ghi nhớ toàn cục để lưu trữ kết quả cho các chuỗi con
    private Map<String, List<String>> memo = new HashMap<>();

    /**
     * Constructs all possible sentences from a string using a dictionary.
     * Uses backtracking with memoization for efficiency.
     * 
     * Xây dựng tất cả các câu khả thi từ một chuỗi bằng cách sử dụng từ điển.
     * Sử dụng quay lui với ghi nhớ để đạt hiệu quả cao.
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return backtrack(s, dict);
    }

    private List<String> backtrack(String s, Set<String> dict) {
        // If s is empty, return a list containing an empty string
        // Nếu s rỗng, trả về một danh sách chứa chuỗi rỗng
        if (s.isEmpty()) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        // Return cached result if exist
        // Trả về kết quả đã lưu trong bộ nhớ nếu có
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> res = new ArrayList<>();

        // Try every possible prefix
        // Thử mọi tiền tố có thể
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if (dict.contains(prefix)) {
                // Recursively find solutions for the suffix
                // Tìm kiếm đệ quy các giải pháp cho hậu tố
                List<String> subSolutions = backtrack(s.substring(i), dict);

                for (String sub : subSolutions) {
                    // Combine prefix and sub-solutions
                    // Kết hợp tiền tố và các giải pháp con
                    String sentence = prefix + (sub.isEmpty() ? "" : " " + sub);
                    res.add(sentence);
                }
            }
        }

        // Cache the result for this substring
        // Lưu kết quả của chuỗi con này vào bộ nhớ tạm
        memo.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        Solution_Memoization solution = new Solution_Memoization();

        // Test Case 1: catsanddog
        List<String> d1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println("Test Case 1: " + solution.wordBreak("catsanddog", d1));
        // Expected: [cat sand dog, cats and dog]

        // Test Case 2: pineapplepenapple
        solution.memo.clear(); // Clear memo for fresh run
        List<String> d2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println("Test Case 2: " + solution.wordBreak("pineapplepenapple", d2));
        // Expected: [pine apple pen apple, pine applepen apple, pineapple pen apple]
    }
}
