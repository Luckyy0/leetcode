# 1059. All Paths from Source Lead to Destination / Tất cả các đường từ Nguồn đều dẫn đến Đích

## Problem Description / Mô tả bài toán
Given a directed graph, return `true` if and only if:
Cho một đồ thị có hướng, hãy trả về `true` nếu và chỉ nếu:
1. There is at least one path from `source` to `destination`.
2. All paths starting from `source` eventually traverse to `destination`.
3. The number of paths from `source` to `destination` is finite (no cycles in paths from source).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with Cycle Detection / DFS với Phát hiện Chu trình
Conditions basically mean:
- From `source`, we must not get stuck in a node with no outgoing edges (unless it's `destination`).
- From `source`, we must not enter a cycle.
- Eventually all roads lead to `destination`.

States:
- 0: unvisited
- 1: visiting (recursion stack)
- 2: visited and validated (safe)

Algorithm `dfs(node)`:
- If `node` has no children: return `node == destination`.
- If `node` is visiting (state 1): Cycle detected! Return `false`.
- If `node` is visited (state 2): Pre-validated. Return `true`.
- Set state 1.
- For each neighbor:
  - If `!dfs(neighbor)`, return `false`.
- Set state 2.
- Return `true`.

### Complexity / Độ phức tạp
- **Time**: O(V + E).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: Finite Flow Validation
Perform a DFS traversal from the source. The graph structure must satisfy two properties: no cycles (to ensure finite paths) and no "dead ends" other than the target itself. Every reachable leaf node must be the target.
Thực hiện duyệt DFS từ nguồn. Cấu trúc đồ thị phải thỏa mãn hai thuộc tính: không có chu trình (để đảm bảo các đường dẫn hữu hạn) và không có "ngõ cụt" nào khác ngoài mục tiêu. Mọi nút lá có thể tiếp cận được phải là mục tiêu.

---
