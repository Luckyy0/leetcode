# Result for Minesweeper
# *Kết quả cho bài toán Dò mìn*

## Description
## *Mô tả*

Let's play the minesweeper game ([Wikipedia](https://en.wikipedia.org/wiki/Minesweeper_(video_game)), [online game](http://minesweeperonline.com/))!
*Hãy chơi trò chơi dò mìn ([Wikipedia](https://en.wikipedia.org/wiki/Minesweeper_(video_game)), [trò chơi trực tuyến](http://minesweeperonline.com/))!*

You are given an `m x n` char matrix `board` representing the game board where:
*Bạn được cho một ma trận ký tự `m x n` `board` đại diện cho bảng trò chơi trong đó:*

*   `'M'` represents an **unrevealed** mine,
    *`'M'` đại diện cho một quả mìn **chưa được tiết lộ**,*
*   `'E'` represents an **unrevealed** empty square,
    *`'E'` đại diện cho một ô trống **chưa được tiết lộ**,*
*   `'B'` represents a **revealed** blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
    *`'B'` đại diện cho một ô trống **đã được tiết lộ** không có mìn lân cận (tức là, trên, dưới, trái, phải và tất cả 4 đường chéo),*
*   digit (`'1'` to `'8'`) represents how many mines are adjacent to this revealed square, and
    *chữ số (`'1'` đến `'8'`) đại diện cho có bao nhiêu quả mìn lân cận với ô đã được tiết lộ này, và*
*   `'X'` represents a **revealed** mine.
    *`'X'` đại diện cho một quả mìn **đã được tiết lộ**.*

You are also given an integer array `click` where `click = [clickr, clickc]` represents the next click position among all the **unrevealed** squares (`'M'` or `'E'`).
*Bạn cũng được cho một mảng số nguyên `click` trong đó `click = [clickr, clickc]` đại diện cho vị trí nhấp tiếp theo trong số tất cả các ô **chưa được tiết lộ** (`'M'` hoặc `'E'`).*

Return *the board after revealing this position according to the following rules*:
*Trả về *bảng sau khi tiết lộ vị trí này theo các quy tắc sau*:*

1.  If a mine `'M'` is revealed, then the game is over - change it to `'X'`.
    *Nếu một quả mìn `'M'` được tiết lộ, thì trò chơi kết thúc - thay đổi nó thành `'X'`.*
2.  If an empty square `'E'` with **no adjacent mines** is revealed, then change it to `'B'` and all of its adjacent **unrevealed** squares should be revealed recursively.
    *Nếu một ô trống `'E'` **không có mìn lân cận** được tiết lộ, hãy thay đổi nó thành `'B'` và tất cả các ô **chưa được tiết lộ** lân cận của nó phải được tiết lộ một cách đệ quy.*
3.  If an empty square `'E'` with **at least one adjacent mine** is revealed, then change it to a digit (`'1'` to `'8'`) representing the number of adjacent mines.
    *Nếu một ô trống `'E'` có **ít nhất một quả mìn lân cận** được tiết lộ, hãy thay đổi nó thành một chữ số (`'1'` đến `'8'`) đại diện cho số lượng mìn lân cận.*
4.  Return the board when no more squares will be revealed.
    *Trả về bảng khi không còn ô nào được tiết lộ nữa.*

## Example 1:
## *Ví dụ 1:*

**Input:** `board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]`
**Output:** `[["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]`
**Output:** `[["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]`

## Constraints:
## *Ràng buộc:*

*   `m == board.length`
*   `n == board[i].length`
*   `1 <= m, n <= 50`
*   `board[i][j]` is either `'M'`, `'E'`, `'B'`, or a digit from `'1'` to `'8'`.
*   `click.length == 2`
*   `0 <= clickr < m`
*   `0 <= clickc < n`
*   `board[clickr][clickc]` is either `'M'` or `'E'`.
