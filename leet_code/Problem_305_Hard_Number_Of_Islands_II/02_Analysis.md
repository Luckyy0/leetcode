# Analysis for Number of Islands II
# *Phân tích cho bài toán Số lượng Đảo II*

## 1. Problem Essence & Union Find (DSU)
## *1. Bản chất vấn đề & Union Find (DSU)*

### The Challenge
### *Thách thức*
Dynamic connectivity. Adding nodes and edges incrementally.
Need to report number of connected components after each addition.
BFS/DFS for each add would be $O(K \cdot MN)$. Too slow ($10^4 \cdot 10^4 = 10^8$).

### Strategy: Union-Find (Disjoint Set Union)
### *Chiến lược: Union-Find*
1.  Treat each cell `(r, c)` as a node with ID `r * n + c`.
2.  Maintain `count` of islands.
3.  When adding land at `(r, c)`:
    - If already land, ignore (return current count).
    - Else, mark as land. `count++`.
    - Check 4 neighbors `(nr, nc)`.
    - If `(nr, nc)` is land:
        - Root1 = find(current).
        - Root2 = find(neighbor).
        - If Root1 != Root2:
            - Union(Root1, Root2).
            - `count--` (Two islands merged into one).
4.  Result array stores `count` after each op.

---

## 2. Approach: DSU Implementation
## *2. Hướng tiếp cận: Cài đặt DSU*

### Logic
### *Logic*
1.  `parent[]` array of size `m*n`, init to `-1` (water).
2.  `count = 0`. List `res`.
3.  Loop `pos` in `positions`:
    - `idx = r*n + c`.
    - If `parent[idx] != -1`: add last `count` and continue.
    - `parent[idx] = idx`. `count++`.
    - Explore neighbors. If neighbor `nIdx` is valid (part of grid) and is land (`parent[nIdx] != -1`):
        - `u = find(idx)`, `v = find(nIdx)`.
        - If `u != v`: `parent[u] = v`. `count--`.
    - Add `count` to `res`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Fast Merge:** DSU does Union/Find in nearly $O(1)$ amortized time ($O(\alpha(N))$).
*   **Dynamic:** Perfect for "add edge" queries.
    *Hợp nhất nhanh: DSU thực hiện Union/Find trong thời gian gần như O(1). Động: Hoàn hảo cho các truy vấn "thêm cạnh".*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \cdot \alpha(MN))$, where K is num operations.
    *Độ phức tạp thời gian: $O(K \cdot \alpha(MN))$.*
*   **Space Complexity:** $O(MN)$ for parent array.
    *Độ phức tạp không gian: $O(MN)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 3x3, Ops: (0,0), (0,1), (1,2), (2,1).
1.  Add (0,0). `p[0]=0`. Count=1. Res: [1].
2.  Add (0,1). `p[1]=1`. Neighbors: (0,0) is land.
    - Find(0)=0. Find(1)=1. Union. `p[0]=1`. Count 1+1-1 = 1. Res: [1, 1].
3.  Add (1,2). `p[5]=5`. Neighbors 0. Count 2. Res: [1, 1, 2].
4.  Add (2,1). `p[7]=7`. Neighbors 0. Count 3. Res: [1, 1, 2, 3].
Wait, example output says [1, 1, 2, 3]. My dry run matches.
Let's check connectivity logic.
(0,0)-(0,1) connected -> 1 island.
(1,2) separate -> 2 islands.
(2,1) separate -> 3 islands.
Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic DSU application. Remember to handle duplicate additions (same position multiple times).
*Ứng dụng DSU kinh điển. Nhớ xử lý các lần thêm trùng lặp (cùng vị trí nhiều lần).*
---
*Những hòn đảo cô độc (isolated islands) cuối cùng sẽ tìm thấy nhau và kết nối (connected) lại. Sự chia cắt chỉ là tạm thời trước khi sự hợp nhất diễn ra.*
Isolated islands will eventually find each other and reconnect. Separation is only temporary before unification takes place.
