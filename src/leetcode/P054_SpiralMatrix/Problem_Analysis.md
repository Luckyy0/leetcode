# 54. Spiral Matrix / Ma Trận Xoắn Ốc

## Problem Description / Mô tả bài toán
Given an `m x n` matrix, return all elements of the matrix in spiral order.
Cho một ma trận `m x n`, hãy trả về tất cả các phần tử của ma trận theo thứ tự xoắn ốc.

### Example 1:
```text
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

### Example 2:
```text
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 10`
- `-100 <= matrix[i][j] <= 100`

---

## Analysis / Phân tích

### Approach: Boundary Traversal (Simulation) / Duyệt Biên (Mô Phỏng)
- **Idea**: Maintain 4 boundaries: `top`, `bottom`, `left`, `right`.
- **Ý tưởng**: Duy trì 4 biên: `top`, `bottom`, `left`, `right`.
- **Steps**:
    1.  Traverse from `left` to `right` along `top`. Increment `top`.
    2.  Traverse from `top` to `bottom` along `right`. Decrement `right`.
    3.  Traverse from `right` to `left` along `bottom`. Decrement `bottom`.
    4.  Traverse from `bottom` to `top` along `left`. Increment `left`.
    5.  Repeat until boundaries cross.
- **Complexity**: O(m * n).

---

## Edge Cases / Các trường hợp biên
1.  **Single Row**: Top traversal covers it, loop ends.
2.  **Single Column**: Top to bottom covers it.
3.  **1x1 Matrix**.
