# Analysis for Spiral Matrix II
# *Phân tích cho bài toán Ma Trận Xoắn Ốc II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n`. *Số nguyên `n`.*
*   **Output:** n x n matrix. *Ma trận n x n.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` is between 1 and 20. Matrix size is small.
*   *`n` nằm trong khoảng từ 1 đến 20. Kích thước ma trận nhỏ.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Boundary Traversal
### *Hướng tiếp cận: Duyệt theo Ranh giới*

*   **Intuition:** This is the reverse of Spiral Matrix I. We maintain four boundaries and fill values from `1` to `n*n` while moving in a spiral pattern.
*   *Ý tưởng: Đây là bài toán ngược của Ma Trận Xoắn Ốc I. Chúng ta duy trì bốn ranh giới và điền các giá trị từ `1` đến `n*n` trong khi di chuyển theo mô hình xoắn ốc.*

*   **Algorithm Steps:**
    1.  Initialize `matrix[n][n]`.
    2.  `top = 0, bottom = n-1, left = 0, right = n-1`.
    3.  `num = 1`.
    4.  While `num <= n * n`:
        *   Fill top row: `i` from `left` to `right`. `matrix[top][i] = num++`. Update `top++`.
        *   Fill right column: `i` from `top` to `bottom`. `matrix[i][right] = num++`. Update `right--`.
        *   Fill bottom row: `i` from `right` to `left`. `matrix[bottom][i] = num++`. Update `bottom--`.
        *   Fill left column: `i` from `bottom` to `top`. `matrix[i][left] = num++`. Update `left++`.

*   **Complexity:**
    *   Time: $O(n^2)$.
    *   Space: $O(1)$ auxiliary space (excluding result matrix).

### Dry Run
### *Chạy thử*
`n = 3`
1. Top: (0,0)=1, (0,1)=2, (0,2)=3. `top=1`.
2. Right: (1,2)=4, (2,2)=5. `right=1`.
3. Bottom: (2,1)=6, (2,0)=7. `bottom=1`.
4. Left: (1,0)=8. `left=1`.
5. Middle: (1,1)=9.
Done.
---
*Cơ chế ranh giới giúp việc điền ma trận trở nên có hệ thống.*
The boundary mechanism makes matrix filling systematic.
