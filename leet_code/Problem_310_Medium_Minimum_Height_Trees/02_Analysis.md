# Analysis for Minimum Height Trees
# *Phân tích cho bài toán Cây có Chiều cao Tối thiểu*

## 1. Problem Essence & Topological Sort
## *1. Bản chất vấn đề & Sắp xếp Topo*

### The Centroid
### *Trọng tâm*
The roots of MHTs are essentially the **centroids** of the graph.
A tree can have at most 2 centroids.
Why? The longest path in the tree determines the height. the middle point(s) of the longest path are the roots maximizing balance (minimizing max distance).

### Strategy: Peel the Onion (Reverse Topological Sort)
### *Chiến lược: Bóc hành (Sắp xếp Topo ngược)*
We want the "middle". Leaves are the "outside".
So we remove leaves layer by layer.
1.  Identify all current leaves (degree 1).
2.  Remove them.
3.  Their neighbors' degrees decrease.
4.  If a neighbor becomes a leaf (degree 1), add to next layer.
5.  Repeat until `count <= 2`.
The remaining nodes are the centroids.

Why stop at 2? Because removing them would leave 0 nodes. The last <= 2 nodes are the answer. (If 1 node left, it's center. If 2 nodes edge-connected, both are centers).

---

## 2. Approach: BFS from Leaves
## *2. Hướng tiếp cận: BFS từ Lá*

### Logic
### *Logic*
1.  Edge case `n=1`: return `[0]`.
2.  Build Adjacency List `List<Set<Integer>> adj`.
3.  Compute `degree[]`.
4.  Init `leaves` list with all nodes `deg == 1`.
5.  Loop while `n > 2`:
    - `n -= leaves.size()`.
    - `newLeaves = []`.
    - For `u` in `leaves`:
        - For neighbor `v` of `u`:
            - `degree[v]--`.
            - If `degree[v] == 1`, add `v` to `newLeaves`.
    - `leaves = newLeaves`.
6.  Return `leaves`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Convergence:** Guaranteed to converge to the center efficiently.
*   **Linear Time:** Every edge/node visited constant times.
    *Hội tụ: Đảm bảo hội tụ về trung tâm một cách hiệu quả. Thời gian tuyến tính: Mọi cạnh/nút được thăm số lần hằng số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 0-1-2-3-4-5.
Leaves: 0, 5.
Remove 0, 5. Remaining: 1-2-3-4. (Leaves: 1, 4).
Remove 1, 4. Remaining: 2-3. (Leaves: 2, 3).
Count = 2. Stop.
Result: [2, 3].

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard "Topological Sort from Leaves" algorithm.
*Thuật toán "Sắp xếp Topo từ Lá" tiêu chuẩn.*
---
*Để tìm ra cốt lõi (minimum height root), ta phải lần lượt loại bỏ những gì ngoại vi (leaves). Khi lớp vỏ ngoài cùng biến mất, bản chất trung tâm sẽ lộ diện.*
To find the core (minimum height root), we must successively remove the periphery (leaves). When the outer shell disappears, the central essence is revealed.
