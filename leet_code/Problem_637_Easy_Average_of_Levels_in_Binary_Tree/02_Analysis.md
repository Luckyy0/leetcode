# Analysis for Average of Levels in Binary Tree
# *Phân tích cho bài toán Trung bình cộng các Mức trong Cây Nhị phân*

## 1. Problem Essence & Level-by-Level Processing
## *1. Bản chất vấn đề & Xử lý theo từng Mức*

### The Challenge
### *Thách thức*
We need to calculate the mathematical average of node values for each horizontal layer (level) of a binary tree.
*Chúng ta cần tính trung bình cộng toán học của giá trị các nút cho mỗi lớp ngang (mức) của một cây nhị phân.*

The core requirement is to aggregate data level-by-level, which naturally suggests a **Breadth-First Search (BFS)** approach.
*Yêu cầu cốt lõi là tổng hợp dữ liệu theo từng mức, điều này tự nhiên gợi ý cách tiếp cận **Duyệt theo chiều rộng (BFS)**.*

---

## 2. Strategy: Breadth-First Search (BFS)
## *2. Chiến lược: Duyệt theo chiều rộng (BFS)*

Using a Queue, we can process all nodes belonging to the same level before moving to the next one.
*Sử dụng một Hàng đợi, chúng ta có thể xử lý tất cả các nút thuộc cùng một mức trước khi chuyển sang mức tiếp theo.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialization:** Start with a queue containing the `root`.
    * **Khởi tạo:** Bắt đầu với một hàng đợi chứa `root`.*

2.  **Level Traversal:** While the queue is not empty:
    * **Duyệt mức:** Khi hàng đợi chưa trống:*
    - Determine the `size` of the current level (current number of elements in the queue).
    - Initialize `sum = 0`.
    - Loop `size` times:
        - Dequeue a node.
        - Add its value to `sum`. (Use `double` for `sum` to handle large totals and precision).
        - Enqueue its non-null left and right children.
    - Calculate `average = sum / size`.
    - Add `average` to the result list.

3.  **Return `res`.**

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Precision and Overflow:** Since node values can be as large as `MAX_INT`, the sum of multiple nodes can easily overflow a 32-bit `int`. Using a `double` for the accumulation is mandatory for both capacity and floating-point result requirements.
    * **Độ chính xác và Tràn số:** Vì giá trị các nút có thể lớn bằng `MAX_INT`, tổng của nhiều nút có thể dễ dàng làm tràn số kiểu `int` 32-bit. Sử dụng kiểu `double` cho việc tích lũy là bắt buộc để đáp ứng yêu cầu về dung lượng và kết quả số thực.*
*   **Intuitive Hierarchy:** BFS perfectly maps to the visual "levels" of a tree, making the code easy to reason about and maintain.
    * **Phân cấp Trực quan:** BFS ánh xạ hoàn hảo tới các "mức" trực quan của một cây, giúp mã nguồn dễ hiểu và dễ bảo trì hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the number of nodes. Every node is visited exactly once.
    * **Độ phức tạp thời gian:** $O(N)$ trong đó $N$ là số lượng nút. Mỗi nút được ghé thăm đúng một lần.*
*   **Space Complexity:** $O(M)$ where $M$ is the maximum width of the tree. The queue will contain at most $M$ nodes (the widest level).
    * **Độ phức tạp không gian:** $O(M)$ trong đó $M$ là chiều rộng tối đa của cây. Hàng đợi sẽ chứa tối đa $M$ nút (mức rộng nhất).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [3, 9, 20, null, null, 15, 7]
1. Queue: [3]. Size: 1. Sum: 3. Avg: 3.0. Children: [9, 20].
2. Queue: [9, 20]. Size: 2. Sum: 29. Avg: 14.5. Children: [15, 7].
3. Queue: [15, 7]. Size: 2. Sum: 22. Avg: 11.0. Children: [].
**Result:** [3.0, 14.5, 11.0].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

BFS is the gold standard for level-based operations in trees or graphs. Always track the level size at the start of each iteration to distinguish between the current level and the next level being built in the queue.
*BFS là tiêu chuẩn vàng cho các thao tác dựa trên mức trong cây hoặc đồ thị. Luôn theo dõi kích thước mức ở đầu mỗi lần lặp để phân biệt giữa mức hiện tại và mức tiếp theo đang được xây dựng trong hàng đợi.*
---
*Sự đồng điệu (Averages) nảy sinh từ sự tập hợp của những cá thể trong cùng một tầng bậc (Levels). Trong cấu trúc của cây (Binary Tree), mỗi mức độ đại diện cho một tầm nhìn đồng nhất. Dữ liệu dạy ta rằng bằng cách đo lường giá trị trung bình (Average), ta có thể thấu hiểu được đặc tính chung của từng giai đoạn phát triển mà không bị xao nhãng bởi những sai biệt đơn lẻ.*
Uniformity (Averages) arises from the assembly of individuals at the same level (Levels). In the structure of a tree (Binary Tree), each level represents a unified vision. Data teaches us that by measuring average values (Average), we can understand the general characteristics of each stage of development without being distracted by individual differences.
