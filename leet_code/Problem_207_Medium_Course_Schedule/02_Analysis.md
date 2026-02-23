# Analysis for Course Schedule
# *Phân tích cho bài toán Lịch học*

## 1. Problem Essence & Graph Theory
## *1. Bản chất vấn đề & Lý thuyết đồ thị*

### Directed Graph Representation
### *Biểu diễn đồ thị có hướng*
The courses and prerequisites form a **Directed Graph**.
- Nodes: Courses (0 to n-1).
- Edges: Prerequisite `[a, b]` means edge `b -> a` (must take `b` to take `a`).
*Các khóa học và điều kiện tiên quyết tạo thành một **Đồ thị có hướng**. Cạnh `b -> a` nghĩa là phải học `b` rồi mới học `a`.*

### The Core Question: Cycle Detection
### *Câu hỏi cốt lõi: Phát hiện chu kỳ*
If there is a cycle (e.g., A needs B, B needs A), it is impossible to finish the courses.
This problem is equivalent to: **"Is this directed graph a Directed Acyclic Graph (DAG)?"**
*Nếu có chu kỳ (VD: A cần B, B cần A), không thể hoàn thành khóa học. Bài toán tương đương: "**Đồ thị này có phải là Đồ thị có hướng không chu kỳ (DAG) không?**"*

---

## 2. Approach: Kahn's Algorithm (BFS based Topological Sort)
## *2. Hướng tiếp cận: Thuật toán Kahn (Sắp xếp Topo dựa trên BFS)*

### Logic
### *Logic*
1.  **Indegree Array:** Calculate the "indegree" (number of incoming edges) for each node. Indegree 0 means a course has no prerequisites (or all are met).
    *Mảng bậc vào: Tính "bậc vào" cho mỗi nút. Bậc vào 0 nghĩa là khóa học không có điều kiện tiên quyết.*
2.  **Queue:** Initialize a queue with all nodes having `indegree == 0`.
3.  **Process:**
    - Poll a node `u` from the queue (we "take" this course).
    - For each neighbor `v` of `u` (courses that require `u`):
        - Decrement `indegree[v]`.
        - If `indegree[v]` becomes 0, add `v` to the queue.
    - Count the number of processed nodes.
4.  **Result:** If `processed_count == numCourses`, return `true` (DAG). Else `false` (Cycle exists).

### Alternative: DFS (3-Coloring)
### *Cách thay thế: DFS (Tô màu 3 trạng thái)*
- **0 (White):** Unvisited.
- **1 (Gray):** Visiting (currently in recursion stack).
- **2 (Black):** Visited (safe).
If DFS encounters a node marked **Gray**, a cycle exists.
*Nếu DFS gặp một nút đang **Xám**, có chu kỳ.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Kahn's Algorithm:** It's intuitive because it simulates the actual process of taking courses. "Take the ones I can, which unlocks new ones...".
    *Thuật toán Kahn: Trực quan vì nó mô phỏng quá trình học thực tế.*
*   **Space Efficient:** Uses a simple array for indegree and an adjacency list.
    *Hiệu quả không gian: Sử dụng mảng đơn giản cho bậc vào và danh sách kề.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(V + E)$. We visit every vertex and every edge once.
    *Độ phức tạp thời gian: $O(V + E)$.*
*   **Space Complexity:** $O(V + E)$. Adjacency list stores E edges.
    *Độ phức tạp không gian: $O(V + E)$.*

---

## 5. Visualized Dry Run (Kahn's)
## *5. Chạy thử bằng hình ảnh (Kahn)*

**Input:** `2, [[1,0]]` -> Edge `0 -> 1`.

1.  **Indegree:** `indegree[0]=0`, `indegree[1]=1`.
2.  **Queue:** `[0]`.
3.  **Process 0:**
    - Neighbor: 1. `indegree[1]` becomes 0. Add 1 to Queue.
    - `count = 1`.
4.  **Process 1:**
    - No neighbors.
    - `count = 2`.
5.  `count == numCourses`. Return **True**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Course Schedule is the hello world of Topological Sort. You must master Kahn's Algorithm or DFS Cycle Detection. Kahn's is often preferred because it's iterative and easier to debug than deep recursion with state tracking.
*Course Schedule là bài nhập môn của Sắp xếp Topo. Bạn phải thành thạo Thuật toán Kahn hoặc Phát hiện chu kỳ bằng DFS. Kahn thường được ưa chuộng hơn vì nó lặp và dễ gỡ lỗi hơn đệ quy sâu.*
---
*Cuộc sống giống như sắp xếp topo; bạn phải giải quyết những điều kiện tiên quyết trước khi mở khóa những cánh cửa mới.*
Life is like topological sorting; you have to resolve prerequisites before unlocking new doors.
