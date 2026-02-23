# Analysis for Populating Next Right Pointers in Each Node
# *Phân tích cho bài toán Điền Con Trỏ Bên Phải Tiếp Theo Trong Mỗi Nút*

## 1. Problem Core Concept
## *1. Khái niệm cốt lõi của bài toán*

### The "Perfect" Property
### *Đặc tính "Hoàn hảo"*
*   This problem specifically states the tree is a **perfect binary tree**. This means every internal node has exactly two children and all leaves are at the same level.
    *Bài toán này nêu rõ cây là một **cây nhị phân hoàn hảo**. Điều này có nghĩa là mọi nút nội bộ đều có đúng hai con và tất cả các lá đều ở cùng một tầng.*
*   The goal is to connect nodes at the same level horizontally from left to right using a `next` pointer.
    *Mục tiêu là kết nối các nút ở cùng một tầng theo chiều ngang từ trái sang phải bằng con trỏ `next`.*

### Types of Connections
### *Các loại kết nối*
There are two distinct types of `next` connections we need to establish:
*Có hai loại kết nối `next` riêng biệt mà chúng ta cần thiết lập:*
1.  **Direct siblings (Internal connection):** The `left` child's `next` always points to the `right` child of the same parent. (e.g., node 2's left child 4 points to node 2's right child 5).
    *Các anh chị em trực tiếp (Kết nối nội bộ): Con bên trái luôn trỏ đến con bên phải của cùng một cha. (ví dụ: con trái 4 của nút 2 trỏ đến con phải 5 của nút 2).*
2.  **Cousins (Across-parent connection):** The `right` child's `next` points to the `left` child of the parent's `next` node. (e.g., node 2's right child 5 points to node 3's left child 6, because node 2.next is node 3).
    *Anh chị em họ (Kết nối xuyên cha): Con bên phải trỏ đến con bên trái của nút `next` của cha nó. (ví dụ: con phải 5 của nút 2 trỏ đến con trái 6 của nút 3, vì nút 2.next là nút 3).*

---

## 2. Approach: Iterative Layer Processing ($O(1)$ Space)
## *2. Hướng tiếp cận: Xử lý tầng lặp (Không gian O(1))*

Since we want to avoid extra space (no queue), we can leverage the `next` pointers established on the previous level to process the current level.
*Vì chúng ta muốn tránh sử dụng thêm không gian (không dùng hàng đợi), chúng ta có thể tận dụng các con trỏ `next` đã được thiết lập ở tầng trước để xử lý tầng hiện tại.*

### Logic
### *Logic*
1.  Start with the `root`.
    *Bắt đầu với `root`.*
2.  Maintain a `leftmost` pointer which tracks the first node of each level.
    *Duy trì một con trỏ `leftmost` theo dõi nút đầu tiên của mỗi tầng.*
3.  For each level, use a `head` traversal pointer starting from `leftmost`.
    *Đối với mỗi tầng, sử dụng một con trỏ duyệt `head` bắt đầu từ `leftmost`.*
4.  While traversing the current level (using `head`), establish the `next` connections for the level below:
    -   `head.left.next = head.right` (Internal)
    -   If `head.next` exists: `head.right.next = head.next.left` (Across-parent)
5.  Move `leftmost` to `leftmost.left` to go to the next level.
    *Di chuyển `leftmost` sang `leftmost.left` để chuyển xuống tầng tiếp theo.*

---

## 3. Mathematical Consistency
## *3. Tính nhất quán về Toán học*

In a perfect binary tree, the number of nodes at level $L$ (starting from 0) is $2^L$.
*Trong một cây nhị phân hoàn hảo, số lượng nút ở tầng $L$ (bắt đầu từ 0) là $2^L$.*
Total nodes $N = 2^{H+1} - 1$.
*Tổng số nút $N = 2^{H+1} - 1$.*

Our algorithm processes each horizontal link exactly once. In any level of $K$ nodes, there are $K-1$ links to establish.
*Giải thuật của chúng ta xử lý mỗi liên kết ngang đúng một lần. Ở bất kỳ tầng nào có $K$ nút, sẽ có $K-1$ liên kết cần thiết lập.*
Total links $\approx \sum 2^L \approx N$.
*Tổng số liên kết $\approx \sum 2^L \approx N$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We visit each node and set its children's `next` pointers. The nested loop structure effectively visits each node in the tree exactly once.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta truy cập mỗi nút và thiết lập con trỏ `next` cho các con của nó. Cấu trúc vòng lặp lồng nhau thực sự truy cập mỗi nút trong cây đúng một lần.*
*   **Space Complexity:** $O(1)$. We only use a few pointers (`leftmost`, `head`). No auxiliary data structures proportional to the tree size are required.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ sử dụng một vài con trỏ (`leftmost`, `head`). Không cần cấu trúc dữ liệu phụ trợ tỷ lệ thuận với kích thước cây.*

---

## 5. Visual Dry Run
## *5. Chạy thử bằng hình ảnh*

Level 0: `leftmost = 1`.
- `head = 1`.
- `1.left(2).next = 1.right(3)`.
Level 1: `leftmost = 2`.
- `head = 2`:
  - `2.left(4).next = 2.right(5)`.
  - `2.right(5).next = 2.next(3).left(6)`.
- `head = 3`:
  - `3.left(6).next = 3.right(7)`.
- Level complete.
Level 2: `leftmost = 4`. All children are null. Termination.
---
*Việc kết nối anh chị em họ thông qua con trỏ của cha là mấu chốt để đạt được độ phức tạp không gian O(1).*
Connecting cousins through the parent's pointer is the key to achieving O(1) space complexity.
