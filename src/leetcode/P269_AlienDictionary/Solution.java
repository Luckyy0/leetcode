package leetcode.P269_AlienDictionary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

    /**
     * Problem 269: Alien Dictionary
     * Approach: Topological Sort (Kahn's Algorithm)
     * 
     * Theoretical Basis:
     * - Nodes are characters.
     * - Edges are ordering constraints (u -> v means u comes before v).
     * - Cycle detection via Topo Sort.
     * 
     * Time Complexity: O(total chars)
     * Space Complexity: O(1) (limit 26)
     */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // 1. Initialize graph for all unique characters
        for (String w : words) {
            for (char c : w.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        // 2. Build graph edges
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Check prefix edge case: if w2 is prefix of w1 but w2 is shorter
            // e.g. "abc", "ab" -> Invalid! Shorter prefix must come first.
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            // Find first difference
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    // Avoid duplicate edges incrementing inDegree wrongly
                    // Check if edge c1 -> c2 already added?
                    // Usually we might just manage lists. But to be safe simply add.
                    // Actually, if we add multi edges, inDegree increases multiple times.
                    // Need to verify if already adjacent? Or use Set for adj values.
                    // Optimization: We process each pair once. c1->c2 implies order.
                    // Subsequent pairs might imply same order. Graph allows multi-edges for Kahn's?
                    // No.
                    // Kahn's relies on "inDegree 0". Duplicate edges confuse count.
                    // Let's check duplicates.

                    // But actually, traversing adjacent words only gives "immediate" relations.
                    // A pair (w1, w2) gives exactly ONE constraint.
                    // BUT (w1, w2) giving c -> d and later (w3, w4) giving c -> d is possible.
                    // So we must dedup edges.

                    // Simple fix: Check if list contains.
                    // Or keep 'processed' but simpler: just assume unique edges per problem
                    // structure logic in small constraints. Or verify.
                    // Let's check existence before adding.

                    // Wait, List.contains is O(N). But max neighbors 26. Fast.
                    List<Character> neighbors = adj.get(c1);
                    boolean edgeExists = false;
                    for (char neighbor : neighbors) {
                        if (neighbor == c2) {
                            edgeExists = true;
                            break;
                        }
                    }

                    if (!edgeExists) {
                        neighbors.add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }

                    // Found first diff, subsequent chars don't matter for word ordering
                    break;
                }
            }
        }

        // 3. Topological Sort
        Queue<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            sb.append(u);

            for (char v : adj.get(u)) {
                inDegree.put(v, inDegree.get(v) - 1);
                if (inDegree.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        // Check cycles
        if (sb.length() < inDegree.size()) {
            return "";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["wrt","wrf","er","ett","rftt"] -> "wertf"
        runTest(solution, new String[] { "wrt", "wrf", "er", "ett", "rftt" }, "wertf");

        // ["z","x"] -> "zx"
        runTest(solution, new String[] { "z", "x" }, "zx");

        // ["z","x","z"] -> ""
        runTest(solution, new String[] { "z", "x", "z" }, "");

        // Prefix invalid: ["abc", "ab"] -> ""
        runTest(solution, new String[] { "abc", "ab" }, "");
    }

    private static void runTest(Solution s, String[] words, String expected) {
        String result = s.alienOrder(words);
        System.out.println("Result: \"" + result + "\" (Expected: \"" + expected + "\")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL"); // Note: multiple valid orders exist, strictest check might need verifying
                                        // validity rather than exact string.
            // But problem examples usually have unique solutions for straightforward cases.
        }
        System.out.println("-----------------");
    }
}
