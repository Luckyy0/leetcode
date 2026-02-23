package leet_code.Problem_554_Medium_Brick_Wall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Finds the vertical line that crosses the minimum number of bricks.
     * Strategy: Use HashMap to count edge frequencies.
     * Time: O(TotalBricks), Space: O(DistinctEdges).
     */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCounts = new HashMap<>();
        int maxEdges = 0;

        for (List<Integer> row : wall) {
            int currentEdge = 0;
            // Iterate until the second to last brick
            for (int i = 0; i < row.size() - 1; i++) {
                currentEdge += row.get(i);
                int count = edgeCounts.getOrDefault(currentEdge, 0) + 1;
                edgeCounts.put(currentEdge, count);
                maxEdges = Math.max(maxEdges, count);
            }
        }

        return wall.size() - maxEdges;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();
        // Example: [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
        List<List<Integer>> wall = List.of(
                List.of(1, 2, 2, 1),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(2, 4),
                List.of(3, 1, 2),
                List.of(1, 3, 1, 1));
        System.out.println("Result: " + solution.leastBricks(wall)); // 2
    }
}
