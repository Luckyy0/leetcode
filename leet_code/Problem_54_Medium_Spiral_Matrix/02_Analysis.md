# Analysis for Spiral Matrix
# *Phân tích cho bài toán Ma Trận Xoắn Ốc*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** m x n matrix. *Ma trận m x n.*
*   **Output:** List of elements in spiral order. *Danh sách các phần tử theo thứ tự xoắn ốc.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Small matrix size (up to 10x10).
*   Correct boundary handling is essential.
*   *Kích thước ma trận nhỏ (lên tới 10x10).*
*   *Xử lý ranh giới chính xác là điều thiết yếu.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Boundary Simulation
### *Hướng tiếp cận: Mô phỏng Ranh giới*

*   **Intuition:** Maintain four boundaries: `top`, `bottom`, `left`, `right`. Traverse in clockwise direction and update boundaries after each pass.
*   *Ý tưởng: Duy trì bốn ranh giới: `trên`, `dưới`, `trái`, `phải`. Duyệt theo chiều kim đồng hồ và cập nhật ranh giới sau mỗi lần đi qua.*

*   **Algorithm Steps:**
    1.  `top = 0, bottom = m - 1, left = 0, right = n - 1`.
    2.  While `top <= bottom && left <= right`:
        *   Traverse right: `i` from `left` to `right`. Add `matrix[top][i]`. `top++`.
        *   Traverse down: `i` from `top` to `bottom`. Add `matrix[i][right]`. `right--`.
        *   If `top <= bottom`: Traverse left: `i` from `right` to `left`. Add `matrix[bottom][i]`. `bottom--`.
        *   If `left <= right`: Traverse up: `i` from `bottom` to `top`. Add `matrix[i][left]`. `left++`.

*   **Complexity:**
    *   Time: $O(m \cdot n)$.
    *   Space: $O(1)$ auxiliary space (excluding result list).

### Dry Run
### *Chạy thử*
`[[1,2,3],[4,5,6],[7,8,9]]`
1. Top row: 1, 2, 3. `top=1`.
2. Right column: 6, 9. `right=1`.
3. Bottom row: 8, 7. `bottom=1`.
4. Left column: 4. `left=1`.
5. Middle: 5.
Done.
---
Proper termination check within the loop is crucial for non-square matrices.
*Kiểm tra kết thúc phù hợp trong vòng lặp là rất quan trọng đối với các ma trận không phải hình vuông.*
