# 74. Search a 2D Matrix / Tìm Kiếm Trong Ma Trận 2D

## Problem Description / Mô tả bài toán
Write an efficient algorithm that searches for a value `target` in an `m x n` integer matrix `matrix`. This matrix has the following properties:
Viết một thuật toán hiệu quả tìm kiếm giá trị `target` trong ma trận số nguyên `m x n`. Ma trận này có các thuộc tính sau:

1.  Integers in each row are sorted from left to right.
    Các số nguyên trong mỗi hàng được sắp xếp từ trái sang phải.
2.  The first integer of each row is greater than the last integer of the previous row.
    Số nguyên đầu tiên của mỗi hàng lớn hơn số nguyên cuối cùng của hàng trước đó.

### Example 1:
```text
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
```

### Example 2:
```text
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 100`
- `-10^4 <= matrix[i][j], target <= 10^4`

---

## Analysis / Phân tích

### Approach: Binary Search as 1D Array / Tìm Kiếm Nhị Phân Như Mảng 1D
- **Idea**: Because the rows are sorted and linked, the entire matrix can be viewed as a single sorted 1D array of size `m * n`.
- **Ý tưởng**: Vì các hàng được sắp xếp và liên kết với nhau, toàn bộ ma trận có thể được xem như một mảng 1D đã sắp xếp duy nhất có kích thước `m * n`.
- **Mapping**: Index `x` in 1D array maps to `matrix[x / n][x % n]` in 2D array.
- **Algorithm**:
    - `lo = 0`, `hi = m * n - 1`.
    - `mid = (lo + hi) / 2`.
    - `val = matrix[mid / n][mid % n]`.
    - If `val == target`, return true.
    - If `val < target`, `lo = mid + 1`.
    - Else, `hi = mid - 1`.
- **Time Complexity**: O(log(m * n)).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Single Element**: `[[1]]`, target 1 -> true.
2.  **Not Found**: `[[1]]`, target 2 -> false.
