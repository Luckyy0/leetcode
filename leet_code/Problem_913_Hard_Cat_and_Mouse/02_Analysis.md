# Analysis for Cat and Mouse
# *Phân tích cho bài toán Mèo và Chuột*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
A game on a graph with two players, alternating turns. Determine the winner assuming optimal play.
*Trò chơi trên đồ thị với hai người chơi, luân phiên lượt. Xác định người thắng giả sử chơi tối ưu.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a Game Theory problem on a graph. The state space is `(mouse_pos, cat_pos, turn)`.
- The graph size $N \le 50$. Total states approx $50 \times 50 \times 2 = 5000$.
- The game can be cyclic (draw).
- We can view this as computing the "color" (Win, Loss, Draw) of each state in the state graph.
- Since it's an impartial game (mostly) with cycles, regular DFS/recursion with memoization might struggle with cycles (infinite loops).
- Instead, we can use **Topological Sort / Iterative Coloring**:
  - Identify terminal states:
    - Mouse at Hole (0): Mouse Wins (Color 1).
    - Mouse == Cat: Cat Wins (Color 2).
  - Propagate results backwards:
    - If a state has a move to a winning state for the current player, the current state is winning.
    - If ALL moves from a state lead to losing states for the current player, the current state is losing.
  - States that cannot be determined are Draws (Color 0).
*Đây là bài toán Lý thuyết Trò chơi trên đồ thị. Không gian trạng thái khoảng 5000. Trò chơi có thể đi theo chu trình (hòa). Ta có thể coi đây là việc tô màu (Thắng, Thua, Hòa) cho từng trạng thái. Dùng Sắp xếp Topo ngược (Coloring) từ các trạng thái kết thúc (Chuột ở Lỗ, Mèo gặp Chuột). Lan truyền ngược lại: đi được đến thế thắng -> thắng; tất cả đường đi dẫn đến thua -> thua. Còn lại là hòa.*

---

## 2. Strategy: Minimax with Topological Sort (Reverse BFS)
## *2. Chiến lược: Minimax với Sắp xếp Topo (BFS ngược)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Definitions:**
    - State: `(m, c, t)` where `t=1` (Mouse turn), `t=2` (Cat turn).
    - Degree: `degree[m][c][t]` = number of valid moves from this state.
    - Color: `color[m][c][t]` initially 0 (Draw).

