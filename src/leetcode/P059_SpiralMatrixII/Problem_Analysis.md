# 59. Spiral Matrix II / Ma Trận Xoắn Ốc II

## Problem Description / Mô tả bài toán
Given a positive integer `n`, generate an `n x n` matrix filled with elements from `1` to `n^2` in spiral order.
Cho một số nguyên dương `n`, hãy tạo một ma trận `n x n` chứa các phần tử từ `1` đến `n^2` theo thứ tự xoắn ốc.

### Example 1:
```text
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
```

### Example 2:
```text
Input: n = 1
Output: [[1]]
```

## Constraints / Ràng buộc
- `1 <= n <= 20`

---

## Analysis / Phân tích

### Approach: Boundary Traversal (Simulation) / Duyệt Biên (Mô Phỏng)
- **Idea**: Similar to Spiral Matrix I, but we fill the matrix instead of reading it.
- **Ý tưởng**: Tương tự như Spiral Matrix I, nhưng chúng ta điền vào ma trận thay vì đọc nó.
- **Algorithm**:
    - Init `top = 0, bottom = n-1, left = 0, right = n-1`.
    - `val = 1`.
    - While `val <= n*n`:
        - Fill top row, increment `top`.
        - Fill right col, decrement `right`.
        - Fill bottom row, decrement `bottom`.
        - Fill left col, increment `left`.
- **Time Complexity**: O(n^2).
- **Space Complexity**: O(1) (excluding output).

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: `[[1]]`.
