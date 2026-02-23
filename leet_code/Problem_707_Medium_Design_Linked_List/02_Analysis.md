# Analysis for Design Linked List
# *Phân tích cho bài toán Thiết kế Danh sách Liên kết*

## 1. Problem Essence & Strategy
## *1. Bản chất vấn đề & Chiến lược*

### The Challenge
### *Thách thức*
Implementing a foundational data structure from scratch. Handling head/tail operations and index-based access requires careful index management and pointer manipulation.
*Cài đặt một cấu trúc dữ liệu cơ bản từ đầu. Việc xử lý các thao tác tại đầu/cuối và truy cập theo chỉ số yêu cầu quản lý chỉ số và thao tác con trỏ cẩn thận.*

---

## 2. Strategy: Doubly Linked List with Sentinel Nodes
## *2. Chiến lược: Danh sách Liên kết Kép với các Nút giả*

Using a **Doubly Linked List** with `head` and `tail` **Sentinel (Dummy) nodes** makes insertions and deletions MUCH simpler because you never have to handle "null" checks for the actual boundaries.
*Sử dụng **Danh sách Liên kết Kép** với các **nút giả (Sentinel)** ở đầu và cuối giúp việc chèn và xóa đơn giản hơn NHIỀU vì bạn không bao giờ phải kiểm tra "null" cho các biên thực tế.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Define Node:** `val`, `prev`, `next`.
2.  **Sentinel Nodes:** Initialize `head` and `tail` such that `head.next = tail` and `tail.prev = head`.
3.  **Operations:**
    - **Add:** Splice the new node between two existing nodes (`node.prev = p; node.next = n; p.next = node; n.prev = node`).
    - **Delete:** Link the neighbor nodes directly to each other (`p.next = n; n.prev = p`).
    - **Get:** Traverse from `head` if `index < size/2`, else traverse from `tail` (Optimization).

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `addAtHead`, `addAtTail`: $O(1)$.
    - `get`, `addAtIndex`, `deleteAtIndex`: $O(index)$, average $O(N)$.
    * **Độ phức tạp thời gian:** $O(1)$ cho đầu/cuối, $O(N)$ cho chỉ số.*
*   **Space Complexity:** $O(N)$ for $N$ nodes.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

Doubly linked lists are more versatile than singly linked lists. Sentinel nodes eliminate edge cases (like empty lists), making the code cleaner and less prone to NullPointerExceptions.
*Danh sách liên kết kép linh hoạt hơn đơn. Các nút giả giúp loại bỏ các trường hợp biên, làm cho mã sạch hơn và ít lỗi hơn.*
---
*Mỗi mắt xích (Node) là một phần của một câu chuyện nối dài (Linked List). Trong dòng chảy của dữ liệu, sự kết nối không chỉ ở phía trước (Next) mà còn ở phía sau (Prev), tạo nên một sự ràng buộc hai chiều vững chắc. Dữ liệu dạy ta rằng bằng cách sử dụng những điểm tựa giả (Sentinel nodes), ta có thể điều hướng qua mọi thay đổi mà không bao giờ mất đi phương hướng của khởi đầu và kết thúc.*
Every link (Node) is part of a continuing story (Linked List). In the flow of data, connection is not only forward (Next) but also backward (Prev), creating a solid two-way constraint. Data teaches us that by using dummy points of reference (Sentinel nodes), we can navigate through all changes without ever losing the direction of the beginning and end.
