# Analysis for All Paths From Source to Target
# *Phân tích cho bài toán Tất cả các đường đi từ Nguồn đến Đích*

## 1. Problem Essence & Graph Traversal
## *1. Bản chất vấn đề & Duyệt đồ thị*

### The Challenge
### *Thách thức*
We are given a Directed Acyclic Graph (DAG). We need to find all paths from node $0$ to node $N-1$.
Since the graph is a DAG, we don't need to worry about cycles, which simplifies the search.
*Chúng ta được cho một đồ thị có hướng không chu trình (DAG). Cần tìm tất cả các con đường từ nút $0$ đến nút $N-1$. Vì là DAG, ta không cần lo lắng về chu trình, giúp việc tìm kiếm đơn giản hơn.*

---

## 2. Strategy: Backtracking (DFS)
## *2. Chiến lược: Quay lui (DFS)*

### Algorithm
### *Thuật toán*

1.  **Backtracking:** Use Depth-First Search to explore all nodes.
    - Start from node $0$, add it to the current path.
    - If the current node is $N-1$, a valid path is found. Add a copy of the current path to the result list.
    - If not at the target, iterate through all neighbors of the current node and recursively call the search function.
    - After returning from the recursion, remove the neighbor from the current path to backtrack.
    *   **Quay lui:** Sử dụng Tìm kiếm theo chiều sâu (DFS) để khám phá tất cả các nút. Bắt đầu từ nút $0$, thêm vào đường đi hiện tại. Nếu đạt tới $N-1$, ta có một đường đi hợp lệ. Sau khi thăm các nút kề, ta xóa nút đó để quay lại trạng thái trước.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(0);
    dfs(graph, 0, path, res);
    return res;
}

private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
    if (node == graph.length - 1) {
        res.add(new ArrayList<>(path));
        return;
    }
    for (int next : graph[node]) {
        path.add(next);
        dfs(graph, next, path, res);
        path.remove(path.size() - 1); // backtrack
    }
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^N \cdot N)$. In the worst case of a complete graph, there can be $2^{N-2}$ paths between node $0$ and $N-1$. For each path, we spend $O(N)$ time to copy it.
    *   **Độ phức tạp thời gian:** $O(2^N \cdot N)$. Trong trường hợp xấu nhất, có thể có $2^{N-2}$ đường đi và mỗi đường đi mất $O(N)$ để sao chép.*
*   **Space Complexity:** $O(2^N \cdot N)$ to store the result. The recursion stack uses $O(N)$.
    *   **Độ phức tạp không gian:** $O(2^N \cdot N)$ để lưu kết quả. Ngăn xếp đệ quy dùng $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `[[1,2],[3],[3],[]]`
1. DFS(0): path=[0]. Neighbors=[1, 2].
2.   Try 1: path=[0, 1]. DFS(1): Neighbors=[3].
3.     Try 3: path=[0, 1, 3]. Target reached! Add [0, 1, 3]. Backtrack path=[0, 1].
4.   Backtrack path=[0].
5.   Try 2: path=[0, 2]. DFS(2): Neighbors=[3].
6.     Try 3: path=[0, 2, 3]. Target reached! Add [0, 2, 3]. Backtrack path=[0, 2].
7.   Backtrack path=[0].
**Result:** `[[0, 1, 3], [0, 2, 3]]`

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Backtracking is the most natural way to find all paths in a graph. For DAGs, it's efficient because there are no recursive cycles to detect.
*Quay lui là cách tự nhiên nhất để tìm tất cả các đường đi trong đồ thị. Với DAG, nó hiệu quả vì không cần xử lý chu trình.*
