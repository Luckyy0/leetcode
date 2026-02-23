package leet_code.Problem_884_Easy_Uncommon_Words_from_Two_Sentences;

import java.util.*;

/**
 * Problem 884: Uncommon Words from Two Sentences
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 */
public class Solution {

    /**
     * Finds uncommon words between two sentences.
     * Strategy: Count frequencies of all words. Return words with total count 1.
     * 
     * @param s1 First sentence string.
     * @param s2 Second sentence string.
     * @return Array of uncommon words.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một từ là "không phổ biến" nếu nó xuất hiện DUY NHẤT một lần trên
     *         tổng thể cả hai câu.
     *         2. Chúng ta sử dụng một bảng băm (HashMap) để đếm số lần xuất hiện
     *         của
     *         mọi từ trong cả s1 và s2.
     *         3. Duyệt qua bảng băm: bất kỳ từ nào có giá trị đếm bằng 1 thì thêm
     *         vào danh sách kết quả.
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> count = new HashMap<>();

        // Count words from s1
        for (String w : s1.split(" ")) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        // Count words from s2
        for (String w : s2.split(" ")) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for (String w : count.keySet()) {
            if (count.get(w) == 1) {
                res.add(w);
            }
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                "Result: " + Arrays.toString(sol.uncommonFromSentences("this apple is sweet", "this apple is sour")));
        // ["sweet", "sour"] (order may vary)

        System.out.println("Result: " + Arrays.toString(sol.uncommonFromSentences("apple apple", "banana")));
        // ["banana"]
    }
}
