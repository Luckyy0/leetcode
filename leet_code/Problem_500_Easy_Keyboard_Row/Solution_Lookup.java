package leet_code.Problem_500_Easy_Keyboard_Row;

import java.util.ArrayList;
import java.util.List;

public class Solution_Lookup {

    /**
     * Filters words typable on one keyboard row.
     * Strategy: Pre-map characters to row indices. Check consistency.
     * Time: O(Total Characters), Space: O(1).
     */
    public String[] findWords(String[] words) {
        // Mapping: 26 lowercase English letters to row index (0, 1, 2)
        // Row 1: qwertyuiop
        // Row 2: asdfghjkl
        // Row 3: zxcvbnm
        int[] rows = {
                1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2
                // a b c d e f g h i j k l m n o p q r s t u v w x y z
                // Let's verify:
                // a(0): 2 (row 2) - Correct.
                // b(1): 2 (row 3) -> Index 2 (0-based correct).
                // Actually let's just map explicitly to avoid manual error.
        };

        // Safer explicit mapping
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";

        int[] map = new int[26];
        for (char c : r1.toCharArray())
            map[c - 'a'] = 1;
        for (char c : r2.toCharArray())
            map[c - 'a'] = 2;
        for (char c : r3.toCharArray())
            map[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.isEmpty())
                continue;

            int row = map[Character.toLowerCase(word.charAt(0)) - 'a'];
            boolean valid = true;

            for (int i = 1; i < word.length(); i++) {
                if (map[Character.toLowerCase(word.charAt(i)) - 'a'] != row) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution_Lookup solution = new Solution_Lookup();
        String[] words = { "Hello", "Alaska", "Dad", "Peace" };
        String[] res = solution.findWords(words);

        System.out.print("Result: [");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + (i < res.length - 1 ? ", " : ""));
        }
        System.out.println("]"); // ["Alaska", "Dad"]
    }
}
