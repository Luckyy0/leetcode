# 36. Valid Sudoku / Sudoku Hợp Lệ

## Problem Description / Mô tả bài toán
Determine if a `9 x 9` Sudoku board is valid. Only the filled cells need to be validated **according to the following rules**:
Xác định xem bảng Sudoku `9 x 9` có hợp lệ hay không. Chỉ các ô đã điền cần được xác thực **theo các quy tắc sau**:

1.  Each row must contain the digits `1-9` without repetition.
    Mỗi hàng phải chứa các chữ số `1-9` mà không bị lặp lại.
2.  Each column must contain the digits `1-9` without repetition.
    Mỗi cột phải chứa các chữ số `1-9` mà không bị lặp lại.
3.  Each of the nine `3 x 3` sub-boxes of the grid must contain the digits `1-9` without repetition.
    Mỗi trong chín ô phụ `3 x 3` của lưới phải chứa các chữ số `1-9` mà không bị lặp lại.

**Note**:
- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Một bảng Sudoku (được điền một phần) có thể hợp lệ nhưng không nhất thiết phải giải được.
- Only the filled cells need to be validated according to the mentioned rules.
- Chỉ các ô đã điền cần được xác thực theo các quy tắc đã đề cập.

### Example 1:
```text
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
```

### Example 2:
```text
Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
```

## Constraints / Ràng buộc
- `board.length == 9`
- `board[i].length == 9`
- `board[i][j]` is a digit `1-9` or `'.'`.

---

## Analysis / Phân tích

### Approach: One Iteration / Một Lần Duyệt
- **Idea**: Iterate through each cell `(i, j)`. If it contains a number, check if it has already appeared in the current row, current column, or current 3x3 box.
- **Ý tưởng**: Duyệt qua từng ô `(i, j)`. Nếu nó chứa một số, kiểm tra xem nó đã xuất hiện trong hàng hiện tại, cột hiện tại, hoặc ô 3x3 hiện tại chưa.
- **Storage**: We can use 2D boolean arrays (or sets) to track seen numbers.
    - `rows[9][9]`: `rows[i][num]` is true if `num` is in row `i`.
    - `cols[9][9]`: `cols[j][num]` is true if `num` is in col `j`.
    - `boxes[9][9]`: `boxes[k][num]` is true if `num` is in box `k`.
- **Box Index**: The index `k` for the box at `(i, j)` is `(i / 3) * 3 + j / 3`.
- **Time Complexity**: O(N^2) where N=9. Since N is fixed, it's effectively O(1).
- **Space Complexity**: O(N^2).

---

## Edge Cases / Các trường hợp biên
1.  **Empty Board**: All dots -> Valid.
2.  **Partially Filled**: Check constraints normally.
3.  **Invalid**: Repetitions in any of the 3 scopes.