2.  **Initialize:**
    - Initialize degrees for all states based on graph connectivity. Note: Cat cannot move to 0.
    - Queue `q` for processing determined states.
    - Add all terminal states to `q`:
        - For all `c`, `(0, c, 2)` (Mouse at hole, Cat's turn... wait, actually Mouse reaching hole ends immediately).
        - Let's say moves are: Mouse moves -> check win. Cat moves -> check win.
        - Better: Enqueue states `(0, c, 1)` and `(0, c, 2)` as MOUSE_WIN.
        - Enqueue states `(x, x, 1)` and `(x, x, 2)` (where `x != 0`) as CAT_WIN.
    - Set initial colors for these states.

3.  **Process Queue:**
    - Pop state `(m, c, t)` with determined `result`.
    - Find all "parent" states `(m2, c2, t2)` that can move TO `(m, c, t)`. 
      - If `t=1` (Mouse turn), parents are `(m, c, 2)` where Cat moved to `c`. Parents: `(m, prevail_c, 2)`.
      - If `t=2` (Cat turn), parents are `(prevail_m, c, 1)`.
    - For each parent:
        - If parent is already colored, skip.
        - **Case 1:** `(m, c, t)` is LOSING for the current player `t` (meaning `result` is the opponent's win).
            - Then the parent `(m2, c2, t2)` can move to this state to win immediately.
            - Set parent color to `result`. Push to queue.
        - **Case 2:** `(m, c, t)` is WINNING for the current player `t` (meaning `result` is `t`'s win).
            - Then for the parent `(m2, c2, t2)`, this move leads to a loss.
            - We decrement `degree[m2][c2][t2]`.
            - If degree becomes 0, it means ALL moves from parent lead to opponent's win.
            - Set parent color to opponent's win (i.e., `result`). Push to queue.
    *   **Xử lý Queue:** Lấy trạng thái đã xác định. Tìm các trạng thái cha. Nếu con là Thua (cho người chơi hiện tại), cha sẽ chọn đi đường này và Thắng. Nếu con là Thắng (cho người chơi hiện tại), cha sẽ tránh đường này; giảm degree của cha. Nếu degree cha về 0, cha buộc phải Thua.*

4.  **Return:** `color[1][2][1]` (Mouse start at 1, Cat at 2, Mouse turn).
    *   **Trả về:** `color[1][2][1]`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class Solution {
    public int catMouseGame(int[][] graph) {
        int N = graph.length;
        int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2;
        int MOUSE_TURN = 1, CAT_TURN = 2;
        
        int[][][] color = new int[N][N][3]; // 0: Draw, 1: Mouse, 2: Cat
        int[][][] degree = new int[N][N][3];
        
        // Calculate degrees
        for (int m = 0; m < N; m++) {
            for (int c = 0; c < N; c++) {
                degree[m][c][MOUSE_TURN] = graph[m].length;
                degree[m][c][CAT_TURN] = graph[c].length;
                // Cat cannot move to 0
                for (int next : graph[c]) {
                    if (next == 0) {
                        degree[m][c][CAT_TURN]--;
                        break;
                    }
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Add terminal states
        for (int i = 0; i < N; i++) {
            for (int t = 1; t <= 2; t++) {
                // Mouse at hole (0) -> Mouse wins
                if (color[0][i][t] == 0) {
                    color[0][i][t] = MOUSE_WIN;
                    queue.offer(new int[]{0, i, t, MOUSE_WIN});
                }
                
                // Cat catches Mouse (i same as i) -> Cat wins (except hole)
                if (i != 0) {
                    if (color[i][i][t] == 0) {
                        color[i][i][t] = CAT_WIN;
                        queue.offer(new int[]{i, i, t, CAT_WIN});
                    }
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int m = state[0], c = state[1], t = state[2], result = state[3];
            
            // Find parents
            int prevT = 3 - t; // 1->2, 2->1
            List<int[]> parents = new ArrayList<>();
            
            if (prevT == MOUSE_TURN) {
                // Previous turn was Mouse's. Mouse moved from prevM to m.
                // So parents are (prevM, c, MOUSE_TURN)
                for (int prevM : graph[m]) {
                    parents.add(new int[]{prevM, c, MOUSE_TURN});
                }
            } else {
                // Previous turn was Cat's. Cat moved from prevC to c.
                // So parents are (m, prevC, CAT_TURN)
                for (int prevC : graph[c]) {
                    if (prevC != 0) { // Cat couldn't have been at 0
                        parents.add(new int[]{m, prevC, CAT_TURN});
                    }
                }
            }
            
            for (int[] parent : parents) {
                int pm = parent[0], pc = parent[1], pt = parent[2];
                if (color[pm][pc][pt] != DRAW) continue;
                
                // If the current result means the parent player wins efficiently
                // (i.e. if it's Mouse turn and result is Mouse Win, or Cat turn and result is Cat Win)
                // Wait...
                // If parent is Mouse Turn:
                //   If child state is MOUSE_WIN -> Mouse will choose this move -> Parent becomes MOUSE_WIN.
                //   If child state is CAT_WIN -> Mouse avoids this. Degree--. If 0 -> Parent becomes CAT_WIN.
                
                if (result == pt) { 
                    // Immediate win for the player at parent state
                    color[pm][pc][pt] = result;
                    queue.offer(new int[]{pm, pc, pt, result});
                } else {
                    // This move leads to opponent win, so we prune it
                    degree[pm][pc][pt]--;
                    if (degree[pm][pc][pt] == 0) {
                        // All moves lead to opponent win
                        color[pm][pc][pt] = result;
                        queue.offer(new int[]{pm, pc, pt, result});
                    }
                }
            }
        }
        
        return color[1][2][MOUSE_TURN];
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$. There are $O(N^2)$ states. Each state is processed once. Processing a state involves iterating over edges, so roughly $N \times (\text{avg degree})$. Total bounded by $O(N^3)$.
    *   **Độ phức tạp thời gian:** $O(N^3)$.*
*   **Space Complexity:** $O(N^2)$ for `color` and `degree` arrays.
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This topological sort / reverse game state propagation is the canonical way to solve game theory problems with cycles. Recursion works only if the game is acyclic (DAG).
*Phương pháp sắp xếp topo / lan truyền trạng thái ngược là cách chuẩn mực để giải các bài toán lý thuyết trò chơi có chu trình. Đệ quy chỉ hoạt động nếu trò chơi không có chu trình (DAG).*
