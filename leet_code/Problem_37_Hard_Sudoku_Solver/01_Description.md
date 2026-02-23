# Result for Sudoku Solver
# *Kết quả cho bài toán Giải Sudoku*

## Description
## *Mô tả*

Write a program to solve a Sudoku puzzle by filling the empty cells.
*Viết một chương trình để giải một câu đố Sudoku bằng cách điền vào các ô trống.*

A sudoku solution must satisfy all of the following rules:
*Một lời giải Sudoku phải thỏa mãn tất cả các quy tắc sau:*

1.  Each of the digits `1-9` must occur exactly once in each row.
    *Mỗi chữ số từ `1-9` phải xuất hiện chính xác một lần trong mỗi hàng.*
2.  Each of the digits `1-9` must occur exactly once in each column.
    *Mỗi chữ số từ `1-9` phải xuất hiện chính xác một lần trong mỗi cột.*
3.  Each of the digits `1-9` must occur exactly once in each of the 9 `3x3` sub-boxes of the grid.
    *Mỗi chữ số từ `1-9` phải xuất hiện chính xác một lần trong mỗi 9 ô phụ `3x3` của lưới.*

The `'.'` character indicates empty cells.
*Ký tự `'.'` biểu thị các ô trống.*

## Example 1:
## *Ví dụ 1:*

**Input:** board = 
```
[["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]]
```
**Output:** 
```
[["5","3","4","6","7","8","9","1","2"],
 ["6","7","2","1","9","5","3","4","8"],
 ["1","9","8","3","4","2","5","6","7"],
 ["8","5","9","7","6","1","4","2","3"],
 ["4","2","6","8","5","3","7","9","1"],
 ["7","1","3","9","2","4","8","5","6"],
 ["9","6","1","5","3","7","2","8","4"],
 ["2","8","7","4","1","9","6","3","5"],
 ["3","4","5","2","8","6","1","7","9"]]
```

## Constraints:
## *Ràng buộc:*

*   `board.length == 9`
*   `board[i].length == 9`
*   `board[i][j]` is a digit or `'.'`.
*   It is guaranteed that the input board has only one solution.
    *Đảm bảo rằng bảng đầu vào chỉ có một lời giải.*
