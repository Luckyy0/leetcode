# Analysis for Rotate Image
# *Phân tích cho bài toán Xoay Hình Ảnh*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** n x n 2D matrix. *Mảng 2 chiều n x n.*
*   **Output:** Transformed matrix (in-place). *Mảng đã biến đổi (tại chỗ).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Must be in-place.
*   n is small (up to 20).
*   Clockwise rotation by 90 degrees.
*   *Phải thực hiện tại chỗ.*
*   *n nhỏ (lên tới 20).*
*   *Xoay 90 độ theo chiều kim đồng hồ.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Transpose then Reverse
### *Hướng tiếp cận: Hoán vị rồi Đảo ngược*

*   **Intuition:** A 90-degree clockwise rotation can be achieved in two steps:
    1.  **Transpose** the matrix (swap `matrix[i][j]` with `matrix[j][i]`).
    2.  **Reverse** each row.
*   *Ý tưởng: Việc xoay 90 độ theo chiều kim đồng hồ có thể đạt được trong hai bước:*
    1.  *Hoán vị mảng (đổi chỗ `matrix[i][j]` và `matrix[j][i]`).*
    2.  *Đảo ngược từng hàng.*

*   **Algorithm Steps:**
    1.  Iterate `i` from `0` to `n-1`, `j` from `i+1` to `n-1`.
        *   Swap `matrix[i][j]` and `matrix[j][i]`.
    2.  Iterate through each row `i` from `0` to `n-1`:
        *   Reverse row `i` (swap `matrix[i][j]` and `matrix[i][n-1-j]` for `j` from `0` to `n/2`).

*   **Complexity:**
    *   Time: $O(n^2)$.
    *   Space: $O(1)$ auxiliary space.

### Dry Run
### *Chạy thử*
`[[1,2,3],[4,5,6],[7,8,9]]`
1.  **Transpose:**
    `[[1,4,7],[2,5,8],[3,6,9]]`
2.  **Reverse Rows:**
    Row 0: `[7,4,1]`
    Row 1: `[8,5,2]`
    Row 2: `[9,6,3]`
Result: `[[7,4,1],[8,5,2],[9,6,3]]`. Correct.
