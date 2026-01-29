# 305. Number of Islands II / Số Lượng Đảo II

## Problem Description / Mô tả bài toán
You are given an empty 2D binary grid `grid` of size `m x n`. The grid represents a map where `0`'s represent water and `1`'s represent land. Initially, all the cells of `grid` are water cells (i.e., all the cells are `0`s).
Bạn được cung cấp một lưới nhị phân 2D trống `grid` có kích thước `m x n`. Lưới đại diện cho một bản đồ trong đó `0` đại diện cho nước và `1` đại diện cho đất liền.

We may perform an add land operation which turns the water at position `(row, col)` into a land. You are given an array `positions` where `positions[i] = [ri, ci]` is the position `(ri, ci)` at which we should operate the `i-th` operation.
Chúng ta có thể thực hiện thao tác thêm đất liền...

Return an array of integers `answer` where `answer[i]` is the number of islands after turning the cell `(ri, ci)` into a land.
Trả về một mảng các số nguyên `answer` trong đó `answer[i]` là số lượng đảo sau khi biến ô `(ri, ci)` thành đất liền.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

### Example 1:
```text
Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1,1,2,3]
Explanation:
Initially, the 2d grid is filled with water.
- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. Map becomes [[1,0,0],[0,0,0],[0,0,0]]. Number of islands = 1.
- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. Map becomes [[1,1,0],[0,0,0],[0,0,0]]. Number of islands = 1.
- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. Map becomes [[1,1,0],[0,0,1],[0,0,0]]. Number of islands = 2.
- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. Map becomes [[1,1,0],[0,0,1],[0,1,0]]. Number of islands = 3.
```

## Constraints / Ràng buộc
- `1 <= m, n, positions.length <= 10^4`
- `1 <= m * n <= 10^4`
- `positions[i].length == 2`
- `0 <= ri < m`
- `0 <= ci < n`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Union-Find (Disjoint Set Union) / Tìm-Hợp (Tập Hợp Rời Rạc)
To handle dynamic connectivity, DSU is the standard approach.
We treat each land cell as a node. When a new land is added:
1.  Increase island count by 1.
2.  Check 4 neighbors. For each neighbor that is **already land**:
    - `union(current, neighbor)`.
    - If `union` performs a merge (i.e., different sets merged), decrease island count by 1.
3.  Store current count.

Nodes can be mapped to integers `i * n + j`.

### Complexity / Độ phức tạp
- **Time**: `O(K * alpha(MN))` where K is number of positions. `alpha` is almost constant.
- **Space**: `O(MN)` for DSU parent/rank arrays + grid state.
- Note constraints: `m*n <= 10^4`, so `MN` is small.

---

## Analysis / Phân tích

### Approach: DSU

**Edge Cases**:
1.  Adding land to a cell that is already land:
    - Count does not change.
    - Result list adds current count.
    - But wait, example sequence implies updates. Usually input doesn't repeat or if it repeats, just ignores validly. If input repeats `addLand(0,0)` twice, second time it's already 1, nothing changes.
2.  Large grid but sparse positions? `m*n` up to `10^4` is small, so array based DSU is fine.

---
