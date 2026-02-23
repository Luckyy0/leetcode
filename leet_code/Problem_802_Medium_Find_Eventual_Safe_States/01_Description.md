# Result for Find Eventual Safe States
# *Kết quả cho bài toán Tìm các trạng thái an toàn cuối cùng*

## Description
## *Mô tả*

There is a directed graph of `n` nodes with each node labeled from `0` to `n - 1`. The graph is represented by a **0-indexed** 2D integer array `graph` where `graph[i]` is an integer array of nodes adjacent to node `i`, meaning there is an edge from node `i` to each node in `graph[i]`.
*Có một đồ thị có hướng gồm `n` nút với mỗi nút được đánh số từ `0` đến `n - 1`. Đồ thị được biểu diễn bằng mảng số nguyên 2D `graph` trong đó `graph[i]` là danh sách các nút kề với nút `i`.*

A node is a **terminal node** if there are no outgoing edges. A node is a **safe node** if every possible path starting from that node leads to a **terminal node** (or another safe node).
*Một nút là **nút kết thúc** nếu không có cạnh đi ra. Một nút là **nút an toàn** nếu mọi con đường bắt đầu từ nút đó đều dẫn đến một **nút kết thúc**.*

Return *an array containing all the **safe nodes** of the graph*. The answer should be sorted in **ascending** order.
*Trả về *một mảng chứa tất cả các **nút an toàn** của đồ thị*. Kết quả phải được sắp xếp theo thứ tự **tăng dần**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** graph = [[1,2],[2,3],[5],[0],Extra... wait]
Actually: [[1,2],[2,3],[5],[0],[5],[],[]]
**Output:** [2,4,5,6]
**Explanation:**
The graph is directed.
Terminal nodes (no output): 5, 6.
Nodes that eventually leads to 5 or 6: 2, 4.
Node 0, 1, 3 are part of a cycle. Paths from them can loop forever.

## Example 2:
## *Ví dụ 2:*

**Input:** graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
**Output:** [4]

---

## Constraints:
## *Ràng buộc:*

*   `n == graph.length`
*   `1 <= n <= 10^4`
*   `0 <= graph[i].length <= n`
*   `0 <= graph[i][j] <= n - 1`
*   `graph[i]` is sorted in strictly increasing order.
*   The graph may contain self-loops.
*   The number of edges in the graph is in the range `[1, 4 * 10^4]`.
