# Result for Reachable Nodes In Subdivided Graph
# *Kết quả cho bài toán Các nút có thể đến được trong Đồ thị Chia nhỏ*

## Description
## *Mô tả*

You are given an undirected graph (the "**original graph**") with `n` nodes labeled from `0` to `n - 1`. You decide to **subdivide** each edge in the graph that connects two nodes `u` and `v` with `cnt` new nodes.
*Bạn được cho một đồ thị vô hướng ("**đồ thị gốc**") với `n` nút được đánh số từ `0` đến `n - 1`. Bạn quyết định **chia nhỏ** mỗi cạnh trong đồ thị nối hai nút `u` và `v` thành `cnt` nút mới.*

After this subdivision, the new graph has a total of `n + sum(cnt)` nodes.
*Sau khi chia nhỏ, đồ thị mới có tổng cộng `n + sum(cnt)` nút.*

You are given a 2D integer array `edges` where `edges[i] = [u, v, cnt]` indicates that there is an edge between nodes `u` and `v` in the original graph with `cnt` new nodes subdividing it.
*Bạn được cho một mảng số nguyên 2D `edges` trong đó `edges[i] = [u, v, cnt]` chỉ ra rằng có một cạnh giữa các nút `u` và `v` trong đồ thị gốc với `cnt` nút mới chia nhỏ nó.*

You start at node `0` on the new graph, and on each move, you can travel along an edge to an adjacent node. You have `maxMoves` moves.
*Bạn bắt đầu tại nút `0` trên đồ thị mới, và trong mỗi bước di chuyển, bạn có thể đi dọc theo một cạnh đến một nút liền kề. Bạn có `maxMoves` bước di chuyển.*

Return *the number of reachable nodes in the new graph*.
*Hãy trả về *số lượng nút có thể đến được trong đồ thị mới*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
**Output:** 13
**Explanation:** 
The reachable nodes are:
Node 0, Node 1, Node 2.
9 nodes on edge [0,1].
1 node on edge [0,2].
All nodes reachable. Total 3 + 9 + 1 = 13.

## Example 2:
## *Ví dụ 2:*

**Input:** edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
**Output:** 23

## Example 3:
## *Ví dụ 3:*

**Input:** edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
**Output:** 1
**Explanation:** Node 0 is disconnected from the rest of the graph, so only node 0 is reachable.

---

## Constraints:
## *Ràng buộc:*

*   `0 <= edges.length <= min(n * (n - 1) / 2, 10000)`
*   `edges[i].length == 3`
*   `0 <= u_i < v_i < n`
*   There are no multiple edges in the graph.
*   `0 <= cnt_i <= 10000`
*   `0 <= maxMoves <= 10^9`
*   `1 <= n <= 3000`
