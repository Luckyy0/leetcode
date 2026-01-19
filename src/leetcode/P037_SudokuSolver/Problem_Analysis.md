# 37. Sudoku Solver / Giải Sudoku

## Problem Description / Mô tả bài toán
Write a program to solve a Sudoku puzzle by filling the empty cells.
Viết một chương trình để giải câu đố Sudoku bằng cách điền vào các ô trống.

A sudoku solution must satisfy all of the following rules:
Một lời giải Sudoku phải thỏa mãn tất cả các quy tắc sau:
1.  Each of the digits `1-9` must occur exactly once in each row.
    Mỗi chữ số `1-9` phải xuất hiện chính xác một lần trong mỗi hàng.
2.  Each of the digits `1-9` must occur exactly once in each column.
    Mỗi chữ số `1-9` phải xuất hiện chính xác một lần trong mỗi cột.
3.  Each of the digits `1-9` must occur exactly once in each of the 9 `3x3` sub-boxes of the grid.
    Mỗi chữ số `1-9` phải xuất hiện chính xác một lần trong mỗi ô phụ `3x3` của lưới.

The `'.'` character indicates empty cells.
Ký tự `'.'` biểu thị các ô trống.

### Example 1:
```text
Input: board = ... (Visual puzzle)
Output: ... (Solved puzzle)
```

## Constraints / Ràng buộc
- `board.length == 9`
- `board[i].length == 9`
- `board[i][j]` is a digit `1-9` or `'.'`.
- It is guaranteed that the input board has only one solution.

---

## Analysis / Phân tích

### Approach: Backtracking / Quay Lui
- **Idea**: We try to fill the board one cell at a time.
- **Ý tưởng**: Chúng ta cố gắng điền vào bảng từng ô một.
- **Algorithm**:
    1.  Find the first empty cell (containing `'.'`).
    2.  Try placing digits `1` through `9` in that cell.
    3.  For each digit, check if it is valid (does not exist in the current row, column, or 3x3 box).
    4.  If valid, place the digit and verify if this placement leads to a solution by recursively calling the solve function.
    5.  If the recursive call returns `true`, we found the solution.
    6.  If not, reset the cell to `'.'` (backtrack) and try the next digit.
    7.  If no digits work, return `false`.
- **Optimization**: We can pre-calculate or track constraints (like in Valid Sudoku) to make validity checks O(1) instead of traversing row/col/box every time. However, for 9x9, standard checking is fast enough.
- **Time Complexity**: O(9^m), where m is the number of empty cells.
- **Space Complexity**: O(n^2) for board and recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Solved Board**: Already solved, should return immediately.
2.  **Unsolvable**: Should return false (though constraint guarantees a solution).
