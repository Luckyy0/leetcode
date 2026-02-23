# Analysis for N-Queens
# *Phân tích cho bài toán N-Queens*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n`. *Số nguyên `n`.*
*   **Output:** List of board configurations. *Danh sách các cấu hình bàn cờ.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` is between 1 and 9. This small range allows for backtracking.
*   Queens must not share rows, columns, or diagonals.
*   *`n` nằm trong khoảng từ 1 đến 9. Phạm vi nhỏ này cho phép thực hiện quay lui.*
*   *Các quân hậu không được ở cùng hàng, cột hoặc đường chéo.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking (DFS)
### *Hướng tiếp cận: Quay lui (DFS)*

*   **Intuition:** Place one queen per row. For each row, check all possible columns. Maintain sets to keep track of columns and diagonals already occupied.
*   *Ý tưởng: Đặt một quân hậu trên mỗi hàng. Đối với mỗi hàng, kiểm tra tất cả các cột có thể. Duy trì các tập hợp để theo dõi các cột và đường chéo đã bị chiếm dụng.*

*   **Algorithm Steps:**
    1.  Create an empty board.
    2.  `solve(row)`:
        *   If `row == n`, add board to results.
        *   For `col` from `0` to `n-1`:
            *   Check if `col`, `row + col` (anti-diagonal), and `row - col` (main diagonal) are safe.
            *   Place queen, mark columns and diagonals.
            *   `solve(row + 1)`.
            *   Backtrack: Remove queen, unmark columns and diagonals.

*   **Complexity:**
    *   Time: $O(N!)$.
    *   Space: $O(N^2)$ to store the board.

### Dry Run
### *Chạy thử*
`n = 4`
1. Row 0: Place at (0, 1).
2. Row 1: Place at (1, 3).
3. Row 2: Place at (2, 0).
4. Row 3: Place at (3, 2).
All 4 queens placed -> Solution found!
Result: `[[".Q..","...Q","Q...","..Q."], ...]`
