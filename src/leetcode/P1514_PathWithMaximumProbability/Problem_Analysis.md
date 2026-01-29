# 1514. Path with Maximum Probability / Đường đi với Xác suất Tối đa

## Problem Description / Mô tả bài toán
Nodes `n`. Edges `succProb` (probability).
Max probability path from `start` to `end`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dijkstra (Max Product)
Probabilities multiply. `p1 * p2 * ...`
Since $0 \le p \le 1$, product decreases.
Equivalent to Shortest Path with weights $- \log(p)$. (Sum of logs).
Or direct Dijkstra maximizing product.
Use Max-Heap. `dist[i]` = max prob to reach `i`.
Init `dist` with 0, `dist[start] = 1`.
Pop max prob. Relax neighbors: `newProb = prob * edgeProb`. If `newProb > dist[neighbor]`, update and push.

### Complexity / Độ phức tạp
- **Time**: O(E log V).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: Dijkstra
Adjacency list. Max-Heap.
Array `maxProb` initialized to 0.
Loop until heap empty or reach end.
Danh sách kề. Max-Heap.
Mảng `maxProb` được khởi tạo bằng 0.
Lặp lại cho đến khi heap trống hoặc đến đích.

---
