# 742. Closest Leaf in a Binary Tree / Lá Gần nhất trong Cây Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree and an integer `k`, return the value of the nearest leaf node to the node with value `k`.
Cho `root` của một cây nhị phân và một số nguyên `k`, hãy trả về giá trị của nút lá gần nhất với nút có giá trị `k`.

A leaf is a node with no children. The distance between two nodes is the number of edges.
Lá là một nút không có con. Khoảng cách giữa hai nút là số cạnh.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS on an Undirected Graph / BFS trên Đồ thị Vô hướng
To find the "nearest" node in any direction (up to parent or down to children), we should treat the tree as a graph.
Để tìm nút "gần nhất" theo bất kỳ hướng nào (lên trên nút cha hoặc xuống dưới các con), chúng ta nên coi cây như một đồ thị.

Algorithm:
1. Traverse the tree to build an adjacency list representing undirected edges (child-parent and parent-child).
2. Locate the node with value `k`.
3. Start a BFS from this node.
4. The first leaf node encountered in BFS is the answer.

### Complexity / Độ phức tạp
- **Time**: O(N) to build the graph and perform BFS.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Graph Conversion + BFS
Trees only have downward pointers. By adding upward pointers to parents, we can move freely to find the shortest path to any leaf.
Cây chỉ có các con trỏ đi xuống. Bằng cách thêm các con trỏ đi lên tới nút cha, chúng ta có thể di chuyển tự do để tìm đường đi ngắn nhất đến bất kỳ lá nào.

---
