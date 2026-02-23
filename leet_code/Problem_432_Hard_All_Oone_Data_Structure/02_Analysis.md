# Analysis for All O`one Data Structure
# *Phân tích cho bài toán Cấu trúc dữ liệu All O`one*

## 1. Problem Essence & O(1) Constraint
## *1. Bản chất vấn đề & Ràng buộc O(1)*

### The Challenge
### *Thách thức*
Maintaining the counts of various strings while being able to retrieve the minimum and maximum counts instantly ($O(1)$). This requires a sophisticated combination of hashing for quick access and a sorted structure for range management.

### Strategy: Doubly Linked List of Buckets + Map
### *Chiến lược: Danh sách liên kết đôi của các "Xô" + Bản đồ*

1.  **Nodes (Buckets):** Each node in a **Doubly Linked List** represents a specific **Count**.
    - Each node contains a `Set<String>` of all keys that have exactly that count.
    - Nodes are kept in increasing order of their `count`.
2.  **Mapping:** A `HashMap<String, Node>` stores which "bucket" (node) a specific key currently belongs to.
3.  **Operations:**
    - `inc(key)`: 
        - Find current node of `key`.
        - Move `key` to the **next** node (count + 1). If next node doesn't exist or has a different count, create it.
    - `dec(key)`:
        - Move `key` to the **previous** node (count - 1). If count becomes 0, remove the key from tracking.
    - `getMaxKey()`: The `Set` in the `tail` of the linked list (if not dummy).
    - `getMinKey()`: The `Set` in the `head` of the linked list (if not dummy).

---

## 2. Approach: Linked Structure Logic
## *2. Hướng tiếp cận: Logic Cấu trúc Liên kết*

### Logic
### *Logic*
(See above). The key to $O(1)$ is that we never "search" for the new count node; we only check the immediate `next` or `prev` neighbors in the linked list. Removing a node is also $O(1)$ when it becomes empty.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bucket Grouping:** Keys with the same frequency stay together, drastically reducing the number of nodes we manage.
    *Gom nhóm theo Xô: Các khóa có cùng tần suất ở cùng nhau, giảm thiểu số lượng nút cần quản lý.*
*   **Constant Time Tracking:** Minimum and maximum are always at the boundary of our linked structure.
    *Theo dõi thời gian hằng số: Giá trị nhỏ nhất và lớn nhất luôn nằm ở biên của cấu trúc liên kết.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ for all operations (amortized).
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(N)$, where $N$ is the number of unique keys stored.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

1. `inc("A")`: New Node(1, {"A"}). List: [1:{"A"}].
2. `inc("A")`: New Node(2, {"A"}). List: [2:{"A"}].
3. `inc("B")`: Existing Node(1) doesn't exist (removed in step 2). List: [1:{"B"}, 2:{"A"}].
4. `getMaxKey()`: Tail is 2. Return "A".
5. `dec("A")`: Move "A" from 2 to 1. Node 2 becomes empty, delete it. List: [1:{"A", "B"}].
Result: $O(1)$ updates and queries.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

HashMap + Doubly Linked List of Bucket nodes.
*Bản đồ băm + Danh sách liên kết đôi của các nút Xô.*
---
*Trong một hệ thống nơi sự thay đổi diễn ra liên tục ($O(1)$), trật tự không được duy trì bằng cách sắp xếp lại toàn bộ, mà bằng cách dịch chuyển khôn ngoan giữa các "tầng" giá trị (buckets). Bằng cách kết nối quá khứ (prev) và tương lai (next), ta giữ cho những thái cực (min/max) luôn nằm trong tầm tay mà không tốn một giây suy sụp.*
In a system where change occurs continuously ($O(1)$), order is not maintained by rearranging everything, but by moving wisely between "levels" of value (buckets). By connecting the past (prev) and the future (next), we keep the extremes (min/max) always within reach without spending one second collapsing.
