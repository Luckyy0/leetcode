# 317. Shortest Distance from All Buildings / Khoảng Cách Ngắn Nhất Từ Tất Cả Các Tòa Nhà

## Problem Description / Mô tả bài toán
You are given an `m x n` grid `grid` of values `0`, `1`, or `2`, where:
- `0` marks an empty land which you can pass by freely.
- `1` marks a building which you cannot pass through.
- `2` marks an obstacle which you cannot pass through.
Bạn được cung cấp một lưới `grid` `m x n`...

You want to build a house on an empty land so that the sum of the shortest distances from the house to all the buildings is minimized. The distance is calculated using Manhattan Distance, but you can only restart at an empty land. Actually, distance is BFS path length (Manhattan if no obstacles, but here obstacles exist).
Bạn muốn xây một ngôi nhà trên một khu đất trống sao cho tổng khoảng cách ngắn nhất từ ngôi nhà đến tất cả các tòa nhà là nhỏ nhất.

Return the minimum total shortest distance. If it is impossible, return `-1`.
Trả về tổng khoảng cách ngắn nhất tối thiểu.

### Example 1:
```text
Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 7
Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
```

## Constraints / Ràng buộc
- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 100`
- `grid[i][j]` is `0`, `1`, or `2`.
- There will be **at least one** building in the `grid`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### BFS from Buildings / BFS Từ Các Tòa Nhà
Instead of starting BFS from every empty land (Lots of BFS), we start BFS from **each building**.
- `total_dist[m][n]`: Accumulates distance sum from all buildings.
- `reach_count[m][n]`: Counts how many buildings can reach this cell.
- `totalBuildings`: Count of 1s.

**Algorithm**:
1.  Iterate grid. If `grid[i][j] == 1`, run BFS.
2.  BFS(startNode):
    - `dist = 0`. `level` iteration.
    - Visit empty lands (0).
    - `total_dist[x][y] += current_dist`
    - `reach_count[x][y]++`
    - Optimization: To avoid `visited` array reset every time, we can mark visited by checking `grid[x][y] == -b_idx`? Or simply use local `visited` boolean array. Given 100x100, `visited` allocation is fine. Or use `walk` value in grid.
    - Optimization: If a building cannot reach any node that was reachable by previous buildings, we can stop? (Pruning).
    - If BFS from a building cannot maximize `reach_count` for ANY node (i.e. graph disconnected), return -1 immediately.

**Final Answer**:
- Loop all `(i, j)`. If `grid[i][j] == 0` and `reach_count[i][j] == totalBuildings`, update min.

### Complexity / Độ phức tạp
- **Time**: `O(K * M * N)` where K is number of buildings. Worst case `K ~ MN`, so `O(M^2 N^2)`. 100^4 = 10^8. Tight but likely acceptable for BFS simple ops.
- **Space**: `O(MN)`.

---

## Analysis / Phân tích

### Approach: BFS from each building

**Algorithm**:
1.  `distMap` and `reachMap`.
2.  Count `buildings`.
3.  Loop: `if grid[i][j] == 1` -> bfs.
4.  Bfs updates `distMap` and `reachMap`.
5.  Check min `distMap` where `reachMap == buildings`.

---
