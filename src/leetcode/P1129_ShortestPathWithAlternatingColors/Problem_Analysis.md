# 1129. Shortest Path with Alternating Colors / Đường đi Ngắn nhất với Màu Xen kẽ

## Problem Description / Mô tả bài toán
Given a directed graph with `n` nodes, some edges are red, some are blue.
Return an array `answer` of length `n`, where `answer[i]` is the length of the shortest path from node 0 to node `i` such that the edge colors alternate red and blue. Or -1 if no such path.
Cho đồ thị có hướng với `n` nút, một số cạnh màu đỏ, một số màu xanh.
Trả về mảng `answer` có độ dài `n`, trong đó `answer[i]` là độ dài đường đi ngắn nhất từ nút 0 đến nút `i` sao cho màu cạnh xen kẽ đỏ và xanh. Hoặc -1 nếu không có đường đi như vậy.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS with State / BFS với Trạng thái
State: `(node, lastColor)`.
Colors: 0 (init/none), 1 (red), 2 (blue).
Or simpler: 0 (red), 1 (blue).
Start with `(0, red)` and `(0, blue)` effectively (distance 0).
Wait, technically the *edge* determines the "next" required color.
Initial: Start at 0 with distance 0. Next edge can be Red OR Blue.
So push `(0, 0)` and `(0, 1)` to queue immediately? No.
State `(u, color)` means we arrived at `u` via an edge of `color`. Next edge must be `1 - color`.
Initial states: From 0, we can take Red edge (arriving at v, color Red) or Blue edge.
Actually, let's track `visited[u][color]` -> minimal distance to reach `u` ending with `color`.
Initialize `dist[u][RE] = inf`, `dist[u][BLUE] = inf`.
Start queue with `(0, neither)`, or handle 0 specially.
Better: `visited[u][0]` and `visited[u][1]`.
Queue stores `(u, last_color_type, distance)`.
Start:
- Add `(0, RED, 0)`? No, "last color" implies constraint on next.
- Actually we can start with a dummy state or push next valid moves from 0.
- `Queue: (0, 0, 0) and (0, 1, 0)`?
- Let's say 0 is RED (next must be BLUE) and 1 is BLUE (next must be RED).
- At 0, we haven't used an edge. So we can use RED or BLUE.
- So we pretend we entered 0 with "BLUE" (to allow RED next) and entered 0 with "RED" (to allow BLUE next).
- So push `(0, RED_signal, 0)` and `(0, BLUE_signal, 0)`.
- `visited[0][RED] = true`, `visited[0][BLUE] = true`.

### Complexity / Độ phức tạp
- **Time**: O(V + E).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: State-Based BFS
Perform a Breadth-First Search where the state includes the color of the last edge used. Maintain `dist[node][0]` (shortest path ending in red) and `dist[node][1]` (shortest path ending in blue). Start the BFS from node 0 assuming both "arrived via red" (allowing next blue) and "arrived via blue" (allowing next red) are possible initial states with distance 0.
Thực hiện Tìm kiếm theo Chiều rộng trong đó trạng thái bao gồm màu của cạnh cuối cùng được sử dụng. Duy trì `dist[node][0]` (đường ngắn nhất kết thúc bằng màu đỏ) và `dist[node][1]` (đường ngắn nhất kết thúc bằng màu xanh). Bắt đầu BFS từ nút 0 giả sử cả "đến qua màu đỏ" (cho phép màu xanh tiếp theo) và "đến qua màu xanh" (cho phép màu đỏ tiếp theo) đều là các trạng thái ban đầu có thể có với khoảng cách 0.

---
