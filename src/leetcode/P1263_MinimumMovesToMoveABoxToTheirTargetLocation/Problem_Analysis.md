# 1263. Minimum Moves to Move a Box to Their Target Location / Số bước đi Tối thiểu để Di chuyển Hộp đến Vị trí Đích

## Problem Description / Mô tả bài toán
Grid with Player ('S'), Box ('B'), Target ('T'), Obstacles ('#'), Content ('.').
Player can push box (needs empty cell behind).
Minimize **box pushes**. Player moves don't count towards cost (but must be valid).
This is BFS on state (box_pos, player_pos).
Cost is pushes.
Edges:
- Player move without pushing box: Cost 0.
- Player push box: Cost 1. (Player must be adjacent to box, moves box and player).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / Dijkstra / 0-1 BFS
State: `(boxRow, boxCol, pushDir)`. `pushDir` is direction from which box was pushed to reach this state (implies player is now at `(boxRow - dirRow, boxCol - dirCol)`).
Actually simpler state: `(boxRow, boxCol, playerRow, playerCol)`. But too large.
Observation: For a fixed box position, the exact player position doesn't matter, only which side of the box the player can reach.
Key: Can player reach the "push position" (cell adjacent to box opposite to push direction)?
State: `(boxRow, boxCol)`.
Transitions: Push Up, Down, Left, Right.
To push Box UP (from `(r, c)` to `(r-1, c)`), Player needs to be at `(r+1, c)`.
Cost of this transition is 1. Validity check: Can Player move from current pos to `(r+1, c)` in the grid with Box at `(r, c)` considered as obstacle?
Since we can have multiple player positions reachable for same box pos, maybe state is `(boxRow, boxCol, playerSide)`.
Or simpler: Since pushing is expensive and moving is free, use 0-1 BFS or PriorityQueue.
State: `(boxR, boxC, playerR, playerC)`.
Use `visited[boxR][boxC][playerR][playerC]`.
Optimization:
We only care where the player is *relative to the box* when "docked" to push.
So `visited[boxR][boxC][pushDirection]`.
Wait. If player is just roaming around, cost 0. If pushing, cost 1.
This is exactly 0-1 BFS or Dijkstra.
Nodes: `(boxR, boxC, playerR, playerC)`.
Edges:
- `(bR, bC, pR, pC) -> (bR, bC, adjPR, adjPC)` cost 0.
- `(bR, bC, pR, pC) -> (bR+dR, bC+dC, bR, bC)` cost 1 (if p is at correct push spot).
But exploring full `box*player` space is `(MN)^2`. N, M <= 20. `(400)^2 = 160000`. This is small enough!
So simple `priority_queue` or `deque` works.
Using `visited[boxR][boxC][playerR][playerC]` is fine.

### Complexity / Độ phức tạp
- **Time**: O( (MN)^2 ).
- **Space**: O( (MN)^2 ).

---

## Analysis / Phân tích

### Approach: 0-1 BFS (or Dijkstra) on Full State
Since the number of cells is small (at most 20x20), the state space `(boxRow, boxCol, playerRow, playerCol)` is manageable ($20^4 \approx 160,000$). Use BFS (specifically 0-1 BFS using a Deque) to find the minimum pushes.
- State: `(boxR, boxC, playerR, playerC)`.
- Transitions:
  1. **Player moves**: Player moves to an adjacent cell (not containing the box or obstacle). Cost: 0. Push to front of Deque.
  2. **Player pushes box**: If player is adjacent to the box and pushes it into a valid empty cell, both box and player move. Cost: 1. Push to back of Deque.
- Target: Any state where box is at target coordinates.
Optimization: To avoid redundant processing, use a `visited` array.
Because we prioritize 0-cost moves, the first time we push the box to the target, it will be with minimal pushes.
Vì số lượng ô nhỏ (tối đa 20x20), không gian trạng thái `(boxRow, boxCol, playerRow, playerCol)` có thể quản lý được ($20^4 \approx 160,000$). Sử dụng BFS (cụ thể là 0-1 BFS sử dụng Deque) để tìm số lần đẩy tối thiểu.
- Trạng thái: `(boxR, boxC, playerR, playerC)`.
- Chuyển đổi:
  1. **Người chơi di chuyển**: Người chơi di chuyển đến ô liền kề (không chứa hộp hoặc chướng ngại vật). Chi phí: 0. Đẩy vào đầu Deque.
  2. **Người chơi đẩy hộp**: Nếu người chơi ở cạnh hộp và đẩy nó vào ô trống hợp lệ, cả hộp và người chơi đều di chuyển. Chi phí: 1. Đẩy vào cuối Deque.
- Mục tiêu: Bất kỳ trạng thái nào hộp ở tọa độ đích.
Tối ưu hóa: Để tránh xử lý dư thừa, hãy sử dụng mảng `visited`.

---
