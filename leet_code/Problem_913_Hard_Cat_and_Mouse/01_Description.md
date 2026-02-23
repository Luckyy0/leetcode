# Result for Cat and Mouse
# *Kết quả cho bài toán Mèo và Chuột*

## Description
## *Mô tả*

A game on an **undirected** graph is played by two players, Mouse and Cat, who alternate turns.
*Một trò chơi trên đồ thị **vô hướng** được chơi bởi hai người chơi, Chuột và Mèo, thay phiên nhau đi.*

The graph is given as follows: `graph[a]` is a list of all nodes `b` such that `ab` is an edge of the graph.
*Đồ thị được cho như sau: `graph[a]` là một danh sách tất cả các nút `b` sao cho `ab` là một cạnh của đồ thị.*

The mouse starts at node `1` and goes first, the cat starts at node `2` and goes second, and there is a hole at node `0`.
*Chuột bắt đầu ở nút `1` và đi trước, mèo bắt đầu ở nút `2` và đi sau, và có một cái lỗ ở nút `0`.*

During each player's turn, they **must** travel along one edge of the graph that connects to their current position. For example, if the Mouse is at node `1`, it must travel to any node in `graph[1]`.
*Trong lượt của mỗi người chơi, họ **phải** di chuyển dọc theo một cạnh của đồ thị kết nối với vị trí hiện tại của họ. Ví dụ, nếu Chuột ở nút `1`, nó phải di chuyển đến bất kỳ nút nào trong `graph[1]`.*

In addition, it is not allowed for the Cat to travel to the Hole (node `0`).
*Ngoài ra, Mèo không được phép di chuyển đến Lỗ (nút `0`).*

Then, the game can end in three ways:
*Sau đó, trò chơi có thể kết thúc theo ba cách:*

*   If ever the Cat occupies the same node as the Mouse, the Cat wins.
    *   *Nếu Mèo chiếm cùng một nút với Chuột, Mèo thắng.*
*   If ever the Mouse reaches the Hole, the Mouse wins.
    *   *Nếu Chuột đến Lỗ, Chuột thắng.*
*   If ever a position is repeated (i.e., the players are in the same position as a previous turn, and it is the same player's turn to move), the game is a draw.
    *   *Nếu một vị trí bị lặp lại (nghĩa là người chơi đang ở cùng vị trí như một lượt trước đó, và đến lượt cùng một người chơi di chuyển), trò chơi hòa.*

Given a `graph`, and assuming both players play optimally, return
*Cho một `graph`, và giả sử cả hai người chơi đều chơi tối ưu, hãy trả về*

*   `1` if the mouse wins the game,
    *   `1` nếu Chuột thắng trò chơi,*
*   `2` if the cat wins the game, or
    *   `2` nếu Mèo thắng trò chơi, hoặc*
*   `0` if the game is a draw.
    *   `0` nếu trò chơi hòa.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
**Output:** 0

## Example 2:
## *Ví dụ 2:*

**Input:** graph = [[1,3],[0],[3],[0,2]]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `3 <= graph.length <= 50`
*   `1 <= graph[i].length < graph.length`
*   `0 <= graph[i][j] < graph.length`
*   `graph[i][j] != i`
*   `graph[i]` is unique.
*   The mouse and the cat can always move.
