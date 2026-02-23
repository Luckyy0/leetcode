package leet_code.Problem_290_Easy_Word_Pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_HashMap {

    /**
     * Checks if s follows pattern.
     * Uses HashMap and HashSet to ensure bijection.
     * Time: O(N), Space: O(M) unique words.
     * 
     * Kiểm tra xem s có tuân theo pattern không.
     * Sử dụng HashMap và HashSet để đảm bảo song ánh.
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (charToWord.containsKey(c)) {
                // If char is mapped, it MUST map to the same word
                // Nếu ký tự đã được ánh xạ, nó PHẢI ánh xạ tới cùng một từ
                if (!charToWord.get(c).equals(w)) {
                    return false;
                }
            } else {
                // If char is not mapped, the word MUST NOT be used by another char
                // Nếu ký tự chưa được ánh xạ, từ KHÔNG ĐƯỢC phép bị ký tự khác sử dụng
                if (usedWords.contains(w)) {
                    return false;
                }
                charToWord.put(c, w);
                usedWords.add(w);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();

        // Test Case 1
        System.out.println("Result 1: " + solution.wordPattern("abba", "dog cat cat dog")); // true

        // Test Case 2
        System.out.println("Result 2: " + solution.wordPattern("abba", "dog cat cat fish")); // false
    }
}
