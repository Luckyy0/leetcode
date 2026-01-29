# 361. Bomb Enemy / Ném Bom Kẻ Thù

## Problem Description / Mô tả bài toán
Given an `m x n` matrix `grid` where each cell is either a wall `'W'`, an enemy `'E'` or empty `'0'`, return the maximum enemies you can kill using one bomb. You can only place the bomb in an empty cell.
Cho một ma trận `grid` `m x n` trong đó mỗi ô là một bức tường `'W'`, một kẻ thù `'E'` hoặc trống `'0'`, trả về số kẻ thù tối đa bạn có thể tiêu diệt bằng một quả bom. Bạn chỉ có thể đặt bom trong một ô trống.

The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Quả bom tiêu diệt tất cả kẻ thù trong cùng một hàng và cột từ điểm đặt cho đến khi đụng phải bức tường.

Note: You can only put the bomb at an empty cell `'0'`.
Lưu ý: Bạn chỉ có thể đặt bom tại ô trống `'0'`.

### Example 1:
```text
Input: grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3
```

### Example 2:
```text
Input: grid = [["W","W","W"],["0","0","0"],["E","E","E"]]
Output: 1
```

## Constraints / Ràng buộc
- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 500`
- `grid[i][j]` is either `'W'`, `'E'`, or `'0'`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Precomputed Sums or Dynamic Caching / Tổng Tính Toán Trước Hoặc Bộ Nhớ Đệm Động
Instead of recalculating enemies for every empty cell (which would be O(M*N * (M+N))), we can cache the number of enemies in the current segment.
Row iteration:
- Iterate rows `i`. Iterate cols `j`.
- If we are at start of row OR previous cell was 'W':
    - Calculate `rowHits`: scan forward from `j` until wall or end. Count 'E'.
Col iteration:
- We can maintain `colHits[n]` array.
- If we are at start of col (i=0) OR cell above was 'W':
    - Calculate `colHits[j]`: scan downwards from `i` until wall or end. Count 'E'.
- For each cell `(i, j)`:
    - If empty `'0'`: total = `rowHits + colHits[j]`. Update max.
    - If enemy `'E'`: do nothing (cannot place).
    - If wall `'W'`: resets happen naturally by check conditions.

### Complexity / Độ phức tạp
- **Time**: O(M * N). Each cell visited constant times (once by main loop, once by row scan, once by col scan).
- **Space**: O(N) for `colHits`.

---

## Analysis / Phân tích

### Approach: Caching Hits

**Algorithm**:
1.  `rowHits = 0`. `colHits[]` size N.
2.  Loop `i`, `j`.
3.  Precompute `rowHits` if needed.
4.  Precompute `colHits[j]` if needed.
5.  If `grid[i][j] == '0'`, update max.

---
