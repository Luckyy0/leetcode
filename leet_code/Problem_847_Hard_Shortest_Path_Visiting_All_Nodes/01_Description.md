# Result for Shortest Path Visiting All Nodes
# *Kết quả cho bài toán Đường đi Ngắn nhất Tham quan Tất cả các Nút*

## Description
## *Mô tả*

You have an undirected, connected graph of `n` nodes given as an adjacency list `graph`.
*Bạn có một đồ thị vô hướng, liên thông gồm `n` nút được cho dưới dạng danh sách kề `graph`.*

Return *the length of the shortest path that visits every node*. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
*Hãy trả về *độ dài của đường đi ngắn nhất tham quan tất cả các nút*. Bạn có thể bắt đầu và kết thúc tại bất kỳ nút nào, bạn có thể tham quan lại các nút nhiều lần và dùng lại các cạnh.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** graph = [[1,2,3],[0],[0],[0]]
**Output:** 4
**Explanation:** One possible path is [1,0,2,0,3].

## Example 2:
## *Ví dụ 2:*

**Input:** graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
**Output:** 4
**Explanation:** One possible path is [0,1,4,2,3].

---

## Constraints:
## *Ràng buộc:*

*   `n == graph.length`
*   `1 <= n <= 12`
*   `0 <= graph[i].length < n`
*   `graph[i]` does not contain `i`.
*   If `graph[a]` contains `b`, then `graph[b]` contains `a`.
*   The input graph is connected.
