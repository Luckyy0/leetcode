# Analysis for Maximum Width of Binary Tree
# *Phân tích cho bài toán Chiều rộng Tối đa của Cây Nhị phân*

## 1. Problem Essence & Complete Binary Tree Indexing
## *1. Bản chất vấn đề & Đánh chỉ số Cây Nhị phân Đầy đủ*

### The Challenge
### *Thách thức*
The width of a level is not just the number of visible nodes, but the total number of slots in a complete binary tree between the leftmost and rightmost nodes. Since the tree can be very deep, we need a way to track the "horizontal position" of each node consistently across levels.
*Chiều rộng của một tầng không chỉ là số lượng các nút hiện hình, mà là tổng số ô trong một cây nhị phân đầy đủ nằm giữa nút ngoài cùng bên trái và ngoài cùng bên phải. Vì cây có thể rất sâu, chúng ta cần một cách để theo dõi "vị trí ngang" của từng nút một cách nhất quán qua các tầng.*

---

## 2. Strategy: BFS with Positional Indexing
## *2. Chiến lược: BFS với Đánh chỉ số Vị trí*

We use a level-order traversal (BFS) and assign an index to each node.
*Chúng ta sử dụng duyệt theo tầng (BFS) và gán một chỉ số cho mỗi nút.*

### Indexing Rule
### *Quy tắc Đánh chỉ số*
For a node at index $i$:
*   Left child: $2i$
*   Right child: $2i + 1$
*   *This is exactly how a binary tree is mapped into an array.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Queue of Pairs:** Use a queue to store both the `node` and its `index`. Start with `(root, 0)`.
    * **Hàng đợi của các Cặp:** Sử dụng một hàng đợi để lưu trữ cả `nút` và `chỉ số` của nó. Bắt đầu với `(root, 0)`.*

2.  **Level Processing:** For each level:
    * **Xử lý Tầng:** Đối với mỗi tầng: *
    - Record the indices of the first (leftmost) and last (rightmost) nodes in the current level.
    - Width of this level = `last_index - first_index + 1`.
    - Update the global `maxWidth`.

3.  **Child Enqueueing:**
    * **Thêm con vào Hàng đợi:** *
    - For each node at index $i$:
        - Left child gets index $2i$.
        - Right child gets index $2i + 1$.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Handling Nulls:** We don't need to actually insert null nodes into the queue. The indexing math ($2i, 2i+1$) automatically accounts for the missing "distance" between nodes.
    * **Xử lý các nút Null:** Chúng ta không cần thực sự chèn các nút null vào hàng đợi. Phép toán đánh chỉ số ($2i, 2i+1$) tự động tính toán "khoảng cách" bị thiếu giữa các nút.*
*   **Integer Overflow:** While the problem guarantees the width fits in 32-bit, the indices themselves can exceed that if the tree is extremely deep. However, since we only care about the *difference* between indices at the same level, we can normalize indices at each level by subtracting the first index of that level. In Java, integer overflow for subtraction is cyclic and still yields the correct distance.
    * **Tràn số Nguyên:** Mặc dù bài toán đảm bảo chiều rộng nằm trong phạm vi 32-bit, bản thân các chỉ số có thể vượt quá giới hạn đó nếu cây cực sâu. Tuy nhiên, vì chúng ta chỉ quan tâm đến *hiệu số* giữa các chỉ số ở cùng một tầng, ta có thể chuẩn hóa các chỉ số hoặc tận dụng tính chất quay vòng của phép trừ số nguyên trong Java.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. Every node is visited once.
    * **Độ phức tạp thời gian:** $O(N)$. Mỗi nút được ghé thăm một lần.*
*   **Space Complexity:** $O(W_{max})$, where $W_{max}$ is the maximum width. The queue will store at most the nodes of one level.
    * **Độ phức tạp không gian:** $O(W_{max})$, trong đó $W_{max}$ là chiều rộng tối đa.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Level 1:** `(root, 0)`. Width = 0 - 0 + 1 = 1.
**Level 2:** `(left, 0), (right, 1)`. Width = 1 - 0 + 1 = 2.
**Level 3:** `(left-left, 0), (left-right, 1), (right-right, 3)`. (Note: right-left is missing).
Width = 3 - 0 + 1 = 4.
**Max Width:** 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Indexing a tree as a complete structure is the standard way to measure distances horizontally across nodes. This logic turns a tree topology problem into a simple arithmetic one.
*Đánh chỉ số một cây như một cấu trúc đầy đủ là cách tiêu chuẩn để đo lường khoảng cách theo chiều ngang giữa các nút. Logic này biến một bài toán kiến trúc cây thành một bài toán số học đơn giản.*
---
*Độ rộng (Width) của một cây không chỉ nằm ở những gì hiển hiện (Nodes), mà còn ở những khoảng trống được che giấu (Nulls). Trong hành trình khám phá chiều ngang (BFS), chỉ số vị trí (Index) chính là chiếc thước đo giúp ta xác định được tầm vóc thực sự của mỗi tầng. Dữ liệu dạy ta rằng chiều rộng thực sự (Maximum width) là sự căng trải giữa hai nút xa xôi nhất, bao trùm lên cả sự tồn tại lẫn sự vắng mặt.*
The width (Width) of a tree lies not only in what is visible (Nodes), but also in the hidden spaces (Nulls). In the journey to explore the horizontal (BFS), the positional index (Index) is the ruler that helps us determine the true stature of each level. Data teaches us that the true width (Maximum width) is the stretch between the two furthest nodes, encompassing both existence and absence.
