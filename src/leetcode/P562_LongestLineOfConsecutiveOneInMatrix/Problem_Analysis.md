# 562. Longest Line of Consecutive One in Matrix / Dòng Số Một Liên Tiếp Dài Nhất Trong Ma Trận

## Problem Description / Mô tả bài toán
Given an `m x n` binary matrix `mat`, return the length of the longest line of consecutive one in the matrix.
Cho một ma trận nhị phân `m x n` `mat`, hãy trả về độ dài của dòng số một liên tiếp dài nhất trong ma trận.

The line could be horizontal, vertical, diagonal, or anti-diagonal.
Dòng này có thể là ngang, dọc, chéo chính hoặc chéo phụ.

### Example 1:
```text
Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
Output: 3
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch động
We need to track 4 directions for each cell.
`dp[i][j][0]` = Horizontal length ending at (i, j).
`dp[i][j][1]` = Vertical length ending at (i, j).
`dp[i][j][2]` = Diagonal length ending at (i, j).
`dp[i][j][3]` = Anti-diagonal length ending at (i, j).

Transitions:
- If `mat[i][j] == 0`, all are 0.
- If `mat[i][j] == 1`:
  - `dp[i][j][0] = dp[i][j-1][0] + 1`
  - `dp[i][j][1] = dp[i-1][j][1] + 1`
  - `dp[i][j][2] = dp[i-1][j-1][2] + 1`
  - `dp[i][j][3] = dp[i-1][j+1][3] + 1`

Space Optimization: Since we only look at `i` and `i-1`, we can reduce to 2D or 3D `[2][n][4]`.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: 3D Dynamic Programming

**Algorithm**:
1.  Initialize DP table for 4 directions.
2.  Iterate through matrix.
3.  If cell is 1, update lengths based on previous neighbors.
4.  Track global maximum.

---
