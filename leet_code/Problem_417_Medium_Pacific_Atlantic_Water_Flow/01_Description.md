# Result for Pacific Atlantic Water Flow
# *Kết quả cho bài toán Dòng nước Thái Bình Dương - Đại Tây Dương*

## Description
## *Mô tả*

There is an `m x n` rectangular island that borders both the **Pacific Ocean** and **Atlantic Ocean**. The **Pacific Ocean** touches the island's left and top edges, and the **Atlantic Ocean** touches the island's right and bottom edges.
*Có một hòn đảo hình chữ nhật `m x n` tiếp giáp với cả **Thái Bình Dương** và **Đại Tây Dương**. **Thái Bình Dương** tiếp giáp với các cạnh trái và trên của đảo, còn **Đại Tây Dương** tiếp giáp với các cạnh phải và dưới của đảo.*

The island is partitioned into a grid of square cells. You are given an `m x n` integer matrix `heights` where `heights[r][c]` represents the **height above sea level** of the cell at coordinate `(r, c)`.
*Hòn đảo được chia thành một mạng lưới các ô vuông. Bạn được cho một ma trận số nguyên `m x n` `heights` trong đó `heights[r][c]` đại diện cho **độ cao so với mực nước biển** của ô tại tọa độ `(r, c)`.*

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is **less than or equal to** the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
*Hòn đảo nhận rất nhiều mưa, và nước mưa có thể chảy sang các ô lân cận theo hướng bắc, nam, đông, tây nếu độ cao của ô lân cận **nhỏ hơn hoặc bằng** độ cao của ô hiện tại. Nước có thể chảy từ bất kỳ ô nào tiếp giáp với đại dương vào đại dương đó.*

Return *a 2D list of grid coordinates `result` where `result[i] = [ri, ci]` means that rain water can flow from cell `(ri, ci)` to **both** the Pacific and Atlantic oceans*.
*Hãy trả về *danh sách 2D các tọa độ lưới `result` trong đó `result[i] = [ri, ci]` có nghĩa là nước mưa có thể chảy từ ô `(ri, ci)` đến **cả hai** đại dương Thái Bình Dương và Đại Tây Dương*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]`
**Output:** `[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `heights = [[1]]`
**Output:** `[[0,0]]`

## Constraints:
## *Ràng buộc:*

*   `m == heights.length`
*   `n == heights[r].length`
*   `1 <= m, n <= 200`
*   `0 <= heights[r][c] <= 10^5`
