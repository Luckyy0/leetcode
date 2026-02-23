# Result for Walls and Gates
# *Kết quả cho bài toán Tường và Cổng*

## Description
## *Mô tả*

You are given an `m x n` grid `rooms` initialized with these three possible values.
*Bạn được cho một lưới `m x n` `rooms` được khởi tạo với ba giá trị khả dĩ sau.*
*   `-1` A wall or an obstacle. (*Tường hoặc chướng ngại vật.*)
*   `0` A gate. (*Cổng.*)
*   `INF` Infinity means an empty room. We use the value `2^31 - 1 = 2147483647` to represent `INF` as you may assume that the distance to a gate is less than `2147483647`. (*Vô cực nghĩa là một căn phòng trống.*)

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with `INF`.
*Điền vào mỗi căn phòng trống khoảng cách đến cổng gần nhất của nó. Nếu không thể đến được cổng nào, hãy để nó là `INF`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]`
**Output:** `[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]`

## Constraints:
## *Ràng buộc:*

*   `m == rooms.length`
*   `n == rooms[i].length`
*   `1 <= m, n <= 250`
*   `rooms[i][j]` is `-1`, `0`, or `2^31 - 1`.
