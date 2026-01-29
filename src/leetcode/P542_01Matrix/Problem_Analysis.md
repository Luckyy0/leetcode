# 542. 01 Matrix / Ma Trận 01

## Problem Description / Mô tả bài toán
Given an `m x n` binary matrix `mat`, return the distance of the nearest `0` for each cell.
Cho một ma trận nhị phân `m x n` `mat`, hãy trả về khoảng cách đến số `0` gần nhất cho mỗi ô.

The distance between two adjacent cells is `1`.
Khoảng cách giữa hai ô liền kề là `1`.

### Example 1:
```text
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
```

### Example 2:
```text
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Multi-source BFS / BFS Đa nguồn
Instead of running BFS from each `1`, we can run BFS starting from all `0`s simultaneously.

Algorithm:
1. Initialize a `queue` and a `dist` matrix.
2. For each cell `(i, j)`:
   - If `mat[i][j] == 0`, add to queue, set `dist[i][j] = 0`.
   - Else `mat[i][j] == 1`, set `dist[i][j] = infinity`.
3. While queue is not empty:
   - Poll cell `curr`.
   - For each neighbor `next`:
     - If `dist[next] > dist[curr] + 1`:
       - `dist[next] = dist[curr] + 1`.
       - Add `next` to queue.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Multi-Source Breadth-First Search

**Algorithm**:
1.  Initialize queue with all 0-cells.
2.  Set 1-cells to max distance.
3.  Propagate BFS outward.
4.  Update distances if shorter path found.

---
