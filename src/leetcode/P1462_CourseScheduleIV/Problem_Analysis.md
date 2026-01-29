# 1462. Course Schedule IV / Lịch trình Khóa học IV

## Problem Description / Mô tả bài toán
Courses `0` to `n-1`. Prerequisites `[u, v]` (u must be before v).
Queries `[u, v]`: Is u a prerequisite of v? (Direct or Indirect).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Floyd-Warshall Algorithm (Transitive Closure)
Graph reachability.
`reachable[i][j]` true if `i -> j`.
Initialization: `reachable[u][v] = true` for edges.
Iterate `k` in `0..n-1`:
  Iterate `i` in `0..n-1`:
    Iterate `j` in `0..n-1`:
      `reachable[i][j] |= reachable[i][k] && reachable[k][j]`.
`N <= 100`. $N^3$ is $10^6$. Very fast.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Floyd-Warshall
Use Floyd-Warshall to compute the transitive closure of the graph.
Use a boolean matrix `isPrerequisite[n][n]`.
Process queries in O(1).
Sử dụng Floyd-Warshall để tính bao đóng bắc cầu của đồ thị.
Sử dụng ma trận boolean `isPrerequisite[n][n]`.
Xử lý các truy vấn trong O(1).

---
