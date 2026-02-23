# Result for Spiral Matrix III
# *Kết quả cho bài toán Ma trận Xoắn ốc III*

## Description
## *Mô tả*

You start at the cell `(rStart, cStart)` of an `rows x cols` grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
*Bạn bắt đầu tại ô `(rStart, cStart)` của một lưới `rows x cols` hướng về phía đông. Góc tây bắc nằm ở hàng và cột đầu tiên trong lưới, và góc đông nam nằm ở hàng và cột cuối cùng.*

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later). Eventually, we reach all `rows * cols` spaces of the grid.
*Bạn sẽ di chuyển theo hình xoắn ốc theo chiều kim đồng hồ để ghé thăm mọi vị trí trong lưới này. Bất cứ khi nào bạn di chuyển ra ngoài biên giới của lưới, chúng ta vẫn tiếp tục di chuyển bên ngoài lưới (nhưng có thể quay lại biên giới lưới sau đó). Cuối cùng, chúng ta sẽ đến tất cả các ô `rows * cols` của lưới.*

Return *an array of coordinates representing the positions of the grid in the order you visited them*.
*Hãy trả về *một mảng các tọa độ đại diện cho các vị trí của lưới theo thứ tự bạn đã ghé thăm chúng*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** rows = 1, cols = 4, rStart = 0, cStart = 0
**Output:** [[0,0],[0,1],[0,2],[0,3]]

## Example 2:
## *Ví dụ 2:*

**Input:** rows = 5, cols = 6, rStart = 1, cStart = 4
**Output:** [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= rows, cols <= 100`
*   `0 <= rStart < rows`
*   `0 <= cStart < cols`
