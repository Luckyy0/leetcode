# Result for The Maze II
# *Kết quả cho bài toán Mê cung II*

## Description
## *Mô tả*

There is a ball in a `maze` with empty spaces (represented as `0`) and walls (represented as `1`). The ball can go through the empty spaces by rolling **up, down, left or right**, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
*Có một quả bóng trong một `maze` (mê cung) với các khoảng trống (được biểu thị là `0`) và các bức tường (được biểu thị là `1`). Quả bóng có thể đi qua các khoảng trống bằng cách lăn **lên, xuống, trái hoặc phải**, nhưng nó sẽ không dừng lăn cho đến khi va vào tường. Khi quả bóng dừng lại, nó có thể chọn hướng tiếp theo.*

Given the `maze`, the ball's `start` position and the `destination`, where `start = [start_row, start_col]` and `destination = [destination_row, destination_col]`, return *the shortest **distance** for the ball to stop at the destination*. If the ball cannot stop at the destination, return `-1`.
*Cho `maze`, vị trí `start` (bắt đầu) của quả bóng và `destination` (đích), trong đó `start = [start_row, start_col]` và `destination = [destination_row, destination_col]`, hãy trả về ***khoảng cách** ngắn nhất để quả bóng dừng lại ở đích*. Nếu quả bóng không thể dừng lại ở đích, hãy trả về `-1`.*

The distance is the number of **empty spaces** traveled by the ball from the start position (excluded) to the destination (included).
*Khoảng cách là số lượng **khoảng trống** mà bóng đã đi qua từ vị trí bắt đầu (không tính) đến đích (tính cả).*

## Example 1:
## *Ví dụ 1:*

**Input:** `maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]`
**Output:** `12`
**Explanation:** One possible way is : left -> down -> left -> down -> right -> down -> right.
The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

## Example 2:
## *Ví dụ 2:*

**Input:** `maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]`
**Output:** `-1`
**Explanation:** There is no way for the ball to stop at the destination.

## Constraints:
## *Ràng buộc:*

*   `m == maze.length`
*   `n == maze[i].length`
*   `1 <= m, n <= 100`
*   `maze[i][j]` is `0` or `1`.
*   `start.length == 2`
*   `destination.length == 2`
