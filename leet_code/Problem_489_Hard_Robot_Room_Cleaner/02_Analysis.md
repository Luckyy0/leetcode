# Analysis for Robot Room Cleaner
# *Phân tích cho bài toán Robot Hút bụi*

## 1. Problem Essence & Blind Exploration
## *1. Bản chất vấn đề & Khám phá Mù*

### The Challenge
### *Thách thức*
Exploring a grid graph without knowing the grid dimensions or absolute coordinates. We only have **relative** movement. We need to visit every reachable cell. This is a standard **DFS** traversal on a graph.

### Strategy: DFS with Relative Coordinates
### *Chiến lược: DFS với Tọa độ Tương đối*

1.  **Coordinate System:** Assign the starting position as `(0, 0)`. Even though we don't know the real map, relative coordinates are sufficient to track visited cells.
2.  **Tracking:** Use a `Set<String>` (e.g., `"x,y"`) to store visited cells.
3.  **Backtracking Logic:**
    - `clean()` the current cell.
    - Mark `(x, y)` as visited.
    - Loop through 4 directions (Up, Right, Down, Left).
    - For each direction:
        - Calculate `next_x`, `next_y`.
        - If `(next_x, next_y)` is NOT visited and `move()` returns true:
            - Recurse: `dfs(next_x, next_y, new_direction)`.
            - **Important:** Backtrack! The robot physically moved. We must move it back to `(x, y)` and restore its facing direction to continue the loop correctly.
        - Turn 90 degrees right to try next direction.
4.  **Backtracking movement:**
    - To go back: `turnRight()`, `turnRight()`, `move()`, `turnRight()`, `turnRight()`. Effectively U-turn, move, U-turn.

---

## 2. Approach: Spiral Backtracking
## *2. Hướng tiếp cận: Quay lui Xoắn ốc*

### Logic
### *Logic*
(See above). The robot maintains its `facing` direction (0: up, 1: right, 2: down, 3: left).
When recursing, if we move 'Up', the robot is now at new cell facing 'Up'.
When loop finishes, the robot must be in the same cell and facing the same direction as start of function call.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Completeness:** DFS ensures all reachable nodes are visited.
    *Tính trọn vẹn: DFS đảm bảo tất cả các nút có thể tiếp cận đều được ghé thăm.*
*   **Physical Consistency:** The code structure mirrors physical movement (Move -> Recurse -> Move Back).
    *Tính nhất quán vật lý: Cấu trúc mã phản ánh chuyển động vật lý (Di chuyển -> Đệ quy -> Quay lại).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N - M)$, where $N$ is total cells and $M$ is obstacles. Basically $O(\text{reachable cells})$. Each cell visited constant times (enter/exit for each neighbor).
    *Độ phức tạp thời gian: $O(V)$.*
*   **Space Complexity:** $O(V)$ for visited set and recursion stack.
    *Độ phức tạp không gian: $O(V)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Start:** (0,0), Facing Up.
1. Clean (0,0). Visited {(0,0)}.
2. Try Up (0, -1). `move()` -> True.
   - Recurse DFS at (0, -1).
   - Clean (0, -1). Visited {(0,0), (0,-1)}.
   - Try Up (0, -2). `move()` -> False (Wall). 
   - Turn Right (Facing Right).
   - Try Right (1, -1). `move()` -> True.
     - Recurse DFS at (1, -1)...
   - After recursion returns, Backtrack (U-turn, move, U-turn). Robot back at (0, -1) facing Right.
   - Turn Right (Facing Down). ...
   - Eventually Backtrack to (0,0).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DFS with relative coordinates and physical backtracking.
*DFS với tọa độ tương đối và quay lui vật lý.*
---
*Đôi khi ta không cần bản đồ (map) để đi hết thế giới, chỉ cần biết mình đang đứng ở đâu so với tảng đá vừa bước qua (relative coordinates). Trong hành trình khám phá (exploration), việc tiến lên (move forward) đòi hỏi sự dũng cảm, nhưng việc quay lại (backtracking) để tìm hướng đi mới đòi hỏi sự kỷ luật. Chỉ cần nhớ đường về, mọi ngõ ngách đều có thể được làm sáng tỏ.*
Sometimes we don't need a map to travel the world, just know where we are standing compared to the rock we just stepped through (relative coordinates). In the journey of exploration (Exploration), moving forward requires courage, but returning (backtracking) to find a new direction requires discipline. Just remember the way back, every corner can be clarified.
