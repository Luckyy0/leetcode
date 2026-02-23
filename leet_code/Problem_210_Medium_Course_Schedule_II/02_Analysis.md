# Analysis for Course Schedule II
# *Phân tích cho bài toán Lịch học II*

## 1. Problem Essence & Topological Sort
## *1. Bản chất vấn đề & Sắp xếp Topo*

### The Order of Execution
### *Thứ tự thực hiện*
This problem is a direct extension of "Course Schedule I". Instead of just checking if a valid schedule *exists*, we must *produce* one such schedule.
This operation is called **Topological Sort**.
*Bài toán này là phần mở rộng trực tiếp của "Lịch học I". Thay vì chỉ kiểm tra sự tồn tại, chúng ta phải *tạo ra* một lịch trình như vậy. Thao tác này được gọi là **Sắp xếp Topo**.*

### Properties
### *Tính chất*
- A valid topological order is only possible if the graph is a **Directed Acyclic Graph (DAG)**. (No cycles).
- There can be multiple valid topological orders (e.g., if A and B both require C but don't depend on each other, `[C, A, B]` and `[C, B, A]` are both valid).
- If a cycle exists, no topological ordering exists.
*Sắp xếp topo chỉ khả thi nếu đồ thị là DAG (không có chu kỳ). Có thể có nhiều thứ tự hợp lệ. Nếu có chu kỳ, không có thứ tự topo.*

---

## 2. Approach: Kahn's Algorithm
## *2. Hướng tiếp cận: Thuật toán Kahn*

### Logic
### *Logic*
We use the same BFS-based approach as Course Schedule I, but we record the nodes as we peel them off the graph.

1.  **Indegree Calculation:** Count dependencies for each course.
2.  **Queue Initialization:** Add all courses with `indegree == 0` (no prereqs) to the Queue.
3.  **Process:**
    - Poll `u`. **Add `u` to the result list/array.**
    - For neighbors `v` of `u`:
        - `indegree[v]--`.
        - If `indegree[v] == 0`, add `v` to Queue.
4.  **Verification:**
    - If `result.size() == numCourses`, return the result array.
    - Else (cycle detected), return empty array `[]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Constructive Proof:** Kahn's algorithm constructively builds the sorted list. The order in which nodes are added to the queue (and subsequently the result list) perfectly respects the dependency constraints.
    *Bằng chứng xây dựng: Thuật toán Kahn xây dựng danh sách đã sắp xếp. Thứ tự thêm nút vào hàng đợi tôn trọng hoàn hảo các ràng buộc phụ thuộc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(V + E)$.
    *Độ phức tạp thời gian: $O(V + E)$.*
*   **Space Complexity:** $O(V + E)$ for adjacency list and indegree array.
    *Độ phức tạp không gian: $O(V + E)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `4, [[1,0],[2,0],[3,1],[3,2]]`
Edges: `0->1, 0->2, 1->3, 2->3`.

1.  **Indegree:** `0:0, 1:1, 2:1, 3:2`.
2.  **Queue:** `[0]`.
3.  **Pop 0:** Result `[0]`.
    - Neighbors 1, 2.
    - `indegree[1]` becomes 0 -> Queue `[1]`.
    - `indegree[2]` becomes 0 -> Queue `[1, 2]`.
4.  **Pop 1:** Result `[0, 1]`.
    - Neighbor 3.
    - `indegree[3]` becomes 1.
5.  **Pop 2:** Result `[0, 1, 2]`.
    - Neighbor 3.
    - `indegree[3]` becomes 0 -> Queue `[3]`.
6.  **Pop 3:** Result `[0, 1, 2, 3]`.
7.  All done. Return `[0, 1, 2, 3]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

If you know Problem 207, you know Problem 210. The only difference is maintaining a result array. When implementing, be careful with the "impossible" case: remember to check if the result array contains *all* courses. If the graph has a cycle, Kahn's algorithm will simply stop early, leaving some nodes untouched (and `result` incomplete).
*Nếu bạn biết Bài 207, bạn biết Bài 210. Sự khác biệt duy nhất là duy trì mảng kết quả. Khi triển khai, hãy cẩn thận với trường hợp "không thể": nhớ kiểm tra xem mảng kết quả có chứa *tất cả* các khóa học không. Nếu có chu kỳ, thuật toán Kahn sẽ dừng sớm.*
---
*Đôi khi thứ tự quan trọng hơn tốc độ. Bạn không thể xây mái nhà trước khi đặt xong nền móng.*
Sometimes order is more important than speed. You cannot build the roof before laying the foundation.
