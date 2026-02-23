# Result for Matrix Cells in Distance Order
# *Kết quả bài toán Các Ô Ma Trận theo Trật Tự Khoảng Cách*

## Description
## *Mô tả*

You are given four integers `rows`, `cols`, `rCenter`, and `cCenter`. There is a `rows x cols` matrix and you are on the cell with the coordinates `(rCenter, cCenter)`.
*Bạn được cấp bốn số nguyên `rows` (số hàng), `cols` (số cột), `rCenter`, và `cCenter`. Có một ma trận kích thước `rows x cols` và bạn đang đứng ngự trị tại ô tọa độ tâm điểm `(rCenter, cCenter)`.*

Return *the coordinates of all cells in the matrix, sorted by their **distance** from `(rCenter, cCenter)` from the smallest distance to the largest distance*. You may return the answer in **any order** that satisfies this condition.
*Yêu cầu: Trả về **tọa độ của TẤT CẢ các ô** nằm vụn vặt trong ma trận đó, nhưng phải được **xếp hạng (sort)** theo **Khoảng cách (Distance)** đi từ tâm `(rCenter, cCenter)` tăng dần từ cực Nhỏ đến cực Lớn. Nếu có nhiều ô cùng gánh chung một khoảng cách y hệt nhau, bạn được phép xổ ra tọa độ của chúng theo **bất kỳ thứ tự lộn xộn nào** miễn là đúng khối khoảng cách đó.*

The **distance** between two cells `(r1, c1)` and `(r2, c2)` is `|r1 - r2| + |c1 - c2|`.
*(Ghi chú: **Khoảng cách** di chuyển giữa hai ô `(r1, c1)` và `(r2, c2)` tuân theo hệ đo lường bậc thang Manhattan: `|r1 - r2| + |c1 - c2|`).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** rows = 1, cols = 2, rCenter = 0, cCenter = 0
**Output:** [[0,0],[0,1]]
**Explanation:** The distances from (0, 0) to other cells are:
- (0, 0) is 0
- (0, 1) is 1
*Giải thích: Ma trận nhỏ xíu $1 \times 2$. Đứng lù lù ở (0, 0). Khoảng cách về chính nó là 0 (lên top 1). Khoảng cách bay qua hàng xóm (0, 1) là 1 (rớt xuồng Đáy).*

## Example 2:
## *Ví dụ 2:*

**Input:** rows = 2, cols = 2, rCenter = 0, cCenter = 1
**Output:** [[0,1],[0,0],[1,1],[1,0]]
**Explanation:** The distances from (0, 1) to other cells are:
- (0, 1) is 0
- (0, 0) is 1
- (1, 1) is 1
- (1, 0) is 2
[0,1],[1,1],[0,0],[1,0] is also a valid answer.
*Giải thích: Đứng ở ô chóp phải (0, 1). Khoảng cách 0 -> (0, 1). Khoảng cách đè nhau mốc 1 -> (0, 0) và (1, 1). Khoảng cách văng tuốt mù khơi mốc 2 -> ô mút chỉ (1, 0).*

## Example 3:
## *Ví dụ 3:*

**Input:** rows = 2, cols = 3, rCenter = 1, cCenter = 2
**Output:** [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= rows, cols <= 100`
*   `0 <= rCenter < rows`
*   `0 <= cCenter < cols`
