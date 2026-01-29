package leetcode.P332_ReconstructItinerary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    /**
     * Problem 332: Reconstruct Itinerary
     * Approach: Hierholzer's Algorithm (DFS)
     * 
     * Time Complexity: O(E log E)
     * Space Complexity: O(E)
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>();
        visit("JFK", adj, result);

        // Result was built in reverse post-order (head of list is last added).
        // Wait, standard Hierholzer adds node to front of list (or stack) after
        // visiting all edges.
        // If using LinkedList 'addFirst', the order becomes correct (Reverse
        // Post-Order).
        // Let's trace:
        // A -> B. visit A -> visit B -> B stuck -> add B to front -> A stuck -> add A
        // to front.
        // Result: A, B. Correct.
        return result;
    }

    private void visit(String u, Map<String, PriorityQueue<String>> adj, LinkedList<String> result) {
        PriorityQueue<String> neighbors = adj.get(u);

        while (neighbors != null && !neighbors.isEmpty()) {
            String v = neighbors.poll();
            visit(v, adj, result);
        }

        result.addFirst(u);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]] ->
        // ["JFK","MUC","LHR","SFO","SJC"]
        List<List<String>> t1 = new ArrayList<>();
        t1.add(Arrays.asList("MUC", "LHR"));
        t1.add(Arrays.asList("JFK", "MUC"));
        t1.add(Arrays.asList("SFO", "SJC"));
        t1.add(Arrays.asList("LHR", "SFO"));

        runTest(solution, t1, Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC"));

        // [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]] ->
        // ["JFK","ATL","JFK","SFO","ATL","SFO"]
        List<List<String>> t2 = new ArrayList<>();
        t2.add(Arrays.asList("JFK", "SFO"));
        t2.add(Arrays.asList("JFK", "ATL"));
        t2.add(Arrays.asList("SFO", "ATL"));
        t2.add(Arrays.asList("ATL", "JFK"));
        t2.add(Arrays.asList("ATL", "SFO"));

        runTest(solution, t2, Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"));
    }

    private static void runTest(Solution s, List<List<String>> tickets, List<String> expected) {
        List<String> result = s.findItinerary(tickets);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
