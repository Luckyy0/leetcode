# 802. Find Eventual Safe States / Tìm các Trạng thái An toàn Cuối cùng

## Problem Description / Mô tả bài toán
There is a directed graph of `n` nodes with each node labeled from 0 to `n - 1`. The graph is represented by a 0-indexed 2D integer array `graph` where `graph[i]` is an integer array of nodes adjacent to node `i`.
Có một đồ thị có hướng gồm `n` nút với mỗi nút được đánh số từ 0 đến `n - 1`. Đồ thị được đại diện bởi một mảng số nguyên 2D `graph` trong đó `graph[i]` là một mảng các nút liền kề với nút `i`.

A node is a **terminal node** if there are no outgoing edges. A node is a **safe node** if every possible path starting from that node leads to a terminal node.
Một nút là **nút đầu cuối (terminal node)** nếu không có cạnh đi ra. Một nút là **nút an toàn (safe node)** nếu mọi đường đi khả thi bắt đầu từ nút đó đều dẫn đến một nút đầu cuối.

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
Trả về một mảng chứa tất cả các nút an toàn của đồ thị. Câu trả lời phải được sắp xếp theo thứ tự tăng dần.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Cycle Detection / Phát hiện Chu trình
A node is safe if it is NOT part of a cycle and does NOT lead to a cycle.
Một nút an toàn nếu nó KHÔNG thuộc một chu trình và KHÔNG dẫn đến một chu trình.

Algorithm:
1. Use DFS with coloring (state tracking):
   - `0`: Unvisited.
   - `1`: Visiting (currently in recursion stack).
   - `2`: Safe (visited and verified not leads to cycle).
2. If we encounter a node with state `1` during DFS, we've found a cycle.

Alternatively:
1. Reverse the graph.
2. Safe nodes are those whose "out-degree" (in the original graph) eventually becomes 0 as we remove terminal nodes. This is Topological Sort (Kahn's Algorithm) on the reversed graph.

### Complexity / Độ phức tạp
- **Time**: O(V + E).
- **Space**: O(V).

---

## Analysis / Phân tích

### Approach: 3-Color DFS
By marking nodes as "visiting", we can detect back-edges. Any node that doesn't trigger a back-edge and has all safe neighbors is marked safe.
Bằng cách đánh dấu các nút là "đang truy cập", chúng ta có thể phát hiện các cạnh ngược (back-edge). Bất kỳ nút nào không tạo ra cạnh ngược và có tất cả láng giềng an toàn sẽ được đánh dấu là an toàn.

---
