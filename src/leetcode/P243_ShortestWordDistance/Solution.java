package leetcode.P243_ShortestWordDistance;

public class Solution {

    /**
     * Problem 243: Shortest Word Distance
     * Approach: One pass linear scan
     * 
     * Theoretical Basis:
     * - Track last seen positions of word1 and word2.
     * - Update min distance whenever one is found.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                i1 = i;
                if (i2 != -1) {
                    minDistance = Math.min(minDistance, i1 - i2);
                }
            } else if (wordsDict[i].equals(word2)) {
                i2 = i;
                if (i1 != -1) {
                    minDistance = Math.min(minDistance, i2 - i1);
                }
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["practice", "makes", "perfect", "coding", "makes"]
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };

        // "coding", "practice" -> 3 (3 - 0)
        runTest(solution, words, "coding", "practice", 3);

        // "makes", "coding" -> 1 (3 - 4 or 1 - 3? no, indices are 1 and 4. coding is 3.
        // |1-3|=2. |4-3|=1.)
        runTest(solution, words, "makes", "coding", 1);
    }

    private static void runTest(Solution s, String[] words, String w1, String w2, int expected) {
        int result = s.shortestDistance(words, w1, w2);
        System.out.println("w1: " + w1 + ", w2: " + w2 + " -> Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
