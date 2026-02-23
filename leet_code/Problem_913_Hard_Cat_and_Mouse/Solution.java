package leet_code.Problem_913_Hard_Cat_and_Mouse;

import java.util.*;

/**
 * Problem 913: Cat and Mouse
 * https://leetcode.com/problems/cat-and-mouse/
 */
public class Solution {

    /**
     * Determines the winner of the Cat and Mouse game.
     * Strategy: Topological Sort (Reverse BFS) on Game States.
     * 
     * @param graph The adjacency list of the graph.
     * @return 1 (Mouse), 2 (Cat), or 0 (Draw).
     * 
     *         Tóm tắt chiến lược:
     *         1. Đây là trò chơi trên đồ thị có chu trình -> Hòa có thể xảy ra.
     *         2. Không gian trạng thái là (mouse_pos, cat_pos, turn).
     *         turn = 1 (Chuột đi), turn = 2 (Mèo đi).
     *         3. Các trạng thái kết thúc (Terminal States):
     *         - Chuột ở lỗ (0): Chuột thắng (1).
     *         - Mèo bắt được Chuột (m == c): Mèo thắng (2).
     *         4. Sử dụng thuật toán lan truyền ngược (Reverse BFS/Coloring):
     *         - Bắt đầu từ các trạng thái kết thúc, lan truyền kết quả ngược về các
     *         trạng thái cha.
     *         - Nếu từ trạng thái cha P có thể đi đến một trạng thái con C mà C là
     *         trạng thái THẮNG cho người chơi ở P -> P là THẮNG.
     *         - Nếu TẤT CẢ các nước đi từ P đều dẫn đến trạng thái THUA cho người
     *         chơi ở P -> P là THUA. (Sử dụng degree để đếm số nước đi chưa xác
     *         định).
     *         - Các trạng thái không bao giờ được tô màu sẽ là HÒA (0).
     */
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2;
        int MOUSE_TURN = 1, CAT_TURN = 2;

        // color[mouse][cat][turn]
        // 0: Draw, 1: Mouse Wins, 2: Cat Wins
        int[][][] color = new int[n][n][3];
        // degree[mouse][cat][turn]: number of outgoing edges (possible moves)
        int[][][] degree = new int[n][n][3];

        // Initialize degrees
        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][MOUSE_TURN] = graph[m].length;
                degree[m][c][CAT_TURN] = graph[c].length;
                // Cat cannot move to hole (0)
                for (int next : graph[c]) {
                    if (next == 0) {
                        degree[m][c][CAT_TURN]--;
                        break;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        // Add initial winning states to queue
        for (int i = 0; i < n; i++) {
            // Mouse is at hole (0) -> Mouse wins regardless of whose turn or cat pos
            for (int t = 1; t <= 2; t++) {
                if (color[0][i][t] == 0) {
                    color[0][i][t] = MOUSE_WIN;
                    queue.offer(new int[] { 0, i, t, MOUSE_WIN });
                }

                // Cat catches mouse (i == i) and not at hole -> Cat wins
                if (i > 0) {
                    if (color[i][i][t] == 0) {
                        color[i][i][t] = CAT_WIN;
                        queue.offer(new int[] { i, i, t, CAT_WIN });
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int m = state[0], c = state[1], t = state[2], result = state[3];

            // Find parent states that can move to this state
            // If current state t=1 (Mouse turn), then parent was Cat turn (2)
            // If current state t=2 (Cat turn), then parent was Mouse turn (1)
            int prevTurn = 3 - t;

            List<int[]> parents = new ArrayList<>();

            if (prevTurn == MOUSE_TURN) {
                // Parent was (prevM, c, MOUSE_TURN) -> moved to m
                for (int prevM : graph[m]) {
                    parents.add(new int[] { prevM, c, MOUSE_TURN });
                }
            } else {
                // Parent was (m, prevC, CAT_TURN) -> moved to c
                for (int prevC : graph[c]) {
                    if (prevC != 0) { // Cat couldn't be at 0
                        parents.add(new int[] { m, prevC, CAT_TURN });
                    }
                }
            }

            for (int[] parent : parents) {
                int pm = parent[0], pc = parent[1], pt = parent[2];

                // If parent already colored, skip
                if (color[pm][pc][pt] != DRAW)
                    continue;

                // If the current Result matches the Player Turn at Parent
                // (e.g. Winner is Mouse, and Parent is Mouse Turn)
                // Then the Parent player can chose this move to Win immediately.
                if (result == pt) {
                    color[pm][pc][pt] = result;
                    queue.offer(new int[] { pm, pc, pt, result });
                } else {
                    // Result is Opponent Win.
                    // Parent player will try to avoid this move.
                    // Decrement degree. If all moves lead to Opponent Win, then Parent loses.
                    degree[pm][pc][pt]--;
                    if (degree[pm][pc][pt] == 0) {
                        color[pm][pc][pt] = result; // Result is opponent win (3-pt or just result)
                        // Actually 'result' here IS the opponent win value (e.g. result=2, pt=1)
                        queue.offer(new int[] { pm, pc, pt, result });
                    }
                }
            }
        }

        return color[1][2][MOUSE_TURN];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] g1 = { { 2, 5 }, { 3 }, { 0, 4, 5 }, { 1, 4, 5 }, { 2, 3 }, { 0, 2, 3 } };
        System.out.println("Result: " + sol.catMouseGame(g1)); // 0

        int[][] g2 = { { 1, 3 }, { 0 }, { 3 }, { 0, 2 } };
        System.out.println("Result: " + sol.catMouseGame(g2)); // 1
    }
}
