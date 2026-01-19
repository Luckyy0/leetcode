# 289. Game of Life / Trò Chơi Sự Sống

## Problem Description / Mô tả bài toán
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
Theo bài báo của Wikipedia: "Game of Life, hay còn gọi đơn giản là Life, là một máy tự động tế bào được nhà toán học người Anh John Horton Conway phát minh ra vào năm 1970."

The board is made up of an `m x n` grid of cells, where each cell has an initial state: `live` (represented by a `1`) or `dead` (represented by a `0`). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Bảng trò chơi được tạo thành từ một lưới `m x n` ô, trong đó mỗi ô có trạng thái ban đầu: `sống` (được biểu thị bằng `1`) hoặc `chết` (được biểu thị bằng `0`). Mỗi ô tương tác với tám ô lân cận của nó (ngang, dọc, chéo) bằng cách sử dụng bốn quy tắc sau:

1.  Any live cell with fewer than two live neighbors dies as if caused by under-population. (Tế bào sống có < 2 hàng xóm sống -> chết).
2.  Any live cell with two or three live neighbors lives on to the next generation. (Tế bào sống có 2 hoặc 3 hàng xóm sống -> tiếp tục sống).
3.  Any live cell with more than three live neighbors dies, as if by over-population. (Tế bào sống có > 3 hàng xóm sống -> chết).
4.  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. (Tế bào chết có đúng 3 hàng xóm sống -> sống lại).

The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the `m x n` grid `board`, return the next state.
Trạng thái tiếp theo được tạo ra bằng cách áp dụng đồng thời các quy tắc trên cho mọi ô trong trạng thái hiện tại.

**Follow up**: Could you solve it in-place?
Bạn có thể giải quyết nó tại chỗ (in-place) không?

### Example 1:
```text
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
```

## Constraints / Ràng buộc
- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 25`
- `board[i][j]` is `0` or `1`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### In-place State Encoding / Mã Hóa Trạng Thái Tại Chỗ
To update concurrently, we need old states while writing new states.
We can use bit manipulation or extra values to store "Old State -> New State" in same cell.
States:
- `00` (0): Dead -> Dead.
- `01` (1): Live -> Dead. (Under/Over population).
- `10` (2): Dead -> Live. (Reproduction).
- `11` (3): Live -> Live. (Survival).

Wait, more intuitive:
- `0`: Dead -> Dead.
- `1`: Live -> Live.
- `-1` or `2`: Live -> Dead. (Was 1, now 0).
- `3` or `-2`: Dead -> Live. (Was 0, now 1).

Or simply use bits:
Bit 0: Old state.
Bit 1: New state.
- `0` (00): Dead -> Dead.
- `1` (01): Live -> Dead. (Wait, input is 1).
  - Input `1` means `01` (Old=1, New=0?). No, input is just old.
  - Let's encode: `NewState << 1 | OldState`.
  - Init: `board[i][j]` is `OldState` (0 or 1).
  - Logic: Compute `NewState`.
  - Store: `board[i][j] = (NewState << 1) | board[i][j]`.
  - Neighbors Count: Count `board[neighbor] & 1`.
  - Finalize: `board[i][j] >>= 1`.

**Algorithm**:
1.  Iterate all cells. Count neighbors (using `val & 1`).
2.  Determine `NewState`.
3.  Update `val |= (NewState << 1)`.
4.  Iterate all cells again. `val >>= 1`.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Bit Manipulation

**Edge Cases**:
1.  Grid boundaries.

---
