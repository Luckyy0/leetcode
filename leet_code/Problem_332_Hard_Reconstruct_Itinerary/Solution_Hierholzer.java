package leet_code.Problem_332_Hard_Reconstruct_Itinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_Hierholzer {

    // Map: Airport -> PriorityQueue of Destinations (sorted lexically)
    // Map: Sân bay -> PriorityQueue các điểm đến (được sắp xếp theo từ điển)
    private Map<String, PriorityQueue<String>> targets;
    private LinkedList<String> route;

    /**
     * Reconstructs itinerary.
     * Uses Hierholzer's algorithm (DFS with post-order traversal).
     * Time: O(E log E), Space: O(E).
     * 
     * Tái tạo lịch trình.
     * Sử dụng thuật toán Hierholzer (DFS với duyệt post-order).
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        targets = new HashMap<>();
        route = new LinkedList<>();

        // Build graph
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        visit("JFK");

        return route;
    }

    private void visit(String airport) {
        // While there are outgoing flights from this airport
        // Trong khi có các chuyến bay đi từ sân bay này
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            // Pick smallest lexical destination and remove edge (greedy)
            // Chọn điểm đến nhỏ nhất theo từ điển và xóa cạnh (tham lam)
            String next = targets.get(airport).poll();
            visit(next);
        }

        // Add to head of linked list (Post-order / Reverse path)
        // Thêm vào đầu danh sách liên kết (Post-order / Đảo ngược đường đi)
        route.addFirst(airport);
    }

    public static void main(String[] args) {
        Solution_Hierholzer solution = new Solution_Hierholzer();

        // Test Case 1
        List<List<String>> t1 = new LinkedList<>();
        t1.add(List.of("MUC", "LHR"));
        t1.add(List.of("JFK", "MUC"));
        t1.add(List.of("SFO", "SJC"));
        t1.add(List.of("LHR", "SFO"));
        System.out.println("Itinerary 1: " + solution.findItinerary(t1));

        // Test Case 2
        List<List<String>> t2 = new LinkedList<>();
        t2.add(List.of("JFK", "SFO"));
        t2.add(List.of("JFK", "ATL"));
        t2.add(List.of("SFO", "ATL"));
        t2.add(List.of("ATL", "JFK"));
        t2.add(List.of("ATL", "SFO"));
        System.out.println("Itinerary 2: " + solution.findItinerary(t2));
    }
}
