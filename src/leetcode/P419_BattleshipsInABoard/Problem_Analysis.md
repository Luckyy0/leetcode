# 419. Battleships in a Board / Đếm Tàu Chiến Trong Bảng

## Problem Description / Mô tả bài toán
Given an `m x n` matrix `board` where each cell is a battleship `'X'` or empty `'.'`, return the number of the **battleships** on `board`.
Cho một ma trận `m x n` mang tên `board` trong đó mỗi ô là một phần của tàu chiến `'X'` hoặc trống `'.'`, hãy trả về số lượng **tàu chiến** trên bảng.

**Battleships** can only be placed horizontally or vertically on `board`. In other words, they can only be made of the shape `1 x k` (one row, k columns) or `k x 1` (k rows, one column), where `k` can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
**Tàu chiến** chỉ có thể được đặt nằm ngang hoặc nằm dọc. Nói cách khác, chúng chỉ có thể có hình dạng `1 x k` hoặc `k x 1`. Luôn có ít nhất một ô trống ngăn cách giữa hai tàu chiến (tức là không có tàu chiến nào nằm cạnh nhau).

### Example 1:
```text
Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2
```

### Example 2:
```text
Input: board = [["."]]
Output: 0
```

## Constraints / Ràng buộc
- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 200`
- `board[i][j]` is either `'.'` or `'X'`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### One-Pass Scan / Duyệt Một Lớp
The key to counting each battleship exactly once without extra space is to identify a unique "anchor" point for each battleship, such as its top-leftmost cell.

Algorithm:
Iterate through each cell `(i, j)` in the board. If the current cell is `'X'`:
1. Check if there is an `'X'` immediately above it: `board[i-1][j] == 'X'`.
2. Check if there is an `'X'` immediately to its left: `board[i][j-1] == 'X'`.

If neither is true, this cell is the "head" of a battleship. We increment the count. If either is true, this cell is part of a battleship we have already counted (shifting from the top or left).

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Anchor Counting

**Algorithm**:
1.  Iterate through `i, j`.
2.  If `board[i][j] == 'X'`:
    - if `i > 0 && board[i-1][j] == 'X'` continue.
    - if `j > 0 && board[i][j-1] == 'X'` continue.
    - `count++`.
3.  Return `count`.

---
