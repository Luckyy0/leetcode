# 1102. Path With Maximum Minimum Value / Đường dẫn có Giá trị Tối thiểu Lớn nhất

## Problem Description / Mô tả bài toán
Given an `m x n` integer matrix `grid`, return the maximum score of a path starting at `(0, 0)` and ending at `(m - 1, n - 1)` moving in the 4 cardinal directions.
The score of a path is defined as the minimum value in that path.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Priority Queue (Max-Heap) / Modified Dijkstra or Prim / Hàng đợi Ưu tiên / Dijkstra hoặc Prim sửa đổi
We want to maximize the bottleneck capacity.
Algorithm:
1. Max-Heap stores `[val, r, c]`. Start with `grid[0][0]`.
2. `visited` array.
3. `minVal` so far in current path exploration logic?
   - Wait, standard Dijkstra finds shortest path. Here we want max-min.
   - We extract largest potential values first.
   - The value of path to reach `(r, c)` is `min(path_so_far, grid[r][c])`.
   - Since we pick max available node, the first time we reach destination, it will be via the optimal bottleneck path.

Algorithm detail:
1. Max-Heap `pq`. Add `(0, 0, grid[0][0])` effectively. Actually `pq` entries are just `(r, c)` sorted by `grid[r][c]`.
2. Wait, careful. We want to maintain "bottleneck to reach this node".
   - `dist[r][c]` = max-min value to reach `(r, c)`. Initialize to -1.
   - Start `dist[0][0] = grid[0][0]`. Heap adds `(grid[0][0], 0, 0)`.
   - While heap not empty:
     - Pop `[val, r, c]`. `val` is the bottleneck of path reaching `(r, c)`.
     - If `(r, c) == dest`, return `val`.
     - Neighbors: `newVal = min(val, grid[nr][nc])`.
     - If `newVal > dist[nr][nc]`:
       - `dist[nr][nc] = newVal`.
       - Push `(newVal, nr, nc)`.
   
   - Or just standard "visited" logic since finding ANY path with max bottleneck is goal, and greedy works.
   - Once visited, never revisit, because we extract max first, so first visit IS with max bottleneck. (Like Prim's).

### Complexity / Độ phức tạp
- **Time**: O(MN log(MN)).
- **Space**: O(MN).

---

## Analysis / Phân tích

### Approach: Greedy Bottleneck Expansion
Use a Max-Heap to explore the grid, prioritizing cells with higher values. This is effectively Prim's algorithm or a modification of Dijkstra's. We track the minimum value encountered on the current path (`path_min`). By always expanding the highest valued reachable cell, we guarantee that when we first reach the destination, the `path_min` associated with that arrival is maximized.
Sử dụng Max-Heap để khám phá lưới, ưu tiên các ô có giá trị cao hơn. Đây thực sự là thuật toán của Prim hoặc một sửa đổi của Dijkstra. Chúng ta theo dõi giá trị tối thiểu gặp phải trên đường dẫn hiện tại (`path_min`). Bằng cách luôn mở rộng ô có giá trị cao nhất có thể truy cập, chúng ta đảm bảo rằng khi chúng ta đến đích lần đầu tiên, `path_min` liên quan đến lần đến đó được tối đa hóa.

---
