# 378. Kth Smallest Element in a Sorted Matrix / Phần Tử Nhỏ Thứ K Trong Ma Trận Đã Sắp Xếp

## Problem Description / Mô tả bài toán
Given an `n x n` matrix where each of the rows and columns is sorted in ascending order, return the `k`-th smallest element in the matrix.
Cho một ma trận `n x n` trong đó mỗi hàng và cột được sắp xếp theo thứ tự tăng dần, trả về phần tử nhỏ thứ `k` trong ma trận.

Note that it is the `k`-th smallest element in the sorted order, not the `k`-th distinct element.
You must find a solution with a memory complexity better than `O(n^2)`.

### Example 1:
```text
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13.
```

## Constraints / Ràng buộc
- `n == matrix.length == matrix[i].length`
- `1 <= n <= 300`
- `-10^9 <= matrix[i][j] <= 10^9`
- All the rows and columns of `matrix` are **guaranteed** to be sorted in **non-decreasing** order.
- `1 <= k <= n^2`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Min-Heap (Merge K Sorted Lists)
Similar to finding K pairs.
Use a Min-Heap.
Push first element of each row: `(val, r, c)`.
Poll K times. Every poll, push next column element `(matrix[r][c+1], r, c+1)`.
Time: O(K log N). Space: O(N).

### Binary Search on Value / Tìm Kiếm Nhị Phân Trên Giá Trị
Range `[minVal, maxVal]`. `min = matrix[0][0]`, `max = matrix[n-1][n-1]`.
`mid = low + (high - low) / 2`.
Count elements `<= mid`.
Since rows/cols are sorted, counting can be done in O(N) starting from bottom-left or top-right.
- Start `r = n-1, c = 0`.
- If `matrix[r][c] <= mid`: All elements in column `c` up to `r` (0..r) are `<= mid`? No, col sorted means `0..r` are smaller? Wait.
- Col sorted: `matrix[0][c] <= ... <= matrix[r][c]`.
- So if `matrix[r][c] <= mid`, then `matrix[0..r][c]` are `<= mid`. Count += `r + 1`. Move `c++`.
- Else (`matrix[r][c] > mid`): `matrix[r][c]` too big. Move `r--`.
If `count < k`: `low = mid + 1`.
Else: `high = mid`.

### Complexity / Độ phức tạp
- **Time**: O(N * log(Range)). Range is integer range.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search on Answer

**Algorithm**:
1.  `low = matrix[0][0]`, `high = matrix[n-1][n-1]`.
2.  While `low < high`:
    - `mid = low + (high - low) / 2`.
    - `count = countLessEqual(mid)`.
    - If `count < k`: `low = mid + 1`.
    - Else: `high = mid`.
3.  Return `low`.

**Count Function**:
1.  `count = 0`, `r = n - 1`, `c = 0`.
2.  While `r >= 0 && c < n`:
    - If `matrix[r][c] <= mid`:
        - `count += r + 1`.
        - `c++`.
    - Else:
        - `r--`.
3.  Return `count`.

---
