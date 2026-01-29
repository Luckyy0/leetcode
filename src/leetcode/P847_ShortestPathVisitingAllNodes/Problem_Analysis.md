# 847. Shortest Path Visiting All Nodes / Đường đi Ngắn nhất Truy cập Tất cả các Nút

## Problem Description / Mô tả bài toán
You have an undirected, connected graph of `n` nodes.
Bạn có một đồ thị vô hướng, được kết nối gồm `n` nút.

Return the length of the shortest path that visits every node. You may start and stop at any node, and you may revisit nodes and edges multiple times.
Trả về độ dài của đường đi ngắn nhất đi qua mọi nút. Bạn có thể bắt đầu và dừng lại ở bất kỳ nút nào, và có thể truy cập lại các nút và cạnh nhiều lần.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS with Bitmask / BFS với Mặt nạ Bit
This is a variation of the Traveling Salesperson Problem (TSP), but in a graph where we can revisit nodes.
Đây là một biến thể của bài toán Người bán hàng (TSP), nhưng trong đồ thị mà chúng ta có thể truy cập lại các nút.

State: `(currentNode, visitedMask)`.
- `currentNode`: 0 to `n-1`.
- `visitedMask`: A bitmask of length `n` representing the set of visited nodes.

Algorithm:
1. Initialize queue with all nodes as starting points: `(i, 1 << i)`.
2. Perform BFS.
3. If `visitedMask == (1 << n) - 1`, we found the shortest path.

### Complexity / Độ phức tạp
- **Time**: O(2^N * N^2).
- **Space**: O(2^N * N).

---

## Analysis / Phân tích

### Approach: State-Space BFS
Explore all possible traversal states. Using a bitmask allows us to track which nodes have been covered in our current journey efficiently. BFS ensures that the first time we see an "all-visited" mask, it is via the shortest possible path.
Khám phá tất cả các trạng thái duyệt có thể. Sử dụng mặt nạ bit cho phép chúng ta theo dõi những nút nào đã được bao phủ trong hành trình hiện tại một cách hiệu quả. BFS đảm bảo rằng lần đầu tiên chúng ta nhìn thấy mặt nạ "đã truy cập tất cả", đó là con đường ngắn nhất có thể.

---
