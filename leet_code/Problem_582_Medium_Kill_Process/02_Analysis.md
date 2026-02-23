# Analysis for Kill Process
# *Phân tích cho bài toán Tiêu diệt Tiến trình*

## 1. Problem Essence & Tree Traversal
## *1. Bản chất vấn đề & Duyệt cây*

### The Challenge
### *Thách thức*
We are given a parent-child relationship between processes and need to find all descendants of a specific process.
*Chúng ta được trao mối quan hệ cha-con giữa các tiến trình và cần tìm tất cả các hậu duệ của một tiến trình cụ thể.*

The processes form a tree structure (since each process has exactly one parent, except the root). Killing a process effectively kills its entire subtree.
*Các tiến trình tạo thành một cấu trúc cây (vì mỗi tiến trình có chính xác một cha, ngoại trừ gốc). Việc tiêu diệt một tiến trình tương đương với việc tiêu diệt toàn bộ cây con của nó.*

---

## 2. Strategy: Adjacency Map with BFS/DFS
## *2. Chiến lược: Bản đồ Kề với BFS/DFS*

The input lists (PID and PPID) are not efficient for direct lookup. We need to build a better representation first.
*Các danh sách đầu vào (PID và PPID) không hiệu quả để tra cứu trực tiếp. Trước tiên, chúng ta cần xây dựng một đại diện tốt hơn.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Build Adjacency Map:** Create a `HashMap<Integer, List<Integer>>` where the key is the parent ID and the value is a list of its children's IDs.
    * **Xây dựng Bản đồ Kề:** Tạo một `HashMap<Integer, List<Integer>>` trong đó khóa là ID cha và giá trị là danh sách các ID con của nó.*

2.  **Selection of Traversal:** Use either Breadth-First Search (BFS) or Depth-First Search (DFS) starting from the `kill` PID.
    * **Lựa chọn Duyệt:** Sử dụng Tìm kiếm theo chiều rộng (BFS) hoặc Tìm kiếm theo chiều sâu (DFS) bắt đầu từ PID bị `kill`.*

3.  **Process Exploration:**
    * **Khám phá Tiến trình:**
    - Initialize a queue/stack with the `kill` PID.
    - *Khởi tạo một hàng đợi/ngăn xếp với PID bị `kill`.*
    - While the structure is not empty, pop/poll a process and add it to our result list.
    - *Trong khi cấu trúc không trống, hãy lấy ra một tiến trình và thêm nó vào danh sách kết quả của chúng ta.*
    - Find all children of this process in the adjacency map and add them to the queue/stack.
    - *Tìm tất cả các con của tiến trình này trong bản đồ kề và thêm chúng vào hàng đợi/ngăn xếp.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Fast Lookup:** The `HashMap` allows us to jump directly to a node's children in $O(1)$ time on average, making the search linear to the number of nodes in the subtree.
    * **Tra cứu Nhanh:** `HashMap` cho phép chúng ta nhảy trực tiếp đến các con của một nút trong thời gian trung bình $O(1)$, giúp việc tìm kiếm tỉ lệ thuận với số lượng nút trong cây con.*
*   **Tree Property:** Since there are no cycles in a process parent-child tree, we don't need a `visited` set to prevent infinite loops.
    * **Thuộc tính Cây:** Vì không có chu trình trong cây cha-con của tiến trình, chúng ta không cần bộ tập hợp `visited` để ngăn chặn các vòng lặp vô hạn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the total number of processes. Building the map takes $O(N)$ and the traversal touches each node in the target subtree once.
    * **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là tổng số tiến trình. Việc xây dựng bản đồ tốn $O(N)$ và quá trình duyệt chạm vào mỗi nút trong cây con mục tiêu một lần.*
*   **Space Complexity:** $O(N)$ to store the adjacency map and the results.
    * **Độ phức tạp không gian:** $O(N)$ để lưu trữ bản đồ kề và kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** pid=[1, 3, 10, 5], ppid=[3, 0, 5, 3], kill=5
- **Map:** {3: [1, 5], 5: [10], 0: [3]}
- **Start BFS with `5`:**
  - Result: [5], Queue: [10].
  - Result: [5, 10], Queue: [].
- **Output:** [5, 10].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always preprocess tree relationship lists into an adjacency map when you need to perform multiple lookups or recursive subtree explorations.
*Luôn tiền xử lý các danh sách mối quan hệ cây thành bản đồ kề khi bạn cần thực hiện nhiều lần tra cứu hoặc khám phá cây con đệ quy.*
---
*Mọi hành động (Kill) đều có những hệ lụy (Children). Trong một hệ thống thứ bậc (Hierarchy), gốc rễ của sự hủy hoại bắt đầu từ một nút và lan tỏa đến tận từng cành lá (Subtree). Bằng cách hiểu rõ sự kết nối (Adjacency), ta có thể tiên đoán toàn bộ phạm vi ảnh hưởng của một quyết định duy nhất.*
Every action (Kill) has consequences (Children). In a hierarchy (Hierarchy), the root of destruction starts at one node and spreads to every branch and leaf (Subtree). By clearly understanding the connection (Adjacency), one can predict the entire scope of influence of a single decision.
