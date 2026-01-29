# 766. Toeplitz Matrix / Ma trận Toeplitz

## Problem Description / Mô tả bài toán
Given an `m x n` matrix, return `true` if the matrix is Toeplitz. Otherwise, return `false`.
Cho một ma trận `m x n`, hãy trả về `true` nếu ma trận đó là ma trận Toeplitz. Ngược lại, trả về `false`.

A matrix is **Toeplitz** if every diagonal from top-left to bottom-right has the same elements.
Một ma trận là **Toeplitz** nếu mọi đường chéo từ trên cùng bên trái đến dưới cùng bên phải đều có các phần tử giống nhau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Diagonal Property / Thuộc tính Đường chéo
In a Toeplitz matrix, for any element at `(r, c)`, it must be equal to the element at `(r+1, c+1)`.
Trong ma trận Toeplitz, đối với bất kỳ phần tử nào tại `(r, c)`, nó phải bằng phần tử tại `(r+1, c+1)`.

Algorithm:
1. Iterate through all `r` from 0 to `m-2`.
2. Iterate through all `c` from 0 to `n-2`.
3. If `matrix[r][c] != matrix[r+1][c+1]`, return `false`.

### Complexity / Độ phức tạp
- **Time**: O(M * N) where M and N are dimensions.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Neighboring Diagonal Comparison
A single pass through the matrix comparing each element (except last row and last column) with its bottom-right neighbor.
Một lần duyệt qua ma trận so sánh từng phần tử (ngoại trừ hàng cuối và cột cuối) với phần tử lân cận phía dưới bên phải của nó.

---
