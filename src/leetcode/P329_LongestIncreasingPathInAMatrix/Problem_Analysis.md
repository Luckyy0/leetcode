# 329. Longest Increasing Path in a Matrix / Đường Dẫn Tăng Dài Nhất Trong Ma Trận

## Problem Description / Mô tả bài toán
Given an `m x n` integers matrix, return the length of the longest increasing path.
Cho một ma trận số nguyên `m x n`, trả về độ dài của đường dẫn tăng dài nhất.

From each cell, you can either move in four directions: left, right, up, or down. You **may not** move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
Từ mỗi ô, bạn có thể di chuyển theo bốn hướng... Bạn **không được** di chuyển theo đường chéo hoặc di chuyển ra ngoài biên.

### Example 1:
```text
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
```

### Example 2:
```text
Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 200`
- `0 <= matrix[i][j] <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### DFS + Memoization / DFS + Ghi Nhớ
We want to find the longest path starting from ANY cell.
`dfs(r, c)` returns the max length starting from `(r, c)`.
`dfs(r, c) = 1 + max(dfs(nr, nc))` for all neighbors `(nr, nc)` such that `matrix[nr][nc] > matrix[r][c]`.
If no neighbor satisfies the increasing condition, returns 1.

Memoize results in `memo[r][c]` to avoid recomputation. Since the path is strictly increasing, there are no cycles, so no `visited` set needed for cycle detection (the values themselves prevent cycles).
However, `memo` acts as visited for computation reuse.

### Complexity / Độ phức tạp
- **Time**: O(M * N). Each cell computed once.
- **Space**: O(M * N) for memo table.

---

## Analysis / Phân tích

### Approach: Memoized DFS

**Algorithm**:
1.  `memo[m][n]`, init with 0.
2.  `maxLen = 0`.
3.  Loop `i`, `j`: `maxLen = max(maxLen, dfs(i, j))`.
4.  `dfs(i, j)`:
    - If `memo[i][j] != 0` return `memo`.
    - `curMax = 1`.
    - Loop 4 directions:
        - If neighbor valid and `mat[neigh] > mat[cur]`:
            - `curMax = max(curMax, 1 + dfs(neigh))`.
    - `memo[i][j] = curMax`.
    - Return `curMax`.

---
