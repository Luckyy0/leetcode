# 867. Transpose Matrix / Chuyển vị Ma trận

## Problem Description / Mô tả bài toán
Given a 2D integer array `matrix`, return the **transpose** of `matrix`.
Cho một mảng số nguyên 2D `matrix`, hãy trả về **ma trận chuyển vị** của nó.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
Ma trận chuyển vị là ma trận được lật qua đường chéo chính, hoán đổi chỉ số hàng và cột.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Index Swapping / Hoán đổi Chỉ số
If the original matrix had dimensions `R x C`, the transpose will have dimensions `C x R`.
Nếu ma trận ban đầu có kích thước `R x C`, ma trận chuyển vị sẽ có kích thước `C x R`.

Equation: `transposed[c][r] = original[r][c]`.

### Complexity / Độ phức tạp
- **Time**: O(R * C).
- **Space**: O(R * C) for the result.

---

## Analysis / Phân tích

### Approach: Result Reallocation
Construct a new grid with inverse dimensions and perform a systematic row-major to column-major transfer of values.
Xây dựng một lưới mới với các kích thước đảo ngược và thực hiện việc chuyển đổi các giá trị từ hàng-chính sang cột-chính một cách có hệ thống.

---
