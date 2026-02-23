# Analysis for Sequence Reconstruction
# *Phân tích cho bài toán Tái cấu trúc Dãy*

## 1. Problem Essence & Unique Topological Sort
## *1. Bản chất vấn đề & Sắp xếp Thứ tự Tô-pô Duy nhất*

### The Challenge
### *Thách thức*
Checking if `nums` is the unique shortest common supersequence of a set of sequences. For a shortest common supersequence to be unique and equal to a permutation `nums` of `[1, n]`, the precedence relations in `sequences` must define a **unique topological sort** that covers all numbers from 1 to $n$.

### Strategy: Kahn's Algorithm (BFS)
### *Chiến lược: Thuật toán Kahn (BFS)*

1.  **Graph Construction:**
    - Use `sequences` to build an adjacency list (Directed Graph).
    - An edge `u -> v` exists if `u` appears before `v` in any sequence.
    - Calculate the **in-degree** of each node.
2.  **Topological Sort:**
    - Use a queue to store all nodes with `in-degree == 0`.
    - **Crucial Condition for Uniqueness:** At every step, the queue must contain **exactly one** node. If at any point the queue size is $> 1$ or $0$ (before visiting $n$ nodes), the sequence is either not unique or impossible.
3.  **Validation:**
    - The sequence of nodes popped from the queue must match `nums`.

---

## 2. Approach: Graph-based Validation
## *2. Hướng tiếp cận: Xác thực dựa trên Đồ thị*

### Logic
### *Logic*
(See above). The uniqueness of a topological sort is guaranteed if and only if there's always exactly one choice for the "next" node in each step of the algorithm.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(V+E) Efficiency:** Standard linear time for graph traversal.
    *Hiệu quả O(V+E): Thời gian tuyến tính tiêu chuẩn cho duyệt đồ thị.*
*   **Logical Rigor:** Directly addresses the "uniqueness" requirement through the queue size constraint.
    *Sự chặt chẽ logic: Giải quyết trực tiếp yêu cầu "duy nhất" thông qua ràng buộc kích thước hàng đợi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(V + E)$, where $V = n$ and $E$ is the total number of relations in `sequences`.
    *Độ phức tạp thời gian: $O(V + E)$.*
*   **Space Complexity:** $O(V + E)$ for the adjacency list and in-degree array.
    *Độ phức tạp không gian: $O(V + E)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [1,2,3], sequences = [[1,2],[2,3]]`
1. Graph: `1 -> 2`, `2 -> 3`.
2. In-degrees: `1:0, 2:1, 3:1`.
3. Queue: `[1]`. (Size = 1).
   - Pop `1`. Match `nums[0]`.
   - Update `2`: in-degree becomes 0. Queue: `[2]`.
4. Queue: `[2]`. (Size = 1).
   - Pop `2`. Match `nums[1]`.
   - Update `3`: in-degree becomes 0. Queue: `[3]`.
5. Queue: `[3]`. (Size = 1).
   - Pop `3`. Match `nums[2]`.
Result: `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Kahn's algorithm with a sanity check on queue size.
*Thuật toán Kahn với kiểm tra kích thước hàng đợi.*
---
*Mọi sự tồn tại đều có một trật tự (order). Để một con đường duy nhất (unique supersequence) được hình thành, những mảnh ghép rời rạc (sequences) phải kết nối với nhau một cách chặt chẽ, không cho phép bất kỳ sự lựa chọn nào khác tại mỗi bước đi (queue size == 1). Khi sự tự do biến mất trước sự ràng buộc của logic, đó cũng là lúc chân lý được khẳng định một cách tuyệt đối.*
Everything that exists has an order (order). For a unique path (unique supersequence) to be formed, discrete pieces (sequences) must connect to each other tightly, not allowing any other choices at each step (queue size == 1). When freedom disappears before the constraints of logic, that is also when the truth is absolutely affirmed.
