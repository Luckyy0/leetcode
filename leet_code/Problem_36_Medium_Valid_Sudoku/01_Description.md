# Result for Valid Sudoku
# *Kết quả cho bài toán Sudoku Hợp Lệ*

## Description
## *Mô tả*

Determine if a `9 x 9` Sudoku board is valid. Only the filled cells need to be validated **according to the following rules**:
*Xác định xem bảng Sudoku `9 x 9` có hợp lệ hay không. Chỉ các ô đã điền mới cần được xác thực **theo các quy tắc sau**:*

1.  Each row must contain the digits `1-9` without repetition.
    *Mỗi hàng phải chứa các chữ số `1-9` mà không bị lặp lại.*
2.  Each column must contain the digits `1-9` without repetition.
    *Mỗi cột phải chứa các chữ số `1-9` mà không bị lặp lại.*
3.  Each of the nine `3 x 3` sub-boxes of the grid must contain the digits `1-9` without repetition.
    *Mỗi trong chín ô phụ `3 x 3` của lưới phải chứa các chữ số `1-9` mà không bị lặp lại.*

**Note:**
***Lưu ý:***

*   A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    *Một bảng Sudoku (đã điền một phần) có thể hợp lệ nhưng không nhất thiết phải giải được.*
*   Only the filled cells need to be validated according to the mentioned rules.
    *Chỉ các ô đã điền mới cần được xác thực theo các quy tắc đã nêu.*

## Example 1:
## *Ví dụ 1:*

**Input:** board = 
```
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
```
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** board = 
```
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
```
**Output:** `false`
**Explanation:** Same as Example 1, except with the **5** in the top left corner being modified to **8**. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
***Giải thích:** Giống như Ví dụ 1, ngoại trừ số **5** ở góc trên bên trái được sửa thành **8**. Vì có hai số 8 trong ô phụ 3x3 ở góc trên bên trái, nên nó không hợp lệ.*

## Constraints:
## *Ràng buộc:*

*   `board.length == 9`
*   `board[i].length == 9`
*   `board[i][j]` is a digit `1-9` or `'.'`.
