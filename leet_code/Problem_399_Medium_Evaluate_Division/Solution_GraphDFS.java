package leet_code.Problem_399_Medium_Evaluate_Division;

import java.util.*;

public class Solution_GraphDFS {

    /**
     * Evaluates division queries based on given equations.
     * Use Graph modeling + DFS.
     * Time: O(Q * (V + E)), Space: O(V + E).
     * 
     * Tính toán các truy vấn phép chia dựa trên các phương trình đã cho.
     * Sử dụng mô hình hóa Đồ thị + DFS.
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        // Dựng đồ thị
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, val);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1.0 / val);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                results[i] = dfs(graph, start, end, 1.0, new HashSet<>());
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double currentProduct,
            Set<String> visited) {
        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);

        if (neighbors.containsKey(target)) {
            return currentProduct * neighbors.get(target);
        }

        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                double result = dfs(graph, entry.getKey(), target, currentProduct * entry.getValue(), visited);
                if (result != -1.0)
                    return result;
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        Solution_GraphDFS solution = new Solution_GraphDFS();

        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = { 2.0, 3.0 };
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x"));

        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println("Results: " + Arrays.toString(results));
    }
}
