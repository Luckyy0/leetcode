# Analysis for Populating Next Right Pointers in Each Node II
# *Phân tích cho bài toán Điền Con Trỏ Bên Phải Tiếp Theo Trong Mỗi Nút II*

## 1. Problem Difficulty & Constraints
## *1. Độ khó & Ràng buộc của bài toán*

### Difference from Part I
### *Sự khác biệt so với Phần I*
*   In the previous problem (116), the tree was guaranteed to be **perfect**.
    *Trong bài toán trước (116), cây được đảm bảo là cây **hoàn hảo**.*
*   In this problem (117), the tree can be **any binary tree**. Some nodes may be missing left or right children, and leaves can be at different levels.
    *Trong bài toán này (117), cây có thể là **bất kỳ cây nhị phân nào**. Một số nút có thể thiếu con trái hoặc con phải, và các lá có thể ở các tầng khác nhau.*
*   Because children can be missing, we cannot simply assume `head.left.next = head.right` or use `leftmost.left` to find the start of the next level.
    *Vì các nút con có thể bị thiếu, chúng ta không thể đơn giản giả định `head.left.next = head.right` hoặc sử dụng `leftmost.left` để tìm điểm bắt đầu của tầng tiếp theo.*

### Constraint Goal
### *Mục tiêu Ràng buộc*
*   We still must aim for $O(1)$ extra space, meaning no Queues (standard BFS).
    *Chúng ta vẫn phải hướng tới không gian bổ sung $O(1)$, nghĩa là không sử dụng Hàng đợi (BFS chuẩn).*

---

## 2. Approach: Dummy Node Traversal
## *2. Hướng tiếp cận: Duyệt bằng nút giả (Dummy Node)*

To handle the irregularity of the tree while maintaining $O(1)$ space, we can treat each level as a linked list. We use a **dummy node** to help us build the linked list of the *next* level while we are traversing the *current* level.
*Để xử lý tính không đều của cây trong khi vẫn duy trì không gian $O(1)$, chúng ta có thể coi mỗi tầng như một danh sách liên kết. Chúng ta sử dụng một **nút giả (dummy node)** để giúp xây dựng danh sách liên kết của tầng *tiếp theo* trong khi đang duyệt tầng *hiện tại*.*

### Logic
### *Logic*
1.  Start with `curr = root`.
    *Bắt đầu với `curr = root`.*
2.  While `curr` is not null (processing levels):
    -   Create a `dummy` node and a `tail` pointer (initialized to `dummy`).
        *Tạo một nút `dummy` và một con trỏ `tail` (khởi tạo tại `dummy`).*
    -   Inside a loop, traverse the current level using the `next` pointers:
        -   If `curr.left` exists:
            -   `tail.next = curr.left`
            -   `tail = tail.next`
        -   If `curr.right` exists:
            -   `tail.next = curr.right`
            -   `tail = tail.next`
        -   Move `curr = curr.next`.
    -   After the current level is done, the first node of the next level is `dummy.next`.
        *Sau khi tầng hiện tại hoàn thành, nút đầu tiên của tầng tiếp theo là `dummy.next`.*
    -   Set `curr = dummy.next` and repeat.

---

## 3. Why the Dummy Node is Brilliant
## *3. Tại sao nút giả lại tuyệt vời*

The dummy node handles three tricky situations automatically:
*Nút giả xử lý ba tình huống khó khăn một cách tự động:*
1.  **Level Start:** It always points to the first existing node of the next level via `dummy.next`.
    *Điểm bắt đầu tầng: Nó luôn trỏ đến nút tồn tại đầu tiên của tầng tiếp theo thông qua `dummy.next`.*
2.  **Missing Children:** If a node has only a right child, the dummy (via `tail`) will skip the missing left child and link to the right child directly.
    *Thiếu con: Nếu một nút chỉ có con phải, dummy (thông qua tail) sẽ bỏ qua con trái bị thiếu và liên kết trực tiếp đến con phải.*
3.  **Cousins:** When moving from one parent to another (e.g., `curr` moves to `curr.next`), the `tail` pointer remains at the last seen child of the previous parent, allowing seamless connection to the first child of the new parent.
    *Anh chị em họ: Khi di chuyển từ cha này sang cha khác, con trỏ `tail` vẫn ở nút con cuối cùng được thấy của cha trước đó, cho phép kết nối liền mạch với con đầu tiên của cha mới.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Every node is visited twice: once as part of the "next level" being built, and once as part of the "current level" being traversed.
    *Độ phức tạp thời gian: $O(N)$. Mọi nút được truy cập hai lần: một lần là một phần của "tầng tiếp theo" đang được xây dựng, và một lần là một phần của "tầng hiện tại" đang được duyệt.*
*   **Space Complexity:** $O(1)$. We only create a dummy node per level (which is garbage collected) and use a few pointers. No data structure proportional to $N$ is used.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ tạo một nút giả cho mỗi tầng và sử dụng một vài con trỏ. Không sử dụng cấu trúc dữ liệu nào tỷ lệ thuận với $N$.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

The Dummy Node technique is the standard way to convert a level-based tree traversal into a linked-list-based traversal. By viewing each level as a linked list, we can solve complex tree problems with minimal memory overhead.
*Kỹ thuật nút giả là cách chuẩn để chuyển đổi phép duyệt cây dựa trên tầng thành phép duyệt dựa trên danh sách liên kết. Bằng cách coi mỗi tầng là một danh sách liên kết, chúng ta có thể giải quyết các bài toán cây phức tạp với chi phí bộ nhớ tối thiểu.*
---
*Nút giả đóng vai trò như một điểm neo tạm thời, giúp chúng ta xây dựng cấu trúc mới mà không làm mất dấu vết của tầng hiện tại.*
The dummy node acts as a temporary anchor, helping us build the new structure without losing track of the current level.
