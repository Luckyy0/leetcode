# Analysis for Sudoku Solver
# *Phân tích cho bài toán Giải Sudoku*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** 2D char array `board`. *Mảng ký tự 2 chiều `board`.*
*   **Output:** Modifies board in-place. *Sửa đổi bảng tại chỗ.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   9x9 grid.
*   One solution guaranteed.
*   Backtracking is the standard approach for Sudoku.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking
### *Hướng tiếp cận: Quay lui*

*   **Intuition:** Iterate through each cell. If it's empty, try numbers 1-9. If a number is valid (check row, col, box), place it and recurse. If recursion returns true, we're done. If not, backtrack (reset cell to '.') and try next number.
    *Ý tưởng: Duyệt qua từng ô. Nếu nó trống, hãy thử các số 1-9. Nếu một số hợp lệ (kiểm tra hàng, cột, hộp), hãy đặt nó và đệ quy. Nếu đệ quy trả về true, xong. Nếu không, quay lui (đặt lại ô thành '.') và thử số tiếp theo.*
*   **Algorithm Steps:**
    1.  Find first empty cell (row, col).
    2.  If no empty cells, return `true`.
    3.  Loop `c` from '1' to '9'.
    4.  Check `isValid(board, row, col, c)`.
    5.  If valid:
        *   `board[row][col] = c`.
        *   If `solve(board)` returns `true`, return `true`.
        *   Backtrack: `board[row][col] = '.'`.
    6.  Return `false`.

*   **Complexity:**
    *   Time: $O(9^M)$, where M is number of empty cells. In practice, constraints pruning makes it much faster.
    *   Space: $O(1)$ (Recursion stack depth max 81).

### Dry Run
### *Chạy thử*
... Standard backtracking flow ...
If cell (0,2) is empty, try '1', '2', ... valid? Place '4'. Recurse.
If stuck later, clear (0,2) and try '5'.
All filled -> True.
