# Analysis for Is Graph Bipartite?
# *Phân tích cho bài toán Đồ thị Hai phía?*

## 1. Problem Essence & Coloring
## *1. Bản chất vấn đề & Tô màu*

### The Challenge
### *Thách thức*
A bipartite graph can be colored with 2 colors such that no two adjacent nodes have the same color.
This is equivalent to checking if the graph contains any **odd cycles**.
*Một đồ thị hai phía có thể được tô bằng 2 màu sao cho không có hai nút kề nhau nào cùng màu. Điều này tương đương với việc kiểm tra xem đồ thị có chứa **chu trình lẻ** nào không.*

---

## 2. Strategy: BFS/DFS Coloring
## *2. Chiến lược: Tô màu BFS/DFS*

### Algorithm
### *Thuật toán*

1.  **Colors Array:** `colors[i]` stores the color of node `i` (0: uncolored, 1: color A, -1: color B).
    *   **Mảng Màu:** `colors[i]` lưu màu của nút `i` (0: chưa tô, 1: màu A, -1: màu B).*

2.  **Iterate Nodes:** Since the graph might be disconnected, iterate `i` from 0 to `n-1`.
    - If `colors[i] == 0`: Start a traversal (BFS or DFS) from `i`.
    *   **Duyệt Nút:** Vì đồ thị có thể không liên thông, duyệt từ 0 đến `n-1`. Nếu chưa tô màu, bắt đầu duyệt.*

3.  **Traversal:**
    - Assign color 1 to start node.
    - For DFS(u, c):
        - `colors[u] = c`.
        - For each neighbor `v`:
            - If `colors[v] == 0`: Recurse DFS(v, -c). If false, return false.
            - If `colors[v] == c`: Conflict detected! Return false.
    *   **Duyệt:** Gán màu 1 cho nút bắt đầu. Với mỗi hàng xóm, nếu chưa tô thì tô màu đối lập. Nếu đã tô màu trùng thì báo lỗi.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colors = new int[n]; // 0: uncolored, 1: A, -1: B
    
    for (int i = 0; i < n; i++) {
        if (colors[i] == 0) {
            // BFS approach
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;
            
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbor : graph[node]) {
                    if (colors[neighbor] == 0) {
                        colors[neighbor] = -colors[node];
                        q.offer(neighbor);
                    } else if (colors[neighbor] == colors[node]) {
                        return false;
                    }
                }
            }
        }
    }
    return true;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(V + E)$. Visit every node and edge once.
    *   **Độ phức tạp thời gian:** $O(V + E)$.*
*   **Space Complexity:** $O(V)$ for colors array and queue/stack.
    *   **Độ phức tạp không gian:** $O(V)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Graph:** `[[1,2,3], [0,2], [0,1,3], [0,2]]`
1. Start 0. Color 1. Q: [0].
2. Pop 0. Check 1, 2, 3.
   - 1: uncolored. Color -1. Q: [1].
   - 2: uncolored. Color -1. Q: [1, 2].
   - 3: uncolored. Color -1. Q: [1, 2, 3].
3. Pop 1 (color -1). Neighbors 0, 2.
   - 0: color 1. OK.
   - 2: color -1. **Conflict!** (-1 == -1).
   - Return False.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

BFS or DFS based 2-coloring is the standard algorithm. Handle disconnected components by looping through all nodes.
*Tô màu 2 màu dựa trên BFS hoặc DFS là thuật toán chuẩn. Xử lý các thành phần không liên thông bằng cách lặp qua tất cả các nút.*
