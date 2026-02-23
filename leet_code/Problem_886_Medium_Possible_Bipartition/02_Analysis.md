# Analysis for Possible Bipartition
# *Phân tích cho bài toán Phân chia Nhị phân Có thể*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Determine if we can split `n` nodes into two groups such that no two connected nodes are in the same group. This is equivalent to checking if the graph formed by `dislikes` is **Bipartite** (can be colored with 2 colors).
*Xác định xem chúng ta có thể chia `n` nút thành hai nhóm sao cho không có hai nút nào được nối với nhau nằm trong cùng một nhóm. Điều này tương đương với việc kiểm tra xem đồ thị được tạo bởi `dislikes` có phải là **đồ thị hai phía** (có thể tô bằng 2 màu) hay không.*

---

## 2. Strategy: Graph Coloring (BFS/DFS)
## *2. Chiến lược: Tô màu Đồ thị (BFS/DFS)*

### Coloring Logic
### *Logic Tô màu*
We try to color the graph with two colors (e.g., 1 and -1).
- Start with an uncolored node, color it with 1.
- All its neighbors MUST be colored with -1.
- All neighbors' neighbors MUST be colored with 1.
- If we encounter a neighbor that is already colored with the *same* color as the current node, we have a conflict, and the graph is not bipartite.
*Chúng ta cố gắng tô màu đồ thị bằng hai màu (ví dụ: 1 và -1). Bắt đầu với một nút chưa tô màu, tô nó màu 1. Tất cả hàng xóm của nó PHẢI được tô màu -1. Nếu gặp một hàng xóm đã được tô *cùng* màu với nút hiện tại, ta có xung đột, và đồ thị không phải là hai phía.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Build Graph:** Construct an adjacency list from the `dislikes` array.
    *   **Xây dựng đồ thị:** Tạo danh sách kề từ mảng `dislikes`.*

2.  **Initialize Colors:** Create an array `color` of size `n + 1`, initialized to 0 (unvisited).
    *   **Khởi tạo màu:** Tạo mảng `color` kích thước `n + 1`, khởi tạo là 0 (chưa thăm).*

3.  **Iterate Nodes:** Loop through each node `i` from 1 to `n`.
    - If `color[i] == 0` (unvisited component), start BFS/DFS to color it.
    - Start coloring `i` with 1.
    *   **Duyệt các nút:** Duyệt qua từng nút `i` từ 1 đến `n`. Nếu `color[i] == 0` (thành phần chưa thăm), bắt đầu BFS/DFS để tô màu nó.*

4.  **BFS Traversal:**
    - Use a queue.
    - While queue is not empty:
        - Pop `u`.
        - For each neighbor `v`:
            - If `color[v] == 0`: Color it `-color[u]` and push to queue.
            - If `color[v] == color[u]`: **Return False** (Conflict).
    *   **Duyệt BFS:** Sử dụng hàng đợi. Lấy `u` ra. Với mỗi hàng xóm `v`: Nếu chưa tô màu, tô màu đối lập và thêm vào hàng đợi. Nếu đã tô cùng màu, trả về False.*

5.  **Return True:** If all components are successfully colored without conflict.
    *   **Trả về True:** Nếu tất cả các thành phần được tô màu thành công mà không có xung đột.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean possibleBipartition(int n, int[][] dislikes) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
    for (int[] d : dislikes) {
        graph.get(d[0]).add(d[1]);
        graph.get(d[1]).add(d[0]);
    }
    
    int[] color = new int[n + 1]; // 0: uncolored, 1: group A, -1: group B
    
    for (int i = 1; i <= n; i++) {
        if (color[i] == 0) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1;
            
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : graph.get(u)) {
                    if (color[v] == 0) {
                        color[v] = -color[u];
                        queue.offer(v);
                    } else if (color[v] == color[u]) {
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

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + E)$, where $N$ is the number of people and $E$ is the number of dislike pairs. Start BFS on each component.
    *   **Độ phức tạp thời gian:** $O(N + E)$, mỗi nút và cạnh được duyệt tối đa một lần.*
*   **Space Complexity:** $O(N + E)$ for the adjacency list and queue.
    *   **Độ phức tạp không gian:** $O(N + E)$ cho danh sách kề và hàng đợi.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Bipartite checking is a fundamental graph algorithm. Using BFS with simple integer coloring (1 vs -1) is the standard and most intuitive approach.
*Kiểm tra tính hai phía là một thuật toán đồ thị cơ bản. Sử dụng BFS với cách tô màu số nguyên đơn giản (1 so với -1) là cách tiếp cận tiêu chuẩn và trực quan nhất.*
