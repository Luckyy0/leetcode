# 547. Number of Provinces / Số Lượng Tỉnh

## Problem Description / Mô tả bài toán
There are `n` cities. Some of them are connected, while some are not. If city `a` is connected directly with city `b`, and city `b` is connected directly with city `c`, then city `a` is connected indirectly with city `c`.
Có `n` thành phố. Một số thành phố được kết nối với nhau, trong khi một số khác thì không. Nếu thành phố `a` được kết nối trực tiếp với thành phố `b`, và thành phố `b` được kết nối trực tiếp với thành phố `c`, thì thành phố `a` được kết nối gián tiếp với thành phố `c`.

A **province** is a group of directly or indirectly connected cities and no other cities outside of the group.
Một **tỉnh** là một nhóm các thành phố được kết nối trực tiếp hoặc gián tiếp và không có thành phố nào khác ngoài nhóm.

You are given an `n x n` matrix `isConnected` where `isConnected[i][j] = 1` if the `i-th` city and the `j-th` city are directly connected, and `isConnected[i][j] = 0` otherwise.
Bạn được cho một ma trận `n x n` `isConnected` trong đó `isConnected[i][j] = 1` nếu thành phố thứ `i` và thành phố thứ `j` được kết nối trực tiếp, và `isConnected[i][j] = 0` nếu ngược lại.

Return the total number of **provinces**.
Hãy trả về tổng số lượng **tỉnh**.

### Example 1:
```text
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Connected Components (DFS/BFS/Union-Find) / Thành Phần Liên Thông
This is a standard problem of finding the number of connected components in a graph.

Algorithm:
1. Initialize `visited` array.
2. Initialize `count = 0`.
3. Iterate `i` from `0` to `n-1`:
   - If `!visited[i]`:
     - `dfs(i)` to visit all reachable nodes.
     - `count++`.
4. Return `count`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) (visiting strict adjacency matrix).
- **Space**: O(N) for recursion/visited array.

---

## Analysis / Phân tích

### Approach: Graph Traversal Counting

**Algorithm**:
1.  Iterate through each city.
2.  If unvisited, trigger DFS/BFS.
3.  Mark all reachable cities as visited.
4.  Increment province count for each trigger.

---
