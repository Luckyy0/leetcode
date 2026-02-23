package leet_code.Problem_809_Medium_Expressive_Words;

public class Solution {

    /**
     * Counts how many words can be stretched to match string s.
     * Strategy: Two pointers to compare character groups in s and word.
     * Time: O(W * S), Space: O(1).
     */
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        int n = s.length(), m = word.length();

        while (i < n && j < m) {
            // Characters must be the same
            if (s.charAt(i) != word.charAt(j))
                return false;

            char c = s.charAt(i);

            // Count length of group in s
            int cntS = 0;
            while (i < n && s.charAt(i) == c) {
                i++;
                cntS++;
            }

            // Count length of group in word
            int cntW = 0;
            while (j < m && word.charAt(j) == c) {
                j++;
                cntW++;
            }

            // Validation:
            // 1. Can't stretch if word has more chars than s
            // 2. If stretching (cntW < cntS), the final count in s must be at least 3
            if (cntW > cntS || (cntW < cntS && cntS < 3)) {
                return false;
            }
        }

        // Both strings must be processed completely
        return i == n && j == m;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "heeellooo";
        String[] w1 = { "hello", "hi", "helo" };
        System.out.println("Result 1: " + sol.expressiveWords(s1, w1)); // 1

        String s2 = "zzzzzyyyyy";
        String[] w2 = { "zzyy", "zy", "zyy" };
        System.out.println("Result 2: " + sol.expressiveWords(s2, w2)); // 3
    }
}
