package leet_code.Problem_320_Medium_Generalized_Abbreviation;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {

    /**
     * Generates all generalized abbreviations.
     * Uses Backtracking (DFS) with a count accumulator.
     * Time: O(2^N), Space: O(N).
     * 
     * Tạo tất cả các từ viết tắt tổng quát.
     * Sử dụng Quay lui (DFS) với một bộ đếm tích lũy.
     */
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        backtrack(word, 0, new StringBuilder(), 0, result);
        return result;
    }

    // pos: current index in word
    // current: string built so far
    // count: number of consecutive characters abbreviated just before this step
    private void backtrack(String word, int pos, StringBuilder current, int count, List<String> result) {
        // Base case: Reached end of word
        // Trường hợp cơ sở: Đã đến cuối từ
        if (pos == word.length()) {
            if (count > 0) {
                current.append(count);
            }
            result.add(current.toString());
            // Backtrack: Remove appended number for other branches if shared StringBuilder?
            // Actually StringBuilder is mutable. We must restore it.
            // But we appended count.
            // To simplify, let's pass String or handle easy backtracking.
            // Wait, standard backtracking with StringBuilder needs deletion.
            if (count > 0) {
                // Remove the number we just added.
                // Number length? count < 16, so 1 or 2 digits.
                int len = String.valueOf(count).length();
                current.setLength(current.length() - len);
            }
            return;
        }

        // Option 1: Abbreviate current character 'word[pos]'
        // Lựa chọn 1: Viết tắt ký tự hiện tại
        backtrack(word, pos + 1, current, count + 1, result);

        // Option 2: Keep current character
        // Lựa chọn 2: Giữ ký tự hiện tại
        // First, append any pending count
        int lenAdded = 0;
        if (count > 0) {
            current.append(count);
            lenAdded = String.valueOf(count).length();
        }
        current.append(word.charAt(pos));

        backtrack(word, pos + 1, current, 0, result);

        // Restore state
        current.setLength(current.length() - 1 - lenAdded);
    }

    // Alternative simpler recursion passing String (immutable) for cleaner code
    // given N is small
    // But StringBuilder is more efficient.

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: "word"
        System.out.println("Result 1: " + solution.generateAbbreviations("word"));

        // Test Case 2: "a"
        System.out.println("Result 2: " + solution.generateAbbreviations("a"));
    }
}
