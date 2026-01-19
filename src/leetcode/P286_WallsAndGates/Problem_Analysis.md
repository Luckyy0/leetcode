# 286. Walls and Gates / Tường và Cổng

## Problem Description / Mô tả bài toán
You are given an `m x n` grid `rooms` initialized with these three possible values.
Bạn được cung cấp một lưới `m x n` `rooms` được khởi tạo với ba giá trị có thể có sau.

1.  `-1`: A wall or an obstacle. (Một bức tường hoặc vật cản).
2.  `0`: A gate. (Một cái cổng).
3.  `INF`: Infinity means an empty room. We use the value `2^31 - 1 = 2147483647` to represent INF as you may assume that the distance to a gate is less than `2147483647`. (Vô cực nghĩa là một căn phòng trống...).

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with `INF`.
Điền vào mỗi phòng trống khoảng cách đến cổng gần nhất của nó. Nếu không thể đến cổng, nó nên được điền là `INF`.

### Example 1:
```text
Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
```

## Constraints / Ràng buộc
- `m == rooms.length`
- `n == rooms[i].length`
- `1 <= m, n <= 250`
- `rooms[i][j]` is `-1`, `0`, or `2^31 - 1`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Multi-Source BFS / BFS Đa Nguồn
Instead of running BFS from each empty room (which would be slow O(Rooms * HW)), we start BFS from **all gates simultaneously**.
1.  Initialize Queue with all coordinates `(r, c)` where `rooms[r][c] == 0`.
2.  While Queue is not empty:
    - Pop `(r, c)`.
    - For each neighbor `(nr, nc)`:
        - If `rooms[nr][nc] == INF` (Empty room):
            - Update distance: `rooms[nr][nc] = rooms[r][c] + 1`.
            - Push `(nr, nc)` to Queue.
        - If neighbor is Wall (-1) or Gate (0) or already visited (distance < INF), ignore.

This works because BFS guarantees finding the shortest path in an unweighted graph. The first time we reach a room, it is via the shortest path from *some* gate.

### Complexity / Độ phức tạp
- **Time**: O(M * N). Each cell is visited at most once.
- **Space**: O(M * N) for the queue.

---

## Analysis / Phân tích

### Approach: Multi-Source BFS

**Algorithm**:
1.  Queue `q`.
2.  Scan grid. Add all `0`s to `q`.
3.  Directions array `[-1, 0], [1, 0], [0, -1], [0, 1]`.
4.  Standard BFS loop.

---
