# 1289. Minimum Falling Path Sum II / Tổng Đường đi Rơi Tối thiểu II

## Problem Description / Mô tả bài toán
`n x n` grid. Falling path with non-zero shifts.
Pick one element from each row.
Next row column must be different from current row column.
Minimize sum.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][j]` = min sum ending at `grid[i][j]`.
`dp[i][j] = grid[i][j] + min(dp[i-1][k])` where `k != j`.
Optimization:
For row `i-1`, we only need the two smallest values.
Let `min1` be the smallest value in row `i-1`, at index `idx1`.
Let `min2` be second smallest, at index `idx2`.
For row `i`:
- If `j != idx1`, `dp[i][j] = grid[i][j] + min1`.
- If `j == idx1`, `dp[i][j] = grid[i][j] + min2`.
Find new `min1`, `min2` for row `i`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(1) (store just prev row min1, min2).

---

## Analysis / Phân tích

### Approach: DP with Minima Check
Instead of iterating all columns $k$ for each $j$ (which would be $O(N^3)$), track the minimum and second minimum values (and the index of the minimum) from the previous row. For the current row `i` and column `j`, if `j` is not the index of the previous minimum, add the previous minimum. If `j` corresponds to the previous minimum's index, add the second minimum. Update the minimum and second minimum for the current row to be used in the next iteration.
Thay vì lặp lại tất cả các cột $k$ cho mỗi $j$ (sẽ là $O(N^3)$), hãy theo dõi các giá trị tối thiểu và tối thiểu thứ hai (và chỉ số của giá trị tối thiểu) từ hàng trước đó. Đối với hàng hiện tại `i` và cột `j`, nếu `j` không phải là chỉ số của giá trị tối thiểu trước đó, hãy cộng giá trị tối thiểu trước đó. Nếu `j` tương ứng với chỉ số của giá trị tối thiểu trước đó, hãy cộng giá trị tối thiểu thứ hai. Cập nhật giá trị tối thiểu và tối thiểu thứ hai cho hàng hiện tại để sử dụng trong lần lặp tiếp theo.

---
