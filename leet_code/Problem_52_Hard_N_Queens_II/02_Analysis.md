# Analysis for N-Queens II
# *Phân tích cho bài toán N-Queens II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n`. *Số nguyên `n`.*
*   **Output:** Integer (count of solutions). *Số lượng giải pháp.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Same as N-Queens I, but only return the count.
*   *Giống như N-Queens I, nhưng chỉ trả về số lượng.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking (DFS)
### *Hướng tiếp cận: Quay lui (DFS)*

*   **Intuition:** Similar to N-Queens I, we try to place queens row by row. Use boolean arrays to check safety for columns and diagonals. Instead of building the board, increment a counter when a solution is reached.
*   *Ý tưởng: Tương tự N-Queens I, chúng ta thử đặt quân hậu từng hàng một. Sử dụng các mảng boolean để kiểm tra an toàn cho các cột và đường chéo. Thay vì xây dựng bàn cờ, hãy tăng một biến đếm khi tìm thấy một giải pháp.*

*   **Algorithm Steps:**
    1.  Initialize `count = 0`.
    2.  Use sets or boolean arrays: `cols`, `diagonals1` (row-col), `diagonals2` (row+col).
    3.  `backtrack(row)`:
        *   If `row == n`, `count++` and return.
        *   For each `col` from `0` to `n-1`:
            *   Calculate diagonal indices.
            *   If safety check passes:
                *   Mark occupation.
                *   `backtrack(row + 1)`.
                *   Unmark (backtrack).
    4.  Return `count`.

*   **Complexity:**
    *   Time: $O(N!)$.
    *   Space: $O(N)$.

### Dry Run
### *Chạy thử*
`n = 4`
- Row 0: Col 1 safe.
- Row 1: Col 3 safe.
- Row 2: Col 0 safe.
- Row 3: Col 2 safe.
- Found solution! `count = 1`.
... (other solutions) ...
Final `count = 2`.
