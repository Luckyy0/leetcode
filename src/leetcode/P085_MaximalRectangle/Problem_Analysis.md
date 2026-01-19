# 85. Maximal Rectangle / Hình Chữ Nhật Lớn Nhất

## Problem Description / Mô tả bài toán
Given a `rows x cols` binary matrix filled with `0`'s and `1`'s, find the largest rectangle containing only `1`'s and return its area.
Cho một ma trận nhị phân `rows x cols` chứa `0` và `1`, hãy tìm hình chữ nhật lớn nhất chỉ chứa `1` và trả về diện tích của nó.

### Example 1:
```text
Input: matrix = [
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
Explanation: The maximal rectangle is shown in the last row of ones.
```

### Example 2:
```text
Input: matrix = [["0"]]
Output: 0
```

## Constraints / Ràng buộc
- `rows == matrix.length`
- `cols == matrix[i].length`
- `1 <= row, cols <= 200`
- `matrix[i][j]` is `'0'` or `'1'`.

---

## Analysis / Phân tích

### Approach: Histogram based (using P084) / Dựa trên Biểu đồ
- **Idea**: Treat each row as the base of a histogram.
- **Ý tưởng**: Coi mỗi hàng là đáy của một biểu đồ.
- **Algorithm**:
    - Initialize `heights` array of size `cols` with 0.
    - Iterate through each row:
        - For each col `j`:
            - If `matrix[i][j] == '1'`, `heights[j] += 1`.
            - If `matrix[i][j] == '0'`, `heights[j] = 0` (reset height).
        - Calculate `largestRectangleArea(heights)` for current row.
        - Update `maxArea`.
- **Time Complexity**: O(N * M). Each cell visited once, stack op O(M). Total O(N*M).
- **Space Complexity**: O(M).

---

## Edge Cases / Các trường hợp biên
1.  **Empty**: 0.
2.  **All Zeros**: 0.
3.  **All Ones**: N*M.
