package leetcode.P126_WordLadderII;

import java.util.*;

public class Solution {

    /**
     * Problem 126: Word Ladder II
     * Approach: BFS + DFS Backtracking
     * 
     * Theoretical Basis:
     * - Model as graph: words are nodes, edges connect words differing by 1 letter
     * - Phase 1: BFS from endWord to build distance map (shortest distance to end)
     * - Phase 2: DFS from beginWord, only follow paths where distance decreases
     * - This ensures we only explore shortest paths
     * 
     * Time Complexity: O(N × L² × 26) for BFS + O(paths × L) for DFS
     * Space Complexity: O(N × L)
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        // endWord must be in wordList
        if (!wordSet.contains(endWord)) {
            return result;
        }

        // BFS from endWord to build distance map
        Map<String, Integer> distance = new HashMap<>();
        distance.put(endWord, 0);

        Queue<String> queue = new LinkedList<>();
        queue.offer(endWord);

        // Add beginWord to wordSet for neighbor finding
        wordSet.add(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int dist = distance.get(word);

            for (String neighbor : getNeighbors(word, wordSet)) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, dist + 1);
                    queue.offer(neighbor);
                }
            }
        }

        // If beginWord is not reachable
        if (!distance.containsKey(beginWord)) {
            return result;
        }

        // DFS from beginWord to collect all shortest paths
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, wordSet, distance, path, result);

        return result;
    }

    private void dfs(String word, String endWord, Set<String> wordSet,
            Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        if (word.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        int currDist = distance.get(word);

        for (String neighbor : getNeighbors(word, wordSet)) {
            // Only follow edges that decrease distance (move closer to endWord)
            if (distance.containsKey(neighbor) && distance.get(neighbor) == currDist - 1) {
                path.add(neighbor);
                dfs(neighbor, endWord, wordSet, distance, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != original) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) {
                        neighbors.add(newWord);
                    }
                }
            }
            chars[i] = original;
        }

        return neighbors;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: hit -> cog
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> result1 = solution.findLadders("hit", "cog", wordList1);
        System.out.println("Test 1 - Paths found: " + result1.size());
        for (List<String> path : result1) {
            System.out.println(path);
        }
        System.out.println("-----------------");

        // Test 2: hit -> cog (no cog in list)
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        List<List<String>> result2 = solution.findLadders("hit", "cog", wordList2);
        System.out.println("Test 2 - Paths found: " + result2.size() + " (Expected: 0)");
        System.out.println("-----------------");
    }
}
