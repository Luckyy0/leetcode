# 1428. Leftmost Column with at Least a One / Cột Trái nhất có Ít nhất Một Số Một

## Problem Description / Mô tả bài toán
Binary Matrix `mat` sorted row-wise (0s then 1s).
Access via `BinaryMatrix` API (`get(r, c)`, `dimensions()`).
Limit calls to `1000`.
Find index of leftmost column with at least one 1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Staircase Search (Top-Right Start)
Since rows are sorted, we can use an approach similar to searching in a sorted matrix.
Start at top-right `(0, cols-1)`.
Current index `currCol = cols - 1`. `ans = -1`.
Iterate row `r` from 0 to rows-1.
While `currCol >= 0` and `get(r, currCol) == 1`:
- Found a 1. This column is a candidate. `ans = currCol`.
- Try to move left: `currCol--`.
Move down to next row? Actually, we don't need to re-check columns > `currCol` for subsequent rows, because we already found a 1 at `currCol` (or smaller). We only care about finding a SMALLER column index.
So just maintain `currCol`. If `get(r, currCol) == 0`, just move to next row `r++`.
If `get(r, currCol) == 1`, update ans, decrement `currCol` (stay in same row to check more left, then move to next row? No, if we find 1 at `currCol`, we want to check `currCol-1`. We can check `currCol-1` at current row. If 0, then for this row, leftmost is `currCol`. We can move to next row to see if we can beat `currCol`. Wait.
Optimization:
Start `(0, cols-1)`.
Loop while `r < rows` and `c >= 0`.
If `get(r, c) == 0`: `r++` (Need to find 1, this row didn't help at column `c` or left of it? Wait. If `(r, c)` is 0, then all to left are 0. So for THIS row, no 1 at `c` or left. Move down to try other rows).
If `get(r, c) == 1`: `ans = c`, `c--` (Found a 1. Maybe there's a 1 to the left in this row OR subsequent rows. Move left).

### Complexity / Độ phức tạp
- **Time**: O(M + N). Max calls M + N. (100+100=200 < 1000).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Top-Right Trick
Start at the top-right corner `(0, w-1)`.
If the current element is 0, move down (since everything to the left in this row is also 0).
If the current element is 1, update result (found a 1 at this column), and move left (to search for an even earlier 1).
Repeat until out of bounds.
Bắt đầu ở góc trên bên phải `(0, w-1)`.
Nếu phần tử hiện tại là 0, hãy di chuyển xuống (vì mọi thứ bên trái trong hàng này cũng là 0).
Nếu phần tử hiện tại là 1, cập nhật kết quả (tìm thấy 1 ở cột này) và di chuyển sang trái (để tìm kiếm 1 sớm hơn nữa).

---
