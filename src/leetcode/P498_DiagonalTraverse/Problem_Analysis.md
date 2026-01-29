# 498. Diagonal Traverse / Duyệt Theo Đường Chéo

## Problem Description / Mô tả bài toán
Given an `m x n` matrix `mat`, return an array of all the elements of the array in a diagonal order.
Cho một ma trận `mat` kích thước `m x n`, hãy trả về một mảng gồm tất cả các phần tử của ma trận được duyệt theo thứ tự đường chéo.

### Example 1:
```text
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
```

## Constraints / Ràng buộc
- `m == mat.length`
- `n == mat[i].length`
- `1 <= m, n <= 10^4`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Direction Switching Simulation / Mô phỏng chuyển đổi hướng
Diagonals are defined by the sum of indices `i + j`.
- All elements with the same `i + j` belong to the same diagonal.
- There are `m + n - 1` such diagonals.

Algorithm:
1. Iterate `sum` from `0` to `m + n - 2`.
2. Based on whether `sum` is even or odd, we traverse the diagonal in different directions:
   - **Even sum**: Traverse **upwards**.
     - Start `i = min(sum, m - 1)`.
     - `j = sum - i`.
     - Adjust `i` and `j` while they are valid.
   - **Odd sum**: Traverse **downwards**.
     - Start `j = min(sum, n - 1)`.
     - `i = sum - j`.
     - Adjust `i` and `j` while they are valid.

### Complexity / Độ phức tạp
- **Time**: O(M * N) as we visit each element once.
- **Space**: O(M * N) for the output array.

---

## Analysis / Phân tích

### Approach: Parity-based Diagonal Scan

**Algorithm**:
1.  Outer loop for number of diagonals.
2.  Directional logic based on index sum parity.
3.  Boundary checks for start and end of each diagonal.

---
