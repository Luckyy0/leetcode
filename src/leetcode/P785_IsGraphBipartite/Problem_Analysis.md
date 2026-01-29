# 785. Is Graph Bipartite? / Đồ thị có Lưỡng phân không?

## Problem Description / Mô tả bài toán
There is an undirected graph with `n` nodes. You are given a 2D array `graph` where `graph[u]` is an array of nodes that node `u` is adjacent to.
Có một đồ thị vô hướng với `n` nút. Bạn được cho một mảng 2D `graph` trong đó `graph[u]` là một mảng các nút mà nút `u` liền kề.

Return `true` if and only if the graph is **bipartite**.
Trả về `true` khi và chỉ khi đồ thị là **lưỡng phân**.

A graph is bipartite if we can split its nodes into two independent sets `A` and `B` such that every edge in the graph connects a node in `A` and a node in `B`.
Một đồ thị là lưỡng phân nếu chúng ta có thể chia các nút của nó thành hai tập hợp độc lập `A` và `B` sao cho mọi cạnh trong đồ thị đều kết nối một nút trong `A` và một nút trong `B`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Graph Coloring (2 Colors) / Tô màu Đồ thị (2 Màu)
A graph is bipartite if it can be colored with 2 colors such that no two adjacent nodes have the same color.
Một đồ thị là lưỡng phân nếu nó có thể được tô bằng 2 màu sao cho không có hai nút lân cận nào có cùng màu.

Algorithm:
1. Initialize a `colors` array with 0 (uncolored).
2. For each uncolored node, start a BFS or DFS.
3. Assign color 1 to the node.
4. For all neighbors, assign the opposite color (-1).
5. If you encounter a neighbor already colored with the same color as the current node, return `false`.

### Complexity / Độ phức tạp
- **Time**: O(V + E).
- **Space**: O(V).

---

## Analysis / Phân tích

### Approach: 2-Color DFS/BFS
Attempt to verify the bipartite property by assigning alternating colors. If we find a violation (a node connected to another of the same color), the property is false.
Cố gắng xác minh thuộc tính lưỡng phân bằng cách gán các màu xen kẽ. Nếu chúng ta tìm thấy một vi phạm (một nút được kết nối với một nút khác cùng màu), thuộc tính đó là sai.

---
