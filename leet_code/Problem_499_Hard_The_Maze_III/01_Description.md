# Result for The Maze III
# *Kết quả cho bài toán Mê cung III*

## Description
## *Mô tả*

There is a ball in a `maze` with empty spaces (represented as `0`) and walls (represented as `1`). The ball can go through the empty spaces by rolling **up, down, left or right**, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a **hole** in this maze. The ball will drop into the hole if it rolls onto the hole.
*Có một quả bóng trong một `maze` (mê cung) với các khoảng trống (được biểu thị là `0`) và các bức tường (được biểu thị là `1`). Quả bóng có thể đi qua các khoảng trống bằng cách lăn **lên, xuống, trái hoặc phải**, nhưng nó sẽ không dừng lăn cho đến khi va vào tường. Khi quả bóng dừng lại, nó có thể chọn hướng tiếp theo. Cũng có một cái **lỗ** trong mê cung này. Quả bóng sẽ rơi vào lỗ nếu nó lăn vào lỗ.*

Given the `maze`, the ball's position `ball` and the hole's position `hole`, where `ball = [ball_row, ball_col]` and `hole = [hole_row, hole_col]`, return *a string instructions of all the instructions that the ball should follow to drop in the hole with the **shortest distance***. If there are multiple instructions associated with the shortest distance, return the one that is **lexicographically smallest**. If the ball cannot drop in the hole, return `"impossible"`.
*Cho `maze`, vị trí của quả bóng `ball` và vị trí của lỗ `hole`, trong đó `ball = [ball_row, ball_col]` và `hole = [hole_row, hole_col]`, hãy trả về *một chuỗi chỉ dẫn gồm tất cả các chỉ dẫn mà quả bóng nên tuân theo để rơi vào lỗ với **khoảng cách ngắn nhất***. Nếu có nhiều chỉ dẫn liên quan đến khoảng cách ngắn nhất, hãy trả về chỉ dẫn có thứ tự **từ điển nhỏ nhất**. Nếu quả bóng không thể rơi vào lỗ, hãy trả về `"impossible"`.*

If there is a way for the ball to drop in the hole, the answer `instructions` should contain the characters `'u'` (i.e., up), `'d'` (i.e., down), `'l'` (i.e., left), and `'r'` (i.e., right).
*Nếu có cách để quả bóng rơi vào lỗ, câu trả lời `instructions` nên chứa các ký tự `'u'` (tức là lên), `'d'` (tức là xuống), `'l'` (tức là trái), và `'r'` (tức là phải).*

The distance is the number of **empty spaces** traveled by the ball from the start position (excluded) to the hole (included).
*Khoảng cách là số lượng **khoảng trống** mà bóng đã đi qua từ vị trí bắt đầu (không tính) đến lỗ (tính cả).*

## Example 1:
## *Ví dụ 1:*

**Input:** `maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], ball = [4,3], hole = [0,1]`
**Output:** `"lul"`
**Explanation:** There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

## Constraints:
## *Ràng buộc:*

*   `m == maze.length`
*   `n == maze[i].length`
*   `1 <= m, n <= 100`
*   `maze[i][j]` is `0` or `1`.
*   `ball.length == 2`
*   `hole.length == 2`
*   `ball != hole`
*   The maze contains at least 2 empty spaces.
