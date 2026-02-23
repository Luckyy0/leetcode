# Analysis for Flatten Binary Tree to Linked List
# *Phân tích cho bài toán Làm Phẳng Cây Nhị Phân Thành Danh Sách Liên Kết*

## 1. Problem Essence & Mapping
## *1. Bản chất và Sự tương quan của bài toán*

### Preorder Pattern
### *Mẫu Thứ tự Trước*
*   The requirement is to transform the tree into a right-only structure based on **Preorder Traversal** (Root -> Left -> Right).
    *Yêu cầu là biến đổi cây thành một cấu trúc chỉ có nhánh phải dựa trên **Duyệt Theo Thứ Tự Trước** (Gốc -> Trái -> Phải).*
*   For a node with children:
    1.  The `left` child becomes the immediate `right` child.
    2.  The original `right` child must be attached to the end of the flattened `left` child's subtree.
    *Đối với một nút có con:*
    *1. Con bên `trái` trở thành con bên `phải` trực tiếp.*
    *2. Con bên `phải` ban đầu phải được gắn vào cuối cây con bên `trái` đã được làm phẳng.*

---

## 2. Approach 1: Reversed Postorder (Recursive)
## *2. Hướng tiếp cận 1: Thứ tự Sau đảo ngược (Đệ quy)*

### Logic
### *Logic*
*   Standard Preorder is **Root -> Left -> Right**.
*   We can traverse the tree in **Right -> Left -> Root** (Reversed Postorder).
*   By maintaining a `prev` pointer (initially `null`), we link the current node's `right` to `prev` and set `left` to `null`.
*   This builds the list from bottom to top.
    *Phép duyệt chuẩn là Gốc -> Trái -> Phải. Chúng ta có thể duyệt theo kiểu Phải -> Trái -> Gốc. Bằng cách duy trì con trỏ `prev`, chúng ta nối `right` của nút hiện tại vào `prev` và đặt `left` bằng `null`. Điều này xây dựng danh sách từ dưới lên trên.*

*   **Complexity:** $O(N)$ time, $O(H)$ space.

---

## 3. Approach 2: Morris-style Traversal (Iterative $O(1)$)
## *3. Hướng tiếp cận 2: Duyệt kiểu Morris (Lặp $O(1)$)*

### Logic
### *Logic*
This approach is the most efficient as it avoids the recursive stack.
*Phương pháp này hiệu quả nhất vì nó tránh được ngăn xếp đệ quy.*

1.  Start with the `current` node at the `root`.
    *Bắt đầu với nút `current` tại `root`.*
2.  If `current` has a **left child**:
    -   Find the **rightmost node** in `current`'s left subtree. This node is the predecessor of the right subtree in preorder.
        *Tìm nút **ngoài cùng bên phải** trong cây con bên trái của `current`. Nút này là nút tiền nhiệm của cây con bên phải trong thứ tự trước.*
    -   Connect `current.right` to this rightmost node's `right`.
        *Nối `current.right` vào `right` của nút ngoài cùng bên phải này.*
    -   Move `current.left` to `current.right`.
        *Chuyển `current.left` sang `current.right`.*
    -   Set `current.left` to `null`.
        *Đặt `current.left` bằng `null`.*
3.  Move `current` to `current.right` and repeat until the whole tree is processed.
    *Di chuyển `current` sang `current.right` và lặp lại cho đến khi toàn bộ cây được xử lý.*

### Why it works?
### *Tại sao nó hoạt động?*
In preorder, after visiting a node and its entire left subtree, the right subtree is visited next. By moving the right subtree to be the right child of the rightmost node of the left subtree, we preserve this sequence without using any extra memory.
*Trong thứ tự trước, sau khi truy cập một nút và toàn bộ cây con bên trái của nó, cây con bên phải sẽ được truy cập tiếp theo. Bằng cách di chuyển cây con bên phải để trở thành con bên phải của nút ngoài cùng bên phải của cây con bên trái, chúng ta bảo toàn trình tự này mà không sử dụng thêm bộ nhớ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Although it might look like more because of the inner loop to find the rightmost node, each edge is visited at most twice.
    *Độ phức tạp thời gian: $O(N)$. Mặc dù trông có vẻ nhiều hơn do vòng lặp bên trong để tìm nút ngoài cùng bên phải, nhưng mỗi cạnh chỉ được truy cập tối đa hai lần.*
*   **Space Complexity:** $O(1)$. We do not use recursion or any extra data structures like stacks or queues.
    *Độ phức tạp không gian: $O(1)$. Chúng ta không sử dụng đệ quy hoặc bất kỳ cấu trúc dữ liệu bổ sung nào như ngăn xếp hoặc hàng đợi.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

The Morris-style iterative approach is highly recommended for technical interviews because it addresses the $O(1)$ space follow-up requirement perfectly. It transforms the tree structure "on the fly" without temporary storage.
*Phương pháp lặp kiểu Morris được khuyến khích mạnh mẽ vì nó giải quyết hoàn hảo yêu cầu bổ sung về không gian $O(1)$. Nó biến đổi cấu trúc cây "ngay lập tức" mà không cần lưu trữ tạm thời.*
---
*Kỹ thuật "mượn" con trỏ để tái cấu trúc cây là một trong những đỉnh cao của giải thuật cây nhị phân.*
The technique of "borrowing" pointers to restructure trees is one of the pinnacles of binary tree algorithms.
