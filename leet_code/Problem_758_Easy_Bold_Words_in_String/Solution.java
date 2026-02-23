package leet_code.Problem_758_Easy_Bold_Words_in_String;

public class Solution {

    /**
     * Bolds the occurrences of words in s.
     * Strategy: Boolean masking.
     * Time: O(W * N * L), Space: O(N).
     */
    public String boldWords(String[] words, String s) {
        int n = s.length();
        boolean[] isBold = new boolean[n];

        // Mark bold indices
        for (String word : words) {
            int start = 0;
            // Find all occurrences
            while ((start = s.indexOf(word, start)) != -1) {
                for (int i = start; i < start + word.length(); i++) {
                    isBold[i] = true;
                }
                // Move forward by 1 to find overlapping occurrences like "aaa" in "aaaa"
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Start of a bold segment
            if (isBold[i] && (i == 0 || !isBold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            // End of a bold segment
            if (isBold[i] && (i == n - 1 || !isBold[i + 1])) {
                sb.append("</b>");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = { "ab", "bc" };
        String s = "aabcd";
        System.out.println("Result 1: " + sol.boldWords(words, s));
        // a<b>abc</b>d

        String[] words2 = { "e", "f" };
        String s2 = "aefb";
        System.out.println("Result 2: " + sol.boldWords(words2, s2));
        // a<b>ef</b>b
    }
}
