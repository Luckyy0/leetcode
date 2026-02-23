package leet_code.Problem_916_Medium_Word_Subsets;

import java.util.*;

/**
 * Problem 916: Word Subsets
 * https://leetcode.com/problems/word-subsets/
 */
public class Solution {

    /**
     * Finds all universal strings in words1.
     * Strategy: Frequency Aggregation (Merge constraints).
     * 
     * @param words1 List of candidate strings.
     * @param words2 List of required subset strings.
     * @return List of universal strings.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một chuỗi 'a' là phổ quát nếu mọi chuỗi 'b' trong words2 đều là
     *         tập con của 'a'.
     *         2. Điều này tương đương với việc tần suất xuất hiện của mỗi ký tự
     *         trong 'a'
     *         phải lớn hơn hoặc bằng tần suất tối đa của ký tự đó trong các chuỗi
     *         của words2.
     *         3. Thay vì kiểm tra từng 'a' với từng 'b', ta tính toán một mảng tần
     *         suất tổng hợp
     *         cho words2 (gọi là maxFreq).
     *         - Với mỗi ký tự 'c', maxFreq[c] = max(count(c, b) với mọi b trong
     *         words2).
     *         4. Sau đó, duyệt qua từng chuỗi 'a' trong words1. Nếu tần suất ký tự
     *         của 'a'
     *         thỏa mãn điều kiện >= maxFreq cho tất cả các ký tự, thì 'a' là phổ
     *         quát.
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];

        // Calculate the maximum frequency requirement for each character from words2
        for (String b : words2) {
            int[] freq = countFreq(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        // Check each word in words1 against the aggregated requirement
        for (String a : words1) {
            int[] freq = countFreq(a);
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(a);
            }
        }

        return result;
    }

    // Helper to count character frequencies
    private int[] countFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] w1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] w2_1 = { "e", "o" };
        System.out.println("Result: " + sol.wordSubsets(w1, w2_1)); // [facebook, google, leetcode]

        String[] w2_2 = { "l", "e" };
        System.out.println("Result: " + sol.wordSubsets(w1, w2_2)); // [apple, google, leetcode]
    }
}
