# Result for Grid Illumination
# *Kết quả cho bài toán Chiếu Sáng Lưới*

## Description
## *Mô tả*

There is a 2D `grid` of size `n x n` where each cell of this grid has a lamp that is initially **turned off**.
*Có một `lưới` 2D kích thước `n x n` trong đó mỗi ô của lưới này có một bóng đèn ban đầu bị **tắt**.*

You are given a 2D array of lamp positions `lamps`, where `lamps[i] = [row_i, col_i]` indicates that the lamp at `grid[row_i][col_i]` is **turned on**. Even if the same lamp is listed more than once, it is turned on.
*Bạn được cho một mảng 2D các vị trí bóng đèn `lamps`, trong đó `lamps[i] = [row_i, col_i]` chỉ ra rằng bóng đèn tại `grid[row_i][col_i]` đang được **bật**. Ngay cả khi cùng một bóng đèn được liệt kê nhiều lần, nó vẫn đang được bật.*

When a lamp is turned on, it **illuminates its cell** and **all other cells** in the same **row, column, or diagonal**.
*Khi một bóng đèn được bật, nó **chiếu sáng ô của nó** và **tất cả các ô khác** cùng **hàng, cột, hoặc đường chéo**.*

You are also given another 2D array `queries`, where `queries[j] = [row_j, col_j]`. For the `j`th query, determine whether `grid[row_j][col_j]` is illuminated or not. After answering the `j`th query, **turn off** the lamp at `grid[row_j][col_j]` and its **8 adjacent lamps** if they exist. A lamp is adjacent if its cell shares either a side or corner with `grid[row_j][col_j]`.
*Bạn cũng được cho một mảng 2D khác `queries`, trong đó `queries[j] = [row_j, col_j]`. Đối với câu truy vấn thứ `j`, hãy xác định xem `grid[row_j][col_j]` có được chiếu sáng hay không. Sau khi trả lời câu truy vấn thứ `j`, hãy **tắt** bóng đèn tại `grid[row_j][col_j]` và **8 bóng đèn kề cạnh nó** nếu chúng tồn tại. Một bóng đèn kề cạnh nếu ô của nó chung cạnh hoặc chung góc với `grid[row_j][col_j]`.*

Return *an array of integers* `ans` *of size* `queries.length` *where* `ans[j]` *is* `1` *if the cell in the* `j`th *query was illuminated, or* `0` *if the cell was not illuminated.*
*Trả về *một mảng số nguyên* `ans` *kích thước* `queries.length` *trong đó* `ans[j]` *là* `1` *nếu ô trong câu truy vấn thứ* `j` *được chiếu sáng, hoặc* `0` *nếu ô đó không được chiếu sáng.*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
**Output:** [1,0]
**Explanation:** We have the initial grid with all lamps turned off. We then turn on the lamp at grid[0][0] and the lamp at grid[4][4].
The 0th query asks if the lamp at grid[1][1] is illuminated or not (the blue square). It is illuminated, so the 0th element of our answer is 1. Then, we turn off all lamps in the red square.
The 1st query asks if the lamp at grid[1][0] is illuminated or not. It is not illuminated, so the 1st element of our answer is 0. Then, we turn off all lamps in the red rectangle.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
**Output:** [1,1]

## Example 3:
## *Ví dụ 3:*

**Input:** n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
**Output:** [1,1,0]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^9`
*   `0 <= lamps.length <= 20000`
*   `0 <= queries.length <= 20000`
*   `lamps[i].length == 2`
*   `queries[j].length == 2`
