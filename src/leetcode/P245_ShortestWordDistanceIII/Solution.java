package leetcode.P245_ShortestWordDistanceIII;

public class Solution {

    /**
     * Problem 245: Shortest Word Distance III
     * Approach: Linear Scan with special handling for word1 == word2
     * 
     * Theoretical Basis:
     * - If words are same, just track previous occurrence.
     * - If words different, track both.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        long minDistance = Integer.MAX_VALUE; // Use long to avoid overflow logic if any
        int p1 = -1;
        int p2 = -1;
        boolean same = word1.equals(word2);

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (same) {
                    if (p1 != -1) {
                        minDistance = Math.min(minDistance, i - p1);
                    }
                    p1 = i;
                } else {
                    p1 = i;
                    if (p2 != -1) {
                        minDistance = Math.min(minDistance, p1 - p2);
                    }
                }
            } else if (wordsDict[i].equals(word2)) {
                // This block executes only if !same (because if same, it goes into first if)
                p2 = i;
                if (p1 != -1) {
                    minDistance = Math.min(minDistance, p2 - p1);
                }
            }
        }

        return (int) minDistance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words = { "practice", "makes", "perfect", "coding", "makes" };

        // "makes", "coding" -> 1
        runTest(solution, words, "makes", "coding", 1);

        // "makes", "makes" -> 3 (indices 1 and 4)
        runTest(solution, words, "makes", "makes", 3);
    }

    private static void runTest(Solution s, String[] words, String w1, String w2, int expected) {
        int result = s.shortestWordDistance(words, w1, w2);
        System.out.println("w1: " + w1 + ", w2: " + w2 + " -> Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
