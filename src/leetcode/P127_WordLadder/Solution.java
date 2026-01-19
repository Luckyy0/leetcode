package leetcode.P127_WordLadder;

import java.util.*;

public class Solution {

    /**
     * Problem 127: Word Ladder
     * Approach: BFS
     * 
     * Theoretical Basis:
     * - Model as graph: words are nodes, edges connect words differing by 1 letter
     * - BFS guarantees shortest path in unweighted graph
     * - First time endWord is reached = shortest path found
     * - Remove visited words immediately to avoid revisiting
     * 
     * Time Complexity: O(N × L² × 26) where N = words, L = word length
     * Space Complexity: O(N × L) for visited set and queue
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // endWord must be in wordList
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1; // Number of words in sequence (including beginWord)

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();

                // Try all possible single-character transformations
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original)
                            continue;

                        chars[j] = c;
                        String newWord = new String(chars);

                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }

                    chars[j] = original;
                }
            }

            level++;
        }

        return 0; // No path found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: hit -> cog
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        runTest(solution, "hit", "cog", wordList1, 5);

        // Test 2: hit -> cog (no cog in list)
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        runTest(solution, "hit", "cog", wordList2, 0);

        // Test 3: Simple case
        List<String> wordList3 = Arrays.asList("hot");
        runTest(solution, "hit", "hot", wordList3, 2);
    }

    private static void runTest(Solution s, String beginWord, String endWord, List<String> wordList, int expected) {
        int result = s.ladderLength(beginWord, endWord, wordList);
        System.out.println("Begin: \"" + beginWord + "\", End: \"" + endWord + "\"");
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
