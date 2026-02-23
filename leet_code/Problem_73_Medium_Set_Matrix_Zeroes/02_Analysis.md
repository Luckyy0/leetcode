# Analysis for Set Matrix Zeroes
# *Phân tích cho bài toán Đặt Ma Trận Thành Số Không*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** m x n matrix. *Ma trận m x n.*
*   **Output:** Grid modified in-place. *Lưới được sửa đổi tại chỗ.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   m, n up to 200.
*   Goal: $O(1)$ space complexity.
*   *m, n lên tới 200.*
*   *Mục tiêu: Độ phức tạp không gian $O(1)$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Using the First Row and Column as Storage
### *Hướng tiếp cận: Sử dụng Hàng và Cột đầu tiên làm nơi lưu trữ*

*   **Intuition:** Instead of using extra arrays to store which rows and columns need to be zeroed, use the first row and the first column of the matrix itself as flags. 
*   *Ý tưởng: Thay vì sử dụng các mảng bổ sung để lưu trữ hàng và cột nào cần đặt thành không, hãy sử dụng chính hàng đầu tiên và cột đầu tiên của ma trận làm các cờ hiệu.*

*   **Algorithm Steps:**
    1.  Check if the first row and first column have any zeros using two boolean variables (`firstRowHasZero`, `firstColHasZero`).
    2.  Use the rest of the matrix (`1...m-1`, `1...n-1`) to find zeros. If `matrix[i][j] == 0`, set `matrix[i][0] = 0` and `matrix[0][j] = 0`.
    3.  Iterate through the matrix again from `(1,1)` and set elements to zero if their row/column flags are zero.
    4.  Finally, handle the first row and first column based on the boolean variables.

*   **Complexity:**
    *   Time: $O(M \cdot N)$.
    *   Space: $O(1)$ auxiliary space.

### Dry Run
### *Chạy thử*
`[[0,1,2,0],[3,4,5,2],[1,3,1,5]]`
1. `firstRowZero = true`, `firstColZero = true`.
2. Scanning inner: No more zeros in `3,4,5,2` or `1,3,1,5`.
3. First row and Col flags used for the original zeros at `(0,0)` and `(0,3)`.
4. Final results set according to flags.
---
*Việc sử dụng chính ma trận làm nơi lưu trữ trạng thái là một kỹ thuật tối ưu hóa không gian phổ biến.*
Using the matrix itself to store state is a common space optimization technique.
