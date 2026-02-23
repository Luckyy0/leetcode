# Result for Game of Life
# *Kết quả cho bài toán Trò chơi Cuộc sống*

## Description
## *Mô tả*

According to [Wikipedia's article](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life): "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
*Theo [bài viết trên Wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life): "Trò chơi Cuộc sống, còn được gọi đơn giản là Life, là một máy tự động tế bào được phát minh bởi nhà toán học người Anh John Horton Conway vào năm 1970."*

The board is made up of an `m x n` grid of cells, where each cell has an initial state: **live** (represented by a `1`) or **dead** (represented by a `0`). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
*Bàn cờ được tạo thành từ một lưới `m x n` các ô, trong đó mỗi ô có trạng thái ban đầu: **sống** (đại diện bởi `1`) hoặc **chết** (đại diện bởi `0`). Mỗi ô tương tác với tám hàng xóm của nó (ngang, dọc, chéo) bằng cách sử dụng bốn quy tắc sau:*

1.  Any live cell with fewer than two live neighbors dies as if caused by under-population. (*Bất kỳ ô sống nào có ít hơn hai hàng xóm sống đều chết do thiếu dân số.*)
2.  Any live cell with two or three live neighbors lives on to the next generation. (*Bất kỳ ô sống nào có hai hoặc ba hàng xóm sống đều sống tiếp sang thế hệ tiếp theo.*)
3.  Any live cell with more than three live neighbors dies, as if by over-population. (*Bất kỳ ô sống nào có hơn ba hàng xóm sống đều chết do quá đông dân số.*)
4.  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. (*Bất kỳ ô chết nào có chính xác ba hàng xóm sống đều trở thành ô sống do sinh sản.*)

The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the `m x n` grid `board`, return *the next state*.
*Trạng thái tiếp theo được tạo ra bằng cách áp dụng các quy tắc trên đồng thời cho mọi ô trong trạng thái hiện tại. Cho trạng thái hiện tại của lưới `m x n` `board`, trả về *trạng thái tiếp theo*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]`
**Output:** `[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `board = [[1,1],[1,0]]`
**Output:** `[[1,1],[1,1]]`

## Constraints:
## *Ràng buộc:*

*   `m == board.length`
*   `n == board[i].length`
*   `1 <= m, n <= 25`
*   `board[i][j]` is `0` or `1`.

**Follow up:**
*   Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
*   In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
