package leetcode.P399_EvaluateDivision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * Problem 399: Evaluate Division
     * Approach: Graph DFS
     * 
     * Time Complexity: O(Q * (V + E))
     * Space Complexity: O(V + E)
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / val);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(start, end, graph, new HashSet<>());
            }
        }

        return result;
    }

    private double dfs(String current, String target, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (current.equals(target))
            return 1.0;

        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);

        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            String next = neighbor.getKey();
            if (visited.contains(next))
                continue;

            double res = dfs(next, target, graph, visited);
            if (res != -1.0) {
                return neighbor.getValue() * res;
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [["a","b"],["b","c"]], values = [2.0,3.0]
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = { 2.0, 3.0 };

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c")); // 6.0
        queries.add(Arrays.asList("b", "a")); // 0.5
        queries.add(Arrays.asList("a", "e")); // -1.0
        queries.add(Arrays.asList("a", "a")); // 1.0
        queries.add(Arrays.asList("x", "x")); // -1.0

        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println("Results: " + Arrays.toString(results));
    }
}
