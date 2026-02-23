# Analysis for Shortest Distance from All Buildings
# *Phân tích cho bài toán Khoảng cách Ngắn nhất từ Tất cả Tòa nhà*

## 1. Problem Essence & BFS from Buildings
## *1. Bản chất vấn đề & BFS từ Tòa nhà*

### The Challenge
### *Thách thức*
Find a `0` minimizing $\sum dist(0, \text{building})$.
Unlike "Best Meeting Point", we have obstacles (`2`) and cannot pass through buildings (`1`). So Manhattan distance formula doesn't work. We must use BFS.
Naively: BFS from each `0` to find all `1`s. $O(\text{zeros} \cdot M \cdot N)$.
Better: BFS from each `1` to update all `0`s. $O(\text{buildings} \cdot M \cdot N)$.
Usually fewer buildings than zeros.

### Strategy: BFS Summation
### *Chiến lược: Tổng hợp BFS*
1.  Arrays `totalDist[m][n]` and `reachCount[m][n]`.
2.  Iterate grid. If cell is `1` (Building):
    - Run BFS.
    - For each reachable `0` at distance `d`:
        - `totalDist[r][c] += d`.
        - `reachCount[r][c] += 1`.
    - Optimization: If a `0` is NOT reached by this building, it can never be the answer.
    - We can pass a `reachId` to `visited` to avoid re-allocating `visited` array (or reuse grid values).

### Pruning Optimization
### *Tối ưu hóa Cắt tỉa*
Instead of standard `visited` array:
Only visit cells where `grid[r][c] == current_reach_val`.
Initially `0`.
After BFS 1: cells reached become `-1`.
After BFS 2: only visit `-1`, update to `-2`.
Valid answer cells will have `grid` value equal to `-numBuildings`.
Wait, this modifies the grid. Need to handle obstacles `2` and existing buildings `1`.
Let's stick to separate `reachCount` array for clarity, or just check `reachCount == current_building_index`.
Method:
`reachCount[m][n]`.
When running BFS for building `k` (0-indexed):
Only push to queue if `reachCount[r][c] == k`.
Then increment `reachCount[r][c]`.
If a cell is not reached, its `reachCount` stays `k`. Next building `k+1` won't visit it.
This effectively prunes unreachable pockets.

---

## 2. Approach: BFS from each Building
## *2. Hướng tiếp cận: BFS từ mỗi Tòa nhà*

### Logic
### *Logic*
1.  `dist[][]` and `reach[][]` grids.
2.  `buildingCount = 0`.
3.  Loop `i, j`:
    - If `grid[i][j] == 1`:
        - BFS(i, j, buildingCount).
        - `buildingCount++`.
4.  After all buildings, finding min `dist[i][j]` where `reach[i][j] == buildingCount` and `grid[i][j] == 0`.

### BFS Details
### *Chi tiết BFS*
Queue `(r, c)`. Steps `dist`.
Level-order traversal.
Check boundaries, obstacle (2), building (1).
Only valid if `grid[r][c] == 0`.
Optimization: Check `reach[r][c] == buildingIdx`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Pruning:** The `reach` check prevents searching parts of the grid that are already known to be unreachable from some buildings.
    *Cắt tỉa: Kiểm tra `reach` ngăn việc tìm kiếm các phần của lưới đã được biết là không thể truy cập từ một số tòa nhà.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \cdot M \cdot N)$ where K is number of buildings.
    *Độ phức tạp thời gian: $O(K \cdot M \cdot N)$.*
*   **Space Complexity:** $O(M \cdot N)$.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:**
1 0 2
0 0 0
Bldg at (0,0). BFS:
(0,1): dist 1. reach 1.
(1,0): dist 1. reach 1.
(1,1): dist 2. reach 1.
(1,2): dist 3. reach 1.

Next Bldg... summing dists. Min dist at (0,1)? No (0,1) blocked? No, (0,1) is 0.
Min dist check.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard multi-source BFS summation.
*Tổng hợp BFS đa nguồn tiêu chuẩn.*
---
*Ngôi nhà lý tưởng (shortest distance) là nơi kết nối (reach) được với tất cả mọi người. Sự tiện lợi không dành riêng cho một cá nhân, mà là tổng hòa của cộng đồng.*
The ideal home (shortest distance) is the place that connects (reach) with everyone. Convenience is not for one individual, but the sum of the community.
