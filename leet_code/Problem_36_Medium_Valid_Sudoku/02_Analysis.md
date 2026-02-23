# Analysis for Valid Sudoku
# *Phân tích cho bài toán Sudoku Hợp Lệ*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** 2D char array `board` (9x9). *Mảng ký tự 2 chiều `board` (9x9).*
*   **Output:** Boolean (valid or not). *Boolean (hợp lệ hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Fixed size 9x9.
*   Only filled cells (digits) matter. Empty cells `.` are ignored.
*   Check rows, cols, sub-boxes.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Array Hashing / Flags
### *Hướng tiếp cận: Băm Mảng / Cờ*

*   **Intuition:** We need to track seen numbers for each row, column, and block.
    *Ý tưởng: Chúng ta cần theo dõi các số đã thấy cho mỗi hàng, cột và khối.*
*   **Data Structures:**
    *   `boolean[9][9] rows`: `rows[i][num]` is true if number `num+1` exists in row `i`.
    *   `boolean[9][9] cols`: `cols[j][num]` is true if number `num+1` exists in col `j`.
    *   `boolean[9][9] boxes`: `boxes[boxIndex][num]` is true if number `num+1` exists in box `boxIndex`.
        *   `boxIndex = (i / 3) * 3 + (j / 3)`.
*   **Algorithm Steps:**
    1.  Initialize boolean arrays.
    2.  Iterate `i` from 0 to 8, `j` from 0 to 8.
    3.  If `board[i][j]` is not `.`:
        *   `num = board[i][j] - '1'`. (0-8 range).
        *   Check `rows[i][num]`, `cols[j][num]`, `boxes[k][num]`.
        *   If any is true -> Return `false`.
        *   Mark them as true.
    4.  Return `true`.

*   **Complexity:**
    *   Time: $O(1)$ (Since 9x9 is constant). Ideally $O(N^2)$ for NxN Sudoku.
    *   Space: $O(1)$ (Fixed arrays).

### Dry Run
### *Chạy thử*
`board[0][0] = '5'`.
*   `rows[0][4] = true`.
*   `cols[0][4] = true`.
*   `box[0][4] = true`.
Next... if we see '5' again in row 0, check `rows[0][4]` -> true -> invalid.
