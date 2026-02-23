# Analysis for Cheapest Flights Within K Stops
# *Phân tích cho bài toán Các chuyến bay Rẻ nhất trong vòng K điểm dừng*

## 1. Problem Essence & Shortest Path with Constraint
## *1. Bản chất vấn đề & Đường đi Ngắn nhất có Ràng buộc*

### The Challenge
### *Thách thức*
We need the shortest path (min cost) with a specific constraint on the number of edges (stops + 1).
`Stops <= K` means `Edges <= K + 1`.
*Chúng ta cần tìm đường đi ngắn nhất (chi phí thấp nhất) với ràng buộc cụ thể về số cạnh (số điểm dừng + 1). `Số điểm dừng <= K` nghĩa là `Số cạnh <= K + 1`.*

Standard Dijkstra doesn't track edge count well unless modified (State: `(cost, node, stops)`).
Bellman-Ford is designed for "k-edge relaxation".
*Dijkstra tiêu chuẩn không theo dõi số cạnh tốt trừ khi sửa đổi trạng thái. Bellman-Ford được thiết kế cho việc "nới lỏng k cạnh".*

---

## 2. Strategy: Bellman-Ford or Modified Dijkstra
## *2. Chiến lược: Bellman-Ford hoặc Dijkstra Sửa đổi*

### Method 1: Bellman-Ford (Standard Solution)
### *Phương pháp 1: Bellman-Ford (Giải pháp Tiêu chuẩn)*
Run `K+1` iterations.
In each iteration, update distances using only distances from the *previous* iteration.
This guarantees we found shortest paths using exactly `i` edges in iteration `i`.
We need to copy the `dist` array to ensure we don't use updated values from the *current* iteration immediately (which would simulate >1 hop in one go).
*Chạy `K+1` vòng lặp. Trong mỗi vòng lặp, cập nhật khoảng cách bằng cách chỉ sử dụng khoảng cách từ vòng lặp *trước đó*. Cần sao chép mảng `dist` để tránh dùng giá trị mới cập nhật ngay lập tức.*

### Method 2: Dijkstra
### *Phương pháp 2: Dijkstra*
PQ State: `(cost, u, stops)`.
Sort by `cost`.
If `stops > K`, prune.
Need to track `best_stops[u]`. Only proceed if we reach `u` with fewer stops than before (even if cost is higher? No, if cost is higher and stops more, prune. If cost lower, proceed. If cost higher but stops fewer, proceed).
Usually pure Bellman-Ford is simpler for this specific "at most K edges" constraint.
*PQ State: `(chi phí, nút, số điểm dừng)`. Nếu `stops > K`, cắt tỉa. Cần theo dõi `best_stops[u]`.*

### Code Logic Preview (Bellman-Ford)
### *Xem trước Logic Mã (Bellman-Ford)*

```java
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    
    for (int i = 0; i <= k; i++) {
        int[] temp = dist.clone();
        for (int[] f : flights) {
            int u = f[0], v = f[1], w = f[2];
            if (dist[u] != Integer.MAX_VALUE) {
                temp[v] = Math.min(temp[v], dist[u] + w);
            }
        }
        dist = temp;
    }
    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \cdot E)$. We iterate edges $K+1$ times.
    *   **Độ phức tạp thời gian:** $O(K \cdot E)$.*
*   **Space Complexity:** $O(N)$ for distance arrays.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**In:** n=3, edges=[[0,1,100],[1,2,100],[0,2,500]], src=0, dst=2, k=1
1. Init: `dist=[0, inf, inf]`.
2. Iter 1 (0 stops/1 edge):
   - Relax (0->1): `temp[1] = min(inf, 0+100) = 100`.
   - Relax (1->2): `dist[1]` is inf (from prev array). No update.
   - Relax (0->2): `temp[2] = min(inf, 0+500) = 500`.
   - `dist` becomes `[0, 100, 500]`.
3. Iter 2 (1 stop/2 edges):
   - Relax (1->2): `dist[1]` is 100. `temp[2] = min(500, 100+100) = 200`.
   - `dist` becomes `[0, 100, 200]`.
4. End. Result 200.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Use Bellman-Ford with array cloning. It's the most straightforward implementation for "at most K edges".
*Sử dụng Bellman-Ford với sao chép mảng. Đây là cách cài đặt trực tiếp nhất cho bài toán "tối đa K cạnh".*
