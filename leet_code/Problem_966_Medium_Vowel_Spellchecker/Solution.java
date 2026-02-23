package leet_code.Problem_966_Medium_Vowel_Spellchecker;

import java.util.*;

/**
 * Problem 966: Vowel Spellchecker
 * https://leetcode.com/problems/vowel-spellchecker/
 */
public class Solution {

    /**
     * Spellchecks queries against a wordlist based on capitalization and vowel
     * rules.
     * Strategy: Multi-Level Hashing.
     * 
     * @param wordlist List of correct words.
     * @param queries  List of query words.
     * @return Array of corrected words.
     * 
     *         Tóm tắt chiến lược:
     *         1. Xây dựng 3 cấu trúc dữ liệu để tra cứu nhanh:
     *         - `exactSet`: HashSet lưu các từ nguyên gốc (dùng cho khớp chính xác
     *         100%).
     *         - `capMap`: HashMap ánh xạ (lowercase -> từ gốc đầu tiên). Dùng cho
     *         khớp không phân biệt hoa thường.
     *         - `vowelMap`: HashMap ánh xạ (từ đã thay nguyên âm bằng * -> từ gốc
     *         đầu tiên). Dùng cho khớp sai nguyên âm.
     *         2. Tiền xử lý `wordlist`:
     *         - Thêm từ vào `exactSet`.
     *         - Tạo phiên bản lowercase. Nếu chưa có trong `capMap`, thêm vào (đảm
     *         bảo lấy từ xuất hiện đầu tiên).
     *         - Tạo phiên bản thay thế nguyên âm (devoweled). Nếu chưa có trong
     *         `vowelMap`, thêm vào.
     *         3. Xử lý từng `query`:
     *         - Kiểm tra `exactSet` trước. Nếu có -> trả về query gốc.
     *         - Kiểm tra `capMap` (dùng query.toLowerCase()). Nếu có -> trả về
     *         value từ map.
     *         - Kiểm tra `vowelMap` (dùng devowel(query.toLowerCase())). Nếu có ->
     *         trả về value từ map.
     *         - Nếu không -> trả về chuỗi rỗng.
     */
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>();
        Map<String, String> capMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exactSet.add(word);

            String lower = word.toLowerCase();
            // Only put if absent to preserve the first occurrence rule
            capMap.putIfAbsent(lower, word);

            String devoweled = devowel(lower);
            vowelMap.putIfAbsent(devoweled, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            // Check exact match
            if (exactSet.contains(q)) {
                result[i] = q;
                continue;
            }

            // Check capitalization match
            String lower = q.toLowerCase();
            if (capMap.containsKey(lower)) {
                result[i] = capMap.get(lower);
                continue;
            }

            // Check vowel match
            String devoweled = devowel(lower);
            if (vowelMap.containsKey(devoweled)) {
                result[i] = vowelMap.get(devoweled);
                continue;
            }

            // No match found
            result[i] = "";
        }

        return result;
    }

    // Helper to replace vowels with a placeholder '*'
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] wl1 = { "KiTe", "kite", "hare", "Hare" };
        String[] q1 = { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" };
        System.out.println("Result: " + Arrays.toString(sol.spellchecker(wl1, q1)));
        // Expected: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]

        String[] wl2 = { "yellow" };
        String[] q2 = { "YellOw" };
        System.out.println("Result: " + Arrays.toString(sol.spellchecker(wl2, q2)));
        // Expected: ["yellow"]
    }
}
