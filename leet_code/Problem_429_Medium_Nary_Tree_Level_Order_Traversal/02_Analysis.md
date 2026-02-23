# Analysis for N-ary Tree Level Order Traversal
# *Phân tích cho bài toán Duyệt cây N-phân theo Mức*

## 1. Problem Essence & BFS
## *1. Bản chất vấn đề & Duyệt theo chiều rộng (BFS)*

### The Challenge
### *Thách thức*
Collecting node values level by level from an N-ary tree. This is a standard BFS application where instead of just `left` and `right`, we iterate over a `children` list.

### Strategy: Queue-based Level Processing
### *Chiến lược: Xử lý theo mức dựa trên hàng đợi*
1.  **Initialize:** A queue containing the `root`.
2.  **Iterate Levels:**
    -   Get the current size of the queue (`levelSize`). This represents all nodes on the current level.
    -   For each of these `levelSize` nodes:
        -   Remove from queue.
        -   Add value to a `currentLevel` list.
        -   Add all its children to the queue for the next level.
3.  **Result:** A list of `currentLevel` lists.

---

## 2. Approach: Standard BFS
## *2. Hướng tiếp cận: BFS Tiêu chuẩn*

### Logic
### *Logic*
(See above). The use of `levelSize` ensures we clearly separate one level from the next.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Each node is visited and put in the queue exactly once.
    *Hiệu quả O(N): Mỗi nút được truy cập và đưa vào hàng đợi đúng một lần.*
*   **Intuitive Top-Down Order:** BFS naturally provides the proximity-based ordering required.
    *Trật tự trên-xuống trực quan: BFS cung cấp sự sắp xếp dựa trên khoảng cách một cách tự nhiên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is total nodes.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(W)$, where $W$ is the maximum width of the tree.
    *Độ phức tạp không gian: $O(W)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Tree:** `1 -> [3, 2, 4]`
1. `Queue: [1]`. `levelSize=1`.
   - Process 1. `currentLevel: [1]`. Add children 3, 2, 4.
2. `Queue: [3, 2, 4]`. `levelSize=3`.
   - Process 3, 2, 4. `currentLevel: [3, 2, 4]`. No children.
Result: `[[1], [3, 2, 4]]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Queue-based Level Order BFS.
*BFS duyệt theo mức dựa trên hàng đợi.*
---
*Khám phá một cây n-phân theo từng mức (level order) cũng giống như việc quan sát những đợt sóng lan tỏa từ một tâm điểm. Bằng cách chờ đợi cho đến khi toàn bộ những người cùng thế hệ (nodes on same level) được ghi nhận xong xuôi, ta có thể thấu hiểu được sự mở rộng tuần tự của tri thức, từ gốc rễ vững chãi đến những tán lá vươn xa.*
Exploring an n-ary tree by level (level order) is like watching waves spreading from a center. By waiting until all of the same generation (nodes on same level) are fully recorded, we can understand the sequential expansion of knowledge, from strong roots to reaching leaves.
