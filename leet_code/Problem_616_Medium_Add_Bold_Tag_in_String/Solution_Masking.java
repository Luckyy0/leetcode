package leet_code.Problem_616_Medium_Add_Bold_Tag_in_String;

public class Solution_Masking {

    /**
     * Adds bold tags to substrings in s that match any word in words.
     * Strategy: Use a boolean mask to mark bold positions and merge intervals.
     * Time: O(S * ΣW), Space: O(S).
     */
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] isBold = new boolean[n];

        // 1. Mark which characters should be bold
        for (String word : words) {
            int start = s.indexOf(word);
            while (start != -1) {
                for (int i = start; i < start + word.length(); i++) {
                    isBold[i] = true;
                }
                // Continue searching for the same word later in the string
                start = s.indexOf(word, start + 1);
            }
        }

        // 2. Build the result string with tags
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Check if we need to start a bold section
            if (isBold[i] && (i == 0 || !isBold[i - 1])) {
                res.append("<b>");
            }

            res.append(s.charAt(i));

            // Check if we need to end a bold section
            if (isBold[i] && (i == n - 1 || !isBold[i + 1])) {
                res.append("</b>");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution_Masking solution = new Solution_Masking();
        String s = "aaabbcc";
        String[] words = { "aaa", "aab", "bc" };
        System.out.println("Result: " + solution.addBoldTag(s, words)); // <b>aaabbc</b>c
    }
}
