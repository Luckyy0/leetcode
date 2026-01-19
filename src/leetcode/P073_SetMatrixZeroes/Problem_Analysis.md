# 73. Set Matrix Zeroes / Đặt Ma Trận Về Không

## Problem Description / Mô tả bài toán
Given an `m x n` integer matrix `matrix`, if an element is `0`, set its entire row and column to `0`'s.
Cho một ma trận số nguyên `m x n` `matrix`, nếu một phần tử là `0`, hãy đặt toàn bộ hàng và cột của nó thành `0`.

You must do it **in-place**.
Bạn phải thực hiện nó **tại chỗ**.

### Example 1:
```text
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
```

### Example 2:
```text
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[0].length`
- `1 <= m, n <= 200`
- `-2^31 <= matrix[i][j] <= 2^31 - 1`

---

## Analysis / Phân tích

### Approach: Use Markers in First Row/Col / Sử Dụng Đánh Dấu ở Hàng/Cột Đầu Tiên
- **Idea**: Use the first row and first column to store states. `matrix[i][0]` and `matrix[0][j]` indicate if row `i` and col `j` should be zeroed.
- **Ý tưởng**: Sử dụng hàng đầu tiên và cột đầu tiên để lưu trạng thái. `matrix[i][0]` và `matrix[0][j]` cho biết hàng `i` và cột `j` có nên được đặt về 0 hay không.
- **Corner Case**: Since `matrix[0][0]` is shared by both first row and first column, we need separate boolean flags for "Is First Row Zero?" and "Is First Col Zero?".
- **Algorithm**:
    1.  Check if first row has any zero -> set `rowZero` flag.
    2.  Check if first col has any zero -> set `colZero` flag.
    3.  Iterate `i` from 1 to m, `j` from 1 to n:
        - If `matrix[i][j] == 0`, set `matrix[i][0] = 0` and `matrix[0][j] = 0`.
    4.  Iterate `i` from 1 to m, `j` from 1 to n:
        - If `matrix[i][0] == 0` or `matrix[0][j] == 0`, set `matrix[i][j] = 0`.
    5.  Handle first row and column based on flags.
- **Time Complexity**: O(m * n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Single Element**: `[[0]]` -> `[[0]]`. `[[1]]` -> `[[1]]`.
2.  **Row/Col of Zeros**: Handled.
