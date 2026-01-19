package leetcode.P068_TextJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 68: Text Justification
     * Approach: Greedy & Simulation
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int lineStart = i;
            int lineLength = words[i].length();
            i++;

            // Try to add more words to the line
            while (i < n && lineLength + 1 + words[i].length() <= maxWidth) {
                lineLength += 1 + words[i].length();
                i++;
            }

            int lineEnd = i - 1;
            int numWords = lineEnd - lineStart + 1;
            StringBuilder sb = new StringBuilder();

            // Case 1: Last line or Single word -> Left Justified
            if (i == n || numWords == 1) {
                for (int j = lineStart; j <= lineEnd; j++) {
                    sb.append(words[j]);
                    if (j < lineEnd) {
                        sb.append(" ");
                    }
                }
                // Fill remainder with spaces
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Case 2: Middle line with multiple words -> Fully Justified
                int totalSpaces = maxWidth - (lineLength - (numWords - 1)); // total - chars
                int gaps = numWords - 1;
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int j = lineStart; j <= lineEnd; j++) {
                    sb.append(words[j]);
                    if (j < lineEnd) {
                        int spacesToApply = spacePerGap + (extraSpaces > 0 ? 1 : 0);
                        extraSpaces--;
                        for (int k = 0; k < spacesToApply; k++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words1 = { "This", "is", "an", "example", "of", "text", "justification." };
        runTest(solution, words1, 16);

        String[] words2 = { "What", "must", "be", "acknowledgment", "shall", "be" };
        runTest(solution, words2, 16);
    }

    private static void runTest(Solution s, String[] words, int maxWidth) {
        System.out.println("MaxWidth: " + maxWidth);
        List<String> result = s.fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
        System.out.println("-----------------");
    }
}
