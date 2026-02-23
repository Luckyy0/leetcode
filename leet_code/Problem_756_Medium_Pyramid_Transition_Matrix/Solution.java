package leet_code.Problem_756_Medium_Pyramid_Transition_Matrix;

import java.util.*;

public class Solution {

    // Map: Pair(Left, Right) -> List of Allowed Tops
    // String key "AB" -> ['C', 'D']
    Map<String, List<Character>> transitions = new HashMap<>();

    // Memoization for failed states
    Set<String> failed = new HashSet<>();

    /**
     * Checks if pyramid can be built.
     * Strategy: DFS with Memoization. Build layer by layer.
     * Time: O(A^(N^2)), Space: O(N^2).
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Build transition map
        for (String s : allowed) {
            String base = s.substring(0, 2);
            char top = s.charAt(2);
            transitions.computeIfAbsent(base, k -> new ArrayList<>()).add(top);
        }

        return solve(bottom);
    }

    private boolean solve(String currentLayer) {
        if (currentLayer.length() == 1) {
            return true;
        }

        if (failed.contains(currentLayer)) {
            return false;
        }

        // Try to build the next layer
        if (buildNextLayer(currentLayer, 0, new StringBuilder())) {
            return true;
        }

        failed.add(currentLayer);
        return false;
    }

    private boolean buildNextLayer(String currentLayer, int index, StringBuilder nextLayer) {
        if (index == currentLayer.length() - 1) {
            // Next layer complete, recurse to solve for the layer above it
            return solve(nextLayer.toString());
        }

        String key = currentLayer.substring(index, index + 2);
        if (transitions.containsKey(key)) {
            for (char top : transitions.get(key)) {
                nextLayer.append(top);
                if (buildNextLayer(currentLayer, index + 1, nextLayer)) {
                    return true;
                }
                nextLayer.deleteCharAt(nextLayer.length() - 1); // Backtrack
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String bottom1 = "BCD";
        List<String> allowed1 = Arrays.asList("BCC", "CDE", "CEA", "FFF");
        System.out.println("Result 1: " + sol.pyramidTransition(bottom1, allowed1)); // true

        String bottom2 = "AABA";
        List<String> allowed2 = Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC");
        System.out.println("Result 2: " + sol.pyramidTransition(bottom2, allowed2)); // false
    }
}
