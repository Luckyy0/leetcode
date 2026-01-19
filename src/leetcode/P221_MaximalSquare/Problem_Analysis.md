# 221. Maximal Square / Hình Vuông Lớn Nhất

## Problem Description / Mô tả bài toán
Given an `m x n` binary matrix filled with `0`'s and `1`'s, find the largest square containing only `1`'s and return its area.
Cho một ma trận nhị phân kích thước `m x n` chứa đầy các số `0` và `1`, hãy tìm hình vuông lớn nhất chỉ chứa các số `1` và trả về diện tích của nó.

### Example 1:
```text
Input: matrix = [
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 4
```

### Example 2:
```text
Input: matrix = [["0","1"],["1","0"]]
Output: 1
```

### Example 3:
```text
Input: matrix = [["0"]]
Output: 0
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 300`
- `matrix[i][j]` is `'0'` or `'1'`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming / Quy hoạch động
Let `dp[i][j]` represent the side length of the **largest square** whose **bottom-right corner** is at `(i, j)`.
Hãy để `dp[i][j]` đại diện cho độ dài cạnh của **hình vuông lớn nhất** có **góc dưới cùng bên phải** tại `(i, j)`.

**Transition Algorithm (Công thức chuyển trạng thái)**:
1.  If `matrix[i][j] == '0'`, then `dp[i][j] = 0` (cannot be part of a square at this specific corner).
2.  If `matrix[i][j] == '1'`:
    - `dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1`.
    - Explanation: To form a square of size `k` ending at `(i, j)`, we need squares of size `k-1` ending at `(i-1, j)`, `(i, j-1)`, and `(i-1, j-1)`. The limiting factor is the smallest of these neighbors.

**Initialization**:
- First row and first column: `dp[i][j] = matrix[i][j] - '0'`.

**Result**:
- `maxSide = max(maxSide, dp[i][j])`.
- Return `maxSide * maxSide`.

---

## Analysis / Phân tích

### Approach: Dynamic Programming

**Complexity / Độ phức tạp**:
- **Time**: O(M * N) - Iterate through the matrix once.
- **Space**: O(M * N) - DP table. Can be optimized to O(N) since we only need the previous row.

---

## Edge Cases / Các trường hợp biên
1.  **Empty matrix**: 0.
2.  **All 0s**: 0.
3.  **All 1s**: min(M, N)^2.
