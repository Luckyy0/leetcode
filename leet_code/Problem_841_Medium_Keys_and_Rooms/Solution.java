package leet_code.Problem_841_Medium_Keys_and_Rooms;

import java.util.*;

/**
 * Problem 841: Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class Solution {

    /**
     * Determines if all rooms can be visited starting from room 0.
     * Strategy: Depth-First Search (DFS) or Breadth-First Search (BFS).
     * 
     * @param rooms Adjacency list represention of keys found in each room.
     * @return True if all rooms are reachable.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng một mảng visited để theo dõi các phòng đã được mở khóa.
     *         2. Bắt đầu từ phòng 0, sử dụng ngăn xếp (Stack) để thực hiện DFS.
     *         3. Với mỗi phòng lấy ra, duyệt qua tất cả các chìa khóa có trong đó.
     *         4. Nếu chìa khóa mở một phòng chưa từng tham quan, đánh dấu đã tham
     *         quan
     *         và thêm phòng đó vào ngăn xếp để tiếp tục khám phá.
     *         5. Cuối cùng, so sánh số phòng đã tham quan với tổng số phòng.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Initial state
        visited[0] = true;
        stack.push(0);
        int visitedCount = 1;

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();

            // Look for keys in the current room
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                    visitedCount++;

                    // Optimization: if all rooms visited, we can return true early
                    if (visitedCount == n)
                        return true;
                }
            }
        }

        return visitedCount == n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        List<List<Integer>> r1 = new ArrayList<>();
        r1.add(Arrays.asList(1));
        r1.add(Arrays.asList(2));
        r1.add(Arrays.asList(3));
        r1.add(new ArrayList<>());
        System.out.println("Can visit all: " + sol.canVisitAllRooms(r1)); // true

        // Example 2
        List<List<Integer>> r2 = new ArrayList<>();
        r2.add(Arrays.asList(1, 3));
        r2.add(Arrays.asList(3, 0, 1));
        r2.add(Arrays.asList(2));
        r2.add(Arrays.asList(0));
        System.out.println("Can visit all: " + sol.canVisitAllRooms(r2)); // false
    }
}
