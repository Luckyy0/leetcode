# Analysis for Swim in Rising Water
# *Phân tích cho bài toán Bơi trong Nước Dâng*

## 1. Problem Essence & Min-Max Path
## *1. Bản chất vấn đề & Đường đi Min-Max*

### The Challenge
### *Thách thức*
We need to find a path from `(0,0)` to `(N-1, N-1)` such that the **maximum value** on the path is minimized.
*Chúng ta cần tìm một đường đi từ `(0,0)` đến `(N-1, N-1)` sao cho **giá trị lớn nhất** trên đường đi là nhỏ nhất.*

This is equivalent to finding the bottleneck capacity path (in reverse) or shortest path where weight is the node value.
*Điều này tương đương với việc tìm đường đi có dung lượng nút thắt cổ chai (đảo ngược) hoặc đường đi ngắn nhất nơi trọng số là giá trị nút.*

---

## 2. Strategy: Dijkstra or Binary Search + DFS
## *2. Chiến lược: Dijkstra hoặc Tìm kiếm Nhị phân + DFS*

### Method 1: Modified Dijkstra (Best)
### *Phương pháp 1: Dijkstra Sửa đổi (Tốt nhất)*

1.  **Priority Queue:** Stores `(time, x, y)`. Initially `(grid[0][0], 0, 0)`.
2.  **Visited:** Keep track of visited cells.
3.  **Loop:**
    - Pop cell with min time `t`.
    - If `(x, y)` is target, return `max(t, bottleneck_so_far)`.
    - Actually, the PQ naturally gives the path with minimal max-height. The value `t` popped is the `max` height encountered so far on this optimal path? No.
    - Correct Logic: `d[x][y]` = min max-height to reach `(x, y)`.
    - Relax: `new_t = max(d[u], grid[v])`. If `new_t < d[v]`, update and push.
    *   **Hàng đợi Ưu tiên:** Lưu `(thời gian, x, y)`. `d[x][y]` lưu độ cao lớn nhất tối thiểu để đến `(x, y)`. Cập nhật `new_t = max(d[u], grid[v])`.*

### Method 2: Binary Search on Answer
### *Phương pháp 2: Tìm kiếm Nhị phân trên Kết quả*

1.  **Range:** 0 to $N^2-1$.
2.  **Check(t):** Can we reach target using only cells $\le t$? (Use BFS/DFS).
3.  **Complexity:** $O(N^2 \log(N^2))$. Very fast for $N=50$.
    *   **Phạm vi:** 0 đến $N^2-1$. **Kiểm tra(t):** Dùng BFS/DFS xác định tính liên thông. Độ phức tạp $O(N^2 \log(N^2))$.*

### Code Logic Preview (Dijkstra)
### *Xem trước Logic Mã (Dijkstra)*

```java
public int swimInWater(int[][] grid) {
    int n = grid.length;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[]{grid[0][0], 0, 0});
    
    boolean[][] visited = new boolean[n][n];
    visited[0][0] = true;
    
    int result = 0;
    
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int val = curr[0];
        int r = curr[1], c = curr[2];
        
        result = Math.max(result, val);
        if (r == n - 1 && c == n - 1) return result;
        
        for (int[] d : dirs) { // 4 directions
            // if valid and not visited
            pq.offer(new int[]{grid[r][c], nr, nc}); // Wait, val should be grid[nr][nc]
            // NO. The key in PQ is the height of the cell we just stepped on.
            // The path max is tracked via 'result' variable outside or implies monotonic increase?
            // Better: PQ stores max height ON THE PATH to reach (r,c).
            // Push: max(curr_path_max, grid[nr][nc]).
        }
    }
}
```

Wait, PQ logic refined:
PQ stores `(max_height_on_path_to_node, r, c)`.
Start: `(grid[0][0], 0, 0)`.
Pop `(h, r, c)`.
Neighbor `(nr, nc)`: new cost `max(h, grid[nr][nc])`.
Push `(new_cost, nr, nc)`.
This guarantees we find the min-max path.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \log N)$ using Dijkstra.
    *   **Độ phức tạp thời gian:** $O(N^2 \log N)$.*
*   **Space Complexity:** $O(N^2)$.
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Grid:** `[[0, 2], [1, 3]]`
1. PQ: `[(0, 0, 0)]`.
2. Pop `(0, 0, 0)`. Neighbors: `(0, 1)` val 2, `(1, 0)` val 1.
   - To `(0, 1)`: max(0, 2)=2. PQ push `(2, 0, 1)`.
   - To `(1, 0)`: max(0, 1)=1. PQ push `(1, 1, 0)`.
3. PQ: `[(1, 1, 0), (2, 0, 1)]`.
4. Pop `(1, 1, 0)`. Neighbors: `(1, 1)` val 3.
   - To `(1, 1)`: max(1, 3)=3. PQ push `(3, 1, 1)`.
5. PQ: `[(2, 0, 1), (3, 1, 1)]`.
6. Pop `(2, 0, 1)`. Neighbors: `(1, 1)` val 3.
   - To `(1, 1)`: max(2, 3)=3. Already visited? Need visited array.
7. Pop `(3, 1, 1)`. Target! Return 3.
**Result:** 3.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Dijkstra is intuitive and optimal. Binary Search is also great but Dijkstra fits the "shortest path" mental model better.
*Dijkstra trực quan và tối ưu. Tìm kiếm Nhị phân cũng rất tốt nhưng Dijkstra phù hợp hơn với mô hình tư duy "đường đi ngắn nhất".*
