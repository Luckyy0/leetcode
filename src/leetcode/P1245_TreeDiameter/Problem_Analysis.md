# 1245. Tree Diameter / Đường kính Cây

## Problem Description / Mô tả bài toán
Given undirected tree as `edges`.
Find the diameter (longest path between any two nodes).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two BFS/DFS Traversal / Hai lần Duyệt BFS/DFS
Method 1:
1. Pick arbitrary node A.
2. BFS to find farthest node B.
3. BFS from B to find farthest node C.
4. Dist(B, C) is diameter.
Proof: B must be one endpoint of diameter.

Method 2: DFS Height.
For each node, compute height of branches.
Diameter passing through node `u` = sum of two largest heights of children + 2 (edges to children).
Update global Max.
Return `max(heights) + 1` to parent.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Double BFS
The standard algorithm for finding the diameter of a tree is to run two Breadth-First Searches (BFS). First, start a BFS from an arbitrary node (e.g., node 0) to find the farthest node, let's call it `u`. Then, start a second BFS from `u` to find the farthest node from it, say `v`. The distance between `u` and `v` is the diameter of the tree.
Thuật toán tiêu chuẩn để tìm đường kính của cây là chạy hai Tìm kiếm theo Chiều rộng (BFS). Đầu tiên, bắt đầu BFS từ một nút tùy ý (ví dụ: nút 0) để tìm nút xa nhất, hãy gọi nó là `u`. Sau đó, bắt đầu BFS thứ hai từ `u` để tìm nút xa nhất từ ​​nó, giả sử là `v`. Khoảng cách giữa `u` và `v` là đường kính của cây.

---
