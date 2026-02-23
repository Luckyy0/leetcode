# Result for The Maze
# *Kết quả cho bài toán Mê cung*

## Description
## *Mô tả*

There is a ball in a `maze` with empty spaces (represented as `0`) and walls (represented as `1`). The ball can go through the empty spaces by rolling **up, down, left or right**, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
*Có một quả bóng trong một `maze` (mê cung) với các khoảng trống (được biểu thị là `0`) và các bức tường (được biểu thị là `1`). Quả bóng có thể đi qua các khoảng trống bằng cách lăn **lên, xuống, trái hoặc phải**, nhưng nó sẽ không dừng lăn cho đến khi va vào tường. Khi quả bóng dừng lại, nó có thể chọn hướng tiếp theo.*

Given the `maze`, the ball's `start` position and the `destination`, where `start = [start_row, start_col]` and `destination = [destination_row, destination_col]`, return `true` if the ball can stop at the destination, otherwise return `false`.
*Cho `maze`, vị trí `start` (bắt đầu) của quả bóng và `destination` (đích), trong đó `start = [start_row, start_col]` và `destination = [destination_row, destination_col]`, hãy trả về `true` nếu quả bóng có thể dừng lại ở đích, nếu không hãy trả về `false`.*

You may assume that **the borders of the maze are all walls**.
*Bạn có thể giả định rằng **các biên của mê cung đều là tường**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]`
**Output:** `true`
**Explanation:** One possible way is : left -> down -> left -> down -> right -> down -> right.

## Example 2:
## *Ví dụ 2:*

**Input:** `maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]`
**Output:** `false`
**Explanation:** There is no way for the ball to stop at the destination.

## Constraints:
## *Ràng buộc:*

*   `m == maze.length`
*   `n == maze[i].length`
*   `1 <= m, n <= 100`
*   `maze[i][j]` is `0` or `1`.
*   `start.length == 2`
*   `destination.length == 2`
