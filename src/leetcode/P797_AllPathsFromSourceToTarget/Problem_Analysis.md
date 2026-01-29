# 797. All Paths From Source to Target / Tất cả các Đường đi từ Nguồn đến Đích

## Problem Description / Mô tả bài toán
Given a directed acyclic graph (DAG) of `n` nodes labeled from 0 to `n - 1`, find all possible paths from node 0 to node `n - 1` and return them in any order.
Cho một đồ thị có hướng không chu trình (DAG) gồm `n` nút được đánh số từ 0 đến `n - 1`, hãy tìm tất cả các đường đi có thể có từ nút 0 đến nút `n - 1` và trả về chúng theo bất kỳ thứ tự nào.

The graph is given as follows: `graph[i]` is a list of all nodes you can visit from node `i`.
Đồ thị được cho như sau: `graph[i]` là danh sách tất cả các nút bạn có thể truy cập từ nút `i`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search (DFS) / Tìm kiếm theo Chiều sâu
Since it's a DAG, we can use DFS to explore all paths starting from node 0.
Vì đây là một DAG, chúng ta có thể sử dụng DFS để khám phá tất cả các đường đi bắt đầu từ nút 0.

Algorithm:
1. Start at `node = 0`.
2. Keep a `currentPath` list.
3. At each node, iterate through all neighbors in `graph[node]`.
4. If a neighbor is `n - 1`, add the path to the result.
5. Recursively call DFS for neighbors. (Backtrack by removing the node from `currentPath` after the call).

### Complexity / Độ phức tạp
- **Time**: O(2^N * N) in the worst case (a fully connected DAG has exponential paths).
- **Space**: O(N) for recursion stack.

---

## Analysis / Phân tích

### Approach: Recursive Path Exploration
Standard backtracking on a graph. The DAG property ensures we won't get stuck in cycles.
Quay lui tiêu chuẩn trên đồ thị. Thuộc tính DAG đảm bảo chúng ta sẽ không bị kẹt trong các chu trình.

---
