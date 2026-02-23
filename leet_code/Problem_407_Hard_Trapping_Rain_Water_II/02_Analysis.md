# Analysis for Trapping Rain Water II
# *Phân tích cho bài toán Hứng nước mưa II*

## 1. Problem Essence & Boundary Contraction
## *1. Bản chất vấn đề & Sự co lại của biên giới*

### The Challenge
### *Thách thức*
In 1D water trapping, we look at left and right maximums. In 2D, water is trapped by the lowest point in the surrounding boundary ring. We need to find the "effective" wall height for every internal cell.

### Strategy: Min-Heap + BFS
### *Chiến lược: Min-Heap + BFS*
1.  **Initialize Boundary:** Add all cells on the outermost edges of the matrix to a `PriorityQueue` (Min-Heap) and mark them as visited. These are the starting constraints.
2.  **Contract Inward:**
    - Always poll the cell with the **minimum height** from the heap. Let this height be `h`.
    - Explore its neighbors.
    - If a neighbor `(nr, nc)` hasn't been visited:
        - If `heightMap[nr][nc] < h`: The difference `h - heightMap[nr][nc]` is trapped water.
        - Add the neighbor to the heap. The "new" height of this neighbor for future boundary calculations is `max(h, heightMap[nr][nc])`.
3.  **Why min-first?** Water overflows at the lowest point of a container. By processing the lowest point of the boundary first, we ensure that if water *could* be trapped, its height is limited by the current bottleneck.

---

## 2. Approach: Dijkstra-like Propagation
## *2. Hướng tiếp cận: Lan truyền kiểu Dijkstra*

### Logic
### *Logic*
(See above). The use of a Min-Heap ensures we are always "filling" the container from its lowest leak point upwards.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Constraint:** Correctly identifies the "leak height" for any internal region.
    *Ràng buộc tối ưu: Xác định chính xác "chiều cao rò rỉ" cho bất kỳ vùng nội bộ nào.*
*   **O(M*N log(M*N)) Efficiency:** Standard priority queue processing for all cells.
    *Hiệu quả: Quy trình xử lý hàng đợi ưu tiên tiêu chuẩn cho tất cả các ô.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(MN \log MN)$, as each cell is added to the heap once.
    *Độ phức tạp thời gian: $O(MN \log MN)$.*
*   **Space Complexity:** $O(MN)$ to store visited status and the heap elements.
    *Độ phức tạp không gian: $O(MN)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**HeightMap:** 3x3 with center lower than borders.
1. All 8 border cells enter Min-Heap.
2. Poll minimum height `h` from border.
3. Check center neighbor:
   - If `center < h`, add `h - center` to total water.
   - Push center to heap with height `h`.
4. Boundary continues to contract until all cells visited.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Min-Heap BFS for boundary tracking.
*BFS dùng Min-Heap để theo dõi biên giới.*
---
*Nước chảy về chỗ trũng, nhưng cũng trào ra ở điểm thấp nhất của thành bể (lowest boundary). Bằng cách luôn để mắt tới những kẻ yếu thế nhất (min height in heap), ta có thể thấu hiểu trọn vẹn sức chứa của cả một hệ thống phức tạp, nơi mà sự tĩnh lặng của mặt hồ (trapped water) chỉ được duy trì bằng những rào chắn vững bền nhất xung quanh.*
Water flows to the hollow, but also overflows at the lowest point of the tank wall (lowest boundary). By always keeping an eye on the most disadvantaged (min height in heap), we can fully understand the capacity of a complex system, where the silence of the lake (trapped water) is only maintained by the strongest barriers around.
